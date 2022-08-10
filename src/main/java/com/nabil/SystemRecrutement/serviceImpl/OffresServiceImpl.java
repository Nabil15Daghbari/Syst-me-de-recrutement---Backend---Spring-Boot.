package com.nabil.SystemRecrutement.serviceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.offresRepository;
import com.nabil.SystemRecrutement.Validator.offresValidator;
import com.nabil.SystemRecrutement.dto.offresDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.Offres;
import com.nabil.SystemRecrutement.service.OffresService;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class OffresServiceImpl implements OffresService{

	private offresRepository offresRepository ;

	
	
	@Autowired
	public OffresServiceImpl (offresRepository offresRepository ) {
		this.offresRepository = offresRepository ; 
	}
	
	
	
	
	@Override
	public offresDto save(offresDto dto) {
       List<String> errors =offresValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("l'offre  in not Valid{}" , dto);
			throw new InvalidEntityExeption("L'offre n'est pas valide ", ErrorCodes.OFFRE_NOT_VALID, errors );
		}
		return offresDto.fromEntity(offresRepository.save(offresDto.toEntity(dto)));
	}

	
	
	@Override
	public offresDto findById(Long id) {
		if(id==null) {
			log.error("Offre ID is null");
			
		
		return null ;
	}
		
		Optional<Offres> offre = offresRepository.findById(id);
		
		return Optional.of(offresDto.fromEntity(offre.get())).orElseThrow( ()->
            new EntityNotFoundException(
            		"Aucun offre avec l'id ="+id +"n'ete trouve dans la BDD" , ErrorCodes.OFFRE_NOT_FOUND
            		
            		));
	}

	
	
	
	@Override
	public List<offresDto> findAll() {
		return offresRepository.findAll().stream()
				.map(offresDto::fromEntity)
				.collect(Collectors.toList())
				
				;
	}

	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("Offre Id is null");
		}
		
		offresRepository.deleteById(id);
	}
		
	

}