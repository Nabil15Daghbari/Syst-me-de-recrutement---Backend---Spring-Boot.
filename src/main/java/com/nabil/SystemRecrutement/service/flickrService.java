package com.nabil.SystemRecrutement.service;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface flickrService {
	
	// methode 
	String savePhoto(InputStream photo , String title) throws FlickrException;

}
