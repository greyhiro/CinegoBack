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
public class Cinema {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idCinema;
	@Column
	private String nomCinema;
	@Column
	private String adresseCinema;
	@Column
	private float prixEtudiant;
	@Column
	private float prixNormal;
	@Column
	private float prixHandicapet;
	@ManyToOne
	@JoinColumn(name= "fk_groupe")
	private Groupes groupe;
	
	


	

}
