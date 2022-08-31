package com.nabil.SystemRecrutement.dto;
import java.util.List;
import javax.persistence.Column;
import com.nabil.SystemRecrutement.model.AppUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class appUserDto {
	

	private Long  id  ;
	private String cin ;
	private int age ;
	//email
	private String username ;
	private String password ;
	private String nom ;
	private String prenom ;
	private String telephone ;
	private String dateNes ;  
	private AdresseDto adresse ;

	@Column(name="photo")
	private String photo ;
    private List<appRoleDto> roles;
    
    
    
    public static appUserDto fromEntity(AppUser u) {
		if(u == null) {
			return null ;
		}
		
		return appUserDto.builder()
				.id(u.getId())
				.cin(u.getCin())
				.age(u.getAge())
				.username(u.getUsername())
				.password(u.getPassword())
				.nom(u.getNom())
				.prenom(u.getPrenom())
				.telephone(u.getTelephone())
				.dateNes(u.getDateNes())
				.photo(u.getPhoto())
				.adresse(AdresseDto.fromEntity(u.getAdresse()))
			//	.email(u.getEmail())
			//	.dateDeNaissance(u.getDateDeNaissance())
				
				
			
				.build();
				
				
				
		
      }
	
	
	public static AppUser toEntity(appUserDto ud ) {
		if(ud == null) {
			return null ;
		}
		
		AppUser u  =new AppUser();
		u.setId(ud.getId());
		u.setUsername(ud.getUsername());
		u.setPhoto(ud.getPhoto());
	//	u.setDateDeNaissance(ud.getDateDeNaissance());
		u.setPassword(ud.getPassword());
		u.setAdresse(AdresseDto.toEntity(ud.getAdresse()));
		
		
		return u ;
	}

}



