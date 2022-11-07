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

	private Long id;

	  private String nom;

	  private String prenom;

	  private String email;

	  private Instant dateDeNaissance;

	  private String moteDePasse;

	  private AdresseDto adresse;

	  private String photo;


	  private List<RolesDto> roles;

	  public static utilisateurDto fromEntity(Utilisateur utilisateur) {
	    if (utilisateur == null) {
	      return null;
	    }

	    return utilisateurDto.builder()
	        .id(utilisateur.getId())
	        .nom(utilisateur.getNom())
	        .prenom(utilisateur.getPrenom())
	        .email(utilisateur.getEmail())
	        .moteDePasse(utilisateur.getMoteDePasse())
	        .dateDeNaissance(utilisateur.getDateDeNaissance())
	        .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
	        .photo(utilisateur.getPhoto())
	        .roles(
	            utilisateur.getRoles() != null ?
	                utilisateur.getRoles().stream()
	                    .map(RolesDto::fromEntity)
	                    .collect(Collectors.toList()) : null
	        )
	        .build();
	  }

	  public static Utilisateur toEntity(utilisateurDto dto) {
	    if (dto == null) {
	      return null;
	    }

	    Utilisateur utilisateur = new Utilisateur();
	    utilisateur.setId(dto.getId());
	    utilisateur.setNom(dto.getNom());
	    utilisateur.setPrenom(dto.getPrenom());
	    utilisateur.setEmail(dto.getEmail());
	    utilisateur.setMoteDePasse(dto.getMoteDePasse());
	    utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
	    utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
	    utilisateur.setPhoto(dto.getPhoto());

	    return utilisateur;
	  }

}
