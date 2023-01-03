package com.nabil.SystemRecrutement.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="RECRUTEUR")
public class recruteur extends AbstractEntity {
	
	
	private String cin ;
	private int age ;
	private String email ;
	@Column(name="nom")
	private String nom ;
	@Column(name="prenom")
	private String prenom ;
	//@Embedded 
  //	private Adresse adresse ;
	@Column(name="photo")
	private String photo ;
	@Column(name="tele")
	private String tele ; 
	@Column(name="login")
	private String login ;
	@Column(name="password")
	private String password ; 
	private String Poste ;
	
	@Column(name="adresse1")
	private String adresse1 ;
	
	@Column(name="ville")
	private String ville ;
	
	@Column(name="codepostale")
	private String codePostale ;
	
	@Column(name="pays")
	private String pays ;
	
	@Column(name = "identreprise")
	private Long idEntreprise;
	
	//mappedBy = "recruteur" ,
	
    //@OneToMany( mappedBy="recruteur")
   // private List<Offres> offres ;

	

}
