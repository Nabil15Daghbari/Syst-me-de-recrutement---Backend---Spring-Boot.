package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.recruteurDto;

public interface RecruteurService {
	
	
	 recruteurDto save(recruteurDto dto) ;
		
	 recruteurDto findById(Long id);
		
	 List<recruteurDto> findAll();
		
	 void delete(Long id);

}
