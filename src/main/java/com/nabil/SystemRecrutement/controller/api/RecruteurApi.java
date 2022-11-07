package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.recruteurDto;
import com.nabil.SystemRecrutement.model.recruteur;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api( "/recruteur")
public interface RecruteurApi {
	
	@PostMapping(value = APP_ROOT + "/recruteur/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un recruteur " , notes="Cette methode permet d'enregistrer ou modofier un recruteur " , response = recruteurDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le recruteur cree / modifie") ,
			@ApiResponse(code=400 , message="le recruteur n'est pas valide ")
	})
	recruteurDto save(@RequestBody recruteurDto dto);
	
	
	 @GetMapping(value=APP_ROOT + "/recruteur/{idRecruteur}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher un recruteupar son ID " , notes="Cette methode permet de chercher un recruteur par son ID dna l BDD" , response = recruteurDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le recruteur a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun recruteur n'existe dans BDD avec l'ID fourni")
		})
	 recruteurDto findById(@PathVariable("idRecruteur") Long id) ;
	 
	 // http://localhost:8081/systemrecrutement/v1/candidat/All
	 
	 @GetMapping(value=APP_ROOT + "/recruteur/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les recruteurs dans l BDD " , notes="Cette methode permet de chercher les recruteurs  " , responseContainer = "List<recruteurDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les recruteurs ont ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun recruteur n'existe dans BDD avec l'ID fourni")
		})
	 List<recruteurDto> findAll() ;
	 
	 
	 //http://localhost:8081/systemrecrutement/v1/candidat/delete/7
	 @DeleteMapping(value=APP_ROOT + "/recruteur/delete/{idRecruteur}" )
	 @ApiOperation(value="Supprimer un recruteur par son ID " , notes="Cette methode permet de supprimer un recruteur par son ID " , response = recruteurDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le recruteur  a ete supprimer dans l BDD") ,
		})
	 void  delete(@PathVariable("idRecruteur") Long id) ;
	
	 
	 @PutMapping(value=APP_ROOT + "/recruteur/update/{id}")
	 recruteur update(@PathVariable("id") Long id, @RequestBody recruteur recruteur) ; 
	 
	 
}
