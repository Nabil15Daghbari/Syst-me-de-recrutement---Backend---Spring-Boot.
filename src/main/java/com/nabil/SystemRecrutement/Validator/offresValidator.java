package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.nabil.SystemRecrutement.dto.offresDto;

public class offresValidator {
	
	public static List<String> validate(offresDto offresDto){
		
		List<String> errors= new ArrayList<>() ;
		
		if(offresDto ==null) {
			
			errors.add("Veuillez renseigner les connaissances");
			errors.add("Veuillez renseigner l'experience");
			
			return errors ;
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
