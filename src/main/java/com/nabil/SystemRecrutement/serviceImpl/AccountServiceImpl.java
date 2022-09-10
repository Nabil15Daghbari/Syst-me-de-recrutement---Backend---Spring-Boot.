package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.Repository.AppRoleRepository;
import com.nabil.SystemRecrutement.Repository.AppUserRepository;
import com.nabil.SystemRecrutement.Validator.UtilisateurValidator;
import com.nabil.SystemRecrutement.dto.ChangerMotDePasseUtilisateurDto;
import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
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

	@Override
	public appUserDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {

		validate(dto);
		
		Optional<AppUser> utilisateurOptional = appUserRepository.findById(dto.getId());	
		
		if(utilisateurOptional.isEmpty()) {
			log.warn("Aucun utilisateur a ete trouve avec id  " + dto.getId());
			
		throw new EntityNotFoundException("Aucun utilisateur a ete trouve avec id " + dto.getId(), ErrorCodes.ENTRETIEN_NOT_FOUND);	
		}
		
		
		
		
		AppUser utilisateur=utilisateurOptional.get();
		String pw = dto.getMotDePasse();
		
		
		utilisateur.setPassword(dto.getMotDePasse());
		utilisateur.setPassword(passwordEncoder.encode(pw));
		
		
		
		return appUserDto.fromEntity(appUserRepository.save(utilisateur));
	}
	
	
	
	
	
	
	
	
	public void validate(ChangerMotDePasseUtilisateurDto dto) {
		
		if(dto==null) {
			log.warn("Impossible de modifier le mot de pasee avec un objet Null");
	
		
		throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		
		}
		
		if(dto.getId()==null) {
			log.warn("Impossible de modifier le mot de pasee avec ID Null");
		
		
		throw new InvalidOperationException("ID UTILISATEUR NULL :: impossible du modifier le mot de passe d'utlisateur ", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		
		
		
		if(!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse() )) {
			log.warn("Impossible de modifier le mot de pasee avec un mot de passe Null");
		
		
		throw new InvalidOperationException("MOT DE PASSE  UTILISATEUR NULL :: impossible du modifier le mot de passe d'utlisateur ", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		
		
		if(!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
			log.warn("Impossible de modifier le mot de pasee avec deux mots de passe different");
		
		
		throw new InvalidOperationException("MOTS DE PASSE  UTILISATEUR non conformes :: impossible du modifier le mot de passe d'utlisateur ", ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
		}
		
	}

}
