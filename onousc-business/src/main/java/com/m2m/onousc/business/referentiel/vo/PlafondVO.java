package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.onousc.business.referentiel.vo.transformer.PlafondVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class PlafondVO implements ValueObject, ISearchResultVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7866294802788688752L;
	
	/** The id. */
	private Long id;

	/** Libellé de la caisse. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	@Size(max = 4)
	private String code;
	
	@NotNull
	private Integer max;
	
	@NotNull
	private Integer min;
	
	public PlafondVO(){
		super();
	}
	
	
	public PlafondVO(String libelle, String code,
			Integer max, Integer min) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.max = max;
		this.min = min;
	}


	/** Statut. */
	private EntityStatus statut;
	
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Plafond, PlafondVO> getTransformer() {
		return new PlafondVOTransformer();
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

	public Integer getMax() {
		return max;
	}


	public void setMax(Integer max) {
		this.max = max;
	}


	public Integer getMin() {
		return min;
	}


	public void setMin(Integer min) {
		this.min = min;
	}


	public EntityStatus getStatut() {
		return statut;
	}


	public void setStatut(EntityStatus statut) {
		this.statut = statut;
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
		PlafondVO other = (PlafondVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
