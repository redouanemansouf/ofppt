package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.vo.transformer.MenuVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class MenuVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214550621066901824L;

	/** Id technique. */
	private Long id;

	/** Identifiant de la cite. */
	@NotNull
	@Size(max = 6)
	private String code;

	/** Libellé de la cite. */
	@NotNull
	@AlphaNum
	private String libelle;

	@NotNull
	@AlphaNum
	private String abbrev;

	@NotNull
	private String pageName; 

	/** Statut. */
	@NotNull
	private EntityStatus statut;

	/**
	 * Instantiates a new cite vo.
	 */
	public MenuVO() {
		super();
	}


	public MenuVO(String code, String libelle, String abbrev,
			EntityStatus statut) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.abbrev = abbrev;
		this.statut = statut;
	}


	@Override
	public ITransformer<Menu, MenuVO> getTransformer() {
		return new MenuVOTransformer();
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
		MenuVO other = (MenuVO) obj;
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


	public EntityStatus getStatut() {
		return statut;
	}


	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}


	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPageName() { 
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


}
