package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.demandesRepository;
import com.nabil.SystemRecrutement.Validator.demandesValidator;
import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.service.DemandesService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DemandesSeriveImpl  implements DemandesService{

	
	private demandesRepository demandesRepository ;
	
	
	@Autowired
	public DemandesSeriveImpl(demandesRepository demandesRepository) {
		this.demandesRepository=demandesRepository ;
	}
	
	
	
	@Override
	public demandesDto save(demandesDto dto) {
		
		List<String> errors =demandesValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("le demande in not Valid{}" , dto);
			throw new InvalidEntityExeption("Le demandes n'est pas valide ", ErrorCodes.DEMANDES_NOT_VALID, errors );
		}
		return demandesDto.fromEntity(demandesRepository.save(demandesDto.toEntity(dto)));
	}

	@Override
	public demandesDto findById(Long id) {
		if(id==null) {
			log.error("Demande ID is null");
			
		
		return null ;
	}
		
		Optional<demandes> demande = demandesRepository.findById(id);
		
		return Optional.of(demandesDto.fromEntity(demande.get())).orElseThrow( ()->
            new EntityNotFoundException(
            		"Aucun demande avec l'id ="+id +"n'ete trouve dans la BDD" , ErrorCodes.DEMANDES_NOT_FOUND
            		
            		));
	}

	@Override
	public List<demandesDto> findAll() {
		return demandesRepository.findAll().stream()
				.map(demandesDto::fromEntity)
				.collect(Collectors.toList())
				
				;
	}

	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("demande Id is null");
		}
		
		demandesRepository.deleteById(id);
	}

}
