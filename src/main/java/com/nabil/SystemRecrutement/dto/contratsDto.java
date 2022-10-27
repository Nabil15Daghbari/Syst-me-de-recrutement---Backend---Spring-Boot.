package com.nabil.SystemRecrutement.dto;

import java.math.BigDecimal;
import java.time.Instant;
import com.nabil.SystemRecrutement.model.contrats;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class contratsDto {
	
	private String code ;
	private Long     id  ;
	private String   poste ;
	private Instant  dateDebut ;	
	private BigDecimal salaire ;	
	private String   signature ; 
	

	
	
	public static contratsDto fromEntity(contrats contrats ) {
		
		if(contrats == null) {
			return null ;
		}
		
		return contratsDto.builder()
				.code(contrats.getCode())
				.id(contrats.getId())
				.poste(contrats.getPoste())
				.dateDebut(contrats.getDateDebut())
				.signature(contrats.getSignature())
		
				.build();
		
	}
	
	
	public static contrats  toEntity(contratsDto contratsDto ) {
		
		if(contratsDto==null) {
			return null ;
		}
		
		contrats contrats = new contrats();
		contrats.setCode(contratsDto.getCode());
		contrats.setId(contratsDto.getId());
		contrats.setPoste(contratsDto.getPoste());
		contrats.setDateDebut(contratsDto.getDateDebut());
		contrats.setSalaire(contratsDto.getSalaire());
		contrats.setSignature(contratsDto.getSignature());

	
		return contrats ;
	}

}
