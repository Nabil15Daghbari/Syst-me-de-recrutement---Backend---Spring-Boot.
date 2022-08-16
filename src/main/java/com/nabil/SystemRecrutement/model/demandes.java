package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// un condidat va postuler un demande 

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="DEMANDES")
public class demandes extends AbstractEntity {

	@Column(name="code")
	private String code ;
	@Column(name="nomCandidat")
	private String nomCondidat ;
	@Column(name="prenomCondidat")
	private String prenomCondidat ;
	@Column(name="dateDemande")
	private Instant dateDemande ;
	@Column(name="experiencesProfessionnel")
	private String  experiencesProfessionnel ;
	@Column(name="Diplome")
	private String  Diplome ;
	@Column(name="sivp")
	private String  sivp ;
	@Column(name="cv")
	private String cv ;
	@Column(name="lettreMotivation")
	private String lettreMotivation ;
	@Column(name="Contact")
	private String Contact ; 
	@Column(name="email")
	private String email ;
	@Column(name="etatDemande")
	private EtatDemande  etatDemande ;
	
	
	@ManyToOne
	@JoinColumn(name="idrecruteur")
	private recruteur recruteur ;
	
	@ManyToMany(mappedBy = "demandes")
	private List<Candidat> candidat ;
	
	
	@ManyToOne
	@JoinColumn(name="idcontrats")
	private contrats contrats ;
}
