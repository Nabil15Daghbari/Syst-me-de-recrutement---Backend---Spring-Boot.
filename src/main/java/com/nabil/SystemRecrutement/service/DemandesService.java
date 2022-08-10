package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.demandesDto;


public interface DemandesService {
	
	 demandesDto save(demandesDto dto) ;
		
	 demandesDto findById(Long id);
		
	 List<demandesDto> findAll();
		
	 void delete(Long id);
 
}
