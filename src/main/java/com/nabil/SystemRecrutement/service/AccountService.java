package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;

public interface AccountService {
	
	AppUser addNewUser(AppUser appUser);
	
	AppRole addNewRole(AppRole appRole);
	
	void addRoleToUser(String username ,String roleName);
	
	AppUser loadUserByUsername(String username) ;
	
	List<AppUser> listUsers();

}
