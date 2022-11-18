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
	private String cin ;
	private String nom ;   
	private String prenom ;
	private String adresse ;
	private String email ;
	private String tele ;
	private String poste ;
	private Date dateDemande ;
	private int StatutCondidature ;
	//private CandidatDto candidat ;
	private offresDto offre ;
	private etatDemande etatDemande ;
	


	
	
	
	
	
	public static demandesDto fromEntity(demandes demande ) { 
		
		if(demande == null) {
			return null ; 
		}
		
		return   demandesDto.builder()
				.id(demande.getId())
				.cin(demande.getCin())
				.nom(demande.getNom())
				.prenom(demande.getPrenom())
				.adresse(demande.getAdresse())
				.email(demande.getEmail())
				.tele(demande.getTele())
				.poste(demande.getPoste())
				.dateDemande(demande.getDateDemande())
				//.candidat(CandidatDto.fromEntity(demande.getCandidat()))
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
		demandes.setCin(demandesDto.getCin());
		demandes.setNom(demandesDto.getNom());
		demandes.setPrenom(demandesDto.getPrenom());
		demandes.setAdresse(demandesDto.getAdresse());
		demandes.setEmail(demandesDto.getEmail());
		demandes.setTele(demandesDto.getTele());
		demandes.setPoste(demandesDto.getPoste());
		demandes.setDateDemande(demandesDto.getDateDemande());
		//demandes.setCandidat(CandidatDto.toEntity(demandesDto.getCandidat()));
		demandes.setOffre(offresDto.toEntity(demandesDto.getOffre()));
		demandes.setEtatDemande(demandesDto.getEtatDemande());
		
		return demandes ;
		
	}
	
	@SuppressWarnings("static-access")
	public boolean  isDemandeAccepte() { 
		return etatDemande.ADMIS.equals(this.etatDemande);
	}

	
}
