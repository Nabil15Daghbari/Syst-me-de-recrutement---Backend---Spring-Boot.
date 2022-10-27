


package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.servApi;
import com.nabil.SystemRecrutement.dto.ServicesDto;
import com.nabil.SystemRecrutement.service.servService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class servController implements servApi {

	
	
	private servService servService ;
	
	public servController(servService servService) {
		this.servService=servService ;
	}
	
	
	
	@Override
	public List<ServicesDto> findAll() {
		return servService.findAll();
	}



	@Override
	public ServicesDto save(ServicesDto dto) {
		return servService.save(dto);
	}



	@Override
	public void delete(Long id) {
		servService.delete(id);		
	}

}
