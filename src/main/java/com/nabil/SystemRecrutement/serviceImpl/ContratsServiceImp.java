package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.nabil.SystemRecrutement.Repository.contratsRepository;
import com.nabil.SystemRecrutement.Validator.contratsValidator;
import com.nabil.SystemRecrutement.dto.contratsDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.contrats;
import com.nabil.SystemRecrutement.service.ContratsService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ContratsServiceImp implements ContratsService{

	
	private contratsRepository contratsRepository ;
	
	
	@Autowired
	public ContratsServiceImp(contratsRepository contratsRepository) {
		this.contratsRepository=contratsRepository ;
		
	}
	
	
	@Override
	public contratsDto save(contratsDto dto) {
		List<String> errors = contratsValidator.validate(dto);
		
		
		if(!errors.isEmpty()) {
			log.error("Le contrat is not Valid {}" , dto);
			throw new InvalidEntityExeption("Le contrat n'est pas valide " , ErrorCodes.CONTRATS_NOT_VALID , errors );
		}
		
		return contratsDto.fromEntity(contratsRepository.save(contratsDto.toEntity(dto)));
	}
		
	

	@Override
	public contratsDto findById(Long id) {
		if(id==null) {
			log.error("candidat ID is null");
			
		
		return null ;
		    }
		
		Optional<contrats> contrat = contratsRepository.findById(id);
	
		return Optional.of(contratsDto.fromEntity(contrat.get())).orElseThrow( () ->  
		new EntityNotFoundException(
				"Aucun contrat avec l'ID =" + id + "n'ete trouve dans la BDD" , ErrorCodes.CONTRATS_NOT_FOUND   ));
	}
	
	
	

	@Override
	public List<contratsDto> findAll() {
		
		return contratsRepository.findAll().stream()
				.map(contratsDto::fromEntity)
				.collect(Collectors.toList() )
				
				;
	}

	@Override
	public void delete(Long id) {	
		if(id==null) {
			log.error("contrat ID is null");
			return  ;
		}
		
		contratsRepository.deleteById(id);
		
		
	}

	/**

	@Override
	public contratsDto findByCodeContrat(String codeContrat) {
		
		if(!StringUtils.hasLength(codeContrat)) {
			log.error("Code contrat is null");
		}

		Optional<contrats>  contrat = contratsRepository.findContratByCodeContrat(codeContrat);
		
		
		return Optional.of(contratsDto.fromEntity(contrat.get())).orElseThrow(()->
		
				new EntityNotFoundException("Aucun contrat avec le code =" + codeContrat + "n'ete trouve dans la BDD" , ErrorCodes.CONTRATS_NOT_FOUND  
		
				
				));
				}
	

*/
	
	
}
