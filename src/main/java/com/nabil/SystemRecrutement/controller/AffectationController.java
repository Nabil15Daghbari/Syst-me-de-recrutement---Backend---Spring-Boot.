package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.AffectationApi;
import com.nabil.SystemRecrutement.dto.AffectationDto;
import com.nabil.SystemRecrutement.service.AffectationService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")

public class AffectationController implements AffectationApi{

	private AffectationService affectationService ;
	
	@Autowired
	public AffectationController(AffectationService affectationService ) {
		this.affectationService=affectationService ;
		
	}
	
	
	
	@Override
	public List<AffectationDto> findAll() {
		return affectationService.findAll();
	}



	@Override
	public List<AffectationDto> findAffectationByIdCandidat(Long idCandidat) {
		return affectationService.findAffectationByIdCandidat(idCandidat);
	}



	@Override
	public AffectationDto save(AffectationDto dto) {
		return affectationService.save(dto);
	}

}
