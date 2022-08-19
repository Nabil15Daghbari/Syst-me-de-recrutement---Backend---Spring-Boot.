package com.nabil.SystemRecrutement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nabil.SystemRecrutement.model.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long>{

	AppRole findByRoleName(String roleName);
}
