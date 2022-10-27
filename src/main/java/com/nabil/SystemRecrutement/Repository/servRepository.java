package com.nabil.SystemRecrutement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.model.Candidat;
import com.nabil.SystemRecrutement.model.Services;

public interface  servRepository  extends JpaRepository<Services, Long> {
	
	

}
