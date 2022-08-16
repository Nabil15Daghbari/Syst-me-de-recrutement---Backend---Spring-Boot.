package com.nabil.SystemRecrutement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.nabil.SystemRecrutement.controller.api.ContratsApi;
import com.nabil.SystemRecrutement.dto.contratsDto;
import com.nabil.SystemRecrutement.service.ContratsService;

@RestController
public class ContratsController implements ContratsApi {
	
	private ContratsService contratsService ;
	
	@Autowired
	public ContratsController (ContratsService contratsService  ) {
		this.contratsService=contratsService ;
	}

	@Override
	public contratsDto save(contratsDto dto) {
		return contratsService.save(dto);
	}

	@Override
	public contratsDto findById(Long id) {
		return contratsService.findById(id);
	}

	@Override
	public List<contratsDto> findAll() {
		return contratsService.findAll();
	}

	@Override
	public void delete(Long id) {
		contratsService.delete(id);
		
	}

	



	

}
