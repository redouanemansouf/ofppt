package com.m2m.technicalservices.security.impl;

import java.util.List;

import com.m2m.technicalservices.security.Permission;
import com.m2m.technicalservices.spring.BeansLookuper;

public class AutorizationManager {
	private String codeOperateur;
	private List<Permission> listPermission;

	public AutorizationManager(String codeOperateur) {
		super();
		this.codeOperateur = codeOperateur;
		AutorizationDAOJpa autorizationDAOJpa = (AutorizationDAOJpa) BeansLookuper
				.lookup("autorizationDao");
		this.listPermission = autorizationDAOJpa.listPermission(codeOperateur);
	}

	/**
	 * verifier l'acces a un ecran ou bouton specifique
	 * 
	 * @param code
	 * @return 
	 */
	public boolean hasEcran(String codeEcran) {
		for (Permission permission : listPermission) {
			if (permission.getCodeEcran().equals(codeEcran)) {
				return permission.isVisible();
			}
		}
		return false;
	}

	/**
	 * verifier l'acces au bouton create
	 * 
	 * @param code
	 * @return
	 */
	public boolean hasCreate(String codeEcran) {
		for (Permission permission : listPermission) { 
			if (permission.getCodeEcran().equals(codeEcran)) {
				return permission.isHasCreate();
			}
		}
		return false;
	}

	/**
	 * verifier l'acces au bouton update
	 * 
	 * @param code
	 * @return
	 */
	public boolean hasUpdate(String codeEcran) {
		for (Permission permission : listPermission) {
			if (permission.getCodeEcran().equals(codeEcran)) {
				return permission.isHasUpdate();
			}
		}
		return false;
	}

	/**
	 * verifier l'acces au bouton delete
	 * 
	 * @param code
	 * @return
	 */
	public boolean hasDelete(String codeEcran) {
		for (Permission permission : listPermission) {
			if (permission.getCodeEcran().equals(codeEcran)) {
				return permission.isHasDelete();
			}
		}
		return false;
	}

	/**
	 * verifier l'acces au bouton select
	 * 
	 * @param code
	 * @return
	 */
	public boolean hasSelect(String codeEcran) {
		for (Permission permission : listPermission) {
			if (permission.getCodeEcran().equals(codeEcran)) {
				return permission.isHasSelect();
			}
		}
		return false;
	}

	public String getCodeOperateur() {
		return codeOperateur;
	}

	public void setCodeOperateur(String codeOperateur) {
		this.codeOperateur = codeOperateur;
	}

	public List<Permission> getListPermission() {
		return listPermission;
	}

	public void setListPermission(List<Permission> listPermission) {
		this.listPermission = listPermission;
	}

}
