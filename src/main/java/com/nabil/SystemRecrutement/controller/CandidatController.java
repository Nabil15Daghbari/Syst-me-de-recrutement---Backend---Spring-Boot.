package com.nabil.SystemRecrutement.controller;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.nabil.SystemRecrutement.controller.api.CandidatApi;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.service.CandidatService;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CandidatController implements CandidatApi {
	
	
	@Autowired
	ServletContext context ;
	
	
	
	// Field Injection
	private CandidatService candidatService ;
	
	// Constructor Injection
		public CandidatController(CandidatService candidatService) {
			this.candidatService = candidatService ;
		}

		
		@Override
		public CandidatDto save(CandidatDto dto )  {
			
			return candidatService.save(dto);
		}

		
		@Override
		public CandidatDto findById(Long id) {
			
			return candidatService.findById(id);
		}

		@Override
		public List<CandidatDto> findAll() {
			return candidatService.findAll();
		}

		@Override
		public void delete(Long id) {
			
			candidatService.delete(id);
		}


		

	
		

		
	}

