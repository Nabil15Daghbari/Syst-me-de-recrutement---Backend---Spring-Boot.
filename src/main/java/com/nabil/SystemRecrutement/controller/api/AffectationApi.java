package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.AffectationDto;
import com.nabil.SystemRecrutement.dto.demandesDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api( "/affectation")
public interface AffectationApi  {
	
	
	@PostMapping(value = APP_ROOT + "/affectation/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister une affectation " , notes="Cette methode permet d'enregistrer ou modofier une affectation " , response = AffectationDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="l'AffectationDto cree / modifie") ,
			@ApiResponse(code=400 , message="l'AffectationDto n'est pas valide ")
	})
	AffectationDto save(@RequestBody AffectationDto dto);
	
	
	
	 @GetMapping(value=APP_ROOT + "/affectation/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les affectation dans BDD" , notes="Cette methode permet de chercher les affectation dans BDD" , responseContainer = "List<ArticleDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les affecation ont ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun affectation n'existe dans BDD avec l'ID fourni")
		})
	 List<AffectationDto> findAll() ;
	 
	 
	 @GetMapping(value =APP_ROOT + "/affectations/filter/candidat/{idCandidat}", produces = MediaType.APPLICATION_JSON_VALUE)	 
	 @ApiOperation(value="rechercher les affectation dans BDD" , notes="Cette methode permet de chercher les affectation dans BDD" , response = AffectationDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les affecation ont ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun affectation n'existe dans BDD avec l'ID fourni")
		})
	 List<AffectationDto> findAffectationByIdCandidat(@PathVariable("idCandidat") Long idCandidat) ;
	 

}
