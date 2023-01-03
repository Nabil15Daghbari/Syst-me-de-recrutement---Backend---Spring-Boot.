package com.nabil.SystemRecrutement.service.Strategy;

import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flickr4java.flickr.FlickrException;
import com.nabil.SystemRecrutement.exception.ErrorCodes;
import com.nabil.SystemRecrutement.exception.InvalidOperationException;

import lombok.Setter;



@Service
public class StrategyPhotoContext {
	
	
	private BeanFactory beanFactory ;
	private Strategy strategy;
	
	@Setter
	private String context ;
	
	
	@Autowired
	public StrategyPhotoContext(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	
	
	public Object savePhoto(String context , Long id , InputStream photo , String title) throws FlickrException {
		
		determinContext(context);
		
		return strategy.savePhoto(id, photo, title);
		
	}
	     
	
	private void determinContext(String context) {
		
		final String beanName = context + "Strategy" ;
		
		switch(context) {
		case "candidat" :
			strategy = beanFactory.getBean(beanName , saveCandidatPhoto.class);
			break ;
		case "recruteur" :
			strategy = beanFactory.getBean(beanName , saveRecruteurPhoto.class);
			break ;
		case "entreprise" :
		        strategy = beanFactory.getBean(beanName, SaveEntreprisePhoto.class);
		          break;
		case "utilisateur" :
			strategy = beanFactory.getBean(beanName , SaveUtilisateurPhoto.class);
			break ;
		  default : throw new InvalidOperationException("Contexte inconnue pour l'enregistrement du la photo", ErrorCodes.UNKNOWN_CONTEXT);

			
		}

	}








	
}
