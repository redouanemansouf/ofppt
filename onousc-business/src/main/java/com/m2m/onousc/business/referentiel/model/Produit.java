package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "PRODUIT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "PRODUIT_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Produit extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1350560031903474397L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "id")
	private Long id;

	@Column(name = "CODE", length = 9)
	private String code;

	@Column(name = "LIBELLE", length = 40)
	private String libelle;

	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@Column(name = "REFERENCE", length = 250)
	private String reference;

	@Column(name = "MONTANT", length = 14)
	private Double montant;

	@Column(name = "TVA")
	private Double tva;

	@Column(name = "CODEBAR")
	private String codeBar;

	@Column(name = "QUANTITE")
	private Double qte;

	@Column(name = "RATIO")
	private Double ratio;

	@Column(name = "PRIX_SUB")
	private Double prixSub;

	@Column(name = "SUBVENTION")
	private boolean sub;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FAMILLE_PRODUIT")
	private CanalVente familleProd;

	@ManyToOne
	@JoinColumn(name = "PR_SITE", referencedColumnName = "SITE_id")
	private Site site;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	public Produit() {

	}

	public Produit(Long id, String code, String libelle, String description, String reference, Double montant,
			Double tva, String codeBar, CanalVente familleProd, boolean sub, Double ratio, EntityStatus statut) {
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
		this.sub = sub;
		this.ratio = ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public boolean isSub() {
		return sub;
	}

	public void setSub(boolean sub) {
		this.sub = sub;
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

	public CanalVente getFamilleProd() {
		return familleProd;
	}

	public void setFamilleProd(CanalVente familleProd) {
		this.familleProd = familleProd;
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

	@Override
	public String getTraceInfo() {
		// TODO Auto-generated method stub
		return toString();
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", code=" + code + ", libelle=" + libelle + ", description=" + description
				+ ", reference=" + reference + ", montant=" + montant + ", tva=" + tva + ", codeBar=" + codeBar
				+ ", familleProd=" + familleProd + ", statut=" + statut + "]";
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
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double getQte() {
		return qte;
	}

	public void setQte(Double qte) {
		this.qte = qte;
	}

	public Double getPrixSub() {
		return prixSub;
	}

	public void setPrixSub(Double prixSub) {
		this.prixSub = prixSub;
	}

	public Double getRatio() {
		return ratio;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
