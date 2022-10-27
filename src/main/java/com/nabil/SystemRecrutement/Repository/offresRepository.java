package com.nabil.SystemRecrutement.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.model.Offres;

public interface offresRepository extends JpaRepository<Offres, Long>{
	
	
	 Optional<Offres> findOffresByCodeOffre(String codeOffre);

}
