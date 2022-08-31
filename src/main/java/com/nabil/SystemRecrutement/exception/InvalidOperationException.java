package com.nabil.SystemRecrutement.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException {
	
	
private static final long serialVersionUID = 1L;
	
	
	@Getter
	private  ErrorCodes errorCodes ; 
	
	
	public InvalidOperationException(String message ,  ErrorCodes errorCodes  ) {
		super(message);
		this.errorCodes=errorCodes;
	}
	

}
