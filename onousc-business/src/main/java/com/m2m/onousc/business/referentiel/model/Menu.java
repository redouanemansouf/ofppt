package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.dao.impl.GenericEntity;



@Entity
@Table(name = "REF_MENU")
public class Menu extends GenericEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5601891196797295945L;


	/** The id. */
	@Id
	@Column(name = "MENU_CODE")
	private String code;


	@Column(name = "MENU_LIBELLE")
	private String libelle;

	@Column(name = "MENU_ABBREV")
	private String abbrev;

	@Column(name = "MENU_PAGE")
	private String pageName;

	@Column(name= "MENU_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;	

	public Menu() {
		super();
	}

	public Menu(String code, String libelle, String abbrev, EntityStatus statut) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.statut = statut;
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;  
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


}
