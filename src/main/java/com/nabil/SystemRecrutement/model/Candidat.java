package com.nabil.SystemRecrutement.model;

import javax.persistence.Embedded;
// inscription d'un condidat 

public class Candidat {
	
	private String nom ; 
	
	private String prenom ;
	
	
	@Embedded
	private Adresse adresse ;
	
	private String email ;
	
	private String dateNaissance ;
	
	private String Login ;
	
	private String password ;
	
	private String tele ;
	

}
