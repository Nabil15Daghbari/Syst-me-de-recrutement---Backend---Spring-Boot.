package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// un condidat va postuler un demande 

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="DEMANDES")
public class demandes extends AbstractEntity {

	private Date dateDemande ;
	private float resultatConcours ;
	private int StatutCondidature ;
	private etatDemande etatDemande ;
	
	
	
	@ManyToOne
	private Candidat candidat ;
	
	
	@ManyToOne
	private Offres offre ;

}
