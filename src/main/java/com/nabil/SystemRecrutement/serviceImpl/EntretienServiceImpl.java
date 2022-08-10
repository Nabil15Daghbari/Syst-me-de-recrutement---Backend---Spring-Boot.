package com.nabil.SystemRecrutement.serviceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.entretienRepository;
import com.nabil.SystemRecrutement.Validator.entretienValidator;
import com.nabil.SystemRecrutement.dto.entretienDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.model.entretien;
import com.nabil.SystemRecrutement.service.entretienService;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EntretienServiceImpl implements entretienService{

	
	private entretienRepository entretienRepository ;
	
	
	@Autowired
	public EntretienServiceImpl (entretienRepository entretienRepository ) {
		this.entretienRepository=entretienRepository ;
	}
	
	@Override
	public entretienDto save(entretienDto dto) {
	   
		List<String> errors = entretienValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("l'entretien is not Valid", dto);
			throw new EntityNotFoundException("l'entretien n'est pas valide " , ErrorCodes.ENTRETIEN_NOT_VALID);
		}
		
		return entretienDto.fromEntity(entretienRepository.save(entretienDto.toEntity(dto)));
	}

	@Override
	public entretienDto findById(Long id) {
		if(id==null) {
			log.error("Entretien ID is null");
			
		
		return null ;
	} 
		Optional<entretien > entretien = entretienRepository.findById(id); 
		
		return Optional.of(entretienDto.fromEntity(entretien.get())).orElseThrow( ()->
        new EntityNotFoundException(
        		"Aucun entretien avec l'id ="+id +"n'ete trouve dans la BDD" , ErrorCodes.ENTRETIEN_NOT_FOUND
        		
        		));
	}

	@Override
	public List<entretienDto> findAll() {
		return  entretienRepository.findAll().stream()
				.map(entretienDto::fromEntity)
				.collect(Collectors.toList())
				
				;
	}

	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("Entretien Id is null");
		}
		
		entretienRepository.deleteById(id);
	}
		
	

}
