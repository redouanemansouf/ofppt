package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.onousc.business.referentiel.vo.transformer.CritereVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class CritereVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7898634802771085319L;
	/** The id. */
	private Long id;

	/** Libell?. */
	@NotNull
	@AlphaNum
	@Size(max = 250)
	private String libelle;

	@NotNull
	@Size(max = 20)
	private String code;

//	@NotNull
//	private Float coefficient;

	/** Statut du canal de vente. */
	private EntityStatus statut;

	public CritereVO() {
		super();
	}

	
	public CritereVO(Long id, String libelle, String code, EntityStatus statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.statut = statut;
	}


	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Critere, CritereVO> getTransformer() {
		return new CritereVOTransformer();
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
		CritereVO other = (CritereVO) obj;
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

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}
}