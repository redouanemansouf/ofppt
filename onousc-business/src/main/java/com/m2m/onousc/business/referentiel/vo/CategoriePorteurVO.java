package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.onousc.business.referentiel.vo.transformer.CategoriePorteurVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class CategoriePorteurVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7898634802771085319L;
	/** The id. */
	private Long id;

	/** Libellé. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	@Size(max = 4)
	private String code;

	private String categorie;

	private Double ratio;

	private String plafJour;

	private Date dated;

	private Date datef;

	private String datedaf;

	private String datefaf;

	private SiteVO siteVO;

	public String getDatedaf() {
		return datedaf;
	}

	public void setDatedaf(String datedaf) {
		this.datedaf = datedaf;
	}

	public String getDatefaf() {
		return datefaf;
	}

	public void setDatefaf(String datefaf) {
		this.datefaf = datefaf;
	}

	/** Statut du canal de vente. */
	private EntityStatus statut;

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}

	public CategoriePorteurVO() {
		super();
	}

	public CategoriePorteurVO(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<CategoriePorteur, CategoriePorteurVO> getTransformer() {
		return new CategoriePorteurVOTransformer();
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
		CategoriePorteurVO other = (CategoriePorteurVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPlafJour() {
		return plafJour;
	}

	public void setPlafJour(String plafJour) {
		this.plafJour = plafJour;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}