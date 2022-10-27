package com.nabil.SystemRecrutement.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="CONTRATS")
public class contrats extends AbstractEntity {

	@Column(name="code")
	private String code ;
	@Column(name="Poste")
    private String   poste ;
	@Column(name="dateDebut")
	private Instant  dateDebut ;
	@Column(name="salaire")
	private BigDecimal   salaire ;
	@Column(name="signature")
	private String   signature ; 

	
}
