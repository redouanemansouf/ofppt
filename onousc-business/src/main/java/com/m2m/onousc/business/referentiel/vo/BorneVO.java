package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.vo.transformer.BorneVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class BorneVO implements ValueObject, ISearchResultVO {

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
	private String libelle;

	@NotNull
	private String ip;

	@NotNull
	private SiteVO siteVO;

	/** Statut. */
	private EntityStatus statut;

	public BorneVO() {
		super();
	}

	public BorneVO(Long id, String code, String libelle, String ip, SiteVO siteVO, EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.ip = ip;
		this.siteVO = siteVO;
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Borne, BorneVO> getTransformer() {
		return new BorneVOTransformer();
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
		BorneVO other = (BorneVO) obj;
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

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
