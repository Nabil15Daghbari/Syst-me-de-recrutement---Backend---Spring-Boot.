package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.nabil.SystemRecrutement.dto.recruteurDto;

public class recruteurValidator {
	
	
	public static List<String> validate(recruteurDto recruteurDto){
		
		List<String> errors= new ArrayList<>() ;
		
		if(recruteurDto ==null) {
			errors.add("Veuillez renseigner le nom ");
			errors.add("Veuillez renseigner le prenom ");
			errors.add("Veuillez renseigner l'adresse  ");
			errors.add("Veuillez renseigner le numéro de telephone ");
			errors.add("Veuillez renseigner Login ");
			errors.add("Veuillez renseigner password ");
			
			return errors ;
		}
		
		
		if(!StringUtils.hasLength(recruteurDto.getNom())) {
			errors.add("Veuillez renseigner le nom ");
		}
		if(!StringUtils.hasLength(recruteurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom ");		
			}
		
		
		
		
		
		if(recruteurDto.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse du recruteur ");
		}else {
			if(!StringUtils.hasLength(recruteurDto.getAdresse().getAdresse1())) {
				errors.add("Le champs Adresse 1' est obligatoire");
			}
			if(!StringUtils.hasLength(recruteurDto.getAdresse().getVille())) {
				errors.add("Le champs 'Ville' est obligatoire");
			}
			if(!StringUtils.hasLength(recruteurDto.getAdresse().getCodePostale())) {
				errors.add("Le champs 'Code postale' est obligatoire");
			}
			if(!StringUtils.hasLength(recruteurDto.getAdresse().getPays())) {
				errors.add("Le champs 'Pays' est obligatoire");
			}
			
			
			
			
			
		if(!StringUtils.hasLength(recruteurDto.getTele())) {
			errors.add("Veuillez renseigner le numéro de telephone ");
		}
		if(!StringUtils.hasLength(recruteurDto.getLogin())) {
			errors.add("Veuillez renseigner Login ");
		}
		if(!StringUtils.hasLength(recruteurDto.getPassword())) {
			errors.add("Veuillez renseigner password ");
		}

		
		
	}
		return errors ;
}
}
