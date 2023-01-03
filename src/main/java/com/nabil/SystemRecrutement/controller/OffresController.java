package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.OffresApi;
import com.nabil.SystemRecrutement.dto.offresDto;
import com.nabil.SystemRecrutement.model.Offres;
import com.nabil.SystemRecrutement.service.OffresService;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class OffresController implements OffresApi{
	
	private OffresService offresService  ;
	
	
	@Autowired
	public OffresController (OffresService offresService  ) {
		this.offresService = offresService ;
	}


	@Override
	public offresDto save(offresDto dto) {
		return offresService.save(dto);
	}


	@Override
	public offresDto findById(Long id) {
		return offresService.findById(id);
	}


	@Override
	public List<offresDto> findAll() {
		return offresService.findAll();
	}


	@Override
	public void delete(Long id) {
		
		offresService.delete(id);
		
	}


	@Override
	public offresDto findOffresByCodeOffre(String codeOffre) {
		return offresService.findOffresByCodeOffre(codeOffre);
	}


	@Override
	public Offres update(Long id, Offres offre) {
		return offresService.update(id, offre);
	}


	@Override
	public List<Object> avgSalaire() {
		return offresService.avg();
	}

}
