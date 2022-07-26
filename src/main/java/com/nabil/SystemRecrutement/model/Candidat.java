package com.nabil.SystemRecrutement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
// inscription d'un condidat 
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="CANDIDAT")
public class Candidat extends AbstractEntity{
	
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
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<demandes> demandes ;
	
	
	@ManyToOne
	@JoinColumn(name="idCONTRATS")
	private contrats CONTRATS ;
	
	
	@ManyToMany(mappedBy = "candidat")
	private List<Offres> offres ;
	
	
	@OneToMany(mappedBy = "candidat")
	private List<entretien> entretien ;
	
	
	
	

}
