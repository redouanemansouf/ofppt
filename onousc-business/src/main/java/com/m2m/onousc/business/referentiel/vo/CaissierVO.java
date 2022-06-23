package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.vo.transformer.CaissierVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Email;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class CaissierVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1668777453738860655L;

	/** The id. */
	private Long id;

	@NotNull
	@Size(max = 4)
	private String code;

	@NotNull
	private CaisseVO caisse;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String nom;

	@NotNull
	@AlphaNum
	@Size(max = 100)
	private String prenom;

	@NotNull
	@AlphaNum
	@FixedSize(size = 10)
	private String numTele;

	@Email
	@Size(max = 100)
	private String adresseEmail;

	private String numCarte;

	private boolean droit;

	private SiteVO siteVO;

	/** Statut. */
	private EntityStatus statut;

	public CaissierVO() {
		super();
	}

	public CaissierVO(String code, CaisseVO caissierVO, String nom, String prenom, String numTele,
			String adresseEmail) {
		super();
		this.code = code;
		this.caisse = caissierVO;
		this.nom = nom;
		this.prenom = prenom;
		this.numTele = numTele;
		this.adresseEmail = adresseEmail;
	}

	public boolean isDroit() {
		return droit;
	}

	public void setDroit(boolean droit) {
		this.droit = droit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public CaisseVO getCaisse() {
		return caisse;
	}

	public void setCaisse(CaisseVO caisse) {
		this.caisse = caisse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Caissier, CaissierVO> getTransformer() {
		return new CaissierVOTransformer();
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
		CaissierVO other = (CaissierVO) obj;
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

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
