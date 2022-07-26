package com.nabil.SystemRecrutement.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name="CONTRATS")
public class contrats extends AbstractEntity {

	@Column(name="nomCandidat")
	private String   nomCandidat ;
	@Column(name="prenomCandidat")
	private String   prenomCandidat ;
	@Column(name="dateDebut")
	private Instant  dateDebut ;
	@Column(name="dateFin")
	private Instant  dateFin ;
	@Column(name="salaire")
	private BigDecimal   salaire ;
	@Column(name="signature")
	private String   signature ; 
	
	
	
	@OneToMany(mappedBy = "CONTRATS")
	private List<Candidat> candidat ;
	
	
	@OneToMany(mappedBy = "contrats")
	private List<demandes> demandes ;
	
}