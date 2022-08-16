package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.RecruteurApi;
import com.nabil.SystemRecrutement.dto.recruteurDto;
import com.nabil.SystemRecrutement.service.RecruteurService;

@RestController
public class RecruteurController implements RecruteurApi{
	
	
	private RecruteurService recruteurService ;
	
	@Autowired
	public RecruteurController (RecruteurService recruteurService  ) {
		this.recruteurService= recruteurService ;
	}

	@Override
	public recruteurDto save(recruteurDto dto) {
		return recruteurService.save(dto);
	}

	@Override
	public recruteurDto findById(Long id) {
		return recruteurService.findById(id);
	}

	@Override
	public List<recruteurDto> findAll() {
		return recruteurService.findAll();
	}

	@Override
	public void delete(Long id) {
		recruteurService.delete(id);		
	}
	
	
	

}
