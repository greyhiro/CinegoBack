package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.cesi.ril18.CineGoBack.entities.Sceances;

public interface SceanceRepository extends CrudRepository<Sceances, Integer>{

	
	List<Sceances> findAll();
	Sceances findByIdSceance(int idSceance);
	
	
	
	@Query(
            value = "SELECT f.ID_Film, f.NOM_FILM ,f. AFFICHE_FILM , s.DATE_ET_HEURE_SCEANCE FROM FILM  F, SCEANCES S WHERE 1? = s.FK_FILM",
            nativeQuery = true
    )
    Iterable<Integer> findAllBySessionDate(Integer idFilm);
	
}
