package com.nabil.SystemRecrutement.Validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

import com.nabil.SystemRecrutement.dto.EntrepriseDto;

public class EntrepriseValidator {

  public static List<String> validate(EntrepriseDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le nom ");
      errors.add("Veuillez reseigner la description ");
      errors.add("Veuillez reseigner le code fiscal");
      errors.add("Veuillez reseigner l'email ");
      errors.add("Veuillez reseigner le numero de telephone ");
      errors.addAll(AdresseValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(dto.getNom())) {
      errors.add("Veuillez renseigner le nom ");
    }
    if (!StringUtils.hasLength(dto.getDescription())) {
      errors.add("Veuillez reseigner la description ");
    }
    if (!StringUtils.hasLength(dto.getCodeFiscal())) {
      errors.add("Veuillez reseigner le code fiscal ");
    }
    if (!StringUtils.hasLength(dto.getEmail())) {
      errors.add("Veuillez reseigner l'email ");
    }
    if (!StringUtils.hasLength(dto.getNumTel())) {
      errors.add("Veuillez reseigner le numero de telephone ");
    }

   // errors.addAll(AdresseValidator.validate(dto.getAdresse()));
    return errors;
  }

}
