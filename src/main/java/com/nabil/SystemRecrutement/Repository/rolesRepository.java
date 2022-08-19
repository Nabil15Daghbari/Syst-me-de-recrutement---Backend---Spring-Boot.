package com.nabil.SystemRecrutement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.model.Roles;

public interface rolesRepository extends JpaRepository<Roles, Long>{

	Roles findByRoleName(String roleName);
	
}
