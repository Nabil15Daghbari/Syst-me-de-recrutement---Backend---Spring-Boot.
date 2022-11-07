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
			errors.add("Veuillez renseigner le poste");
			errors.add("Veuillez renseigner le nombre à recruter");
			errors.add("Veuillez renseigner le salaire");
			
			return errors ;
		}
		
		
	
		if(!StringUtils.hasLength(offresDto.getConnaissances())) {
			errors.add("Veuillez renseigner les connaissances");
		}
		
		if(!StringUtils.hasLength(offresDto.getPoste())) {
			errors.add("Veuillez renseigner le poste");
		}
		if(offresDto.getNbrARecruter() == 0) {
			errors.add("Veuillez renseigner le nombre à recruter");
		}
		if(offresDto.getSalaire() == 0) {
			errors.add("Veuillez renseigner le salaire");
		}
		
		
		return errors ;

	}
}
