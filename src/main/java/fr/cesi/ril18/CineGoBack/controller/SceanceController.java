package fr.cesi.ril18.CineGoBack.controller;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.entities.Sceances;
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;
import fr.cesi.ril18.CineGoBack.repositories.SceanceRepository;

@CrossOrigin
@RestController
@RequestMapping("Sceance")
public class SceanceController {
	
	@Autowired 
	SceanceRepository sceanceRepo;
	
	@Autowired
	FilmRepository filmRepo;

	 
	@GetMapping
	public List<Sceances> getSceance(){

		return sceanceRepo.findAll();

		
	}
	

	@PostMapping("/Create")
	public ResponseEntity<?> ajouterSceance(@RequestBody Sceances sceance) {

		

			sceanceRepo.save(sceance);
			return ResponseEntity.ok(this.sceanceRepo.findAll());	

	}
	
	
	
	@PutMapping("Modif/{id}")
	public ResponseEntity<?> updateSceance(@RequestBody Sceances sceance , @PathVariable Integer id){
		
		Optional <Sceances> sceanceOptional = sceanceRepo.findById(id);
		
		if(!sceanceOptional.isPresent())
			return ResponseEntity.status(400).body("Cette sceance n'existe pas en base");
		
		sceance.setIdSceance(id);
		sceanceRepo.save(sceance);
		
		return ResponseEntity.ok(this.sceanceRepo.findAll());
		
	}
	
	
	@PostMapping("/Delete/{id}")
	public ResponseEntity<?> deleteSceance(@RequestBody Sceances sceance, @PathVariable Integer id){
		
		Optional<Sceances> sceanceOptional = sceanceRepo.findById(id);
		
		if(!sceanceOptional.isPresent()) {
			
			return ResponseEntity.status(400).body("Cette Scéance n'existe pas en base");
		}
		
		
		sceanceRepo.delete(sceance);
		
		return ResponseEntity.ok(this.sceanceRepo.findAll());
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSceance(@RequestBody Sceances sceance){
		
		Sceances id = sceanceRepo.findByIdSceance(sceance.getIdSceance());
		
		if(id != null) {
			sceanceRepo.delete(sceance);
		}else {
			 ResponseEntity.status(400).body("la Sceance a supprimer n'existe pas en base");
		}
		
		 return ResponseEntity.ok(this.sceanceRepo.findAll());
	}

	@GetMapping("/{idFilm}")
	public ResponseEntity<?> getSceanceAvecSonFilm(@PathVariable Integer idFilm)
	
	{
	
		Film film = filmRepo.findByIdFilm(idFilm);
		
		
			
			return ResponseEntity.ok(this.sceanceRepo.findByFilm(film));
		
		
	}

}
