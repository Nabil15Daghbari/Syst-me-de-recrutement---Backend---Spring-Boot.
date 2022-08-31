package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table(name="utilisateur")
public class Utilisateur extends AbstractEntity {
	
	@Column(name="nom")
	private String nom ;
	
	@Column(name="prenom")
	private String prenom ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name="datedenaissance")
	private Instant dateDeNaissance ;
	
	@Column(name="motdepasse")
    private	String motDePasse ;
    
	@Column(name="adresse")
    private Adresse adresse ;
    
	@Column(name="photo")
    private String photo ;
	

     @ManyToMany
     private List<Roles> roles;


	
		
		     
     

}
