package fr.cesi.ril18.CineGoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	 @PatchMapping("/Modif")
	    public ResponseEntity<?> updateFilm(@RequestParam Integer id, @RequestBody Film film) {
	        
	        Film FilmToUpdate = repoFilm.findByIdFilm(id);
	        if (FilmToUpdate == null) {
	            
	            return  ResponseEntity.status(400).body("Le film choisi pour la modification n'est pas présent en base");
	        } 
	        
	        repoFilm.save(FilmToUpdate);
	        return ResponseEntity.ok(this.repoFilm.findAll());
	    }
	 
	 
	 @PostMapping("/Delete")
	 public ResponseEntity<?>  deleteFilm(@RequestBody Film film){
		 
		 Film id = repoFilm.findByIdFilm(film.getIdFilm());
		 
		 if(id !=null) {
			 
			 repoFilm.delete(film);
		 }else {
			 ResponseEntity.status(400).body("le film a supprimer n'existe pas en base");
		 }
		 
		 
		 return ResponseEntity.ok(this.repoFilm.findAll());
	 }

}
