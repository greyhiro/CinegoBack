package fr.cesi.ril18.CineGoBack.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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

import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.util.Duration;
import fr.cesi.ril18.CineGoBack.entities.Commande;
import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.entities.Sceances;
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
	public ResponseEntity<?> jouterCommande(@RequestBody Sceances sceance) {

		
			Commande commande = new Commande();
			commande.setSceance(sceance);

			commandeRepo.save(commande);
			return ResponseEntity.ok(this.commandeRepo.findAll());	

	}
	
	
	@PutMapping("Modif/{id}")
	public ResponseEntity<?> updateCommande(@RequestBody Commande commande , @PathVariable Integer id){
		
		Optional <Commande> commandeOptionnal = commandeRepo.findById(id);
		
		if(!commandeOptionnal.isPresent())
			return ResponseEntity.status(400).body("Cette commande n'existe pas en base");
		
		commande.setIdCommande(id);
		commandeRepo.save(commande);
		
		return ResponseEntity.ok(this.commandeRepo.findAll());
		
	}
	
	
	@PostMapping("/Delete/{id}")
	public ResponseEntity<?> deleteCommande(@PathVariable Integer id){
		
		LocalDateTime aujourdui = LocalDateTime.now();
		
		
		
		Commande commande = commandeRepo.findByIdCommande(id);

		Sceances sceanceCommande = commande.getSceance();
		String dateSceance = sceanceCommande.getDateEtHeureSceance();
		
		LocalDateTime dateSceanceDateTime = LocalDateTime.parse(dateSceance);
		
		long hours = ChronoUnit.HOURS.between(aujourdui, dateSceanceDateTime);
		
		System.out.println("sceance time : "+ dateSceanceDateTime);
		System.out.println("ajourdhui" + aujourdui);
		
		if(hours<24) {
		
		
		commandeRepo.delete(commande);

		return ResponseEntity.ok(this.commandeRepo.findAll());
		
		}
		return ResponseEntity.status(400).body("pas possible de supprimer une commande de scéances si moins de 24 avant la Scéances");
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteCommande(@RequestBody Commande commande){
		
		Commande id = commandeRepo.findByIdCommande(commande.getIdCommande());
		
		if(id != null) {
			commandeRepo.delete(commande);
		}else {
			 ResponseEntity.status(400).body("le cinema a supprimer n'existe pas en base");
		}
		
		 return ResponseEntity.ok(this.commandeRepo.findAll());
	}



}

	
	
	

