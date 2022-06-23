package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.vo.transformer.CiteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Email;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class CiteVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214550621066901824L;

	/** Id technique. */
	private Long id;

	/** Identifiant de la cite. */
	@NotNull
	@Size(max = 4)
	private String code;

	/** Libellé de la cite. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	private UniversiteVO universite;

	@Size(max = 300)
	private String adresseCite;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String nomResponsableCite;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String prenomResponsableCite;

	@NotNull
	@AlphaNum
	@FixedSize(size = 10)
	private String numTeleCite;

	@Email
	@Size(max = 100)
	private String adresseEmailCite;

	@NotNull
	private VilleVO ville;

	/** Statut. */
	private EntityStatus statut;

	/**
	 * Instantiates a new cite vo.
	 */
	public CiteVO() {
		super();
	}

	/**
	 * Instantiates a new cite vo.
	 * 
	 */
	

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	public CiteVO(String code, String libelle, UniversiteVO universite,
			String adresseCite, String nomResponsableCite,
			String prenomResponsableCite, String numTeleCite,
			String adresseEmailCite, VilleVO ville, EntityStatus statut) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.universite = universite;
		this.adresseCite = adresseCite;
		this.nomResponsableCite = nomResponsableCite;
		this.prenomResponsableCite = prenomResponsableCite;
		this.numTeleCite = numTeleCite;
		this.adresseEmailCite = adresseEmailCite;
		this.ville = ville;
		this.statut = statut;
	}

	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
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
	 * @return universite
	 */


	/**
	 * 
	 * @return adresseCite
	 */
	public String getAdresseCite() {
		return adresseCite;
	}

	/**
	 * 
	 * @param adresseCite
	 */
	public void setAdresseCite(String adresseCite) {
		this.adresseCite = adresseCite;
	}

	/**
	 * 
	 * @return nomResponsableCite
	 */
	public String getNomResponsableCite() {
		return nomResponsableCite;
	}

	/**
	 * 
	 * @param nomResponsableCite
	 */
	public void setNomResponsableCite(String nomResponsableCite) {
		this.nomResponsableCite = nomResponsableCite;
	}

	/**
	 * 
	 * @return prenomResponsableCite
	 */
	public String getPrenomResponsableCite() {
		return prenomResponsableCite;
	}

	/**
	 * 
	 * @param prenomResponsableCite
	 */
	public void setPrenomResponsableCite(String prenomResponsableCite) {
		this.prenomResponsableCite = prenomResponsableCite;
	}

	/**
	 * 
	 * @return numTeleCite
	 */
	public String getNumTeleCite() {
		return numTeleCite;
	}

	/**
	 * 
	 * @param numTeleCite
	 */
	public void setNumTeleCite(String numTeleCite) {
		this.numTeleCite = numTeleCite;
	}

	/**
	 * 
	 * @return adresseEmailCite
	 */
	public String getAdresseEmailCite() {
		return adresseEmailCite;
	}

	/**
	 * 
	 * @param adresseEmailCite
	 */
	public void setAdresseEmailCite(String adresseEmailCite) {
		this.adresseEmailCite = adresseEmailCite;
	}

	/**
	 * 
	 * @return statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * 
	 * @param statut
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	

	public UniversiteVO getUniversite() {
		return universite;
	}

	public void setUniversite(UniversiteVO universite) {
		this.universite = universite;
	}

	public VilleVO getVille() {
		return ville;
	}

	public void setVille(VilleVO ville) {
		this.ville = ville;
	}

	@Override
	public ITransformer<Cite, CiteVO> getTransformer() {
		return new CiteVOTransformer();
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
		CiteVO other = (CiteVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
