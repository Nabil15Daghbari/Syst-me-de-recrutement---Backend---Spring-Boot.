package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.entretienDto;

public interface entretienService {
	
	
	 entretienDto save(entretienDto dto) ;
		
	 entretienDto findById(Long id);
		
	 List<entretienDto> findAll();
		
	 void delete(Long id);
}
