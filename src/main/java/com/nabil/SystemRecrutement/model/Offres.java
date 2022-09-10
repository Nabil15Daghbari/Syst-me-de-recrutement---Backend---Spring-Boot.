package com.nabil.SystemRecrutement.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="OFFRES")
public class Offres extends AbstractEntity {
	
	private String poste ; 
	private String  mission ;
	private String connaissances ;
	private String niveauEtudes ;
	private String formation ;
	private String experience ;
	private String criteres;
	private String domaine ;
	private String langues ;
	private int nbrARecruter ;
	private String cantrat ;
	private String ville ;
	private Date dateExpiration;
	private Date dateOrale ;
	private Date dateConcours ;
	private int salaire ;
	
	
	@OneToMany(mappedBy = "offre")
	private List<demandes> demandes ;
	
	@ManyToOne
	private recruteur recruteur  ;
	
	
	@ManyToOne
	private Admin admin ; 
	
	

}
