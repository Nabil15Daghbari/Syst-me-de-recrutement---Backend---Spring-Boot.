package com.nabil.SystemRecrutement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
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
	
	private String nomService ;

	@ManyToOne
    @JoinColumn(name = "idcandidat")
	private Candidat candidat ;
	
	
	@OneToMany(mappedBy = "affectation")
	private List<Services> services  ;
	
	
}
