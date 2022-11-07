package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.AffectationDto;
import com.nabil.SystemRecrutement.model.Affectation;

public interface AffectationService {
	
	List<AffectationDto> findAll();
	
    List<AffectationDto> findAffectationByIdCandidat(Long idCandidat);
    
    Affectation update(Long id , Affectation affectation) ;
    

}
