package com.nabil.SystemRecrutement.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
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
	private etatDemande etatDemande ;
	
	
	
	@ManyToOne
	private Candidat candidat ;
	
	
	@ManyToOne
	private Offres offre ;

}
