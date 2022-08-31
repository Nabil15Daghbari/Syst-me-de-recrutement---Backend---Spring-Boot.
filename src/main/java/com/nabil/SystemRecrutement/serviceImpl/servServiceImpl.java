package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabil.SystemRecrutement.Repository.servRepository;
import com.nabil.SystemRecrutement.Validator.candidatValidator;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.dto.ServicesDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.service.servService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class servServiceImpl implements servService {

	private servRepository servRepository ;
	
	
	@Autowired
	public servServiceImpl(servRepository servRepository ) {
		this.servRepository=servRepository ;
	}
	
	
	
	@Override
	public List<ServicesDto> findAll() {
		return servRepository.findAll().stream()
				.map(ServicesDto::fromEntity)
				.collect(Collectors.toList() )
				
				;
	}



	@Override
	public ServicesDto save(ServicesDto dto) {
		//List<String> errors = candidatValidator.validate(dto);
		
		
		//if(!errors.isEmpty()) {
		//	log.error("Le candidat is not Valid {}" , dto);
		//	throw new InvalidEntityExeption("Le candidat n'est pas valide " , ErrorCodes.CANDIDAT_NOT_VALID , errors );
		//}
		
		return ServicesDto.fromEntity(servRepository.save(ServicesDto.toEntity(dto)));
	}



	@Override
	public void delete(Long id) {
		
		if(id==null) {
			log.error("Service ID is null");
			
			return  ;
			
			
		}
		
		servRepository.deleteById(id);
		
		
	}

}
