package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.EntrepriseDto;

public interface EntrepriseService {

  EntrepriseDto save(EntrepriseDto dto);

  EntrepriseDto findById(Long  id);

  List<EntrepriseDto> findAll();

  void delete(Long id);

}
