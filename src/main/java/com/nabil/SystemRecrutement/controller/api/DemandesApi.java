package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.demandesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/demande")
public interface DemandesApi {

	
	@PostMapping(value = APP_ROOT + "/demande/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister une demande " , notes="Cette methode permet d'enregistrer ou modofier une demande " , response = demandesDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le demande cree / modifie") ,
			@ApiResponse(code=400 , message="le demande n'est pas valide ")
	})
	demandesDto save(@RequestBody demandesDto dto);
	
	
	
	 @GetMapping(value=APP_ROOT + "/demande/{idDemande}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @PostMapping(value = APP_ROOT + "/demande/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="rechercher une demande par son ID " , notes="Cette methode permet de chercher  une demande par son ID" , response = demandesDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le demande a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun demande n'existe dans BDD avec l'ID fourni")
		})
	 demandesDto findById(@PathVariable("idDemande") Long id) ;
	 
	 // http://localhost:8081/systemrecrutement/v1/demande/All
	 
	 @GetMapping(value=APP_ROOT + "/demande/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @PostMapping(value = APP_ROOT + "/demande/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Enregister une demande " , notes="Cette methode permet d'enregistrer ou modofier une demande " , response = demandesDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le demande a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun demande n'existe dans BDD avec l'ID fourni ")
		})
	 List<demandesDto> findAll() ;
	 
	 
	 //http://localhost:8081/systemrecrutement/v1/candidat/delete/7
	 @DeleteMapping(value=APP_ROOT + "/demande/delete/{idDemande}" )
	 @PostMapping(value = APP_ROOT + "/demande/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="supprimer une demande par ID " , notes="Cette methode permet de supprimer  une demande par son ID" , response = demandesDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le demande a ete supprimer dans l BD") 
		})
	 void  delete(@PathVariable("idDemande") Long id) ;
	
}
