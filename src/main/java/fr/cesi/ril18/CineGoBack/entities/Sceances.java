package fr.cesi.ril18.CineGoBack.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import fr.cesi.ril18.CineGoBack.entities.Salles;;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sceances {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idSceance;
	
	@Column
	private String dateEtHeureSceance;
	
	@ManyToOne
	@JoinColumn(name = "Fk_Film")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name ="FK_Salle")
	private Salles salle;
	

}