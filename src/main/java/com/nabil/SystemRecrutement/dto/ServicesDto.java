package com.nabil.SystemRecrutement.dto;

import com.nabil.SystemRecrutement.model.Services;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicesDto {
	
	
	private Long id  ;
	
	private String nomServices ;
	
	private AffectationDto affectation ;

	
	
public static ServicesDto fromEntity(Services services ) { 
		
		if(services == null) {
			return null ; 
		}
		
		return   ServicesDto.builder()
				.id(services.getId())
				.nomServices(services.getNomServices())
				.affectation(AffectationDto.fromEntity(services.getAffectation()))
		
				.build();		
						
						
				
	}
	
	public static Services toEntity(ServicesDto servicesDto) {
		if(servicesDto==null) {
			return null ;
			
		}
		
		Services services =new Services();
		services.setId(servicesDto.getId());
		services.setNomServices(servicesDto.getNomServices());
		services.setAffectation(AffectationDto.toEntity(servicesDto.getAffectation()));
		
		
		return services ;
		
	}


}
