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
import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.dto.auth.RoleUserFrom;
import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/user")
public interface AccountApi {
	
	
	@PostMapping(path=APP_ROOT + "/createUser")
	appUserDto saveUser(@RequestBody appUserDto appUser );
	
	
	@GetMapping(path=APP_ROOT +"/users")
	List<AppUser> appUsers();
	
	@PostMapping(path=APP_ROOT + "/createRole")
	AppRole saveRole(@RequestBody AppRole appRole);
	
	@PostMapping(path=APP_ROOT + "/addRoleToUser")
	void addRoleToUser(@RequestBody RoleUserFrom RoleUserFrom);
	
	
	@GetMapping(value=APP_ROOT + "/user/{idUtilisateur}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher un utlisateur par ID  " , notes="Cette methode permet de chercher   un utlisateur par son ID" , response = CandidatDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'utlisateur a ete trouvee dans l BD"),
				@ApiResponse(code = 404 , message = "Aucun utlisateur n'existe dans BDD avec l'ID fourni")
		})
	appUserDto findById(@PathVariable("idUtilisateur") Long id) ;
	
	
	
	 @DeleteMapping(value=APP_ROOT + "/user/delete/{idUtilisateur}" )
	 @ApiOperation(value="supprimer un utilisateur par ID  " , notes="Cette methode permet de supprimer un utilisateur par son ID" , response = utilisateurDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'utlisateur a ete supprimer dans l BD"),
				
		})
	 void  delete(@RequestParam("idUtilisateur") Long id) ;
	

}


