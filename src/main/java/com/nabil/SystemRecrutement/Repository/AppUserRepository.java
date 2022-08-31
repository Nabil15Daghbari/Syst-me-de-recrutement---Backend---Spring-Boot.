package com.nabil.SystemRecrutement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nabil.SystemRecrutement.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String email);
}
