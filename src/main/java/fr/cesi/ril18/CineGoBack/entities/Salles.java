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
	@Column(length = 15000)
	private String FichierXMLplace;
	
	@ManyToOne
	@JoinColumn (name="fk_Cinema")
	private Cinema idCinema;
	

public String CreateFichierXML(int nbplace, int nbplaceHandicapet) {
		
		
		
		String Json = "{ \"places\" : { \"placeNormal\":[";
		
		for (int i=0; i<=nbplace; i++)
		{
			Json += "{  \"prise\":  \"false\",";
			Json += "\"id\"" +":"+ i;
			if(nbplace>i) {
				Json += "},";
			}
				else {
					Json +="}";
				}
			}
		
		
		Json +="],  \"PlaceHandicapet: \":[";
		
		for (int i=0; i<=nbplaceHandicapet; i++)
		{
			Json += "{  \"prise\":  \"false\",";
			Json += "\"id\"" +":"+ i;
			if(nbplace>i) {
				Json += "},";
			}
				else {
					Json +="}";
				}
			}
		
		Json += "]}}";
		System.out.println(Json);
		
		
		return Json;
		
	}
	
	
}
