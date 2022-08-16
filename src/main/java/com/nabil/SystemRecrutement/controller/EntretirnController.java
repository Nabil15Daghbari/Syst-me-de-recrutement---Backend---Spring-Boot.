package com.nabil.SystemRecrutement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.EntretienApi;
import com.nabil.SystemRecrutement.dto.entretienDto;
import com.nabil.SystemRecrutement.service.entretienService;


@RestController
public class EntretirnController implements EntretienApi{
	
	
	private entretienService entretienService ;
	
	@Autowired
	public EntretirnController (entretienService entretienService ) {
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
