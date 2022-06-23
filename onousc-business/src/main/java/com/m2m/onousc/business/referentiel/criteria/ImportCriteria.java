package com.m2m.onousc.business.referentiel.criteria;

import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;

public class ImportCriteria extends BaseCriteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8062742265290124850L;
	private Date dateDebut;
	private Date dateFin;
	private String userName;
	private String cin;
	private String codeMassar;

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

}
