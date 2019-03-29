package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril18.CineGoBack.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

	List <Reservation>  findAll();
	Reservation findByIdReservation(Integer idReservation);
	
	
}
