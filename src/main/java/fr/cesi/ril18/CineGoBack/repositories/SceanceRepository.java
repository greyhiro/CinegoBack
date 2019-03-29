package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import fr.cesi.ril18.CineGoBack.entities.Sceances;

public interface SceanceRepository extends CrudRepository<Sceances, Integer>{

	
	List<Sceances> findAll();
	Sceances findByIdSecance(int idSceance);
	
	
}
