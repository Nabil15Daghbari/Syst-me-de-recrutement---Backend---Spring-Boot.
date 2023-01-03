package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.offresDto;
import com.nabil.SystemRecrutement.model.Offres;

public interface OffresService {
	
	
	public offresDto save(offresDto dto) ;
		
	public offresDto findById(Long id);
	 
	public Offres update(Long id , Offres offre) ;
		
	public List<offresDto> findAll();
		
	public void delete(Long id);
	 
	public offresDto  findOffresByCodeOffre(String codeOffre);
	
	
	public List<Object> avg();
}
