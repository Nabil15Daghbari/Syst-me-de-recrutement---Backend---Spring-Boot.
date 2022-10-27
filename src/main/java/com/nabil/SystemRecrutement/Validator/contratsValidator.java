package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.contratsDto;




public class contratsValidator {
	
	public static List<String> validate(contratsDto contratsDto){
		
		List<String> errors= new ArrayList<>() ;
		
		
		if(contratsDto ==null) {
			
			errors.add("Veuillez renseigner la date Debut");
			errors.add("Veuillez renseigner le salaire ");
			errors.add("Veuillez renseigner le signature du contrat");
			
			return errors ;
		}
		
		
		
		
		
		
        if(contratsDto.getDateDebut()==null) {
			
			errors.add("Veuillez renseigner la date du debut");	
		}
		

       
		
         if(contratsDto.getSalaire()==null) {
			
			errors.add("Veuillez renseigner le salaire ");	
		}
         
         if(!StringUtils.hasLength(contratsDto.getSignature())) {
 			errors.add("Veuillez renseigner le signature du contrat ");
 		} 
		
		return errors ;

}
	
}
