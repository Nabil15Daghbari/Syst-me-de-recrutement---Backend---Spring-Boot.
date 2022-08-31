

package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.dto.ServicesDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/service")
public interface servApi {
	

	@PostMapping(value = APP_ROOT + "/service/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un candidat " , notes="Cette methode permet d'enregistrer ou modofier un candidat " , response = CandidatDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le candidat cree / modifie") ,
			@ApiResponse(code=400 , message="le candidat n'est pas valide ")
	})
	ServicesDto save(@RequestBody ServicesDto dto);
	
	 @GetMapping(value=APP_ROOT + "/service/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les articles dans BDD" , notes="Cette methode permet de chercher les article dans BDD" , responseContainer =   "List<CandidatDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les candidats ont ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun candidat n'existe dans BDD avec l'ID fourni")
		})
	 List<ServicesDto> findAll() ;

	 
	 
	 @DeleteMapping(value=APP_ROOT + "/service/delete/{idService}" )
	 @ApiOperation(value="supprimer un candidat par ID  " , notes="Cette methode permet de supprimer un candidat par son ID" , response = CandidatDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le candidat a ete supprimer dans l BD"),
				
		})
	 void  delete(@RequestParam("idService") Long id) ;
}
