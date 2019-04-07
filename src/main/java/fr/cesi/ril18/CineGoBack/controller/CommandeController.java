package fr.cesi.ril18.CineGoBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril18.CineGoBack.entities.Commande;
import fr.cesi.ril18.CineGoBack.repositories.CommandeRepository;


@CrossOrigin
@RestController
@RequestMapping("Commande")
public class CommandeController {

@Autowired 
CommandeRepository commandeRepo;
	
	@GetMapping
	public List<Commande> getCommande(){

		return commandeRepo.findAll();

		
	}
	

	@PostMapping("/Create")
	public ResponseEntity<?> ajouterCinema(@RequestBody Commande commande) {

		

			commandeRepo.save(commande);
			return ResponseEntity.ok(this.commandeRepo.findAll());	

	}
	
	
	@PutMapping("Modif/{id}")
	public ResponseEntity<?> updateCinema(@RequestBody Commande commande , @PathVariable Integer id){
		
		Optional <Commande> commandeOptionnal = commandeRepo.findById(id);
		
		if(!commandeOptionnal.isPresent())
			return ResponseEntity.status(400).body("Cette commande n'existe pas en base");
		
		commande.setIdCommande(id);
		commandeRepo.save(commande);
		
		return ResponseEntity.ok(this.commandeRepo.findAll());
		
	}
	
	
	@PostMapping("/Delete/{id}")
	public ResponseEntity<?> deleteCinema(@RequestBody Commande commande, @PathVariable Integer id){
		
		Optional<Commande> commandeOptionnal = commandeRepo.findById(id);
		
		if(!commandeOptionnal.isPresent()) {
			
			return ResponseEntity.status(400).body("Cette Scéance n'existe pas en base");
		}
		
		
		commandeRepo.delete(commande);
		
		return ResponseEntity.ok(this.commandeRepo.findAll());
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSceance(@RequestBody Commande commande){
		
		Commande id = commandeRepo.findByIdCommande(commande.getIdCommande());
		
		if(id != null) {
			commandeRepo.delete(commande);
		}else {
			 ResponseEntity.status(400).body("le cinema a supprimer n'existe pas en base");
		}
		
		 return ResponseEntity.ok(this.commandeRepo.findAll());
	}



}

	
	
	

