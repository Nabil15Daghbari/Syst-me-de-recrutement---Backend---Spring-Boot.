package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.model.Utilisateur;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/utilisateur")
public interface UtilisateurApi {
	
	
	
	
	@PostMapping(value=APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un utilisateur " , notes="Cette methode permet d'enregistrer ou modofier un utilisateur " , response = Utilisateur.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="l'utilisateur cree / modifie") ,
			@ApiResponse(code=400 , message="l'utilisateur n'est pas valide ")
	})
	utilisateurDto save(@RequestBody utilisateurDto dto);
	
	
	
	
	
	// http://localhost:8081/systemrecrutement/v1/utilisateur/All?id=1
	@GetMapping(value=APP_ROOT + "/utilisateur/{idUtilisateur}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher un utlisateur par ID  " , notes="Cette methode permet de chercher   un utlisateur par son ID" , response = CandidatDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'utlisateur a ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun utlisateur n'existe dans BDD avec l'ID fourni")
		})
	utilisateurDto findById(@PathVariable("idUtilisateur") Long id) ;
	
	
	
	@GetMapping(value=APP_ROOT + "/utilisateur/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les utilisateur dans BDD" , notes="Cette methode permet de chercher les utilisateur dans BDD" , response = CandidatDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les utilisateurs ont ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun utilisateur n'existe dans BDD avec l'ID fourni")
		})
	 List<utilisateurDto> findAll() ;
	
	
	
	
	
	 @DeleteMapping(value=APP_ROOT + "/utilisateur/delete/{idUtilisateur}" )
	 @ApiOperation(value="supprimer un utilisateur par ID  " , notes="Cette methode permet de supprimer un utilisateur par son ID" , response = utilisateurDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'utlisateur a ete supprimer dans l BD"),
				
		})
	 void  delete(@RequestParam("idUtilisateur") Long id) ;
	
}
