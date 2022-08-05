package com.nabil.SystemRecrutement.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import com.nabil.SystemRecrutement.model.contrats;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class contratsDto {
	
	private Long     id  ;
	private String   nomCandidat ;	
	private String  prenomCandidat ;	
	private Instant  dateDebut ;	
	private Instant  dateFin ;	
	private BigDecimal salaire ;	
	private String   signature ; 	
	private List<CandidatDto> candidat ;	
	private List<demandesDto> demandes ;
	
	
	
	public static contratsDto fromEntity(contrats contrats ) {
		
		if(contrats == null) {
			return null ;
		}
		
		return contratsDto.builder()
				.id(contrats.getId())
				.nomCandidat(contrats.getNomCandidat())
				.prenomCandidat(contrats.getPrenomCandidat())
				.dateDebut(contrats.getDateDebut())
				.dateFin(contrats.getDateFin())
				.salaire(contrats.getSalaire())
				.signature(contrats.getSignature())
				.candidat(
						contrats.getCandidat()!=null ?
						contrats.getCandidat().stream()	
					    .map(CandidatDto::fromEntity)
					    .collect(Collectors.toList()) : null
						
						)
				.demandes(
						contrats.getDemandes()!=null ?
						contrats.getDemandes().stream()	
						.map(demandesDto::fromEntity)
						.collect(Collectors.toList()) : null
						)
				.build();
	}
	
	
	public static contrats  toEntity(contratsDto contratsDto ) {
		
		if(contratsDto==null) {
			return null ;
		}
		
		contrats contrats = new contrats();
		contrats.setId(contratsDto.getId());
		contrats.setNomCandidat(contratsDto.getNomCandidat());
		contrats.setPrenomCandidat(contratsDto.getPrenomCandidat());
		contrats.setDateDebut(contratsDto.getDateDebut());
		contrats.setDateFin(contratsDto.getDateFin());
		contrats.setSalaire(contratsDto.getSalaire());
		contrats.setSignature(contratsDto.getSignature());
		
		
		
		
		
		return contrats ;
	}

}
