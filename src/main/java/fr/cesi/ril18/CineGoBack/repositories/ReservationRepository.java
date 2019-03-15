package fr.cesi.ril18.CineGoBack.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril18.CineGoBack.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
