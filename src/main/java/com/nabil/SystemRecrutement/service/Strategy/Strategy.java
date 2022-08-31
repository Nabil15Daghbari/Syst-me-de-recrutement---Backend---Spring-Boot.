package com.nabil.SystemRecrutement.service.Strategy;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface Strategy<T> {
	
	
	T savePhoto(Long id  ,InputStream photo , String titre) throws FlickrException;

}
