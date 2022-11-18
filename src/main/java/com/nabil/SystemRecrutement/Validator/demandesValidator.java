package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.demandesDto;

public class demandesValidator {
	
	
	public static List<String> validate(demandesDto demandesDto){
		
		List<String> errors= new ArrayList<>();
		
		if(demandesDto==null) {
			
			errors.add("Veuillez renseigner la date de demande ");
			errors.add("Veuillez renseigner votre cin ");
			errors.add("Veuillez renseigner votre nom ");
			errors.add("Veuillez renseigner votre prenom");
			errors.add("Veuillez renseigner  votre email ");



			
			
			
			return errors ;
		}
		
		
	
		
		
		
		if(demandesDto.getDateDemande()==null) {
			errors.add("Veuillez renseigner la date de demande ");
			
		}
		if(demandesDto.getCin()==null) {
			errors.add("Veuillez renseigner votre cin ");
			
		}
		if(demandesDto.getNom()==null) {
			errors.add("Veuillez renseigner votre nom ");
			
		}
		if(demandesDto.getPrenom()==null) {
			errors.add("Veuillez renseigner votre prenom");
			
		}
		if(demandesDto.getEmail()==null) {
			errors.add("Veuillez renseigner votre email ");
			
		}
		
		
		
		
		return errors ;
		
		
	}

}
