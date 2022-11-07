package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.nabil.SystemRecrutement.dto.AffectationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api( "/affectation")
public interface AffectationApi  {
	
	
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
