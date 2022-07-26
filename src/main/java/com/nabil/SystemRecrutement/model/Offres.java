package com.nabil.SystemRecrutement.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
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

// inteface Offre


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="OFFRES")
public class Offres extends AbstractEntity {
	
	@Column(name="titre")
	private String  titre ;
	@Column(name="description")
	private String  description ;
	@Column(name="dateCreation")
	private Instant dateCreation ;
	@Column(name="dateCloture")
	private Instant dateCloture ;
	@Column(name="connaissances")
	private String  connaissances  ;
	@Column(name="experience")
	private String  experience ;
	
	
	@ManyToOne
	@JoinColumn(name="idrecruteur")
	private recruteur recruteur ;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Candidat> candidat ;

}
