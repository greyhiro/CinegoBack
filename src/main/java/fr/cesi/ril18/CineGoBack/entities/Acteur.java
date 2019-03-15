package fr.cesi.ril18.CineGoBack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActeur;
	@Column
	private String nomActeur;
	@ManyToOne
	@JoinColumn(name= "FK_Film")
	private Film film;
	
	

}
