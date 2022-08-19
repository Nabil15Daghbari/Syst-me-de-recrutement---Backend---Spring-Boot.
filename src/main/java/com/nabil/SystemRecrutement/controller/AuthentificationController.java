/*package com.nabil.SystemRecrutement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.dto.auth.AuthenticationRequest;
import com.nabil.SystemRecrutement.dto.auth.AuthenticationResponse;
import com.nabil.SystemRecrutement.service.auth.ApplicationUserDetailsService;
import com.nabil.SystemRecrutement.util.JwtUtil;

import static com.nabil.SystemRecrutement.util.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthentificationController {
	
	@Autowired
	private JwtUtil jwtUtil  ;
	
	@Autowired
	private AuthenticationManager authenticationManager ; 
	
	
	private ApplicationUserDetailsService userDetailsService;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request ){
		
		// authenticationManager.authenticate(
		//		new UsernamePasswordAuthenticationToken(
	   	//		request.getLogin(),
	   	//		request.getPassword()
	  	//		)
	 // 	);
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(AuthenticationResponse.builder().accesToken("jwt").build());
		
		
	}

}
*/