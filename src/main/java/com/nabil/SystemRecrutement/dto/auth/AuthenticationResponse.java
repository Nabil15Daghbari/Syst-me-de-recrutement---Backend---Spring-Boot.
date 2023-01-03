package com.nabil.SystemRecrutement.dto.auth;


import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class AuthenticationResponse {
	
	// accessToken :c'est le token qui sera utiliser pour authentification
	private String accessToken ;

}
