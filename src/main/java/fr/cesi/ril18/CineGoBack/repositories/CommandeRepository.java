package fr.cesi.ril18.CineGoBack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril18.CineGoBack.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {
	
	List <Commande> findAll();
	
	Commande findByIdCommande(Integer IdCommande);

}
