package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CiteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.DetailProfilVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Number;
import com.m2m.technicalservices.web.ISearchResultVO;

public class DetailProfilVO implements ValueObject, ISearchResultVO {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2940127462366686385L;

	private Long id;

	private String tranche;


	private String jour;

	private Date dateDebut;

	
	private Date dateFin;


	private CritereVO profil;
	
	
	private Integer toleranceDateDebut;
	

	private Integer toleranceDateFin;

	
	private EntityStatus statut;

	/**
	 * Instantiates a new cite vo.
	 */
	public DetailProfilVO() {
		super();
	}

	
	

	public DetailProfilVO(Long id, String tranche, String jour, Date dateDebut,
			Date dateFin, CritereVO profil, EntityStatus statut) {
		super();
		this.id = id;
		this.tranche = tranche;
		this.jour = jour;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.profil = profil;
		this.statut = statut;
	}




	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getTranche() {
		return tranche;
	}




	public void setTranche(String tranche) {
		this.tranche = tranche;
	}




	public String getJour() {
		return jour;
	}




	public void setJour(String jour) {
		this.jour = jour;
	}




	public Date getDateDebut() {
		return dateDebut;
	}




	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}




	public Date getDateFin() {
		return dateFin;
	}




	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}




	public CritereVO getProfil() {
		return profil;
	}




	public void setProfil(CritereVO profil) {
		this.profil = profil;
	}




	public EntityStatus getStatut() {
		return statut;
	}




	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}




	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new DetailProfilVOTransformer();
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
		DetailProfilVO other = (DetailProfilVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	public Integer getToleranceDateDebut() {
		return toleranceDateDebut;
	}




	public void setToleranceDateDebut(Integer toleranceDateDebut) {
		this.toleranceDateDebut = toleranceDateDebut;
	}




	public Integer getToleranceDateFin() {
		return toleranceDateFin;
	}




	public void setToleranceDateFin(Integer toleranceDateFin) {
		this.toleranceDateFin = toleranceDateFin;
	}

	
	
	

	
}
