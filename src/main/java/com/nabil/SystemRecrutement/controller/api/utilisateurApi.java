package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.utilisateurDto;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/utilisateur")
public interface utilisateurApi {
	
	
	
	
	@PostMapping(value=APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	utilisateurDto save(@RequestBody utilisateurDto dto);
	
	
	
	
	
	// http://localhost:8081/systemrecrutement/v1/utilisateur/All?id=1
	@GetMapping(value=APP_ROOT + "/utilisateur/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	utilisateurDto findById(Long id) ;
	
	
	@DeleteMapping(value=APP_ROOT + "/candidat/delete/{idutilisateur}" )
	void  delete(@PathVariable("idutilisateur")  Long id) ;

}
