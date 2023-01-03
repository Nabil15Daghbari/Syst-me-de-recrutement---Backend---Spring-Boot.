package com.nabil.SystemRecrutement.controller.api;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nabil.SystemRecrutement.dto.offresDto;
import com.nabil.SystemRecrutement.model.Offres;
import com.nabil.SystemRecrutement.model.etatDemande;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api( "/offre")
public interface OffresApi {
	
	@PostMapping(value = APP_ROOT + "/offre/createOffre" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Enregister une offre " , notes="Cette methode permet d'enregistrer ou modofier une offre " , response = offresDto.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message ="l'offre cree / modifie") ,
			@ApiResponse(code=400 , message="l'offre n'est pas valide ")
	})
	public offresDto save(@RequestBody offresDto dto);
	
	
	 @GetMapping(value=APP_ROOT + "/offre/{idOffre}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher une offre par son ID" , notes="Cette methode permet chercher une offre par son ID " , response = offresDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'offre a ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun offre n'existe dans BDD avec l'ID fourni")
		})
	 public offresDto findById(@PathVariable("idOffre") Long id) ;
	 
	 // http://localhost:8081/systemrecrutement/v1/candidat/All
	 
	 @GetMapping(value=APP_ROOT + "/offre/All" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value="rechercher les offres dans BDD " , notes="Cette methode permet de chercher les offres" , responseContainer = "List<offresDto>")
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="les offres ont ete trouvee dans l BD") ,
				@ApiResponse(code=400 , message="Aucun offre n'existe dans BDD avec l'ID fourni")
		})
	 public List<offresDto> findAll() ;
	 
	 
	 //http://localhost:8081/systemrecrutement/v1/candidat/delete/7
	 @DeleteMapping(value=APP_ROOT + "/offre/delete/{idOffre}" )
	 @ApiOperation(value="Supprimer une offre " , notes="Cette methode permet supprimer une offre " , response = offresDto.class)
		@ApiResponses(value= {
				@ApiResponse(code= 200 , message ="l'offre a ete supprimer dans l BD ") ,
		})
	 public void  delete(@PathVariable("idOffre") Long id) ;
	

	 
	 
	 
	 @GetMapping(value = APP_ROOT + "/offre/filter/{codeOffre}", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation(value = "Rechercher un offre par CODE", notes = "Cette methode permet de chercher un offre par son CODE", response =
			  offresDto.class)
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "offre a ete trouve dans la BDD"),
	      @ApiResponse(code = 404, message = "Aucun offre n'existe dans la BDD avec le CODE fourni")
	  })
	 public  offresDto findOffresByCodeOffre(@PathVariable("codeOffre") String codeOffre) ;
	 
	 
	 
	 
	 
	 @PutMapping(value=APP_ROOT + "/offre/update/{id}")
	 public Offres update(@PathVariable("id") Long id, @RequestBody Offres offre);
	 
	 
	 @GetMapping(value = APP_ROOT + "/offre/avg", produces = MediaType.APPLICATION_JSON_VALUE)
	 List<Object> avgSalaire() ;
}
