package com.nabil.SystemRecrutement.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.nabil.SystemRecrutement.model.TypeContrats;
import com.nabil.SystemRecrutement.model.contrats;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class contratsDto {
	private String code ;
	private Long     id  ;
	private String   nomCandidat ;	
	private String  prenomCandidat ;	
	private String    Cin   ;
	private String   poste ;
	private Instant  dateDebut ;	
	private Instant  dateFin ;	
	private BigDecimal salaire ;	
	private String   signature ; 
	private TypeContrats typeContrats ;
	private List<CandidatDto> candidat ;	
	private List<demandesDto> demandes ;
	
	
	
	public static contratsDto fromEntity(contrats contrats ) {
		
		if(contrats == null) {
			return null ;
		}
		
		return contratsDto.builder()
				.code(contrats.getCode())
				.id(contrats.getId())
				.nomCandidat(contrats.getNomCandidat())
				.prenomCandidat(contrats.getPrenomCandidat())
				.Cin(contrats.getCin())
				.poste(contrats.getPoste())
				.dateDebut(contrats.getDateDebut())
				.dateFin(contrats.getDateFin())
				.salaire(contrats.getSalaire())
				.signature(contrats.getSignature())
				.typeContrats(contrats.getTypeContrats())
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
		contrats.setCode(contratsDto.getCode());
		contrats.setId(contratsDto.getId());
		contrats.setNomCandidat(contratsDto.getNomCandidat());
		contrats.setPrenomCandidat(contratsDto.getPrenomCandidat());
		contrats.setCin(contratsDto.getCin());
		contrats.setPoste(contratsDto.getPoste());
		contrats.setDateDebut(contratsDto.getDateDebut());
		contrats.setDateFin(contratsDto.getDateFin());
		contrats.setSalaire(contratsDto.getSalaire());
		contrats.setSignature(contratsDto.getSignature());
		contrats.setTypeContrats(contratsDto.getTypeContrats());
		
		
		
		
		
		return contrats ;
	}

}
