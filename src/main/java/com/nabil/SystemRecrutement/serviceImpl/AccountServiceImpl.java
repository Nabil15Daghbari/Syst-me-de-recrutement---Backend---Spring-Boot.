package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nabil.SystemRecrutement.Repository.AppRoleRepository;
import com.nabil.SystemRecrutement.Repository.AppUserRepository;
import com.nabil.SystemRecrutement.Validator.UtilisateurValidator;
import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.AppRole;
import com.nabil.SystemRecrutement.model.AppUser;
import com.nabil.SystemRecrutement.model.Utilisateur;
import com.nabil.SystemRecrutement.service.AccountService;

import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {

	
	private AppUserRepository appUserRepository ;
	
	private AppRoleRepository  appRoleRepository ;
	
	private PasswordEncoder passwordEncoder ;
	
	
	
	
	
	public AccountServiceImpl(AppUserRepository appUserRepository,AppRoleRepository appRoleRepository , PasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
		this.passwordEncoder = passwordEncoder ;
		
	}

	@Override
	public appUserDto addNewUser(appUserDto appUserdto) {
		
   List<String> errors = UtilisateurValidator.Validate(appUserdto);
		
		if(!errors.isEmpty()) {
			log.error("L'utilisateur is not Valid {}" , appUserdto);
			throw new InvalidEntityExeption("L'utilisateur n'est pas valide " , ErrorCodes.UTILISATEUR_NOT_VALID , errors );
		}
		
		
		String pw = appUserdto.getPassword();
		appUserdto.setPassword(passwordEncoder.encode(pw));
		
		return appUserDto.fromEntity(appUserRepository.save(appUserDto.toEntity(appUserdto)));
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByRoleName(roleName);
		
		appUser.getAppRoles().add(appRole);
		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> listUsers() {
		return appUserRepository.findAll();
	}
	
	

	@Override
	public appUserDto findById(Long id) {
		
		if(id==null) {
			log.error("Utilisateur ID is null");
			
		
			return null ;
		}
		
		Optional<AppUser> utilisateur = appUserRepository.findById(id);		

		
		return Optional.of(appUserDto.fromEntity(utilisateur.get())).orElseThrow( () ->  
		new EntityNotFoundException(
				"Aucun utilistaeur avec l'ID =" + id + "n'ete trouve dans la BDD" , ErrorCodes.UTILISATEUR_NOT_FOUND    ));
		
	}

	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("utilistaeur ID is null");
			return  ;
		}
		
		appUserRepository.deleteById(id);
		
		
	}

}
