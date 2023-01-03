package com.nabil.SystemRecrutement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name="services")
public class Services  extends AbstractEntity {
	
	private String nomServices ;
	
	@Column(name = "identreprise")
	private Long idEntreprise;
	
	@ManyToOne
	private Affectation affectation ;
	
	
	
	
	

}
