package fr.cesi.ril18.CineGoBack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idReservation;
	@Column
	private float prixReservation;
	

	

}
