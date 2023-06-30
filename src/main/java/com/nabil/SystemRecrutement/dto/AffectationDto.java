package com.nabil.SystemRecrutement.dto;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.nabil.SystemRecrutement.model.Affectation;
import com.nabil.SystemRecrutement.model.demandes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AffectationDto {
	
	private Long id ;
	private String dateAffectation ;
	private String nomService ;

	private demandesDto demandes ;
	private List<ServicesDto> services  ;
	
	
	
	
public static AffectationDto fromEntity(Affectation affectation ) { 
		
		if(affectation == null) {
			return null ; 
		}
		
		return   AffectationDto.builder()
				.id(affectation.getId())
				.dateAffectation(affectation.getDateAffectation())
				.nomService(affectation.getNomService())
				.demandes(demandesDto.fromEntity(affectation.getDemandes()))
				.services(
						   affectation.getServices()  != null ?
					   affectation.getServices() .stream()
						   .map(ServicesDto::fromEntity)
						   .collect(Collectors.toList()) : null
						
						)
		
				.build();		
						
						
				
	}
	
	public static Affectation toEntity(AffectationDto affectationDto) {
		if(affectationDto==null) {
			return null ;
			
		}
		
		Affectation affectation =new Affectation();
		affectation.setId(affectationDto.getId());
		affectation.setNomService(affectationDto.getNomService());
		affectation.setDateAffectation(affectationDto.getDateAffectation());
		affectation.setDemandes(demandesDto.toEntity(affectationDto.getDemandes()));
		
		
		return affectation ;
		
	}


}
