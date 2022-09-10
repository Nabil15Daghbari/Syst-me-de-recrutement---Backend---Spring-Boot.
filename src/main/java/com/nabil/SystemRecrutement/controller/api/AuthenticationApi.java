package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/refreshToken")
public interface AuthenticationApi {
	
	@GetMapping(value=APP_ROOT + "/refreshToken" )
	 public void refreshToken(HttpServletRequest request , HttpServletResponse response ) throws Exception;
	
	
	

}
