package com.nabil.SystemRecrutement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabil.SystemRecrutement.model.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
	
	  private Long id;

	  private String roleName;

	  @JsonIgnore
	  private utilisateurDto utilisateur;

	  public static RolesDto fromEntity(Roles roles) {
	    if (roles == null) {
	      return null;
	    }
	    return RolesDto.builder()
	        .id(roles.getId())
	        .roleName(roles.getRoleName())
	        .build();
	  }

	  public static Roles toEntity(RolesDto dto) {
	    if (dto == null) {
	      return null;
	    }
	    Roles roles = new Roles();
	    roles.setId(dto.getId());
	    roles.setRoleName(dto.getRoleName());
	    roles.setUtilisateur(utilisateurDto.toEntity(dto.getUtilisateur()));
	    return roles;
	  }

	}
