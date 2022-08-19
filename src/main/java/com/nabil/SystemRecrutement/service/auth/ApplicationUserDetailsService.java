/*package com.nabil.SystemRecrutement.service.auth;


import java.util.Collections;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nabil.SystemRecrutement.Repository.UtilisateurRepository;
import com.nabil.SystemRecrutement.model.Utilisateur;


@Service
public class ApplicationUserDetailsService implements  UserDetailsService{
    @Autowired 
	private UtilisateurRepository repository ;
	
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
//	Utilisateur utilisateur = repository.findUtilisateurByEmail(email);
		
		return new  User("ali" , "ali" , Collections.emptyList());
	}
	

}
*/