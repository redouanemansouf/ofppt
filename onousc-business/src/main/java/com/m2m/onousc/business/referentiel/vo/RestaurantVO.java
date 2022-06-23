package com.m2m.onousc.business.referentiel.vo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.vo.transformer.RestaurantVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Email;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class RestaurantVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1668777453738860655L;

	/** The id. */
	private Long id;

	/** Libellé de la caisse. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	@Size(max = 4)
	private String code;

	private CiteVO cite;

	@Size(max = 300)
	private String adresse;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String nomResponsable;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String prenomResponsable;

	@NotNull
	@AlphaNum
	@FixedSize(size = 10)
	private String numTele;

	@Email
	@Size(max = 100)
	private String adresseEmail;

	private boolean etatr;

	private Integer nbreplace;

	private List<CanalVenteVO> produitVOs;

//	@NotNull
	private VilleVO villeVO;

	/** Statut. */
	private EntityStatus statut;

	private SiteVO siteVO;

	public RestaurantVO() {
		super();
	}

	public RestaurantVO(String libelle, String code, CiteVO cite, String adresse, String nomResponsable,
			String prenomResponsable, String numTele, String adresseEmail, Integer nbreplace, VilleVO ville,
			EntityStatus statut) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.cite = cite;
		this.adresse = adresse;
		this.nomResponsable = nomResponsable;
		this.prenomResponsable = prenomResponsable;
		this.numTele = numTele;
		this.adresseEmail = adresseEmail;
		this.nbreplace = nbreplace;
		this.villeVO = ville;
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Restaurant, RestaurantVO> getTransformer() {
		return new RestaurantVOTransformer();
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

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}

	public String getNumTele() {
		return numTele;
	}

	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public Integer getNbreplace() {
		return nbreplace;
	}

	public void setNbreplace(Integer nbreplace) {
		this.nbreplace = nbreplace;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
		RestaurantVO other = (RestaurantVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public CiteVO getCite() {
		return cite;
	}

	public void setCite(CiteVO cite) {
		this.cite = cite;
	}

	public VilleVO getVilleVO() {
		return villeVO;
	}

	public void setVilleVO(VilleVO villeVO) {
		this.villeVO = villeVO;
	}

	public List<CanalVenteVO> getProduitVOs() {
		return produitVOs;
	}

	public void setProduitVOs(List<CanalVenteVO> produitVOs) {
		this.produitVOs = produitVOs;
	}

	public boolean isEtatr() {
		return etatr;
	}

	public void setEtatr(boolean etatr) {
		this.etatr = etatr;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
