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
import fr.cesi.ril18.CineGoBack.repositories.FilmRepository;

@RestController
@RequestMapping("Film/")
public class FilmController {
	
	@Autowired
	FilmRepository repoFilm;
	
	@PostMapping("/Create")
	public ResponseEntity<?> ajouterFilm(@RequestBody Film film) {

		
		
		Film nom = repoFilm.findBynomFilm(film.getNomFilm());
				
				if(nom != null) {
					return ResponseEntity.ok("deja present en BDD");
				}
		
		if(film != null) {
		
			repoFilm.save(film);
			return ResponseEntity.ok(this.repoFilm.findAll());	
		}
		return ResponseEntity.status(400).body("Vous devez ajouter un film valable");


	}
	
	@GetMapping
	public List<Film> GetFilms() {
		
		return repoFilm.findAll();
	}

}
