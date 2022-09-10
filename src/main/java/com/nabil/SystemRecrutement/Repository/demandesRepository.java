package com.nabil.SystemRecrutement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.demandes;

public interface demandesRepository extends JpaRepository<demandes, Long>{

	
	// demandesDto findDemandeByIdCandidat(Long id );
	
	
}
