package com.nabil.SystemRecrutement.handlers;

import java.util.ArrayList;
import java.util.List;

import com.nabil.SystemRecrutement.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// c'est l'objet que je le renvoyais lorsque je catche une exception

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class ErrorDto {
	
	private Integer httpCode;
	
	private ErrorCodes code ;
	
	private String messsage ;
	
	private  List<String> errors = new ArrayList<>();

}
