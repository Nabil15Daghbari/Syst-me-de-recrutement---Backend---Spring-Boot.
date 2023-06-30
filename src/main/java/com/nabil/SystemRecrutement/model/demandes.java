package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
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
@Table(name="DEMANDES")
public class demandes extends AbstractEntity {

	private String cin ;
	private String nom ;   
	private String prenom ;
	private String adresse ;
	private String email ;
	private String tele ;
	private String poste ;
	
	private String dateDemande ;
	
	@Enumerated(EnumType.STRING)
	private etatDemande etatDemande ;
	
	
	@Column(name = "identreprise")
	private Long idEntreprise;

	
	@ManyToOne
	private Candidat candidat ;
	
	
	@ManyToOne
	@JoinColumn(name = "idoffre")
	private Offres offre ;
	
	
	@OneToMany(mappedBy = "demandes")
	private List<Affectation> affectation ;

}
