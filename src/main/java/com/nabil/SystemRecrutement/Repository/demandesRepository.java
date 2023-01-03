package com.nabil.SystemRecrutement.Repository;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.model.etatDemande;

public interface demandesRepository extends JpaRepository<demandes, Long>{
	
      List<demandes> findAllByOffreId(Long idOffre);
      
      List<demandes> findDemandeByEtatDemande(etatDemande etat);
      
      List<demandes> findDemandeByCin(String cin);

      List<Object> countByEtatDemande(etatDemande etat);
      
      
      @Query(value="select COUNT(*) from demandes d where DATE_FORMAT(d.date_demande,'%Y-%m')=:annee",nativeQuery = true)
  	public List<demandes> GetNombreDemandeParMois(@Param("annee") String annee);
      
        @Query(value="select code_offre ,count(*) from demandes d inner join offres o on d.idoffre=o.id GROUP by code_offre\r\n",nativeQuery = true)
	   public List<?> GetNombreDemande();
  	
      List<Object> countByOffreId(Long idOffre);
    
}
