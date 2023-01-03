package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.model.etatDemande;


public interface DemandesService {
	
	 demandesDto save(demandesDto dto) ;
		
	 demandesDto findById(Long id);
		
	 List<demandesDto> findAll();
	 List<demandes> GetNombreDemande(String annee);

		
	 void delete(Long id);
	 
	 demandesDto updateEtatDemande(Long idDemande , etatDemande etatDemande  );
	 
	  List<demandesDto> findAllDemandeByIdOffre(Long idOffre);

	  List<demandesDto>  findByEtatDemande(etatDemande etat);   
	  
	  List<Object> findDemandeByEtatDemande(etatDemande etat);
      
      List<demandesDto>  findByCin(String cin);
      
      List<Object> calculerNombreDemandeByOffre(Long idOffre);
      
      
      
      public List<?> GetNombreDemandeByOffre();

}
