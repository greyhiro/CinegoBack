package fr.cesi.ril18.CineGoBack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salles {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSalles;
	@Column
	private int nbplaces;
	@Column
	private int nbPlaceHandicap;
	@Column
	private String FichierXMLplace;
	
	@ManyToOne
	@JoinColumn (name="fk_Cinema")
	private Cinema idCinema;
	
	

	
	
}
