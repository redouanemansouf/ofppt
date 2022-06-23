package com.m2m.onousc.business.referentiel.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.vo.transformer.AnneeUniversitaireVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

public class AnneeUniversitaireVO implements ValueObject, ISearchResultVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6167626956856888130L;
	/** The id. */
	private Long id;
	
	/** Libellé */
	@NotNull
	@Size(max = 30)
	private String libelle;
	
	@NotNull
	@Size(max = 4)
	private String code;
	
	@NotNull
	private Date date_debut;
	
	@NotNull
	private Date date_fin;
	

	private String datefinExp;
	
	/** Statut du canal de vente. */
	private EntityStatus statut;
	
	public AnneeUniversitaireVO(){
		super();
	}
	
	public AnneeUniversitaireVO(String libelle, Date date_debut, Date date_fin) {
		super();
		this.libelle = libelle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<AnneeUniversitaire, AnneeUniversitaireVO> getTransformer() {
		return new AnneeUniversitaireVOTransformer();
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
		AnneeUniversitaireVO other = (AnneeUniversitaireVO) obj;
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

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getDatefinExp() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date_fin);
				
				
	}

	public void setDatefinExp(String datefinExp) {
		this.datefinExp = datefinExp;
	}
}
