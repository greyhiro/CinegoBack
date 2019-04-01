package fr.cesi.ril18.CineGoBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril18.CineGoBack.entities.Salles;
import fr.cesi.ril18.CineGoBack.repositories.SallesRepository;


@RestController
@RequestMapping("Salles")
public class SalleController {
	
	@Autowired SallesRepository salleRepo;
	
	@GetMapping
	public List<Salles> getSalle(){

		return salleRepo.findAll();

		
	}
	

	@PostMapping("/Create")
	public ResponseEntity<?> ajouterSceance(@RequestBody Salles salle) {

		
		
		Salles id = salleRepo.findByIdSalles(salle.getIdSalles());
				
				if(id != null) {
					return ResponseEntity.ok("deja present en BDD");
				}

			salleRepo.save(salle);
			return ResponseEntity.ok(this.salleRepo.findAll());	

	}
	
	
	@PutMapping("Modif/{id}")
	public ResponseEntity<?> updateSceance(@RequestBody Salles salle , @PathVariable Integer id){
		
		Optional <Salles> salleOptional = salleRepo.findById(id);
		
		if(!salleOptional.isPresent())
			return ResponseEntity.status(400).body("Cette sceance n'existe pas en base");
		
		salle.setIdSalles(id);
		salleRepo.save(salle);
		
		return ResponseEntity.ok(this.salleRepo.findAll());
		
	}
	
	
	@PostMapping("/Delete/{id}")
	public ResponseEntity<?> deleteSceance(@RequestBody Salles salle, @PathVariable Integer id){
		
		Optional<Salles> salleOptional = salleRepo.findById(id);
		
		if(!salleOptional.isPresent()) {
			
			return ResponseEntity.status(400).body("Cette Scéance n'existe pas en base");
		}
		
		
		salleRepo.delete(salle);
		
		return ResponseEntity.ok(this.salleRepo.findAll());
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSceance(@RequestBody Salles salle){
		
		Salles id = salleRepo.findByIdSalles(salle.getIdSalles());
		
		if(id != null) {
			salleRepo.delete(salle);
		}else {
			 ResponseEntity.status(400).body("la Sceance a supprimer n'existe pas en base");
		}
		
		 return ResponseEntity.ok(this.salleRepo.findAll());
	}
	
	


}
