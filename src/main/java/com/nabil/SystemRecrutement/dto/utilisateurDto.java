package com.nabil.SystemRecrutement.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import com.nabil.SystemRecrutement.model.Utilisateur;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class utilisateurDto {

	private Long  id  ;
	private String nom ;
	private String prenom ;
	private String email ;
	private Instant dateDeNaissance ;
    private	String motDePasse ;
    private AdresseDto adresse ;
    private String photo ;
    private List<RolesDto> roles;
    
    
    
    public static utilisateurDto fromEntity(Utilisateur u) {
		if(u == null) {
			return null ;
		}
		
		return utilisateurDto.builder()
				.id(u.getId())
				.nom(u.getNom())
				.prenom(u.getPrenom())
				.adresse(AdresseDto.fromEntity(u.getAdresse()))
				.photo(u.getPhoto())
				.email(u.getEmail())
				.dateDeNaissance(u.getDateDeNaissance())
				.motDePasse(u.getMotDePasse())
				
			//	.roles    (
				//		    u.getRoles() !=null ?
				//			u.getRoles().stream()
				//			.map(RolesDto :: fromEntity)
				//			.collect(Collectors.toList()) : null
				//		  )
				.build();
				
				
				
		
      }
	
	
	public static Utilisateur toEntity(utilisateurDto ud ) {
		if(ud == null) {
			return null ;
		}
		
		Utilisateur u  =new Utilisateur();
		u.setId(ud.getId());
		u.setNom(ud.getNom());
		u.setPrenom(ud.getPrenom());
		u.setPhoto(ud.getPhoto());
		u.setEmail(ud.getEmail());
		u.setDateDeNaissance(ud.getDateDeNaissance());
		u.setMotDePasse(ud.getMotDePasse());
		u.setAdresse(AdresseDto.toEntity(ud.getAdresse()));
		
		
		return u ;
	}

}
