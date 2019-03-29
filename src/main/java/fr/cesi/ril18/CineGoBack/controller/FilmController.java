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
import fr.cesi.ril18.CineGoBack.entities.Film;
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;

@RestController
@RequestMapping("Film")
public class FilmController {
	
	@Autowired
	FilmRepository repoFilm;
	
	@PostMapping("/CreateFilm")
	public ResponseEntity<?> ajouterFilm(@RequestBody Film film) {

		
		
		Film nom = repoFilm.findBynomFilm(film.getNomFilm());
				
				if(nom != null) {
					return ResponseEntity.ok("deja present en BDD");
				}
		
			repoFilm.save(film);
			return ResponseEntity.ok(this.repoFilm.findAll());	
	
	}
	
	@GetMapping
	public List<Film> GetFilms() {
		
		return repoFilm.findAll();
	}
	
	@PutMapping("/Modif/{id}")
	public ResponseEntity<?> updateFilm(@RequestBody Film film, @PathVariable Integer id) {

		Optional<Film> filmOptionnal = repoFilm.findById(id);

		if (!filmOptionnal.isPresent())
			return ResponseEntity.status(400).body("Ce film n'existe pas en base");

		film.setIdFilm(id);
		
		repoFilm.save(film);

		return ResponseEntity.ok(this.repoFilm.findAll());
	}
	 
	
	 @PostMapping("/Delete/{id}")
	 public ResponseEntity<?>  deleteFilm(@RequestBody Film film ,@PathVariable Integer id){
		 
			Optional<Film> filmOptionnal = repoFilm.findById(id);

			if (!filmOptionnal.isPresent())
				return ResponseEntity.status(400).body("Ce film n'existe pas en base");

			film.setIdFilm(id);
			
			repoFilm.delete(film);

			return ResponseEntity.ok(this.repoFilm.findAll());
	 }

	
	 @PostMapping("/Delete")
	 public ResponseEntity<?> deleteFilm(@RequestBody Film film){
		 
		 Film id = repoFilm.findByIdFilm(film.getIdFilm());
		 
		 if(id !=null) {
			 
			 repoFilm.delete(film);
		 }else {
			 ResponseEntity.status(400).body("le film a supprimer n'existe pas en base");
		 }
		 
		 
		 return ResponseEntity.ok(this.repoFilm.findAll());
	 }

}
