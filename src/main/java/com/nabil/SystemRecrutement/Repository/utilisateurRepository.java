package com.nabil.SystemRecrutement.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nabil.SystemRecrutement.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	/*
	//  @Query("select u from Utilisateur u where u.email =:email")
	//  Optional<Utilisateur>	 findUtilisateurByEmail(@Param("email")  String email);

	@Query("select u from Utilisateur u where u.email = :email")
    Utilisateur findUtilisateurByEmail(@Param("email") String email );
    */
	
	Utilisateur findByEmail(String email) ;
}
