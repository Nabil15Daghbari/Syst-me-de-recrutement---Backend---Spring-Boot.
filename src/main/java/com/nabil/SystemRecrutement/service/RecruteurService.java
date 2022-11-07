package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.recruteurDto;
import com.nabil.SystemRecrutement.model.recruteur;

public interface RecruteurService {
	
	
	 recruteurDto save(recruteurDto dto) ;
		
	 recruteurDto findById(Long id);
		
	 List<recruteurDto> findAll();
	 
	 
	 recruteur update(Long id , recruteur recruteur );
		
	 void delete(Long id);

}
