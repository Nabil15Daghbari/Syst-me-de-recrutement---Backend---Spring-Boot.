package com.nabil.SystemRecrutement.dto;

import com.nabil.SystemRecrutement.model.AppRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class appRoleDto {
	
	private Long id  ;
	private String roleName;
	
	
	
	public static appRoleDto fromEntity(AppRole r) {
		if(r == null ) {
			return null ;
				
		}
		
		return appRoleDto.builder()
				.id(r.getId())
				.roleName(r.getRoleName())
				.build();
		
		
	}
	
	
	public static AppRole toEntity(appRoleDto rd) {
		if(rd == null) {
			return null ;
		}
		
		AppRole r = new AppRole();
		r.setId(rd.getId());
		r.setRoleName(rd.getRoleName());
		
	
		
		return r ;
		
		
	}

}
