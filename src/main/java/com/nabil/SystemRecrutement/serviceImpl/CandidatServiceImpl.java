package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.candidatRepository;
import com.nabil.SystemRecrutement.Validator.candidatValidator;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.model.Candidat;
import com.nabil.SystemRecrutement.service.CandidatService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidatServiceImpl implements CandidatService {

	 private candidatRepository candidatRepository ;
	

	
	
	@Autowired
	public CandidatServiceImpl (candidatRepository candidatRepository    ) {
		
		this.candidatRepository= candidatRepository ;
		  
		
	}
	
	@Override
	public CandidatDto save(CandidatDto dto) {
		
		List<String> errors = candidatValidator.validate(dto);
		
		
		//if(!errors.isEmpty()) {
		//	log.error("Le candidat is not Valid {}" , dto);
		//	throw new InvalidEntityExeption("Le candidat n'est pas valide " , ErrorCodes.CANDIDAT_NOT_VALID , errors );
	//	}
		
		return CandidatDto.fromEntity(candidatRepository.save(CandidatDto.toEntity(dto)));
	}
	
	
	
	
	

	@Override
	public CandidatDto findById(Long id) {
		
		if(id==null) {
			log.error("candidat ID is null");
			
		
		return null ;
		    }
		
		Optional<Candidat> candidat = candidatRepository.findById(id);
		

		
		return Optional.of(CandidatDto.fromEntity(candidat.get())).orElseThrow( () ->  
		new EntityNotFoundException(
				"Aucun candidat avec l'ID =" + id + "n'ete trouve dans la BDD" , ErrorCodes.CANDIDAT_NOT_FOUND   
				));
	}
	
	
	

	@Override
	public List<CandidatDto> findAll() {
		
		return candidatRepository.findAll().stream()
				.map(CandidatDto::fromEntity)
				.collect(Collectors.toList() )
				
				;
	}

	
	
	
	@Override
	public void delete(Long id) {
		
		
		if(id==null) {
			log.error("Candidat ID is null");	
			return  ;		
		}
			 candidatRepository.deleteById(id);		
	}


	


	
	
}
