package com.nabil.SystemRecrutement.dto;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.nabil.SystemRecrutement.model.Offres;
import com.nabil.SystemRecrutement.model.recruteur;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class recruteurDto {

	
	private Long id  ;
	private String cin ;
	private int age ;
	private String nom ;
	private String prenom ;
	// private AdresseDto adresse ;
	private String photo ;
	private String tele ; 
	private String login ;
	private String password ; 
	private String Poste ;
	
	private String adresse1 ;
	private String ville ;
	private String codePostale ;
	private String pays ;
	
	
	
	
	private List<offresDto> offres ;

	
	public static recruteurDto fromEntity(recruteur recruteur ) {
		if(recruteur==null) {
			return null ;
		}
		
		return recruteurDto.builder()
				.id(recruteur.getId())
				.cin(recruteur.getCin())
				.age(recruteur.getAge())
				.nom(recruteur.getNom())
				.prenom(recruteur.getPrenom())
			//	.adresse(AdresseDto.fromEntity(recruteur.getAdresse()))
				.photo(recruteur.getPhoto())
				.tele(recruteur.getTele())
				.login(recruteur.getLogin())
				.password(recruteur.getPassword())
				.Poste(recruteur.getPoste())
				.adresse1(recruteur.getAdresse1())
				.pays(recruteur.getPays())
				.ville(recruteur.getVille())
				.codePostale(recruteur.getCodePostale())
            ///    .offres(
						
				//		recruteur.getOffres() !=null ?
				//		recruteur.getOffres().stream()
				//		.map(offresDto::fromEntity)
				//		.collect(Collectors.toList()) : null
						
				//		)
		
				.build();
		
	}
	
	
	public static recruteur toEntity(recruteurDto recruteurDto ) {
		if(recruteurDto==null) {
			return null ;
		}
		
		recruteur recruteur = new recruteur();
		
		
		recruteur.setId(recruteurDto.getId());
		recruteur.setCin(recruteurDto.getCin());
		recruteur.setAge(recruteurDto.getAge());
		recruteur.setNom(recruteurDto.getNom());
		recruteur.setPrenom(recruteurDto.getPrenom());
		//recruteur.setAdresse(AdresseDto.toEntity(recruteurDto.getAdresse()));
		recruteur.setPhoto(recruteurDto.getPhoto());
		recruteur.setTele(recruteurDto.getTele());
		recruteur.setLogin(recruteurDto.getLogin());
		recruteur.setPassword(recruteurDto.getPassword());
		recruteur.setPoste(recruteurDto.getPoste());
		recruteur.setAdresse1(recruteurDto.getAdresse1());
		recruteur.setPays(recruteurDto.getPays());
		recruteur.setVille(recruteurDto.getVille());
		recruteur.setCodePostale(recruteurDto.getCodePostale());
		
		
		
		return recruteur ;
	}
}
