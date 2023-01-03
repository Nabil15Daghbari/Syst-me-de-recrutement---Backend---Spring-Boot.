package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.io.IOException;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nabil.SystemRecrutement.dto.contratsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.jasperreports.engine.JRException;

@Api( "/contrat")
public interface ContratsApi {
	
	@PostMapping(value = APP_ROOT + "/contrat/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister un contrat " , notes="Cette methode permet d'enregistrer ou modofier un contrat " , response = contratsDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le contrat cree / modifie") ,
			@ApiResponse(code=400 , message="le contrat n'est pas valide ")
	})
	contratsDto save(@RequestBody contratsDto dto);
	
	
	
	
	@GetMapping(value=APP_ROOT + "/contrat/{idContrat}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="rechercher un contrat par son ID" , notes="Cette methode permet de chercher un contrat " , response = contratsDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="le contrat a ete trouvee dans l BD") ,
			@ApiResponse(code=400 , message="Aucun contrat  n'existe dans BDD avec l'ID fourni ")
	})
	contratsDto findById(@PathVariable("idContrat") Long id) ;
	 
	 // http://localhost:8081/systemrecrutement/v1/contrat/All
	 
	 @GetMapping(value=APP_ROOT + "/contrat/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher tous les contrats " , notes="Cette methode permet de recupurer tous les contrat " , responseContainer = "List<contratsDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les contrats a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun contrats n'existe dans BDD avec l'ID fourni ")
		})
	 List<contratsDto> findAll() ;
	 
	 
	 //http://localhost:8081/systemrecrutement/v1/contrat/delete/7
	 @DeleteMapping(value=APP_ROOT + "/contrat/delete/{idContrat}" )
	 @ApiOperation(value="supprimer un contrat par ID" , notes="Cette methode permet de supprimer un contrats par son ID " , response = contratsDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le contrat  a ete supprimer dans l BD") 
		})
	 void  delete(@PathVariable("idContrat") Long id) ;
	 
	 
	 /**
	 @GetMapping(value = APP_ROOT + "/contrat/{codeContrat}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="rechercher un contrat par CODE  " , notes="Cette methode permet de chercher   un contrat par son CODE" , response = contratsDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="le contrat a ete trouvee dans l BD"),
			@ApiResponse(code = 404 , message = "Aucun contrat n'existe dans BDD avec le CODE fourni")
	})
	 contratsDto findByCodeContrat(@PathVariable("codeContrat") String codeContrat);
	*/
	 
	 @GetMapping(value=APP_ROOT + "/report/{ReportName}/{cin}" )
	 @ApiOperation(value="rechercher tous les contrats " , notes="Cette methode permet de recupurer tous les contrat " , responseContainer = "List<contratsDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les contrats a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun contrats n'existe dans BDD avec l'ID fourni ")
		})
	 byte[] getReportfile(@PathVariable String ReportName, @PathVariable String cin) throws JRException, IOException;

}
