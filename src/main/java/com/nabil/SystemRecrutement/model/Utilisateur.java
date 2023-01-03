package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
	 @Column(name = "nom")
	  private String nom;

	  @Column(name = "prenom")
	  private String prenom;
	  
	  @Column(name = "description")
	  private String description;

	  @Column(name = "email")
	  private String email;

	  @Column(name = "datedenaissance")
	  private Instant dateDeNaissance;

	  @Column(name = "motdepasse")
	  private String moteDePasse;

	  
		@Column(name="adresse1")
		private String adresse1 ;
		
		@Column(name="ville")
		private String ville ;
		
		@Column(name="codepostale")
		private String codePostale ;
		  
		@Column(name="pays")
		private String pays ;
	  

	  @Column(name = "photo")
	  private String photo;
	  
	  

	  @ManyToOne
	  @JoinColumn(name = "idEntreprise")
	  private Entreprise entreprise;

	 

	  @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	  @JsonIgnore
     private List<Roles> roles;


	
		
		     
     

}
