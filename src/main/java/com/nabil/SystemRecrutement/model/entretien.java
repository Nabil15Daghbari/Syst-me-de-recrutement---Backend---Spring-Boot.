package com.nabil.SystemRecrutement.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="ENTRETIEN")
public class entretien extends AbstractEntity {
	
	@Column(name="code")
	private String code ;
	@Column(name="nomCandidat")
	private String   nomCandidat ;
	@Column(name="prenomCandidat")
	private String   prenomCandidat ;
	@Column(name="dateEntretien")
	private Instant  dateEntretien ;
	@Column(name="email")
	private String   email ; 
	

	@ManyToOne
	@JoinColumn(name="idcandidat")
	private Candidat candidat ;
	
	@ManyToOne
	@JoinColumn(name="idrecruteur")
	private recruteur  recruteur ;
	

}
