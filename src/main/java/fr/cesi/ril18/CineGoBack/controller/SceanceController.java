package fr.cesi.ril18.CineGoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.entities.Sceances;
import fr.cesi.ril18.CineGoBack.repositories.SceanceRepository;

@RestController
@RequestMapping("Sceance")
public class SceanceController {
	
	@Autowired SceanceRepository sceanceRepo;
	
	@GetMapping
	public List<Sceances> getSceance(){

		return sceanceRepo.findAll();

		
	}
	
	@PostMapping("/Create")
	public ResponseEntity<?> ajouterFilm(@RequestBody Sceances sceance) {

		
		
		Sceances id = sceanceRepo.findByIdSecance(sceance.getIdSecance());
				
				if(id != null) {
					return ResponseEntity.ok("deja present en BDD");
				}
		
		if(id != null) {
		
			sceanceRepo.save(sceance);
			return ResponseEntity.ok(this.sceanceRepo.findAll());	
		}
		return ResponseEntity.status(400).body("Vous devez ajouter un film valable");


	}
	
	
	
	

}
