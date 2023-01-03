package com.nabil.SystemRecrutement.serviceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.Repository.offresRepository;
import com.nabil.SystemRecrutement.Validator.offresValidator;
import com.nabil.SystemRecrutement.dto.offresDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.Offres;
import com.nabil.SystemRecrutement.model.Services;
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




	@Override
	public offresDto findOffresByCodeOffre(String codeOffre) {
		 if (!StringUtils.hasLength(codeOffre)) {
		      log.error("Offre CODE is null");
		      return null;
		    }

		    return offresRepository.findOffresByCodeOffre(codeOffre)
		        .map(offresDto::fromEntity)
		        .orElseThrow(() ->
		            new EntityNotFoundException(
		                "Aucun offre avec le CODE = " + codeOffre + " n' ete trouve dans la BDD",
		                ErrorCodes.OFFRE_NOT_FOUND)
		        );
	}




	@Override
	public Offres update(Long id, Offres offre) {
		Offres offreUpdate = offresRepository.findById(id).get();
		offreUpdate.setCodeOffre(offre.getCodeOffre());
		offreUpdate.setPoste(offre.getPoste());
		offreUpdate.setMission(offre.getMission());
		offreUpdate.setConnaissances(offre.getConnaissances());
		offreUpdate.setNiveauEtudes(offre.getNiveauEtudes());
		offreUpdate.setFormation(offre.getFormation());
		offreUpdate.setExperience(offre.getExperience());
		offreUpdate.setCriteres(offre.getCriteres());
		offreUpdate.setDomaine(offre.getDomaine());
		offreUpdate.setLangues(offre.getLangues());
		offreUpdate.setNbrARecruter(offre.getNbrARecruter());
		offreUpdate.setCantrat(offre.getCantrat());
		offreUpdate.setDateExpiration(offre.getDateExpiration());
		offreUpdate.setSalaire(offre.getSalaire());
		offreUpdate.setVille(offre.getVille());
		

		return offresRepository.saveAndFlush(offreUpdate);
	}




	@Override
	public List<Object> avg() {
		return offresRepository.avg();  
	}
		
	

}
