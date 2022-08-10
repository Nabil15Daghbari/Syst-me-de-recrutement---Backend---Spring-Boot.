package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.dto.demandesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/demande")
public interface DemandesApi {

	
	@PostMapping(value = APP_ROOT + "/demande/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister une demande " , notes="Cette methode permet d'enregistrer ou modofier une demande " , response = CandidatDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le demande cree / modifie") ,
			@ApiResponse(code=400 , message="le demande n'est pas valide ")
	})
	demandesDto save(@RequestBody demandesDto dto);
}
