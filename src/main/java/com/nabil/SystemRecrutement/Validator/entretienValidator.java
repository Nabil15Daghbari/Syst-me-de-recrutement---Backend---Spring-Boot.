package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.entretienDto;

public class entretienValidator {
	
	public static List<String> validate(entretienDto entretienDto){
		
		List<String> errors= new ArrayList<>() ;
		
		if(entretienDto ==null) {
			errors.add("Veuillez renseigner le nom du candidat");
			errors.add("Veuillez renseigner le prenom du candidat");
			errors.add("Veuillez renseignerla date d'entretien ");
			errors.add("Veuillez renseigner l'email ");
			
			return errors ;
		}
		
		
		
		if(!StringUtils.hasLength(entretienDto.getNomCandidat())) {
			errors.add("Veuillez renseigner le nom du candidat");
		}
		if(!StringUtils.hasLength(entretienDto.getPrenomCandidat())) {
			errors.add("Veuillez renseigner le prenom du candidat");
		}
		if(entretienDto.getDateEntretien()==null) {
			errors.add("Veuillez renseignerla date d'entretien ");
		}
		if(!StringUtils.hasLength(entretienDto.getEmail())) {
			errors.add("Veuillez renseigner l'email ");
		}
		
		return errors ;

	}
}
