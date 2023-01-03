package com.nabil.SystemRecrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nabil.SystemRecrutement.controller.api.DemandesApi;
import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.demandes;
import com.nabil.SystemRecrutement.model.etatDemande;
import com.nabil.SystemRecrutement.service.DemandesService;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")

public class DemandesController implements DemandesApi {

	private DemandesService demandesService ;
	
	
	@Autowired
	public DemandesController(DemandesService demandesService ) {
		this.demandesService=demandesService ;
	}
	
	
	@Override
	public demandesDto save(demandesDto dto) {
		return demandesService.save(dto);
	}


	@Override
	public demandesDto findById(Long id) {
		return demandesService.findById(id);
	}


	@Override
	public List<demandesDto> findAll() {
		return demandesService.findAll();
	}


	@Override
	public void delete(Long id) {
		demandesService.delete(id);		
	}


	@Override
	public demandesDto updateEtatDemande(Long id, etatDemande etatDemande) {
		return demandesService.updateEtatDemande(id, etatDemande);
	}


	@Override
	public List<demandesDto> findAllDemandeByIdOffre(Long idOffre) {
		return demandesService.findAllDemandeByIdOffre(idOffre);
	}


	@Override
	public List<demandesDto> findDemandeByEtatDemande(etatDemande etat) {
	
		return demandesService.findByEtatDemande(etat);
				
	}


	@Override
	public List<Object>  countDemandeByEtatDemande(etatDemande etat) {
		return demandesService.findDemandeByEtatDemande(etat);
	}


	@Override
	public List<demandes> GetNombreDemande(String annee) {
		return demandesService.GetNombreDemande(annee);
	}


	@Override
	public List<demandesDto> findDemandeByCin(String cin) {
		return demandesService.findByCin(cin);
	}


	@Override
	public List<Object> countDemandeByOffre(Long idOffre) {
		
		return demandesService.calculerNombreDemandeByOffre(idOffre);
	}


	@Override
	public List<?> GetNombreDemByOffre() {
		return demandesService.GetNombreDemandeByOffre();
	}
	
	

}
