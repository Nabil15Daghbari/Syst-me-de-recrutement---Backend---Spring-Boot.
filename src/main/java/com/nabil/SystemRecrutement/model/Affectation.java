package com.nabil.SystemRecrutement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="affectation")
public class Affectation  extends AbstractEntity{
	
	
	private Date dateAffectation ; 

	@ManyToOne
	private Candidat candidat ;
	
	
	@OneToMany(mappedBy = "affectation")
	private List<Services> services  ;
	
	
}
