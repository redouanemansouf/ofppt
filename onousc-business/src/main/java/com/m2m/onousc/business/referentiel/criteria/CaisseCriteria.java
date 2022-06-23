package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class CaisseCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582716643660036812L;

	/** Code **/
	private String code;
	/** Libellé de la caisse. */
	private String libelle;

	/** cite. */
	private String librest;

	private Long idSite;

	public CaisseCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.librest = null;
	}

	public CaisseCriteria(String code, String libelle, String libcite, EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.librest = libcite;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	@SuppressWarnings("rawtypes")
	public void activeCriteria() {
		boolean filter = false;
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			Object v = null;
			try {
				v = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TO-DO
			}
			if (t == EntityStatus.class && v != null) {
				filter = true;
				break;
			} else if (!t.isPrimitive() && !"sortField".equals(field) && !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

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
		this.libelle = WebUtils.prepareForLikeStatement(libelle);
	}

	public String getLibrest() {
		return librest;
	}

	public void setLibrest(String librest) {
		this.librest = librest;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
