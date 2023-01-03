package com.nabil.SystemRecrutement.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest {

	// pour que l'utilisateur va auth il fournit d'un login et mot de passe
  private String login;

  private String password;

}
