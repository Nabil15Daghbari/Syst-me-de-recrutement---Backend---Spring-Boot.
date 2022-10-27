package com.nabil.SystemRecrutement.dto;

import java.util.Date;
import java.util.List;
import com.nabil.SystemRecrutement.model.Offres;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class offresDto {
     
	private String codeOffre;
	private Long   id  ;
	private String poste ; 
	private String  mission ;
	private String connaissances ;
	private String niveauEtudes ;
	private String formation ;
	private String experience ;
	private String criteres;
	private String domaine ;
	private String langues ;
	private int nbrARecruter ;
	private String cantrat ;
	private String ville ;
	private Date dateExpiration;
	private Date dateOrale ;
	private Date dateConcours ;
	private int salaire ;
	
	private AdminDto admin ;
	
	private recruteurDto recruteur  ;
	
	private List<demandesDto> demandes ;


	
	public static offresDto fromEntity(Offres offres) {
		if(offres==null) {
			return null ;
		}
		
		return offresDto.builder()
				.codeOffre(offres.getCodeOffre())
				.id(offres.getId())
				.poste(offres.getPoste())
				.mission(offres.getMission())
				.connaissances(offres.getConnaissances())
				.niveauEtudes(offres.getNiveauEtudes())
				.formation(offres.getFormation())
				.experience(offres.getExperience())
				.criteres(offres.getCriteres())
				.domaine(offres.getDomaine())
				.langues(offres.getLangues())
				.nbrARecruter(offres.getNbrARecruter())
				.cantrat(offres.getCantrat())
				.ville(offres.getVille())
				.dateExpiration(offres.getDateExpiration())
				.dateOrale(offres.getDateOrale())
				.dateConcours(offres.getDateConcours())
				.salaire(offres.getSalaire())
				.admin(AdminDto.fromEntity(offres.getAdmin()))
				.recruteur(recruteurDto.fromEntity(offres.getRecruteur()))
			//	.demandes(
						
			//		         	 offres.getDemandes() != null ? 
			//					 offres.getDemandes().stream()
			//					 .map(demandesDto::fromEntity)
			//					 .collect(Collectors.toList()) : null
								
						
			//	)
				
				
				
	
		          .build();
	}

	public static Offres toEntity(offresDto offresDto ) {
		if(offresDto==null) {
			return null ;
		}
		
		Offres offres = new Offres();
		offres.setCodeOffre(offresDto.getCodeOffre());
		offres.setId(offresDto.getId());
		offres.setPoste(offresDto.getPoste());
		offres.setMission(offresDto.getMission());
		offres.setConnaissances(offresDto.getConnaissances());
		offres.setNiveauEtudes(offresDto.getNiveauEtudes());
		offres.setFormation(offresDto.getFormation());
		offres.setExperience(offresDto.getExperience());
		offres.setCriteres(offresDto.getCriteres());
		offres.setDomaine(offresDto.getDomaine());
		offres.setLangues(offresDto.getLangues());
		offres.setNbrARecruter(offresDto.getNbrARecruter());
		offres.setCantrat(offresDto.getCantrat());
		offres.setVille(offresDto.getVille());
		offres.setDateExpiration(offresDto.getDateExpiration());
		offres.setDateOrale(offresDto.getDateOrale());
		offres.setDateConcours(offresDto.getDateConcours());
		offres.setSalaire(offresDto.getSalaire());
		offres.setAdmin(AdminDto.toEntity(offresDto.getAdmin()));
		offres.setRecruteur(recruteurDto.toEntity(offresDto.getRecruteur()));
			
		
		
		return offres ;
		
		
		
	}
}
