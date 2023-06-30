package com.nabil.SystemRecrutement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.model.Affectation;


public interface Affectationrepository  extends JpaRepository<Affectation, Long>{
	
	  List<Affectation> findByDemandesId(Long idDemande);


}
