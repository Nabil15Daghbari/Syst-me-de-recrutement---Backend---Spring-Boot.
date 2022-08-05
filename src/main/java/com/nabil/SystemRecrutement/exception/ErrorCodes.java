package com.nabil.SystemRecrutement.exception;




public enum ErrorCodes {
	
	CANDIDAT_NOT_FOUND(1000),
	CANDIDAT_NOT_VALID(1001), 
	
	CONTRATS_NOT_FOUND(1000),
	CONTRATS_NOT_VALID(1001),
	
	
	DEMANDES_NOT_FOUND(1000),
	DEMANDES_NOT_VALID(1001),
	
	
	ENTRETIEN_NOT_FOUND(1000),
	ENTRETIEN_NOT_VALID(1001),
	
	
	OFFRE_NOT_FOUND(1000),
	OFFRE_NOT_VALID(1001),
	
	
	RECRUTEUR_NOT_FOUND(1000),
	RECRUTEUR_NOT_VALID(1001),
	
	
	UTILISATEUR_NOT_FOUND(13000),
	UTILISATEUR_NOT_VALID(13001);
	
	
	
	
	
	
  private int code ;
	
	
	private ErrorCodes(int code){
		this.code=code ;
	}
	
	public int getcode() {
		return code ;
	}

}
