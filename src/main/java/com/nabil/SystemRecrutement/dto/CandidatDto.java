package com.nabil.SystemRecrutement.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.nabil.SystemRecrutement.model.Candidat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidatDto {

	private String code ;
	
	private Long id ;
	
	private String nom ; 
	
	private String prenom ;
	
	private AdresseDto adresse ;
	
	private String email ;
	
	private String dateNaissance ;

	private String photo ;

	private String Login ;
	
	private String password ;

	private String tele ;

	private contratsDto CONTRATS ;
	
	private List<demandesDto> demandes ;
	
	
	public static CandidatDto fromEntity(Candidat candidat) {
		
		if(candidat == null) {
			return null ;
		}
		
		
		return CandidatDto.builder()
				.code(candidat.getCode())
				.id(candidat.getId())
				.nom(candidat.getNom())
				.prenom(candidat.getPrenom())
				.adresse(AdresseDto.fromEntity(candidat.getAdresse()))
				.email(candidat.getEmail())
				.dateNaissance(candidat.getDateNaissance())
				.photo(candidat.getPhoto())
				.Login(candidat.getLogin())
				.password(candidat.getPassword())
				.tele(candidat.getTele())
				.CONTRATS(contratsDto.fromEntity(candidat.getCONTRATS()))
				.demandes
				     (
						candidat.getDemandes() !=null ?
						candidat.getDemandes().stream()
					    .map(demandesDto :: fromEntity)
						.collect(Collectors.toList()) : null
						
						)
				.build();
				

 
		
	}
	
	
	public static Candidat toEntity(CandidatDto candidatDto ) {
		if(candidatDto==null) {
			return null ;
		}
		
		Candidat candidat = new Candidat();
		candidat.setCode(candidatDto.getCode());
		candidat.setId(candidatDto.getId());
		candidat.setNom(candidatDto.getNom());
		candidat.setPrenom(candidatDto.getPrenom());
		candidat.setAdresse(AdresseDto.toEntity( candidatDto.getAdresse()));
		candidat.setEmail(candidatDto.getEmail());
		candidat.setDateNaissance(candidatDto.getDateNaissance());
		candidat.setPhoto(candidatDto.getPhoto());
		candidat.setLogin(candidatDto.getLogin());
		candidat.setPassword(candidatDto.getPassword());
		candidat.setTele(candidatDto.getTele());
		candidat.setCONTRATS(contratsDto.toEntity(candidatDto.getCONTRATS()));
		
	    
		
		
		
		return candidat ;
	}
}
