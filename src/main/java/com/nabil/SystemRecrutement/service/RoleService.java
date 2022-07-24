package com.nabil.SystemRecrutement.service;

import java.util.Collection;
import java.util.stream.Stream;

import com.nabil.SystemRecrutement.model.Role;


public interface RoleService {
	
	Role findByRoleName(String roleName);
	
	Collection<Role> getAllRoles();
	
	Stream<Role> getAllRolesStream();
}