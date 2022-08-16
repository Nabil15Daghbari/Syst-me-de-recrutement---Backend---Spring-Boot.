package com.nabil.SystemRecrutement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nabil.SystemRecrutement.model.contrats;

@Repository

public interface contratsRepository extends JpaRepository<contrats, Long>{
	
//	Optional<contrats>  findContratByCodeContrat(String codeContrat);

}
