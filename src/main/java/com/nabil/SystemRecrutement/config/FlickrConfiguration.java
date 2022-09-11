package com.nabil.SystemRecrutement.config;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.apis.FlickrApi.FlickrPerm;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

// cette classe va exucuté une seule fois 
@Configuration
public class FlickrConfiguration {
	
    @Value("${flickr.apiKey}")
	private String apiKey ;
    
    @Value("${flickr.apiSecret}")
    private String apiSecret ;
    
    
    @Value("${flickr.appKey}")
    private String appKey ;
    
    @Value("${flickr.appSecret}")
    private String appSecret ;
  
    
    /*
    
    //  creation d'une methode de type de return flickr qui s'appelle fetFlickr 
   @Bean //  on ajouter l'annotation be	n : lors de demarrage du l'application spring doit exécuté cette methode  
   public Flickr getFlickr() throws InterruptedException , ExecutionException , IOException , FlickrException {
	   
	   
    	
	   // instancer une objet flickr qui prend on parametre apikey et apiSecret et un objet new rest 
   	Flickr flickr  = new Flickr(apiKey , apiSecret ,  new REST()) ;
   	
   
   	OAuth10aService service = new ServiceBuilder(apiKey)
   			
   			.apiSecret(apiSecret)
   			// FlickrPerm : c'est la permution qui va donner a mon application : write , read  , Delete(read , write )  les photo 
   			.build(FlickrApi.instance(FlickrPerm.DELETE)) ;
   	
   	final Scanner scanner = new Scanner(System.in);
   	
   	final OAuth1RequestToken request = service.getRequestToken();
   	
   	final String authUrl = service.getAuthorizationUrl(request);
   	
   	System.out.println(authUrl);
   	System.out.println("Paste it here >> ");
   	
   	final String authVerifier = scanner.nextLine();
   	
   	OAuth1AccessToken accesToken = service.getAccessToken(request, authVerifier);
   	
   	
   	
  
	System.out.println(accesToken.getToken());
	System.out.println(accesToken.getTokenSecret());
	
	// Auth auth = flickr.getAuthInterface().checkToken(accesToken);
	
	
//	System.out.println("-----------------------------");
 //	System.out.println(auth.getToken());
//	System.out.println(auth.getTokenSecret());
   	
   			 
   	return flickr ;
    	
   
  }
  
  
  */
  
    @Bean
    public Flickr getFlickr() {
    	
        Flickr  flickr =new Flickr(apiKey , apiSecret , new REST());
		Auth auth = new Auth();
		
		
		auth.setToken(appKey);
		auth.setTokenSecret(appSecret);
		auth.setPermission(Permission.DELETE);
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		
		flickr.setAuth(auth);	
		
    	return flickr ;
    }
    
    
}
    
    
    




    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
