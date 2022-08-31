package com.nabil.SystemRecrutement.service.Strategy;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.dto.recruteurDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.model.recruteur;
import com.nabil.SystemRecrutement.service.RecruteurService;
import com.nabil.SystemRecrutement.service.flickrService;

import lombok.extern.slf4j.Slf4j;


@Service("recruteurStrategy")
@Slf4j
public class saveRecruteurPhoto implements Strategy<recruteurDto> {

	
	private flickrService  flickrService ;
	
	private RecruteurService recruteurService; 
	
	
	
	
	@Autowired
	public saveRecruteurPhoto(flickrService flickrService,
			RecruteurService recruteurService) {

		
		this.flickrService = flickrService;
		this.recruteurService = recruteurService;
	}





	@Override
	public recruteurDto savePhoto(Long id  ,InputStream photo, String titre) throws FlickrException {
		recruteurDto recruteur=recruteurService.findById(id);
		 String urlPhoto =flickrService.savePhoto(photo, titre);
		
		  if(StringUtils.hasLength(urlPhoto)) {
	        	throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de recruteur", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
	        }
	        
		  recruteur.setPhoto(urlPhoto);
		return recruteurService.save(recruteur);
	}

}
