
package com.nabil.SystemRecrutement.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nabil.SystemRecrutement.model.Admin;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {

	private Long id  ;
	
    private String nom ; 
	
	private String prenom ;
		
	private String email ;
	
	private String password ;
	
	private int age ;
	
	private String Telephone ;
	
	private String login ;
	
	private String photo ;

	
	private List<offresDto> offres ;
	
	
	
	public static AdminDto fromEntity(Admin admin) {
		
		if(admin == null) {
			return null ;
		}
		
		
		return AdminDto.builder()
				.id(admin.getId())
				.nom(admin.getNom())
				.prenom(admin.getPrenom())
				.email(admin.getEmail())
				.photo(admin.getPhoto())
				.login(admin.getLogin())
				.password(admin.getPassword())
				.Telephone(admin.getTelephone())
			//	.offres
			 //    (
			  //  		         admin.getOffres() !=null ?
			  // 				 admin.getOffres().stream()
				//               .map(offresDto :: fromEntity)
				//             .collect(Collectors.toList()) : null
					
			//	)
	
				.build();
				

 
		
	}
	
	
	public static Admin toEntity(AdminDto adminDto ) {
		if(adminDto==null) {
			return null ;
		}
		
		Admin admin = new Admin();
		admin.setId(adminDto.getId());
		admin.setNom(adminDto.getNom());
		admin.setPrenom(adminDto.getPrenom());
		admin.setEmail(adminDto.getEmail());
		admin.setPhoto(adminDto.getPhoto());
		admin.setLogin(adminDto.getLogin());
		admin.setPassword(adminDto.getPassword());
		admin.setTelephone(adminDto.getTelephone());

		
	    
		
		
		
		return admin ;
	}
	
}
