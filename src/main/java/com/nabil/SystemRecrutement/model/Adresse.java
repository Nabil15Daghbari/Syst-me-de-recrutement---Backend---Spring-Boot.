package com.nabil.SystemRecrutement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode
@Data

@Embeddable
public class Adresse implements Serializable {
	
	
	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	//public String getAdresse2() {
	//	return adresse2;
	//}

	//public void setAdresse2(String adresse2) {
	//	this.adresse2 = adresse2;
	//}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="adresse1")
	private String adresse1 ;
	
	//@Column(name="adresse2")
	//private String adresse2 ;
	
	@Column(name="ville")
	private String ville ;
	
	@Column(name="codepostale")
	private String codePostale ;
	
	@Column(name="pays")
	private String pays ;
	
	//@Column(name="idEntreprise")
	//private Integer idEntreprise ;
	

}

