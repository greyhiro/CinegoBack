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

import fr.cesi.ril18.CineGoBack.entities.Reservation;
import fr.cesi.ril18.CineGoBack.repositories.ReservationRepository;


@RestController
@RequestMapping("Reservation")
public class reservationController {

	@Autowired
	ReservationRepository repoReservation;
	
	@PostMapping("/Create")
	public ResponseEntity<?> ajouterReservation(@RequestBody Reservation reservation) {

		
		
		Reservation id = repoReservation.findByIdReservation(reservation.getIdReservation());
				
				if(id != null) {
					return ResponseEntity.status(400).body("deja present en BDD");
				}
	
		
			repoReservation.save(reservation);
			return ResponseEntity.ok(this.repoReservation.findAll());

	}
	
	@GetMapping
	public List<Reservation> GetFilms() {
		
		return repoReservation.findAll();
	}
	
	@PutMapping("/Modif/{id}")
	public ResponseEntity<?> updateReservation(@RequestBody Reservation reservation, @PathVariable Integer id) {

		Optional<Reservation> reservationOptionnal = repoReservation.findById(id);

		if (!reservationOptionnal.isPresent())
			return ResponseEntity.status(400).body("La reservation n'existe pas en base");

		reservation.setIdReservation(id);
		
		repoReservation.save(reservation);

		return ResponseEntity.ok(this.repoReservation.findAll());
	}
	 
	
	 @PostMapping("/Delete/{id}")
	 public ResponseEntity<?>  deleteFilm(@RequestBody Reservation reservation ,@PathVariable Integer id){
		 
			Optional<Reservation> reservationOptionnal = repoReservation.findById(id);

			if (!reservationOptionnal.isPresent())
				return ResponseEntity.status(400).body("Ce film n'existe pas en base");

			reservation.setIdReservation(id);
			
			repoReservation.delete(reservation);

			return ResponseEntity.ok(this.repoReservation.findAll());
	 }

	
	 @PostMapping("/Delete")
	 public ResponseEntity<?>  deleteFilm(@RequestBody Reservation reservation){
		 
		 Reservation id = repoReservation.findByIdReservation(reservation.getIdReservation());
		 
		 if(id !=null) {
			 
			 repoReservation.delete(reservation);
		 }else {
			 ResponseEntity.status(400).body("le film a supprimer n'existe pas en base");
		 }
		 
		 
		 return ResponseEntity.ok(this.repoReservation.findAll());
	 }

}