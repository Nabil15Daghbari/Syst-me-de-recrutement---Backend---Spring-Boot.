package com.nabil.SystemRecrutement.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nabil.SystemRecrutement.exception.EntityNotFoundException;
import com.nabil.SystemRecrutement.exception.InvalidEntityExeption;


//  lors de l'ajout de l'annotation @RestControllerAdvice signifie qu'il n'y a pas besoin d'ajouter l'annotation @ResponseBady à chaque méthode.
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	 @ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception , WebRequest webRequest){
		
		
		final HttpStatus  notFound =HttpStatus.NOT_FOUND;
	    final ErrorDto errorDto = ErrorDto.builder() 
            .code(exception.getErrorCodes())
		    .httpCode(notFound.value())
		    .messsage(exception.getMessage())
		    .build();
		
	return new ResponseEntity<>(errorDto , notFound) ;	
		
	  }
	 
	 @ExceptionHandler(InvalidEntityExeption.class)
	 public ResponseEntity<ErrorDto> handleException(InvalidEntityExeption exception , WebRequest webRequest){
		 
		 final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		 
		 final ErrorDto errorDto = ErrorDto.builder()
				 .code(exception.getErrorCodes())
				 .httpCode(badRequest.value())
				 .messsage(exception.getMessage())
				 .errors(exception.getErrors())
				 .build();
		 
		 
		 return new ResponseEntity<>(errorDto , badRequest) ;
		 
	 }
}
