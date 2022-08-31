package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;

public interface AccountService {
	
	appUserDto addNewUser(appUserDto appUserdto);
	
	AppRole addNewRole(AppRole appRole);
	
	void addRoleToUser(String email ,String roleName);
	
	AppUser loadUserByUsername(String email) ;
	
	List<AppUser> listUsers();
	
    appUserDto findById(Long id);
		
	void delete(Long id);


}
