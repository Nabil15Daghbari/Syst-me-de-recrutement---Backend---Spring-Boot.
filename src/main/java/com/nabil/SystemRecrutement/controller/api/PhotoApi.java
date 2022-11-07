package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.flickr4java.flickr.FlickrException;

import io.swagger.annotations.Api;

@Api("/photos")
public interface PhotoApi {
	
	@PostMapping(value = APP_ROOT + "/photos/{id}/{title}/{context}" )
	Object savePhoto(String context , Long id ,@RequestPart("file") MultipartFile photo , String title) throws IOException, FlickrException;

}
