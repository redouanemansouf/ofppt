/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.vo.transformer.SiteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
public class SiteVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8161591620134745200L;

	/** The id. */
	private Long id;

	/** Libellé du canal de vente. */

	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@FixedSize(size = 4)
	private String code;

	@Size(max = 300)
	private String adresse;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String nomResponsable;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String prenomResponsable;

	@NotNull
	@AlphaNum
	@FixedSize(size = 10)
	private String numTele;

	private VilleVO ville;

	private EntityStatus statut;

	/**
	 * Instantiates a new canal vente vo.
	 */
	public SiteVO() {
		super();
	}

	/**
	 * Instantiates a new canal vente vo.
	 * 
	 * @param libelle     the libelle
	 * @param description the description
	 */
	public SiteVO(String libelle, String description) {
		super();
		this.libelle = libelle;
//		this.description = description;
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
	 * @param id the id to set
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
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the descpription
	 */
//	public String getDescription() {
//		return description;
//	}
//
//	/**
//	 * Sets the description.
//	 * 
//	 * @param description
//	 *            the new description
//	 */
//	public void setDescription(String description) {
//		this.description = description;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteVO other = (SiteVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public ITransformer<Site, SiteVO> getTransformer() {
		return new SiteVOTransformer();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}

	public String getNumTele() {
		return numTele;
	}

	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}

	public VilleVO getVille() {
		return ville;
	}

	public void setVille(VilleVO ville) {
		this.ville = ville;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

}
