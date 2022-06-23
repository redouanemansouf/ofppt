/*
 * CarteVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteNapsVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class CarteNapsVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957140225816747987L;

	/** The Constant serialVersionUID. */

	private Long id;

	private String nomprenom;

	private String nom;

	private String prenom;

	private String numidentite;

	private String tel;

	private String etab;

	private String matr;

	private String numcarte;

	private String motifRejet;

	private CategoriePorteurVO categorie;

	private EntityStatus statut;

	private SiteVO siteVO;

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
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

	public String getNumidentite() {
		return numidentite;
	}

	public void setNumidentite(String numidentite) {
		this.numidentite = numidentite;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEtab() {
		return etab;
	}

	public void setEtab(String etab) {
		this.etab = etab;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public CarteNapsVO() {
		// TODO Auto-generated constructor stub
	}

	public CarteNapsVO(Long id, String nomprenom, String nom, String prenom, String numidentite, String tel,
			String etab, String matr, String numcarte, String motifRejet, CategoriePorteurVO categorie,
			EntityStatus statut, SiteVO siteVO) {
		super();
		this.id = id;
		this.nomprenom = nomprenom;
		this.nom = nom;
		this.prenom = prenom;
		this.numidentite = numidentite;
		this.tel = tel;
		this.etab = etab;
		this.matr = matr;
		this.numcarte = numcarte;
		this.motifRejet = motifRejet;
		this.categorie = categorie;
		this.statut = statut;
		this.siteVO = siteVO;
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
		CarteNapsVO other = (CarteNapsVO) obj;
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
	public ITransformer<CarteNaps, CarteNapsVO> getTransformer() {
		return new CarteNapsVOTransformer();
	}

	public String getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	public CategoriePorteurVO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePorteurVO categorie) {
		this.categorie = categorie;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}
}
