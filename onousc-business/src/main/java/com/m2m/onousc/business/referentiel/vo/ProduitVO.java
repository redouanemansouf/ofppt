package com.m2m.onousc.business.referentiel.vo;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.transformer.ProduitVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ProduitVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834584399369396642L;

	/** Id technique. */
	private Long id;

	private String code;

	private String libelle;

	private String description;

	private String reference;

	private Double montant;

	private Double tva;

	private String codeBar;

	private CanalVenteVO familleProd;

	private EntityStatus statut;
	
	private Integer quantite=1;
	
	private Double totalMont;
	
	private Double  qte;
	
	private Double ratio;
	
	private Double prixSub;
	
	private boolean sub;
	
	private String subaf;
	
	private SiteVO siteVO;
	
	public String getSubaf() {
		return subaf;
	}

	public void setSubaf(String subaf) {
		this.subaf = subaf;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	public ProduitVO() {

	}

	public ProduitVO(Long id, String code, String libelle, String description,
			String reference, Double montant, Double tva, String codeBar,
			CanalVenteVO familleProd, Double ratio , Double prixSub, boolean sub , EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.reference = reference;
		this.montant = montant;
		this.tva = tva;
		this.codeBar = codeBar;
		this.familleProd = familleProd;
		this.statut = statut;
		this.ratio = ratio;
		this.sub = sub;
		this.prixSub = prixSub;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public CanalVenteVO getFamilleProd() {
		return familleProd;
	}

	public void setFamilleProd(CanalVenteVO familleProd) {
		this.familleProd = familleProd;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new ProduitVOTransformer();
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
		ProduitVO other = (ProduitVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getTotalMont() {
		if(quantite!=0)
			totalMont=quantite*montant;
		else 
			totalMont=montant;
		
		return totalMont;
	}

	public void setTotalMont(Double totalMont) {
		this.totalMont = totalMont;
	}

	public Double getQte() {
		return qte;
	}

	public void setQte(Double qte) {
		this.qte = qte;
	}



	public boolean isSub() {
		return sub;
	}

	public void setSub(boolean sub) {
		this.sub = sub;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Double getPrixSub() {
		return prixSub;
	}

	public void setPrixSub(Double prixSub) {
		this.prixSub = prixSub;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
