package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.vo.transformer.ClotureCaisseVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ClotureCaisseVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731044455145529279L;

	private Long id;

	private CaisseVO caissevo;

	private CaissierVO caissiervo;

	private Double solde;

	private Date dateCloture;

	private Date heureCloture;

	public ClotureCaisseVO() {
		caissiervo=new CaissierVO();
		caissevo=new CaisseVO();
	}

	public ClotureCaisseVO(Long id, CaisseVO caissevo, CaissierVO caissiervo,
			Double solde, Date dateCloture, Date heureCloture) {
		super();
		this.id = id;
		this.caissevo = caissevo;
		this.caissiervo = caissiervo;
		this.solde = solde;
		this.dateCloture = dateCloture;
		this.heureCloture = heureCloture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CaisseVO getCaissevo() {
		return caissevo;
	}

	public void setCaissevo(CaisseVO caissevo) {
		this.caissevo = caissevo;
	}

	public CaissierVO getCaissiervo() {
		return caissiervo;
	}

	public void setCaissiervo(CaissierVO caissiervo) {
		this.caissiervo = caissiervo;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Date getHeureCloture() {
		return heureCloture;
	}

	public void setHeureCloture(Date heureCloture) {
		this.heureCloture = heureCloture;
	}

	@Override
	public String getIdForSearch() {
		return this.id.toString();
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
		ClotureCaisseVO other = (ClotureCaisseVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new ClotureCaisseVOTransformer();
	}

}
