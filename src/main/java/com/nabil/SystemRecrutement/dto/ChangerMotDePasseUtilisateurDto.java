package com.nabil.SystemRecrutement.dto;

import lombok.Builder;
import lombok.Data;

@Builder 
@Data
public class ChangerMotDePasseUtilisateurDto {

	
	  private Long id;
	  private String motDePasse;
	  private String confirmMotDePasse;

}
