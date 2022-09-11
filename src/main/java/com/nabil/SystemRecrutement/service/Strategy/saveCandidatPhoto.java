package com.nabil.SystemRecrutement.service.Strategy;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.dto.CandidatDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.model.Candidat;
import com.nabil.SystemRecrutement.service.CandidatService;
import com.nabil.SystemRecrutement.service.flickrService;

import lombok.extern.slf4j.Slf4j;

@Service("candidatStrategy")
@Slf4j
public class saveCandidatPhoto implements Strategy<CandidatDto>{

	private flickrService  flickrService ;
	private CandidatService candidatService ;
	
	
	
	
	@Autowired
	public saveCandidatPhoto(flickrService flickrService,
			CandidatService candidatService) {
	
		this.flickrService = flickrService;
		this.candidatService = candidatService;
	}





	@Override
	public CandidatDto savePhoto(Long id , InputStream photo, String titre) throws FlickrException {
        CandidatDto candidat = candidatService.findById(id);
        String urlPhoto =flickrService.savePhoto(photo, titre);
        if(!StringUtils.hasLength(urlPhoto)) {
        	throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de candidat", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        
        candidat.setPhoto(urlPhoto);
        
		return candidatService.save(candidat);
	}

}
