package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.AccountApi;
import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.dto.auth.RoleUserFrom;
import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;
import com.nabil.SystemRecrutement.service.AccountService;

@RestController
public class AccountRestController implements AccountApi {
	
	
	private AccountService accountService ;

	public AccountRestController(AccountService accountService) {
		
		this.accountService = accountService;
	}
	
	
	public List<AppUser> appUsers(){
		return accountService.listUsers();
	}


	


	@Override
	public AppRole saveRole(AppRole appRole) {

		return accountService.addNewRole(appRole);
	}


	@Override
	public void addRoleToUser(RoleUserFrom RoleUserFrom) {
		
		accountService.addRoleToUser( RoleUserFrom.getUsername() , RoleUserFrom.getRolename());

		
	}


	@Override
	public appUserDto findById(Long id) {
		return accountService.findById(id);
	}


	@Override
	public void delete(Long id) {

		accountService.delete(id);
		
		
	}


	@Override
	public appUserDto saveUser(appUserDto appUser) {
		return accountService.addNewUser(appUser);
	}

}
