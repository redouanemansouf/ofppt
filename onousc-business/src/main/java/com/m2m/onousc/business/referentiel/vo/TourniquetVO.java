package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.vo.transformer.TourniquetVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class TourniquetVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -444481103041396588L;
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

	
	private RestaurantVO restaurant;

	@NotNull
	private String reference;
	
	private String mode;
	
	private String type;

	/** Statut. */
	private EntityStatus statut;

	public TourniquetVO() {
		super();
	}

	

	public TourniquetVO(Long id, String libelle, String code,
			RestaurantVO restaurant, String reference, String mode,
			String type, EntityStatus statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.restaurant = restaurant;
		this.reference = reference;
		this.mode = mode;
		this.type = type;
		this.statut = statut;
	}



	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Tourniquet, TourniquetVO> getTransformer() {
		return new TourniquetVOTransformer();
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
		TourniquetVO other = (TourniquetVO) obj;
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

	

	public RestaurantVO getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantVO restaurant) {
		this.restaurant = restaurant;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
