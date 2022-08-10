package com.nabil.SystemRecrutement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.DemandesApi;
import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.service.DemandesService;



@RestController
public class DemandesController implements DemandesApi {

	private DemandesService demandesService ;
	
	public DemandesController(DemandesService demandesService ) {
		this.demandesService=demandesService ;
	}
	
	
	@Override
	public demandesDto save(demandesDto dto) {
		return demandesService.save(dto);
	}

}
