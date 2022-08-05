package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.nabil.SystemRecrutement.dto.offresDto;

public class offresValidator {
	
	public static List<String> validate(offresDto offresDto){
		
		List<String> errors= new ArrayList<>() ;
		
		if(offresDto ==null) {
			errors.add("Veuillez renseigner le titre");
			errors.add("Veuillez renseigner le description");
			errors.add("Veuillez renseigner la date du Creation");
			errors.add("Veuillez renseigner la date Cloture");
			errors.add("Veuillez renseigner les connaissances");
			errors.add("Veuillez renseigner l'experience");
			
			return errors ;
		}
		
		
		if(!StringUtils.hasLength(offresDto.getTitre())) {
			errors.add("Veuillez renseigner le titre");
		}
		if(!StringUtils.hasLength(offresDto.getDescription())) {
			errors.add("Veuillez renseigner le description");
		}
		if(offresDto.getDateCreation()==null) {
			errors.add("Veuillez renseigner la date du Creation");
		}
		if(offresDto.getDateCloture()==null) {
			errors.add("Veuillez renseigner la date Cloture");
		}
		if(!StringUtils.hasLength(offresDto.getConnaissances())) {
			errors.add("Veuillez renseigner les connaissances");
		}
		if(!StringUtils.hasLength(offresDto.getExperience())) {
			errors.add("Veuillez renseigner l'experience");
		}
		
		
		return errors ;

	}
}
