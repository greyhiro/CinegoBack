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
import fr.cesi.ril18.CineGoBack.entities.Cinema;
import fr.cesi.ril18.CineGoBack.repositories.CinemaRepository;

@CrossOrigin
@RestController
@RequestMapping("Cinema")
public class CinemaController {

@Autowired 
CinemaRepository cinemaRepo;
	
	@GetMapping
	public List<Cinema> getCinema(){

		return cinemaRepo.findAll();

		
	}
	

	@PostMapping("/Create")
	public ResponseEntity<?> ajouterCinema(@RequestBody Cinema cinema) {

		
		
		Cinema id = cinemaRepo.findByIdCinema(cinema.getIdCinema());
				
				if(id != null) {
					return ResponseEntity.ok("deja present en BDD");
				}

			cinemaRepo.save(cinema);
			return ResponseEntity.ok(this.cinemaRepo.findAll());	

	}
	
	
	@PutMapping("Modif/{id}")
	public ResponseEntity<?> updateCinema(@RequestBody Cinema cinema , @PathVariable Integer id){
		
		Optional <Cinema> cinemaOptionnal = cinemaRepo.findById(id);
		
		if(!cinemaOptionnal.isPresent())
			return ResponseEntity.status(400).body("Cette sceance n'existe pas en base");
		
		cinema.setIdCinema(id);
		cinemaRepo.save(cinema);
		
		return ResponseEntity.ok(this.cinemaRepo.findAll());
		
	}
	
	
	@PostMapping("/Delete/{id}")
	public ResponseEntity<?> deleteCinema(@RequestBody Cinema cinema, @PathVariable Integer id){
		
		Optional<Cinema> cinemaOptionnal = cinemaRepo.findById(id);
		
		if(!cinemaOptionnal.isPresent()) {
			
			return ResponseEntity.status(400).body("Cette Scéance n'existe pas en base");
		}
		
		
		cinemaRepo.delete(cinema);
		
		return ResponseEntity.ok(this.cinemaRepo.findAll());
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSceance(@RequestBody Cinema cinema){
		
		Cinema id = cinemaRepo.findByIdCinema(cinema.getIdCinema());
		
		if(id != null) {
			cinemaRepo.delete(cinema);
		}else {
			 ResponseEntity.status(400).body("le cinema a supprimer n'existe pas en base");
		}
		
		 return ResponseEntity.ok(this.cinemaRepo.findAll());
	}

	
	

}

	

