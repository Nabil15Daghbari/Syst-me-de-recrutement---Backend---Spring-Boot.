package com.nabil.SystemRecrutement.model.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;



public class ExtendedUser extends User {

	 

	  public ExtendedUser(String username, String password,
	      Collection<? extends GrantedAuthority> authorities) {
	    super(username, password, authorities);
	  }

	
	}
