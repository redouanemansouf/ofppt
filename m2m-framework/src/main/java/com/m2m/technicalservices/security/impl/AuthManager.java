package com.m2m.technicalservices.security.impl;

import com.m2m.technicalservices.web.UserSessionHelper;

public class AuthManager {
	
	private AutorizationManager autorizationManager; 
	
	public AuthManager() {
		String codeOperateur = UserSessionHelper.getUserConecte().getCode();
		autorizationManager = new AutorizationManager(codeOperateur);
	}
	
	/**
	 * verifier l'acces a un ecran ou bouton specifique
	 * @param code
	 * @return
	 */
	public boolean hasEcran(String codeEcran){
		return autorizationManager.hasEcran(codeEcran);
	}
	/**
	 * verifier l'acces au bouton create
	 * @param code
	 * @return
	 */
	public  boolean hasCreate(String codeEcran){
		return autorizationManager.hasCreate(codeEcran);
	}
	/**
	 * verifier l'acces au bouton update
	 * @param code
	 * @return
	 */
	public  boolean hasUpdate(String codeEcran){
		return autorizationManager.hasUpdate(codeEcran);
	}
	/**
	 * verifier l'acces au bouton delete
	 * @param code
	 * @return
	 */
	public  boolean hasDelete(String codeEcran){
		return autorizationManager.hasDelete(codeEcran);
	}
	/**
	 * verifier l'acces au  bouton select 
	 * @param code
	 * @return
	 */
	public  boolean hasSelect(String codeEcran){
		return autorizationManager.hasSelect(codeEcran);
	}
	
	
	
}
	