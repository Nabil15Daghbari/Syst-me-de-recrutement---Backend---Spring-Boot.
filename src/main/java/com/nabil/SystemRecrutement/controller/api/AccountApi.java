package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.auth.RoleUserFrom;
import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/user")
public interface AccountApi {
	
	
	@PostMapping(path=APP_ROOT + "/createUser")
	AppUser saveUser(@RequestBody AppUser appUser );
	
	
	@GetMapping(path=APP_ROOT +"/users")
	List<AppUser> appUsers();
	
	@PostMapping(path=APP_ROOT + "/createRole")
	AppRole saveRole(@RequestBody AppRole appRole);
	
	@PostMapping(path=APP_ROOT + "/addRoleToUser")
	void addRoleToUser(@RequestBody RoleUserFrom RoleUserFrom);
	
	
	
	
	
	
	

}


