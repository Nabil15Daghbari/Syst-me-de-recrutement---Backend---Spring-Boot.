package com.nabil.SystemRecrutement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabil.SystemRecrutement.model.Entreprise;

import java.util.List;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

  private Long id;

  private String nom;

  private String description;

//  private AdresseDto adresse;
  
	private String adresse1 ;
	
	private String ville ;
	
	private String codePostale ;
	
	private String pays ;

  private String codeFiscal;

  private String photo;

  private String email;

  private String numTel;

  private String steWeb;


  @JsonIgnore
  private List<utilisateurDto> utilisateurs;

  public static EntrepriseDto fromEntity(Entreprise entreprise) {
    if (entreprise == null) {
      return null;
    }
    return EntrepriseDto.builder()
        .id(entreprise.getId())
        .nom(entreprise.getNom())
        .description(entreprise.getDescription())
      //  .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
        .adresse1(entreprise.getAdresse1())
		.pays(entreprise.getPays())
		.ville(entreprise.getVille())
		.codePostale(entreprise.getCodePostale())
        .codeFiscal(entreprise.getCodeFiscal())
        .photo(entreprise.getPhoto())
        .email(entreprise.getEmail())
        .numTel(entreprise.getNumTel())
        .steWeb(entreprise.getSteWeb())
        .build();
  }

  public static Entreprise toEntity(EntrepriseDto dto) {
    if (dto == null) {
      return null;
    }
    Entreprise entreprise = new Entreprise();
    entreprise.setId(dto.getId());
    entreprise.setNom(dto.getNom());
    entreprise.setDescription(dto.getDescription());
   // entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
    entreprise.setCodeFiscal(dto.getCodeFiscal());
    entreprise.setPhoto(dto.getPhoto());
    entreprise.setEmail(dto.getEmail());
    entreprise.setNumTel(dto.getNumTel());
    entreprise.setSteWeb(dto.getSteWeb());
    entreprise.setAdresse1(dto.getAdresse1());
    entreprise.setPays(dto.getPays());
	entreprise.setVille(dto.getVille());
	entreprise.setCodePostale(dto.getCodePostale());
	

    return entreprise;
  }



}
