package fr.cesi.ril18.CineGoBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.cesi.ril18.CineGoBack.entities.Cinema;
import fr.cesi.ril18.CineGoBack.entities.Fidelite;
import fr.cesi.ril18.CineGoBack.entities.Groupes;
import fr.cesi.ril18.CineGoBack.entities.Salles;
import fr.cesi.ril18.CineGoBack.repositories.CinemaRepository;
import fr.cesi.ril18.CineGoBack.repositories.FideliteRepository;
import fr.cesi.ril18.CineGoBack.repositories.GroupesRepository;
import fr.cesi.ril18.CineGoBack.repositories.SallesRepository;


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
	
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void Initialise() {
		
		Fidelite fidelite1 = new Fidelite();
		fidelite1.setCodeFidelite(0546132);
		
		fidRepo.save(fidelite1);
		 
		Groupes groupe1 = new Groupes();
		groupe1.setIdFidelite(fidelite1);
		groupe1.setAdrGroupe("28 rue des patates");
		groupe1.setNomGroupe("Paté");
		
		grRepo.save(groupe1);
		
		Cinema cinema1 = new Cinema();
		cinema1.setGroupe(groupe1);
		cinema1.setNomCinema("Paté Toulouse");
		cinema1.setPrixEtudiant(5);
		cinema1.setPrixHandicapet(3);
		cinema1.setPrixNormal(7);
		
		Cinemarepo.save(cinema1);
		
		
		
		
		
		Salles salle1= new Salles();
		salle1.setIdCinema(cinema1);
		salle1.setNbPlaceHandicap(20);
		salle1.setNbplaces(50);
		salle1.setFichierXMLplace(salle1.CreateFichierXML(salle1.getNbplaces(), salle1.getNbPlaceHandicap()));
		
		SallesRepo.save(salle1);
	}
	

}
