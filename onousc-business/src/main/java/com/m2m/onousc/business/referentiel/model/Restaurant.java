package com.m2m.onousc.business.referentiel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_RESTAURANT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "RESTAURANT_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Restaurant extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4655589766933870934L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "RS_ID")
	private Long id;

	/** Libellé du restaurant. */
	@Column(name = "RS_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "RS_CODE")
	private String code;

	/** Cite. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITE_ID")
	private Cite cite;

	/** Adresse de la cité. */
	@Column(name = "RS_ADRESSE", length = 300)
	private String adresse;

	/** Nom responsable. */
	@Column(name = "RS_NOMRES", length = 100)
	private String nomResponsable;

	/** Prenom responsable. */
	@Column(name = "RS_PRENRES", length = 100)
	private String prenomResponsable;

	/** Numéro tele. */
	@Column(name = "RS_NUMTELE", length = 10)
	private String numTele;

	/** Adresse email. */
	@Column(name = "RS_ADREMAIL", length = 100)
	private String adresseEmail;

	/** Nombre place. */
	@Column(name = "RS_NBRE_PLACE", length = 100)
	private Integer nbreplace;

	/** Ville. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VILL_CODE")
	private Ville ville;

	@ManyToMany(mappedBy = "restaurant")
	private List<CanalVente> produits;

	@Column(name = "ETATR")
	private boolean etatr;

	/** Statut du caisse. */
	@Column(name = "CA_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "RS_SITE", referencedColumnName = "SITE_id")
	private Site site;

	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "RESTAURANT [id=" + ", code=" + code + ", libelle=" + libelle;
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

	public Cite getCite() {
		return cite;
	}

	public void setCite(Cite cite) {
		this.cite = cite;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean isEtatr() {
		return etatr;
	}

	public void setEtatr(boolean etatr) {
		this.etatr = etatr;
	}

	public List<CanalVente> getProduits() {
		return produits;
	}

	public void setProduits(List<CanalVente> produits) {
		this.produits = produits;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	

}
