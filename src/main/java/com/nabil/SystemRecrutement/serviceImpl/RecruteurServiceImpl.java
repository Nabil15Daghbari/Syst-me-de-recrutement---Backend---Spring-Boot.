package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.recruteurRepository;
import com.nabil.SystemRecrutement.Validator.recruteurValidator;
import com.nabil.SystemRecrutement.dto.recruteurDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.recruteur;
import com.nabil.SystemRecrutement.service.RecruteurService;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class RecruteurServiceImpl implements RecruteurService {

	private recruteurRepository recruteurRepository ;
	
	@Autowired
	public RecruteurServiceImpl (recruteurRepository recruteurRepository ) {
		this.recruteurRepository= recruteurRepository ; 
	}   
	
	
	
	
	
	@Override
	public recruteurDto save(recruteurDto dto) {
		 List<String> errors =recruteurValidator.validate(dto);
			
			if(!errors.isEmpty()) {
				log.error("le recruteur is not Valid{}" , dto);
				throw new InvalidEntityExeption("le recruteur n'est pas valide ", ErrorCodes.RECRUTEUR_NOT_VALID, errors );
			}
			return recruteurDto.fromEntity(recruteurRepository.save(recruteurDto.toEntity(dto)));
	}

	@Override
	public recruteurDto findById(Long id) {
		if(id==null) {
			log.error("Recruteur ID is null");
			
		
		return null ;
	}
		
		Optional<recruteur> recruteur = recruteurRepository.findById(id);
		
		return Optional.of(recruteurDto.fromEntity(recruteur.get())).orElseThrow( ()->
            new EntityNotFoundException(
            		"Aucun Recruteur avec l'id ="+id +"n'ete trouve dans la BDD" , ErrorCodes.RECRUTEUR_NOT_FOUND
            		
            		));
	}

	@Override
	public List<recruteurDto> findAll() {
		return recruteurRepository.findAll().stream()
				.map(recruteurDto::fromEntity)
				.collect(Collectors.toList())
				
				;
	}

	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("Recruteur Id is null");
		}
		
		recruteurRepository.deleteById(id); 
	}





	@Override
	public recruteur update(Long id, recruteur recruteur) {

		recruteur recruteurUpdate = recruteurRepository.findById(id).get();
		
		recruteurUpdate.setCin(recruteur.getCin());
		recruteurUpdate.setAge(recruteur.getAge());
		recruteurUpdate.setEmail(recruteur.getEmail());
		recruteurUpdate.setNom(recruteur.getNom());
		recruteurUpdate.setPrenom(recruteur.getPrenom());
		//recruteurUpdate.setAdresse(recruteur.getAdresse());
		recruteurUpdate.setTele(recruteur.getTele());
		recruteurUpdate.setLogin(recruteur.getLogin());
		recruteurUpdate.setPassword(recruteur.getPassword());
		recruteurUpdate.setPoste(recruteur.getPoste());
		
		return recruteurRepository.saveAndFlush(recruteurUpdate);
	}
		
	

}
