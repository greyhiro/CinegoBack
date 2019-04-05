package fr.cesi.ril18.CineGoBack;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.cesi.ril18.CineGoBack.entities.Cinema;
import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.entities.Salles;
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;
import fr.cesi.ril18.CineGoBack.services.AppListener;
import fr.cesi.ril18.CineGoBack.services.FilmApiJson;

@SpringBootApplication
@ComponentScan
public class MainApplication {


	
	public static void main(String[] args) throws IOException, ParseException{
	
		
	
		
		SpringApplication.run(MainApplication.class, args);
		
		// TODO Auto-generated method stub
	
		
		
		
		
		
	
		
	}
	
	

}
	
			
		
