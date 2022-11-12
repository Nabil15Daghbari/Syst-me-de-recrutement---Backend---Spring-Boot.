package com.nabil.SystemRecrutement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.EntretienApi;
import com.nabil.SystemRecrutement.dto.entretienDto;
import com.nabil.SystemRecrutement.service.entretienService;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")

public class EntretienController implements EntretienApi{
	
	
	private entretienService entretienService ;
	
	@Autowired
	public EntretienController (entretienService entretienService ) {
		this.entretienService =entretienService  ;
	}

	@Override
	public entretienDto save(entretienDto dto) {
		return entretienService.save(dto);
	}

	@Override
	public entretienDto findById(Long id) {
		return entretienService.findById(id);
	}

	@Override
	public List<entretienDto> findAll() {
		return entretienService.findAll();
	}

	@Override
	public void delete(Long id) {
		
		entretienService.delete(id);
		
	}

}
