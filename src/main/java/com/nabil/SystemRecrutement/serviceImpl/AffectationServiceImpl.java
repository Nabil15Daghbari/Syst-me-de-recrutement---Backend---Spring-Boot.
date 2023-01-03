package com.nabil.SystemRecrutement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabil.SystemRecrutement.Repository.Affectationrepository;
import com.nabil.SystemRecrutement.dto.AffectationDto;
import com.nabil.SystemRecrutement.model.Affectation;
import com.nabil.SystemRecrutement.service.AffectationService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AffectationServiceImpl implements AffectationService{

	private Affectationrepository  affectationrepository ;
	
	@Autowired
	public AffectationServiceImpl(Affectationrepository affectationrepository) {
		this.affectationrepository = affectationrepository ;
	}
	
	
	@Override
	public List<AffectationDto> findAll() {
		return affectationrepository.findAll().stream()
				.map(AffectationDto::fromEntity)
				.collect(Collectors.toList() )
				
				;
	}


	@Override
	public List<AffectationDto> findAffectationByIdCandidat(Long idCandidat) {
	 return affectationrepository.findByCandidatId(idCandidat).stream()
		        .map(AffectationDto::fromEntity)
		        .collect(Collectors.toList());
	}


	@Override
	public Affectation update(Long id, Affectation affectation) {	
		
		return null;
	}


	@Override
	public AffectationDto save(AffectationDto aff) {
		
		return AffectationDto.fromEntity(affectationrepository.save(AffectationDto.toEntity(aff)));
	}

}
