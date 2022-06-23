package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.onousc.business.referentiel.vo.transformer.NoteCritereVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * 
 * @author abousnane
 * 
 */
public class NoteCritereVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3398434978686956758L;

	/** Id technique. */
	private Long id;

	/** Identifiant de l'universite. */
	@NotNull
	@Size(max = 4)
	private String code;

	@NotNull
	@Size(max = 30)
	private String libelle;

	@NotNull
	private Integer max;

	@NotNull
	private Integer min;

	@NotNull
	private Float note;

	@NotNull
	private CritereVO critereVO;

	/** Statut. */
	private EntityStatus statut;

	/**
	 * Instantiates a new universite vo.
	 */
	public NoteCritereVO() {
		super();
	}

	/**
	 * Instantiates a new universite vo.
	 * 
	 * 
	 */

	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public NoteCritereVO(String code, String libelle, Integer max, Integer min,
			Float note, CritereVO critereVO) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.max = max;
		this.min = min;
		this.note = note;
		this.critereVO = critereVO;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 * @return adresseUniv
	 */

	/**
	 * 
	 * @return statut
	 */
	public EntityStatus getStatut() {
		return statut;
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

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public CritereVO getCritereVO() {
		return critereVO;
	}

	public void setCritereVO(CritereVO critereVO) {
		this.critereVO = critereVO;
	}

	/**
	 * 
	 * @param statut
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<NoteCritere, NoteCritereVO> getTransformer() {
		return new NoteCritereVOTransformer();
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
		NoteCritereVO other = (NoteCritereVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;

	}

}
