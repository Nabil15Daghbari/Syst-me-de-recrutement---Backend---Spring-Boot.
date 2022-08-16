package com.nabil.SystemRecrutement.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.nabil.SystemRecrutement.model.EtatDemande;
import com.nabil.SystemRecrutement.model.demandes;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class demandesDto {
    
	private String code ;
	private Long    id ;
	private String  nomCondidat ;
	private String  prenomCondidat ;
	private Instant dateDemande ;
	private String  experiencesProfessionnel ;
	private String  Diplome ;
	private String  sivp ;
	private String  cv ;
	private String  lettreMotivation ;
	private String  Contact ; 
	private String   email ; 
	private EtatDemande etatDemande ;
	private recruteurDto recruteur ;
	private contratsDto contrats ;
	private List<CandidatDto> candidat ;
	
	public static demandesDto fromEntity(demandes demande ) { 
		
		if(demande == null) {
			return null ; 
		}
		
		return   demandesDto.builder()
				.code(demande.getCode())
				.id(demande.getId())
				.nomCondidat(demande.getNomCondidat())
				.prenomCondidat(demande.getPrenomCondidat())
				.dateDemande(demande.getDateDemande())
				.experiencesProfessionnel(demande.getExperiencesProfessionnel())
				.Diplome(demande.getDiplome())
				.sivp(demande.getSivp())
				.cv(demande.getCv())
				.lettreMotivation(demande.getLettreMotivation())
				.Contact(demande.getContact())
				.email(demande.getEmail())
				.etatDemande(demande.getEtatDemande())
				.recruteur(recruteurDto.fromEntity(demande.getRecruteur()))
				.contrats(contratsDto.fromEntity(demande.getContrats()))	
				.candidat(
						
						demande.getCandidat() !=null ?
						demande.getCandidat().stream()
				    	.map(CandidatDto:: fromEntity)
					    .collect(Collectors.toList()) : null
								
								)
						.build();		
						
						
				
	}
	
	public static demandes toEntity(demandesDto demandesDto) {
		if(demandesDto==null) {
			return null ;
			
		}
		
		demandes demandes =new demandes();
		demandes.setCode(demandesDto.getCode());
		demandes.setId(demandesDto.getId());
		demandes.setNomCondidat(demandesDto.getNomCondidat());
		demandes.setPrenomCondidat(demandesDto.getPrenomCondidat());
		demandes.setDateDemande(demandesDto.getDateDemande());
		demandes.setExperiencesProfessionnel(demandesDto.getExperiencesProfessionnel());
		demandes.setDiplome(demandesDto.getDiplome());
		demandes.setSivp(demandesDto.getSivp());
		demandes.setCv(demandesDto.getCv());
		demandes.setLettreMotivation(demandesDto.getLettreMotivation());
		demandes.setContact(demandesDto.getContact());
		demandes.setEmail(demandesDto.getEmail());
		demandes.setEtatDemande(demandesDto.getEtatDemande());
		demandes.setRecruteur(recruteurDto.toEntity(demandesDto.getRecruteur()));
		demandes.setContrats(contratsDto.toEntity(demandesDto.getContrats()));
		
		
		return demandes ;
		
	}

	
}
