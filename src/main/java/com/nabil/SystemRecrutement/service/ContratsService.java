package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.contratsDto;

public interface ContratsService {
	
	   contratsDto save(contratsDto dto) ;
		
	   contratsDto findById(Long id);
	   
	 //  contratsDto findByCodeContrat(String codeContrat);
		
		List<contratsDto> findAll();
		
		void delete(Long id);

}
