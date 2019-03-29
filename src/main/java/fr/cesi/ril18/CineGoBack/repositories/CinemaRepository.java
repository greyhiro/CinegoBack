package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import fr.cesi.ril18.CineGoBack.entities.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

	List<Cinema> findAll();
	
	Cinema findByIdCinema(Integer IdCinema);
	
}
