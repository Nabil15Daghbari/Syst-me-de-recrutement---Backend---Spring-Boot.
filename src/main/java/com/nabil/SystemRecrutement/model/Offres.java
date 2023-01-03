package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	
	
	private String codeOffre;
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
	private String dateExpiration;
	private int salaire ;
	
	@Column(name = "identreprise")
	private Long idEntreprise;
	
	@OneToMany(mappedBy = "offre")
	private List<demandes> demandes ;   
	
	//@ManyToOne
	//private recruteur recruteur  ;
	
	
	@ManyToOne
	private Admin admin ; 
	
	
	

}
