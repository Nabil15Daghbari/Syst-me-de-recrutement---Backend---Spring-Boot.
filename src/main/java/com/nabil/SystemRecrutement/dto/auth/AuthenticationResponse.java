package com.nabil.SystemRecrutement.dto.auth;


import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class AuthenticationResponse {
	
	
	private String accesToken ;

}
