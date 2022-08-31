package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.ServicesDto;

public interface servService {
	
	ServicesDto save(ServicesDto dto) ;

	List<ServicesDto> findAll();
	
	void delete(Long id);

}
