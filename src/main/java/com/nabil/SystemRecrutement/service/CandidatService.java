package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.CandidatDto;


public interface CandidatService {
	
    CandidatDto save(CandidatDto dto) ;
	
    CandidatDto findById(Long id);
	
	List<CandidatDto> findAll();
	
	void delete(Long id);

}
