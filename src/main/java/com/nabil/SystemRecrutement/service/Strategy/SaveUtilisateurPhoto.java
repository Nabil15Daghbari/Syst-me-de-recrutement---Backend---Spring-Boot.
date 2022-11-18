package com.nabil.SystemRecrutement.service.Strategy;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.dto.utilisateurDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.service.UtilisateurService;
import com.nabil.SystemRecrutement.service.flickrService;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("utilisateurStrategy")

public class SaveUtilisateurPhoto implements Strategy<utilisateurDto> {

  private flickrService flickrService;
  private UtilisateurService utilisateurService;

  @Autowired
  public SaveUtilisateurPhoto(flickrService flickrService, UtilisateurService utilisateurService) {
    this.flickrService = flickrService;
    this.utilisateurService = utilisateurService;
  }

  @Override
  public utilisateurDto savePhoto(Long id, InputStream photo, String titre) throws FlickrException {
    utilisateurDto utilisateur = utilisateurService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'utilisateur", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    utilisateur.setPhoto(urlPhoto);
    return utilisateurService.save(utilisateur);
  }
}
