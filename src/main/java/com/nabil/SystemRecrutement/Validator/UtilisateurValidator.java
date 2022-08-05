package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.utilisateurDto;


public class UtilisateurValidator {

	public static List<String> Validate(utilisateurDto utilisateurDto){
		
	List<String> errors = new ArrayList<>();
	
	if(utilisateurDto==null) {
		errors.add("Veuillez renseigner le nom d'utilisateur");
		errors.add("Veuillez renseigner le prenom d'utilisateur");
		errors.add("Veuillez renseigner le mot passe  d'utilisateur");
		errors.add("Veuillez renseigner l'adresse d'utilisateur");
		return errors ;
	}
	
	
	if(!StringUtils.hasLength(utilisateurDto.getNom())) {
		errors.add("Veuillez renseigner le nom d'utilisateur");
	}
	
	if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
		errors.add("Veuillez renseigner le prenom d'utilisateur");
	}
	if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
		errors.add("Veuillez renseigner l'email  d'utilisateur");
	}
	
	if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
		errors.add("Veuillez renseigner le mot passe  d'utilisateur");
	}
	
	if(utilisateurDto.getDateDeNaissance()==null) {
		errors.add("Veuillez renseigner la date de naissance  d'utilisateur");
	}
	
	if(utilisateurDto.getAdresse() == null) {
		errors.add("Veuillez renseigner l'adresse d'utilisateur");
	}else {
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
			errors.add("Le champs Adresse 1' est obligatoire");
		}
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
			errors.add("Le champs 'Ville' est obligatoire");
		}
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
			errors.add("Le champs 'Code postale' est obligatoire");
		}
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
			errors.add("Le champs 'Pays' est obligatoire");
		}
	}
	
	
	
	return errors ;
		
	}
}
