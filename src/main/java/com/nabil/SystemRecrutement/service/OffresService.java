package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.offresDto;

public interface OffresService {
	
	
	 offresDto save(offresDto dto) ;
		
	 offresDto findById(Long id);
		
	 List<offresDto> findAll();
		
	 void delete(Long id);
	 
	 
	 
	 offresDto  findOffresByCodeOffre(String codeOffre);
}
