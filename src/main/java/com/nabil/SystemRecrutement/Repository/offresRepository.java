package com.nabil.SystemRecrutement.Repository;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nabil.SystemRecrutement.model.Offres;

public interface offresRepository extends JpaRepository<Offres, Long>{
	
	
	 Optional<Offres> findOffresByCodeOffre(String codeOffre);
	 
	@Query(value = "select avg(salaire) FROM Offres") 
	List<Object> avg();

}
