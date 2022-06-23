/*
 * SemaineUniversitaireVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.referentiel.vo.transformer.SemaineUniversitaireVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class SemaineUniversitaireVO.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
public class SemaineUniversitaireVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8040966315001639624L;

	/** The id. */
	private Long id;

	/** The libelle. */
	private String libelle;

	/** The date debut. */
	private Date dateDebut;

	/** The date fin. */
	private Date dateFin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ValueObject#getTransformer()
	 */
	@Override
	public ITransformer<SemaineUniversitaire, SemaineUniversitaireVO> getTransformer() {
		return new SemaineUniversitaireVOTransformer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SemaineUniversitaireVO [id=" + id + ", libelle=" + libelle
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 * 
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the date debut.
	 * 
	 * @return the date debut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 * 
	 * @param dateDebut
	 *            the new date debut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 * 
	 * @return the date fin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 * 
	 * @param dateFin
	 *            the new date fin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
