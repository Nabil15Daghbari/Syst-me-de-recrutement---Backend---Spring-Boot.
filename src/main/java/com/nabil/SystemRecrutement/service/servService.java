package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.ServicesDto;
import com.nabil.SystemRecrutement.model.Services;

public interface servService {
	
	ServicesDto save(ServicesDto dto) ;

	List<ServicesDto> findAll();
	
	ServicesDto  findById(Long id); 
	
	Services update(Long id , Services s) ;
		
	void delete(Long id);

}
