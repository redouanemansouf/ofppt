package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.onousc.business.referentiel.vo.transformer.EquipementVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class EquipementVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -444481103041396588L;
	/** The id. */
	private Long id;

	@NotNull
	@Size(max = 4)
	private String code;

	/** Libellé. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String numSerie;

	/** Libellé. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String marque;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String fournisseur;

	@NotNull
	private Double prixAchat;

	@NotNull
	private Date dateAchat;

	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String type;

	@NotNull
	private CiteVO citeVO;

	@NotNull
	private RestaurantVO RestaurantVO;

	@NotNull
	private String reference;

	/** Statut. */
	private EntityStatus statut;

	public EquipementVO() {
		super();
	}

	public EquipementVO(String code, String numSerie, String marque,
			String fornisseur, Double prixAchat, Date dateAchat, String type,
			CiteVO cite, RestaurantVO restaurantVO, String reference) {
		super();
		this.code = code;
		this.numSerie = numSerie;
		this.marque = marque;
		this.fournisseur = fornisseur;
		this.prixAchat = prixAchat;
		this.dateAchat = dateAchat;
		this.type = type;
		this.citeVO = cite;
		RestaurantVO = restaurantVO;
		this.reference = reference;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Equipement, EquipementVO> getTransformer() {
		return new EquipementVOTransformer();
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
		EquipementVO other = (EquipementVO) obj;
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

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fornisseur) {
		this.fournisseur = fornisseur;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CiteVO getCiteVO() {
		return citeVO;
	}

	public void setCiteVO(CiteVO cite) {
		this.citeVO = cite;
	}

	public RestaurantVO getRestaurantVO() {
		return RestaurantVO;
	}

	public void setRestaurantVO(RestaurantVO RestaurantVO) {
		this.RestaurantVO = RestaurantVO;
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

}
