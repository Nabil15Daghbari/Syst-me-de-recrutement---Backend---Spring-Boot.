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
			
			
			return errors ;
		}
		
		
	
		
		
		
		if(demandesDto.getDateDemande()==null) {
			errors.add("Veuillez renseigner la date de demande ");
			
		}
		
		
		
		
		return errors ;
		
		
	}

}
