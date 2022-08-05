package com.nabil.SystemRecrutement.dto;



import com.nabil.SystemRecrutement.model.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
	
	private Long id  ;
	private String roleName;
	private utilisateurDto utilisateur ;
	
	
	
	public static RolesDto fromEntity(Roles r) {
		if(r == null ) {
			return null ;
				
		}
		
		return RolesDto.builder()
				.id(r.getId())
				.roleName(r.getRoleName())
				.utilisateur(utilisateurDto.fromEntity(r.getUtilisateur()))
				.build();
		
		
	}
	
	
	public static Roles toEntity(RolesDto rd) {
		if(rd == null) {
			return null ;
		}
		
		Roles r = new Roles();
		r.setId(rd.getId());
		r.setRoleName(rd.getRoleName());
		r.setUtilisateur(utilisateurDto.toEntity(rd.getUtilisateur()));
		
	
		
		return r ;
	}

}
