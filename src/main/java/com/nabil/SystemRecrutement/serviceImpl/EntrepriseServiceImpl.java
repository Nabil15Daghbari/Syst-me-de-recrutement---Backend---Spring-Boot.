package com.nabil.SystemRecrutement.serviceImpl;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabil.SystemRecrutement.Repository.EntrepriseRepository;
import com.nabil.SystemRecrutement.service.EntrepriseService;
import com.nabil.SystemRecrutement.service.UtilisateurService;
import com.nabil.SystemRecrutement.Repository.rolesRepository ;
import com.nabil.SystemRecrutement.Validator.EntrepriseValidator;
import com.nabil.SystemRecrutement.dto.EntrepriseDto;
import com.nabil.SystemRecrutement.dto.RolesDto;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;
import com.nabil.SystemRecrutement.model.Roles;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

  private EntrepriseRepository entrepriseRepository;
  private UtilisateurService utilisateurService;
  private rolesRepository rolesRepository;

  @Autowired
  public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, UtilisateurService utilisateurService,
		  rolesRepository rolesRepository) {
    this.entrepriseRepository = entrepriseRepository;
    this.utilisateurService = utilisateurService;
    this.rolesRepository = rolesRepository;
  }

  @Override
  public EntrepriseDto save(EntrepriseDto dto) {
    List<String> errors = EntrepriseValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Entreprise is not valid {}", dto);
      throw new InvalidEntityExeption("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
    }
    EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
        entrepriseRepository.save(EntrepriseDto.toEntity(dto))
    );

    utilisateurDto utilisateur = fromEntreprise(savedEntreprise);

    utilisateurDto savedUser = utilisateurService.save(utilisateur);
        // Roles roles = new Roles() ; 
        // roles.getRoleName() =>  w athi tetzad fi blaset "ADMIN "
    // taba3 vidio msajel ela youtpe " authentification bay role "
    RolesDto rolesDto = RolesDto.builder()	
        .roleName("UTILISATEUR")
        .utilisateur(savedUser)
        .build();

    rolesRepository.save(RolesDto.toEntity(rolesDto));

    return  savedEntreprise;
  }

  private utilisateurDto fromEntreprise(EntrepriseDto dto) {
    return utilisateurDto.builder()
    	.adresse1(dto.getAdresse1())
    	.pays(dto.getPays())
    	.ville(dto.getVille())
    	.codePostale(dto.getCodePostale())	
        .nom(dto.getNom())
        .prenom(dto.getCodeFiscal())
        .description(dto.getDescription())
        .email(dto.getEmail())
        .moteDePasse(generateRandomPassword())
        .entreprise(dto)
        .dateDeNaissance(Instant.now())
        .photo(dto.getPhoto())
        .build();   
  }

  private String generateRandomPassword() {
    return "som3R@nd0mP@$$word";
  }

  @Override
  public EntrepriseDto findById(Long id) {
    if (id == null) {    
      log.error("Entreprise ID is null");
      return null;
    }
    return entrepriseRepository.findById(id)
        .map(EntrepriseDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune entreprise avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
  }

  @Override
  public List<EntrepriseDto> findAll() {
    return entrepriseRepository.findAll().stream()
        .map(EntrepriseDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Long id) {
    if (id == null) {
      log.error("Entreprise ID is null");
      return;
    }
    entrepriseRepository.deleteById(id);
  }
}
