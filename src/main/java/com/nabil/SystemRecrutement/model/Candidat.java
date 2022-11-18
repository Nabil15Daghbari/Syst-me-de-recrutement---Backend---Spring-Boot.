package com.nabil.SystemRecrutement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// je cherche un candidat par son id et son id contrat ==> v 26


@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="CANDIDAT")

public class Candidat extends AbstractEntity{
	



	@Column(name="cin")
	private String cin ;
	@Column(name="nom")
	private String nom ; 
	@Column(name="prenom")
	private String prenom ;
	@Embedded
	private Adresse adresse ;
	@Column(name="email")
	private String email ;
	@Column(name="dateNaissance")
	private String dateNaissance ;
	@Column(name="photo")
	private String photo ;
	@Column(name="Login")
	private String Login ;
	@Column(name="password")
	private String password ;
	@Column(name="tele")
	private String tele ;
	

	
    
	@OneToMany(mappedBy = "candidat")
	private List<demandes> demandes ;
	
	
	@OneToMany(mappedBy = "candidat")
	private List<Affectation> affectation ;
	
	
	
	
	
	

}
