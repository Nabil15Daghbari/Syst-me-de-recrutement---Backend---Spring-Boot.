package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.UtilisateurRepository;
import com.nabil.SystemRecrutement.Validator.UtilisateurValidator;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.Utilisateur;
import com.nabil.SystemRecrutement.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class UtilistaeurServiceImpl  implements UtilisateurService {
	
	
	
   private UtilisateurRepository utilistaeurRepository ;
	
   
   @Autowired
	public UtilistaeurServiceImpl(UtilisateurRepository utilistaeurRepository) {
		this.utilistaeurRepository = utilistaeurRepository ;
	}
	
	
	
	
	@Override
	public utilisateurDto save(utilisateurDto dto) {
		
	//	List<String> errors = UtilisateurValidator.Validate(dto);
		
	//	if(!errors.isEmpty()) {
	//		log.error("L'utilisateur is not Valid {}" , dto);
	//		throw new InvalidEntityExeption("L'utilisateur n'est pas valide " , ErrorCodes.UTILISATEUR_NOT_VALID , errors );
	//	}
		
		return utilisateurDto.fromEntity(utilistaeurRepository.save(utilisateurDto.toEntity(dto)));
	}

	

	
	@Override
	public utilisateurDto findById(Long id) {
		if(id==null) {
			log.error("Utilisateur ID is null");
			
		
			return null ;
		}
		
		Optional<Utilisateur> utilisateur = utilistaeurRepository.findById(id);		

		
		return Optional.of(utilisateurDto.fromEntity(utilisateur.get())).orElseThrow( () ->  
		new EntityNotFoundException(
				"Aucun utilistaeur avec l'ID =" + id + "n'ete trouve dans la BDD" , ErrorCodes.UTILISATEUR_NOT_FOUND    ));
	}

	
	

	
	
	
	

	@Override
	public List<utilisateurDto> findAll() {
		
		return utilistaeurRepository.findAll().stream()
				.map(utilisateurDto::fromEntity)
				.collect(Collectors.toList() )
				
				;
	}

	
	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("utilistaeur ID is null");
			return  ;
		}
		
		utilistaeurRepository.deleteById(id);
		
	   }
	
	
}



