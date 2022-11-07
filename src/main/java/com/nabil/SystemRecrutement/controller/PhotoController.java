package com.nabil.SystemRecrutement.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.controller.api.PhotoApi;
import com.nabil.SystemRecrutement.service.Strategy.StrategyPhotoContext;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class PhotoController implements PhotoApi {

	private StrategyPhotoContext strategyPhotoContext ;
	
	
	
	@Autowired
	public PhotoController(StrategyPhotoContext strategyPhotoContext) {
		this.strategyPhotoContext = strategyPhotoContext;
	}



	@Override
	public Object savePhoto(String context, Long id, MultipartFile photo, String title) throws  IOException, FlickrException {
		return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
	}

}
