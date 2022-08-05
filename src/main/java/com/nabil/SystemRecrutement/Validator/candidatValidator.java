package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.CandidatDto;


// lors du l'envoi du la requette http pour  creé un nouvelle candidat du type candidatDto mais avant d'enregestrie on va fait une validation des entités du cette candidat 
public class candidatValidator {
	
	
	public static List<String> validate(CandidatDto candidatDto){
		
	List<String> errors= new ArrayList<>() ;
	
	if(candidatDto ==null) {
		errors.add("Veuillez renseigner le nom du candidat");
		errors.add("Veuillez renseigner le prenom du candidat");
		errors.add("Veuillez renseigner l'adresse");
		errors.add("Veuillez renseigner le numéro de telephone du candidat");
		errors.add("Veuillez renseigner l'email du candidat");
		errors.add("Veuillez renseigner Login du candidat");
		errors.add("Veuillez renseigner password du candidat");
		
		return errors ;
	}
	
	
	if(!StringUtils.hasLength(candidatDto.getNom())) {
		errors.add("Veuillez renseigner le nom du candidat");
	}
	
	if(!StringUtils.hasLength(candidatDto.getPrenom())) {
		errors.add("Veuillez renseigner le prenom du candidat");
	}
	
	if(!StringUtils.hasLength(candidatDto.getTele())) {
		errors.add("Veuillez renseigner le numéro de telephone du candidat");
	}
	
	if(!StringUtils.hasLength(candidatDto.getEmail())) {
		errors.add("Veuillez renseigner l'email du candidat");
	}
	
	if(!StringUtils.hasLength(candidatDto.getLogin())) {
		errors.add("Veuillez renseigner Login du candidat");
	}
	
	if(!StringUtils.hasLength(candidatDto.getPassword())) {
		errors.add("Veuillez renseigner password du candidat");
	}
	
	
	if(candidatDto.getAdresse() == null) {
		errors.add("Veuillez renseigner l'adresse du candidat ");
	}else {
		if(!StringUtils.hasLength(candidatDto.getAdresse().getAdresse1())) {
			errors.add("Le champs Adresse 1' est obligatoire");
		}
		if(!StringUtils.hasLength(candidatDto.getAdresse().getVille())) {
			errors.add("Le champs 'Ville' est obligatoire");
		}
		if(!StringUtils.hasLength(candidatDto.getAdresse().getCodePostale())) {
			errors.add("Le champs 'Code postale' est obligatoire");
		}
		if(!StringUtils.hasLength(candidatDto.getAdresse().getPays())) {
			errors.add("Le champs 'Pays' est obligatoire");
		}
	}
	
	
	
	
	return errors ;
	}

}
