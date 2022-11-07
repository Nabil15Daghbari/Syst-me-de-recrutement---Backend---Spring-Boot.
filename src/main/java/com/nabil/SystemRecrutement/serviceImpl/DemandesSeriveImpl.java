package com.nabil.SystemRecrutement.serviceImpl;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.demandesRepository;
import com.nabil.SystemRecrutement.Validator.demandesValidator;
import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.model.etatDemande;
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



	@Override
	public demandesDto updateEtatDemande(Long idDemande, etatDemande etatDemande) {
		
		checkIdDemande(idDemande);
		
		if(!StringUtils.hasLength(String.valueOf(etatDemande))) {
			log.error("L'etat de la demande is Null");
			throw new InvalidOperationException("Impossible de modifier l'etat de la demande avec un etat null", ErrorCodes.DEMANDES_NOT_MODIFIABLE);
		}
		
		demandesDto demandes = checkEtatDemande(idDemande);
		demandes.setEtatDemande(etatDemande);
		
		
		return demandesDto.fromEntity(
				demandesRepository.save(demandesDto.toEntity(demandes))	
				
				);
	}
	
	
	
	
	
	
	
	
	
	
	
	private demandesDto checkEtatDemande(Long idDemande) {
		demandesDto demande = findById(idDemande);
		
		if(demande.isDemandeAccepte()) {
			throw new InvalidOperationException("imposible de modifier le demande lorsqu'elle est accepte" , ErrorCodes.DEMANDES_NOT_VALID);
		}
		
		return demande ;
	}
	
	
	
	
	
	private void checkIdDemande(Long idDemande) {
		
		
		if(idDemande == null) {
			log.error("Id demande est null ");
			
			throw new InvalidEntityExeption("L'ID demande n'est pas null ");
			
		}
		
		
		
}

}
