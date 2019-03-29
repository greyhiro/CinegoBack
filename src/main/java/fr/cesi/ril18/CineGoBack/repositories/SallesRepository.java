package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril18.CineGoBack.entities.Salles;

public interface SallesRepository extends CrudRepository<Salles, Integer> {

	List <Salles> findAll();
	
	Salles findByIdSalles(Integer IdSalles);
	
	
}
