package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;
import com.nabil.SystemRecrutement.dto.RolesDto;

public class RolesValidator {
	
public List<String> Validator(RolesDto v) {
		
		List<String> errors = new ArrayList<>();
		
		if(v == null) {
			
			errors.add("Veuillez renseigner le nom du role");
			return errors ;
			
			
		}
		
		if(v.getRoleName()==null) {
			
			errors.add("Veuillez renseigner le nom du role");
			
		}
		


		
		
		return errors ;
	}

}
