package com.m2m.onousc.web.commons.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.m2m.technicalservices.security.impl.AuthManager;

@ManagedBean
@SessionScoped
public class AuthMbean {
	
	private AuthManager authMbean; 
	
	public AuthMbean() {
		authMbean = new AuthManager();
	}
	
	/**
	 * verifier l'acces a un ecran ou bouton specifique
	 * @param code
	 * @return
	 */
	public boolean hasEcran(String codeEcran){
		return authMbean.hasEcran(codeEcran);
	}
	/**
	 * verifier l'acces au bouton create
	 * @param code
	 * @return
	 */
	public  boolean hasCreate(String codeEcran){
		return authMbean.hasCreate(codeEcran);
	}
	/**
	 * verifier l'acces au bouton update
	 * @param code
	 * @return
	 */
	public  boolean hasUpdate(String codeEcran){
		return authMbean.hasUpdate(codeEcran);
	}
	/**
	 * verifier l'acces au bouton delete
	 * @param code
	 * @return
	 */
	public  boolean hasDelete(String codeEcran){
		return authMbean.hasDelete(codeEcran);
	}
	/**
	 * verifier l'acces au  bouton select 
	 * @param code
	 * @return
	 */
	public  boolean hasSelect(String codeEcran){
		return authMbean.hasSelect(codeEcran);
	}

	/**
	 * @return
	 */
	public AuthManager getAuthMbean() {
		return authMbean;
	}

	/**
	 * @param authMbean
	 */
	public void setAuthMbean(AuthManager authMbean) {
		this.authMbean = authMbean;
	}
	
	
	
}
	