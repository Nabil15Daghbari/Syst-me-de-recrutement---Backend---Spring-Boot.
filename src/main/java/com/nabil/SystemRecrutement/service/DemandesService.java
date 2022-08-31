package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.etatDemande;


public interface DemandesService {
	
	 demandesDto save(demandesDto dto) ;
		
	 demandesDto findById(Long id);
		
	 List<demandesDto> findAll();
		
	 void delete(Long id);
	 
	 demandesDto updateEtatDemande(Long idDemande , etatDemande etatDemande  );
	 
	 /////////// Etat demandes v 36
 
}
