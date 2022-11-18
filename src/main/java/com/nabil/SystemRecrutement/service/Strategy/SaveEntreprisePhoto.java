package com.nabil.SystemRecrutement.service.Strategy;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.dto.EntrepriseDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.service.EntrepriseService;
import com.nabil.SystemRecrutement.service.flickrService;

import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("entrepriseStrategy")
@Slf4j
public class SaveEntreprisePhoto implements Strategy<EntrepriseDto> {

	private flickrService  flickrService ;
  private EntrepriseService entrepriseService;

  @Autowired
  public SaveEntreprisePhoto(flickrService flickrService, EntrepriseService entrepriseService) {
    this.flickrService = flickrService;
    this.entrepriseService = entrepriseService;
  }

  @Override
  public EntrepriseDto savePhoto(Long id, InputStream photo, String titre) throws FlickrException {
    EntrepriseDto entreprise = entrepriseService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'entreprise", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    entreprise.setPhoto(urlPhoto);
    return entrepriseService.save(entreprise);
  }
}
