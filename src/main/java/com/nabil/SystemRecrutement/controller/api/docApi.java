package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.nabil.SystemRecrutement.dto.demandesDto;
import com.nabil.SystemRecrutement.model.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("document")
public interface docApi {
	
	@PostMapping(value= APP_ROOT +"/uploadFiles"  , consumes = MediaType.MULTIPART_FORM_DATA_VALUE ,  produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value="Enregister document " , notes="Cette methode permet d'enregistrer ou modofier une document " , response = Doc.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le doc cree / modifie") ,
			@ApiResponse(code=400 , message="le doc n'est pas valide ")
	})
	String uploadMultipleFiles(@RequestPart("files") MultipartFile[] files ) ;
	
	@GetMapping(value= APP_ROOT +"/downloadFile/{fileId}"  )
    ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId);
	
	
	@GetMapping(value=APP_ROOT + "/get"  )
	String get(Model model) ;

}
