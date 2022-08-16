package com.nabil.SystemRecrutement.serviceImpl;

import java.io.InputStream;
import org.springframework.stereotype.Service;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.nabil.SystemRecrutement.service.flickrService;



@Service

public class flickerServiceImpl  implements flickrService {
	    
	    
	    Flickr flickr ;
	
	    
	    public flickerServiceImpl(Flickr flickr) {
			this.flickr = flickr ;

		}

	    
	    
	    
	    
	    
	
	@Override
	public String savePhoto(InputStream photo, String title)  throws FlickrException{
		
		UploadMetaData uploadMetaData = new UploadMetaData();
		uploadMetaData.setTitle(title);
		
		String PhotoId = flickr.getUploader().upload(photo, uploadMetaData);
		
		
		
		
		return flickr.getPhotosInterface().getPhoto(PhotoId).getMedium640Url();
		
	}


	
	
	
}
