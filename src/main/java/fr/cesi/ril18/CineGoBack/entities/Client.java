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
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
	@Column
	private String nomClient;
	@Column
	private String prenomClient;
	@Column
	private int ageClient;
	@Column
	private String adrClient;
	
	@ManyToOne
	@JoinColumn(name = "fk_fidelite")
	private Fidelite numeroFidelite;

}
