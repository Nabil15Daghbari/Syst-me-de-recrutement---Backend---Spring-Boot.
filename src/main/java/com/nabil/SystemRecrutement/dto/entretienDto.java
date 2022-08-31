package com.nabil.SystemRecrutement.dto;

import java.time.Instant;

import com.nabil.SystemRecrutement.model.entretien;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class entretienDto {
	
	private String    code ;
	private Long      id  ;
	private String    nomCandidat ;
	private String    prenomCandidat ;
	private Instant   dateEntretien ;
	private String    email ; 
//	private CandidatDto  candidat ;
//	private recruteurDto  recruteur ;
	
	public static entretienDto fromEntity(entretien entretien) {
		if(entretien==null) {
			return null ;
		}
		
		return  entretienDto.builder()
				.code(entretien.getCode())
				.id(entretien.getId())
				.nomCandidat(entretien.getNomCandidat())
				.prenomCandidat(entretien.getPrenomCandidat())
				.dateEntretien(entretien.getDateEntretien())
				.email(entretien.getEmail())
		//		.candidat(CandidatDto.fromEntity(entretien.getCandidat()))
		//		.recruteur(recruteurDto.fromEntity(entretien.getRecruteur()))
				.build(); 
		
	}
	
	public static entretien toEntity(entretienDto entretienDto) {
		if(entretienDto==null) {
			return null ;
		}
		
		entretien entretien = new entretien();
		entretien.setCode(entretienDto.getCode());
		entretien.setId(entretienDto.getId());
		entretien.setNomCandidat(entretienDto.getNomCandidat());
		entretien.setPrenomCandidat(entretienDto.getPrenomCandidat());
		entretien.setDateEntretien(entretienDto.getDateEntretien());
		entretien.setEmail(entretienDto.getEmail());
	//	entretien.setCandidat(CandidatDto.toEntity(entretienDto.getCandidat()));
	//	entretien.setRecruteur(recruteurDto.toEntity(entretienDto.getRecruteur()));


		return entretien ;
		
	}

}
