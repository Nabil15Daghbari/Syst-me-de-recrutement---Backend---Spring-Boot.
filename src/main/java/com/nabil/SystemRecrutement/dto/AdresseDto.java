package com.nabil.SystemRecrutement.dto;




import com.nabil.SystemRecrutement.model.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {
	
	
	private String adresse1 ;
	
	
	private String adresse2 ;
	

	private String ville ;
	
	private String codePostale ; 
	
	
	private String pays ;
	
	
	
	public static AdresseDto fromEntity(Adresse adresse) {
		if(adresse== null) {
			return null ;
		}
		
		return AdresseDto.builder()
				.adresse1(adresse.getAdresse1())
				.adresse2(adresse.getAdresse2())
				.ville(adresse.getVille())
				.codePostale(adresse.getCodePostale())
				.pays(adresse.getPays())
				.build(); 
		
	}
	
	
	


	public static Adresse toEntity(AdresseDto add) {
		if(add==null) {
			return null ;
		}
		
		Adresse ad = new Adresse();
		
		ad.setAdresse1(add.getAdresse1());
		ad.setAdresse2(add.getAdresse2());
		ad.setCodePostale(add.getCodePostale());
		ad.setPays(add.getPays());
		ad.setVille(add.getVille());
		
		return ad ;
		
		
		
	}





	
	

}
