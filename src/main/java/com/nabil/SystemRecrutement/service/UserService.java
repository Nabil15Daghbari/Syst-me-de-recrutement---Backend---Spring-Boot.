package com.nabil.SystemRecrutement.service;

import java.util.Collection;
import java.util.Optional;

import com.nabil.SystemRecrutement.exception.BusinessResourceException;
import com.nabil.SystemRecrutement.model.User;


public interface UserService {

	Collection<User> getAllUsers();
	
	Optional<User> getUserById(Long id) throws BusinessResourceException;
	
	Optional<User> findByLogin(String login) throws BusinessResourceException;
	
	User saveOrUpdateUser(User user) throws BusinessResourceException;
	
	void deleteUser(Long id) throws BusinessResourceException;

	Optional<User> findByLoginAndPassword(String login, String password) throws BusinessResourceException;

}