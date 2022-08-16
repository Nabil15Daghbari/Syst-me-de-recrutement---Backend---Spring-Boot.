package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.entretienDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/entretien")
public interface EntretienApi {

	
	@PostMapping(value = APP_ROOT + "/entretien/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un entretien " , notes="Cette methode permet d'enregistrer ou modofier un entretien " , response = entretienDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="l'entretien cree / modifie") ,
			@ApiResponse(code=400 , message="l'entretien n'est pas valide ")
	})
	entretienDto save(@RequestBody entretienDto dto);
	
	
	
	
	 @GetMapping(value=APP_ROOT + "/entretien/{idEntretien}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="rechercher un entretien " , notes="Cette methode permet de chercher un entretien par son ID " , response = entretienDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'entretien a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun entretien n'existe dans BDD avec l'ID fourni")
		})
	 entretienDto findById(@PathVariable("idEntretien") Long id) ;
	 
	 
	 
	 
	 
	 
	 // http://localhost:8081/systemrecrutement/v1/candidat/All
	 
	 @GetMapping(value=APP_ROOT + "/entretien/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les entretien " , notes="Cette methode permet de chercher les entretiens dans BDD " , response = entretienDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les entretien  ont ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message=" Aucun entretienn'existe dans BDD avec l'ID fourni ")
		})
	 List<entretienDto> findAll() ;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //http://localhost:8081/systemrecrutement/v1/candidat/delete/7
	 @DeleteMapping(value=APP_ROOT + "/entretien/delete/{idEntretien}" )
	 @ApiOperation(value="supprimer un entretien " , notes="Cette methode permet de supprimer un entretien par son id " , response = entretienDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'entretien a ete supprimer dans la BDD") 		})
	 void  delete(@PathVariable("idEntretien") Long id) ;
	
}
