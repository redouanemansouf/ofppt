package com.m2m.technicalservices.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
//@NamedQueries({
//		@NamedQuery(name = "LIST_PERMISSION",query = "SELECT w FROM WinMenu w WHERE w.operateur = ?1"),
//})
@Table(name = "WINMENUAGC")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "WinMenu_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)   
public class WinMenu  extends GenericEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7373418012379812173L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PkGen")    
	@Column(name = "WIN_ID")  
	private Long id;    
	
	@Column(name = "AMN_CODE")
	private String code;
	@Column(name = "AMN_LIBELLE")  
	private String libelle;
	@Column(name = "AMN_ABREV")
	private String abbrev;
	@Column(name = "AMN_LANGUE")
	private String langue;
	@Column(name = "AMN_OPER")
	private String operateur;
	@Column(name = "AMN_DRTCREAT")
	private boolean droitCreat;
	@Column(name = "AMN_DRTMODIF")
	private boolean droitModif;
	@Column(name = "AMN_DRTSUPPR")
	private boolean droitSuppr;
	@Column(name = "AMN_DRTCNSLT")
	private boolean droitConsult;
	@Column(name = "AMN_ACTIF")
	private boolean actif;
	@Column(name = "AMN_TYPE")
	private String type;
	@Column(name = "AMN_STATUT")
	private String statut;

	
	
	
	public WinMenu(String code, String abbrev, String libelle, String langue,
			String operateur, String type) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.langue = langue;
		this.operateur = operateur;
		this.droitCreat = false;
		this.droitModif = false;
		this.droitSuppr = false;
		this.droitConsult = false;
		this.actif = false;  
		this.type = type;
	}

	public WinMenu() {
		super();  
	}

	public WinMenu(WinMenu win) {
		super();  
		this.code = win.getCode();
		this.libelle = win.getLibelle();
		this.abbrev = win.getAbbrev();
		this.langue = win.getLangue();
		this.droitCreat = win.isDroitCreat();
		this.droitModif = win.isDroitModif();
		this.droitSuppr = win.isDroitSuppr();
		this.droitConsult = win.isDroitConsult();
		this.actif = win.isActif();
		this.type = win.getType();
		this.statut = "ENABLED";   
	}

	public WinMenu(Long id, String code, String libelle, String abbrev,
			String langue, String operateur, boolean droitCreat,
			boolean droitModif, boolean droitSuppr, boolean droitConsult,
			boolean actif, String type) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.langue = langue;
		this.operateur = operateur;
		this.droitCreat = droitCreat;
		this.droitModif = droitModif;
		this.droitSuppr = droitSuppr;
		this.droitConsult = droitConsult;
		this.actif = actif;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	
	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public boolean isDroitCreat() {
		return droitCreat;
	}

	public void setDroitCreat(boolean droitCreat) {
		this.droitCreat = droitCreat;
	}

	public boolean isDroitModif() {
		return droitModif;
	}

	public void setDroitModif(boolean droitModif) {
		this.droitModif = droitModif;
	}

	public boolean isDroitSuppr() {
		return droitSuppr;
	}

	public void setDroitSuppr(boolean droitSuppr) {
		this.droitSuppr = droitSuppr;
	}

	public boolean isDroitConsult() {
		return droitConsult;
	}

	public void setDroitConsult(boolean droitConsult) {
		this.droitConsult = droitConsult;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}
