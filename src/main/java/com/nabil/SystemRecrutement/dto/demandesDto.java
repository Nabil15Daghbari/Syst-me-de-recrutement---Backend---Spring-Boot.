package com.nabil.SystemRecrutement.dto;

import java.util.Date;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.model.etatDemande;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class demandesDto {
    
	private Long    id ;
	private Date dateDemande ;
	private float resultatConcours ;
	private int StatutCondidature ;
	private CandidatDto candidat ;
	private offresDto offre ;
	private etatDemande etatDemande ;
	


	
	
	
	
	
	public static demandesDto fromEntity(demandes demande ) { 
		
		if(demande == null) {
			return null ; 
		}
		
		return   demandesDto.builder()
				.id(demande.getId())
				.dateDemande(demande.getDateDemande())
				.resultatConcours(demande.getResultatConcours())
				.StatutCondidature(demande.getStatutCondidature())
				.candidat(CandidatDto.fromEntity(demande.getCandidat()))
				.offre(offresDto.fromEntity(demande.getOffre()))
				.etatDemande(demande.getEtatDemande())
		
						.build();		
						
						
				
	}
	
	public static demandes toEntity(demandesDto demandesDto) {
		if(demandesDto==null) {
			return null ;
			
		}
		
		demandes demandes =new demandes();
		demandes.setId(demandesDto.getId());
		demandes.setDateDemande(demandesDto.getDateDemande());
		demandes.setResultatConcours(demandesDto.getResultatConcours());
		demandes.setStatutCondidature(demandesDto.getStatutCondidature());
		demandes.setCandidat(CandidatDto.toEntity(demandesDto.getCandidat()));
		demandes.setOffre(offresDto.toEntity(demandesDto.getOffre()));
		demandes.setEtatDemande(demandesDto.getEtatDemande());
		
		return demandes ;
		
	}
	
	@SuppressWarnings("static-access")
	public boolean  isDemandeAccepte() { 
		return etatDemande.ACCEPTER.equals(this.etatDemande);
	}

	
}
