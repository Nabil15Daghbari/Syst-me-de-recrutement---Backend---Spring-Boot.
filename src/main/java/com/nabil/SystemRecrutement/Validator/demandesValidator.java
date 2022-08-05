package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.demandesDto;

public class demandesValidator {
	
	
	public static List<String> validate(demandesDto demandesDto){
		
		List<String> errors= new ArrayList<>();
		
		if(demandesDto==null) {
			errors.add("Veuillez renseigner le nom du candidat");
			errors.add("Veuillez renseigner le prenom du candidat");
			errors.add("Veuillez renseigner la date de demande ");
			errors.add("Veuillez renseigner le experiences professionnel");
			errors.add("Veuillez renseigner le diplome");
			errors.add("Veuillez renseigner le sivp");
			errors.add("Veuillez renseigner le CV ");
			errors.add("Veuillez renseigner la lettre du motivation ");
			errors.add("Veuillez renseigner le contact");
			errors.add("Veuillez renseigner l'email");
			
			return errors ;
		}
		
		
		if(!StringUtils.hasLength(demandesDto.getNomCondidat())) {
			errors.add("Veuillez renseigner le nom du candidat");
		}
		
		if(!StringUtils.hasLength(demandesDto.getPrenomCondidat())) {
			errors.add("Veuillez renseigner le prenom du candidat");
		}
		
		if(demandesDto.getDateDemande()==null) {
			errors.add("Veuillez renseigner la date de demande ");
			
		}
		
		if(!StringUtils.hasLength(demandesDto.getExperiencesProfessionnel())) {
			errors.add("Veuillez renseigner le experiences professionnel");
		}
		
		if(!StringUtils.hasLength(demandesDto.getDiplome())) {
			errors.add("Veuillez renseigner le diplome");
		}
		
		if(!StringUtils.hasLength(demandesDto.getSivp())) {
			errors.add("Veuillez renseigner le sivp");
		}
		
		if(!StringUtils.hasLength(demandesDto.getCv())) {
			errors.add("Veuillez renseigner le CV ");
		}
		
		if(!StringUtils.hasLength(demandesDto.getLettreMotivation())) {
			errors.add("Veuillez renseigner la lettre du motivation ");
		}
		
		if(!StringUtils.hasLength(demandesDto.getContact())) {
			errors.add("Veuillez renseigner le contact");
		}
		
		if(!StringUtils.hasLength(demandesDto.getEmail())) {
			errors.add("Veuillez renseigner l'email");
		}
		
		
		return errors ;
		
		
	}

}
