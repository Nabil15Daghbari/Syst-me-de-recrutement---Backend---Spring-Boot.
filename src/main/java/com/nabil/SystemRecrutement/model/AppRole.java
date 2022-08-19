package com.nabil.SystemRecrutement.model;

import java.util.Collection;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole extends AbstractEntity {

	
	private String roleName ;
}
