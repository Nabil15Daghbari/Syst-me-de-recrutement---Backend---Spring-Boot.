package com.nabil.SystemRecrutement.exception;

import lombok.Getter;

/*
 Cette exception " Entity not fount exception "
par exemple je recherchais un article par son code et je ne trouve pas cet article.Danc I retourne une exception pour le type EntityNotFoundException. 
 --> comme ca l'exception est claire pour le client ou le consommateur
*/
 public  class EntityNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	private  ErrorCodes errorCodes ;
	
	public EntityNotFoundException(String message ) {
		super(message );
	}
	
	
	public EntityNotFoundException(String message ,  Throwable cause) {
		super(message , cause);
	}
	
	
	public EntityNotFoundException(String message ,  ErrorCodes errorCodes  ) {
		super(message);
		this.errorCodes=errorCodes;
	}
	
	
	
	public EntityNotFoundException(String message , Throwable cause , ErrorCodes errorCode ) {
		super(message , cause );
		
		this.errorCodes=errorCode;
		}
	
	
	
	
	
	
	

}
