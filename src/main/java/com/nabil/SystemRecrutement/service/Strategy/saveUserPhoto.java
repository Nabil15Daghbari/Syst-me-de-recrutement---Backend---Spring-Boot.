package com.nabil.SystemRecrutement.service.Strategy;


import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.dto.appUserDto;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;
import com.nabil.SystemRecrutement.model.AppUser;
import com.nabil.SystemRecrutement.service.AccountService;
import com.nabil.SystemRecrutement.service.flickrService;

import lombok.extern.slf4j.Slf4j;

@Service("userStrategy")
@Slf4j
public class saveUserPhoto implements Strategy<appUserDto> {

	private flickrService  flickrService ;
    private AccountService accountService;
	
	
	
	@Autowired
	public saveUserPhoto(flickrService flickrService,
			AccountService accountService) {
		this.flickrService = flickrService;
		this.accountService = accountService;
	}




	@Override
	public appUserDto savePhoto(Long id  ,InputStream photo, String titre) throws FlickrException {

		appUserDto appUser = accountService.findById(id);
		
		String urlPhoto =flickrService.savePhoto(photo, titre);
        if(StringUtils.hasLength(urlPhoto)) {
        	throw new InvalidOperationException("Erreur lors de l'enregistrement de photo d'utilisateur", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
		
        appUser.setPhoto(urlPhoto);
        
		
		return accountService.addNewUser(appUser);
	}

}
