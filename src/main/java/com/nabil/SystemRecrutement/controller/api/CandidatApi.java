package com.nabil.SystemRecrutement.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.CandidatDto;



@Api(APP_ROOT + "/candidat")
public interface CandidatApi {
	
	
	@PostMapping(value = APP_ROOT + "/candidat/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un candidat " , notes="Cette methode permet d'enregistrer ou modofier un candidat " , response = CandidatDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le candidat cree / modifie") ,
			@ApiResponse(code=400 , message="le candidat n'est pas valide ")
	})
	
	CandidatDto save(@RequestBody CandidatDto dto);
	
	
	
	 CandidatDto findById(Long id) ;
	 
	 
	 
	 
	 
	 
	 // http://localhost:8081/systemrecrutement/v1/candidat/All
	 
	 @GetMapping(value=APP_ROOT + "/candidat/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 List<CandidatDto> findAll() ;
	 
	 
	void  delete(Long id) ;
	

}
