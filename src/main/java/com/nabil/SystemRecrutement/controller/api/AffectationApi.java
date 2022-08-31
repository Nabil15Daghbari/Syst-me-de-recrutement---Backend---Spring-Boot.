package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.nabil.SystemRecrutement.dto.AffectationDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(APP_ROOT + "/affectation")
public interface AffectationApi  {
	
	 @GetMapping(value=APP_ROOT + "/affectation/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les articles dans BDD" , notes="Cette methode permet de chercher les article dans BDD" , responseContainer =   "List<CandidatDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les candidats ont ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun candidat n'existe dans BDD avec l'ID fourni")
		})
	 List<AffectationDto> findAll() ;

}
