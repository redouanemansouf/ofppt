package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.MonitoringEchange;
import com.m2m.onousc.business.referentiel.vo.transformer.MonitoringEchangeVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class MonitoringEchangeVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6215056164369368647L;
	private Long id;
	private Date dateImport;
	private Integer nbreLigneErronee;
	private Integer nbreLigne;
	private String responsable;
	private String entite;
	private String typeFichier;
	private String path;
	private String statut;

	public MonitoringEchangeVO() {
		super();
	}

	public MonitoringEchangeVO(Date dateImport, Integer nbreLigneErronee, Integer nbreLigne, String responsable,
			String entite, String typeFichier) {
		super();
		this.dateImport = dateImport;
		this.nbreLigneErronee = nbreLigneErronee;
		this.nbreLigne = nbreLigne;
		this.responsable = responsable;
		this.entite = entite;
		this.typeFichier = typeFichier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateImport() {
		return dateImport;
	}

	public void setDateImport(Date dateImport) {
		this.dateImport = dateImport;
	}

	public Integer getNbreLigneErronee() {
		return nbreLigneErronee;
	}

	public void setNbreLigneErronee(Integer nbreLigneErronee) {
		this.nbreLigneErronee = nbreLigneErronee;
	}

	public Integer getNbreLigne() {
		return nbreLigne;
	}

	public void setNbreLigne(Integer nbreLigne) {
		this.nbreLigne = nbreLigne;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getTypeFichier() {
		return typeFichier;
	}

	public void setTypeFichier(String typeFichier) {
		this.typeFichier = typeFichier;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "MonitoringEchangeVO [id=" + id + ", dateImport=" + dateImport + ", nbreLigneErronee=" + nbreLigneErronee
				+ ", nbreLigne=" + nbreLigne + ", responsable=" + responsable + ", entite=" + entite + ", typeFichier="
				+ typeFichier + ", path=" + path + ", statut=" + statut + "]";
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
		MonitoringEchangeVO other = (MonitoringEchangeVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<MonitoringEchange, MonitoringEchangeVO> getTransformer() {
		return new MonitoringEchangeVOTransformer();
	}

}
