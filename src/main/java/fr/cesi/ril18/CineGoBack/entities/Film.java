package fr.cesi.ril18.CineGoBack.entities;



import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "FILM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idFilm;
	@Column
	private String nomFilm;
	@Column
	private String nomFilmOriginal;
	@Column(length = 15000)
	private String description;
	@Column
	private String afficheFilm;
	@Column
	private String dateRealisation;
	@Column
	private String video;
	
	public Film(String nomFilm, String nomFilmOriginal, String description, String afficheFilm, String dateRealisation,
			String video) {
		super();
		this.nomFilm = nomFilm;
		this.nomFilmOriginal = nomFilmOriginal;
		this.description = description;
		this.afficheFilm = afficheFilm;
		this.dateRealisation = dateRealisation;
		this.video = video;
	}
	
	
	
	
}
