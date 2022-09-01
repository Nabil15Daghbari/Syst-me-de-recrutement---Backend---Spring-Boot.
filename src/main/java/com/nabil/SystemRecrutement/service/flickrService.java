package com.nabil.SystemRecrutement.service;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface flickrService {
	
	String savePhoto(InputStream photo , String title) throws FlickrException;

}
