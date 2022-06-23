/*
 * CarteVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.ProfilPorteur;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteNapsVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ProfilPorteurVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class ProfilPorteurVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 314529418461863656L;


	/** The Constant serialVersionUID. */
	


	private Long id;


	private String code;


	private String libelle;

	
	private String categorie;


	private Integer ratio;

	private EntityStatus statut;
	

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


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public Integer getRatio() {
		return ratio;
	}


	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}


	public EntityStatus getStatut() {
		return statut;
	}


	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ProfilPorteurVO() {
		// TODO Auto-generated constructor stub
	}


	public ProfilPorteurVO(Long id, String code, String libelle,
			String categorie, Integer ratio, EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
		this.ratio = ratio;
		this.statut = statut;
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
		ProfilPorteurVO other = (ProfilPorteurVO) obj;
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
	public ITransformer<ProfilPorteur, ProfilPorteurVO> getTransformer() {
		return new ProfilPorteurVOTransformer();
	}

	
	
}
