package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.UTILISATEUR_ENDPOINT;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.ChangerMotDePasseUtilisateurDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import io.swagger.annotations.Api;



@Api("utilisateurs")
public interface UtilisateurApi {
	
	
	
	 @PostMapping(UTILISATEUR_ENDPOINT + "/create")
	  utilisateurDto save(@RequestBody utilisateurDto dto);

	  @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
	  utilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

	  @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
	  utilisateurDto findById(@PathVariable("idUtilisateur") Long id);

	  @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
	  utilisateurDto findByEmail(@PathVariable("email") String email);

	  @GetMapping(UTILISATEUR_ENDPOINT + "/all")
	  List<utilisateurDto> findAll();

	  @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
	  void delete(@PathVariable("idUtilisateur") Long id);

	 
	
	
}
