package com.nabil.SystemRecrutement.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import com.nabil.SystemRecrutement.model.Offres;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class offresDto {
     
	private String code ;
	private Long   id  ;
	private String  titre ;
	private String  description ;
	private Instant dateCreation ;
	private Instant dateCloture ;
	private String  connaissances  ;
	private String  experience ;
	private recruteurDto recruteur ;
	private List<CandidatDto> candidat ;
	
	
	public static offresDto fromEntity(Offres offres) {
		if(offres==null) {
			return null ;
		}
		
		return offresDto.builder()
				.code(offres.getCode())
				.id(offres.getId())
				.titre(offres.getTitre())
				.description(offres.getDescription())
				.dateCreation(offres.getDateCreation())
				.dateCloture(offres.getDateCloture())
				.connaissances(offres.getConnaissances())
				.experience(offres.getExperience())
				.recruteur(recruteurDto.fromEntity(offres.getRecruteur()))
				.candidat(
					        	  
						             offres.getCandidat() !=null ?
								     offres.getCandidat().stream() 
								     .map(CandidatDto :: fromEntity)
								   	.collect(Collectors.toList()) : null
									
									
						)
								    
		          .build();
	}

	public static Offres toEntity(offresDto offresDto ) {
		if(offresDto==null) {
			return null ;
		}
		
		Offres offres = new Offres();
		offres.setCode(offresDto.getCode());
		offres.setId(offresDto.getId()); 
		offres.setTitre(offresDto.getTitre());
		offres.setDescription(offresDto.getDescription());
		offres.setDateCreation(offresDto.getDateCreation());
		offres.setDateCloture(offresDto.getDateCloture());
		offres.setConnaissances(offresDto.getConnaissances());
		offres.setExperience(offresDto.getExperience());
		offres.setRecruteur(recruteurDto.toEntity(offresDto.getRecruteur()));
		
		
		return offres ;
		
		
		
	}
}
