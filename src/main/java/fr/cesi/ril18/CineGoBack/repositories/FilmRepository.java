package fr.cesi.ril18.CineGoBack.repositories;


import fr.cesi.ril18.CineGoBack.entities.Film;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface FilmRepository extends CrudRepository<Film, Integer> {
	
	Film findBynomFilm(String nomFilm);

	List<Film> findAll();

	Film findByIdFilm(Integer Id);
	
	}


