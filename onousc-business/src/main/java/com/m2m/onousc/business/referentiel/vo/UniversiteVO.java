package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.vo.transformer.UniversiteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Email;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.validation.Number;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * 
 * @author abousnane
 * 
 */
public class UniversiteVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3398434978686956758L;

	/** Id technique. */
	private Long id;

	/** Identifiant de l'universite. */
	@NotNull
	@FixedSize(size = 4)
	private String code;

	/** Libellé d'universite. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	/** Adresse de l'universite. */

	@Size(max = 300)
	private String adresseUniv;

	/** Nom responsable de l'universite. */
	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String nomResponsableUniv;

	/** Prenom responsable de l'universite. */
	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String prenomResponsableUniv;

	/** Numéro tele de l'universite.. */
	@NotNull
	@Number
	@FixedSize(size = 10)
	private String numTeleUniv;

	/** Adresse email de l'universite. */
	@Email
	@Size(max = 100)
	private String adresseEmailUniv;

	@NotNull
	private VilleVO villeVO;

	/** Statut. */
	private EntityStatus statut;

	/**
	 * Instantiates a new universite vo.
	 */
	public UniversiteVO() {
		super();
	}

	/**
	 * Instantiates a new universite vo.
	 * 
	 * 
	 */

	public UniversiteVO(String libelle, String adresseUniv,
			String nomResponsableUniv, String prenomResponsableUniv,
			String numTeleUniv, String adresseEmailUniv, VilleVO villeVO) {
		super();
		this.libelle = libelle;
		this.adresseUniv = adresseUniv;
		this.nomResponsableUniv = nomResponsableUniv;
		this.prenomResponsableUniv = prenomResponsableUniv;
		this.numTeleUniv = numTeleUniv;
		this.adresseEmailUniv = adresseEmailUniv;
		this.villeVO = villeVO;
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
	 * @return adresseUniv
	 */
	public String getAdresseUniv() {
		return adresseUniv;
	}

	/**
	 * 
	 * @param adresseUniv
	 */
	public void setAdresseUniv(String adresseUniv) {
		this.adresseUniv = adresseUniv;
	}

	/**
	 * 
	 * @return nomResponsableUniv
	 */
	public String getNomResponsableUniv() {
		return nomResponsableUniv;
	}

	/**
	 * 
	 * @param nomResponsableUniv
	 */
	public void setNomResponsableUniv(String nomResponsableUniv) {
		this.nomResponsableUniv = nomResponsableUniv;
	}

	/**
	 * 
	 * @return prenomResponsableUniv
	 */
	public String getPrenomResponsableUniv() {
		return prenomResponsableUniv;
	}

	/**
	 * 
	 * @param prenomResponsableUniv
	 */
	public void setPrenomResponsableUniv(String prenomResponsableUniv) {
		this.prenomResponsableUniv = prenomResponsableUniv;
	}

	/**
	 * 
	 * @return numTeleUniv
	 */
	public String getNumTeleUniv() {
		return numTeleUniv;
	}

	/**
	 * 
	 * @param numTeleUniv
	 */
	public void setNumTeleUniv(String numTeleUniv) {
		this.numTeleUniv = numTeleUniv;
	}

	/**
	 * 
	 * @return adresseEmailUniv
	 */
	public String getAdresseEmailUniv() {
		return adresseEmailUniv;
	}

	/**
	 * 
	 * @param adresseEmailUniv
	 */
	public void setAdresseEmailUniv(String adresseEmailUniv) {
		this.adresseEmailUniv = adresseEmailUniv;
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

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	public VilleVO getVilleVO() {
		return villeVO;
	}

	public void setVilleVO(VilleVO villeVO) {
		this.villeVO = villeVO;
	}

	@Override
	public ITransformer<Universite, UniversiteVO> getTransformer() {
		return new UniversiteVOTransformer();
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
		UniversiteVO other = (UniversiteVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;

	}

}
