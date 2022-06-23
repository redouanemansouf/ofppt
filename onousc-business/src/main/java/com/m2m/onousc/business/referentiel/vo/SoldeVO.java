/*
 * CarteVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.vo.transformer.SoldeVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class SoldeVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957140225816747987L;

	/** The Constant serialVersionUID. */

	private Long id;

	private String matr;

	private Date date;

	private String maj;

	private String init;

	private String nom;

	private String prenom;

	private String getnom;

	private String getprenom;

	private SiteVO siteVO;

	public String getGetnom() {
		return getnom;
	}

	public void setGetnom(String getnom) {
		this.getnom = getnom;
	}

	public String getGetprenom() {
		return getprenom;
	}

	public void setGetprenom(String getprenom) {
		this.getprenom = getprenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public SoldeVO() {
		// TODO Auto-generated constructor stub
	}

	public SoldeVO(Long id, String matr, Date date, String maj, String init) {
		super();
		this.id = id;
		this.matr = matr;
		this.date = date;
		this.maj = maj;
		this.init = init;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoldeVO other = (SoldeVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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
	public ITransformer<Solde, SoldeVO> getTransformer() {
		return new SoldeVOTransformer();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMaj() {
		return maj;
	}

	public void setMaj(String maj) {
		this.maj = maj;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
