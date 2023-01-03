package com.nabil.SystemRecrutement.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.auth.AuthenticationRequest;
import com.nabil.SystemRecrutement.dto.auth.AuthenticationResponse;


import io.swagger.annotations.Api;




import static com.nabil.SystemRecrutement.util.Constants.AUTHENTICATION_ENDPOINT;




// @Api("authentication")
public interface AuthenticationApi1  {
	
	  @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
