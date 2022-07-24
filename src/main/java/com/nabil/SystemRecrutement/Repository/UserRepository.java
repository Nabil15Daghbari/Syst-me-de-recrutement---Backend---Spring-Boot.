package com.nabil.SystemRecrutement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabil.SystemRecrutement.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByLogin(String loginParam);
}