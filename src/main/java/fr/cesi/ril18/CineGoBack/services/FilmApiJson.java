package fr.cesi.ril18.CineGoBack.services;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;

@Component
public class FilmApiJson {

	
 	
	private Scanner sc;

	private int pageTotalInt;

	private String dateRealisation;

	private String afficheFilm;

	private String Description;

	private String nomFilm;

	private String nomFilmOriginal;

	private String video;
	@Autowired
	FilmRepository filmRepo;
	

	private int idFilm;




	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void MyGETRequest() throws IOException, ParseException {
	
		int page = 1;
		pageTotalInt = 2;
		
		while (pageTotalInt >= page) {
	    URL url = new URL("https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-04-01&primary_release_date.lte=2019-05-01&api_key=dd3ce9a7b49c2eac73fc965b61d7baf6&language=fr&page="+page+"");
	    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	    
	    conn.setRequestMethod("GET"); 
	    
	    conn.connect(); 
	    
	    
	    int responsecode = conn.getResponseCode(); 
	    
	    
	    if(responsecode != 200)
	    	throw new RuntimeException("HttpResponseCode: "+ responsecode);
	    	else
	    	{
	    	    System.out.println("Systeme OK");
	    	}
	    
	    sc = new Scanner(url.openStream());
	   String inline="";
	   
		while(sc.hasNext())
	    {
	    inline+=sc.nextLine()+ "\n";
	    }
		
	    JSONParser parse = new JSONParser(); 
	    JSONObject jobj = (JSONObject)parse.parse(inline); 
	   
	 
	 

	    JSONArray jsonarr_1 = (JSONArray) jobj.get("results");
	    
	    Object pageTotal = jobj.get("total_pages");
	    String pageTotalString = pageTotal.toString();
	    pageTotalInt = Integer.parseInt(pageTotalString);
	
	
	  //Get data for Results array
	    //while(pageCourante != pageMax) {
	    	
	    
	   for(int i=0;i<jsonarr_1.size();i++)
	    {
	    //Store the JSON objects in an array
	    //Get the index of the JSON object and print the values as per the index
	     JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
	     this.idFilm = i;
	    
	     this.nomFilm = ""+jsonobj_1.get("title");
	    
	     this.afficheFilm ="https://image.tmdb.org/t/p/original/"+ jsonobj_1.get("poster_path");
	    
	     this.nomFilmOriginal = ""+jsonobj_1.get("original_title");
	    
	     this.dateRealisation = ""+jsonobj_1.get("release_date");
	     
	     this.video = ""+jsonobj_1.get("video");
	  
	  
	    if(!jsonobj_1.get("overview").equals("")) {
	     Description = ""+jsonobj_1.get("overview");
	    }else { 
	    	Description = "pas de description";
	    }
	    System.out.println("insertion Film " +i);
	    
	    Film filmCreate = new Film();
	    
	   	filmCreate.setNomFilm(this.nomFilm);
	   	filmCreate.setNomFilmOriginal(this.nomFilmOriginal);
	   	filmCreate.setDescription(this.Description);
	    filmCreate.setAfficheFilm(this.afficheFilm);
	   	filmCreate.setDateRealisation(this.dateRealisation);
	   	filmCreate.setVideo(this.video);
	   	
	   	System.out.println(filmCreate);
	   	filmRepo.save(filmCreate);
	   	
	   
	    }
	   

	 
	   page = page +1; 
	     
	     try {
	         Thread.sleep(2500);
	     }
	     catch(InterruptedException e) {
	         
	     }
	
	   
	  
		}
		
		 sc.close();
	}
	

	
}

