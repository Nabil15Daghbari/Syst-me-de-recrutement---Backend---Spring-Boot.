package com.nabil.SystemRecrutement.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class AppUser extends AbstractEntity {
	
		
		private String cin ;
		private int age ;
		@Column(name="email")
		private String username ;
		private String password ;
		private String nom ;
		private String prenom ;
		private String telephone ;
		private String dateNes ;  
		private Adresse adresse ;
    
		@Column(name="photo")
		private String photo ;
	
		@ManyToMany(fetch = FetchType.EAGER)
		private Collection<AppRole> appRoles = new ArrayList<>() ;
}
