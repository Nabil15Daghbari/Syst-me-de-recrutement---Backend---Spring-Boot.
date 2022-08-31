package com.nabil.SystemRecrutement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nabil.SystemRecrutement.dto.AdresseDto;

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
@Table(name="admin")
public class Admin extends AbstractEntity {
	
	private String nom ; 
	
	private String prenom ;
		
	private String email ;
	
	private String password ;
	
	private int age ;
	
	private String Telephone ;
	
	private String login ;
	
	
	private String photo ;
	
	
	@OneToMany(mappedBy = "admin")
	private List<Offres> offres ;
	

}
