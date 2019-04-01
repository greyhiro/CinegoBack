package fr.cesi.ril18.CineGoBack.services;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.cesi.ril18.CineGoBack.entities.Cinema;
import fr.cesi.ril18.CineGoBack.entities.Fidelite;
import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.entities.Groupes;
import fr.cesi.ril18.CineGoBack.entities.Salles;
import fr.cesi.ril18.CineGoBack.entities.Sceances;
import fr.cesi.ril18.CineGoBack.repositories.CinemaRepository;
import fr.cesi.ril18.CineGoBack.repositories.FideliteRepository;
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;
import fr.cesi.ril18.CineGoBack.repositories.GroupesRepository;
import fr.cesi.ril18.CineGoBack.repositories.SallesRepository;
import fr.cesi.ril18.CineGoBack.repositories.SceanceRepository;


@Component
public class AppListener {
	

	
	@Autowired
	FideliteRepository fidRepo;
	
	@Autowired
	GroupesRepository grRepo;
	
	@Autowired
	CinemaRepository Cinemarepo;
	
	@Autowired
	SallesRepository SallesRepo;
	
	@Autowired
	SceanceRepository sceanceRepo;
	
	@Autowired
	FilmRepository repoFilm;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void Initialise() {
		
		Fidelite fidelite1 = new Fidelite();
		fidelite1.setCodeFidelite(1);
		
		Fidelite fidelite2 = new Fidelite();
		fidelite2.setCodeFidelite(2);
		
		Fidelite fidelite3 = new Fidelite();
		fidelite2.setCodeFidelite(3);
		
		Fidelite fidelite4 = new Fidelite();
		fidelite2.setCodeFidelite(4);
		
		Fidelite fidelite5 = new Fidelite();
		fidelite2.setCodeFidelite(5);
		
		
		fidRepo.save(fidelite1);
		fidRepo.save(fidelite2);
		fidRepo.save(fidelite3);
		fidRepo.save(fidelite4);
		fidRepo.save(fidelite5);
		 
		Groupes groupe1 = new Groupes();
		groupe1.setIdFidelite(fidelite1);
		groupe1.setNomGroupe("L'Archipel");
		
		Groupes groupe2 = new Groupes();
		groupe2.setIdFidelite(fidelite2);
		groupe2.setNomGroupe("Gaumont");
		
		Groupes groupe3 = new Groupes();
		groupe3.setIdFidelite(fidelite3);
		groupe3.setNomGroupe("Pathé");
		
		Groupes groupe4 = new Groupes();
		groupe4.setIdFidelite(fidelite4);
		groupe4.setNomGroupe("Utopia");
		
		Groupes groupe5 = new Groupes();
		groupe5.setIdFidelite(fidelite5);
		groupe5.setNomGroupe("Cocinor");
		
		grRepo.save(groupe1);
		grRepo.save(groupe2);
		grRepo.save(groupe3);
		grRepo.save(groupe4);
		grRepo.save(groupe5);
		
		Cinema cinema1 = new Cinema();
		cinema1.setGroupe(groupe1);
		cinema1.setNomCinema("Paté Toulouse");
		cinema1.setAdresseCinema("4 rue des fleurs");
		cinema1.setPrixEtudiant((float) 5.3);
		cinema1.setPrixHandicapet((float) 3.5);
		cinema1.setPrixNormal((float) 7.5);
		
		Cinemarepo.save(cinema1);
		
		Salles salle1= new Salles();
		salle1.setIdCinema(cinema1);
		salle1.setNbPlaceHandicap(20);
		salle1.setNbplaces(50);
		salle1.setFichierXMLplace(salle1.CreateFichierXML(salle1.getNbplaces(), salle1.getNbPlaceHandicap()));
		
	
		Salles salle2= new Salles();
		salle2.setIdCinema(cinema1);
		salle2.setNbplaces(50);
		salle2.setNbPlaceHandicap(20);
		salle2.setFichierXMLplace(salle2.CreateFichierXML(salle2.getNbplaces(), salle2.getNbPlaceHandicap()));
		
		DateTime dateEtHeureAujourdhui = new DateTime();
		
		Film film = new Film();
		film.setNomFilm("lala");
		film.setDateRealisation("2010-20-10");
		film.setDescription("patata");
		film.setNomFilmOriginal("lalalalalala");
		film.setAfficheFilm("https://images-na.ssl-images-amazon.com/images/I/71B8dk%2B64AL._SX342_.jpg");
		film.setVideo("false");
		
		Sceances sceance1 = new Sceances();
	
		sceance1.setDateEtHeureSceance("2020-10-12: 10:55");
		sceance1.setFilm(film);
		
		
		
		repoFilm.save(film);
		sceanceRepo.save(sceance1);
		
		
		SallesRepo.save(salle2);
	}
	

}
