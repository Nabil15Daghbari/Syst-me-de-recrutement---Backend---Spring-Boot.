package com.nabil.SystemRecrutement.service;

import java.util.List;

import com.nabil.SystemRecrutement.dto.ChangerMotDePasseUtilisateurDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;


public interface UtilisateurService {
	
	
	  utilisateurDto save(utilisateurDto dto);

	  utilisateurDto findById(Long id);

	  List<utilisateurDto> findAll();

	  void delete(Long id);

	  utilisateurDto findByEmail(String email);

	  utilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
