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

@Entity
@Table(name = "TABLE_CAISSIERS")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "table_caissiers_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Caissier extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3112267535625956951L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "Id_caissier")
	private Long id;

	@Column(name = "NUMCARTE", length = 50)
	private String numCarte;

	/** Identifiant de la cité. */
	@Column(name = "CAISSIER_CODE")
	private String code;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CA_ID")
	private Caisse caisse;

	/** Nom responsable de la cité. */
	@Column(name = "nom_caissier", length = 100)
	private String nom;

	/** Prenom responsable de la cité. */
	@Column(name = "prenom_caissier", length = 100)
	private String prenom;

	/** Numéro tele de la cité. */
	@Column(name = "tel_caissier", length = 10)
	private String numTele;

	/** Adresse email de la cité. */
	@Column(name = "caissier_ADREMAIL", length = 100)
	private String adresseEmail;

	@Column(name = "DROIT")
	private boolean droit;

	/** Statut. */
	@Column(name = "CAISSIER_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "TC_SITE", referencedColumnName = "SITE_id")
	private Site site;

	public boolean getDroit() {
		return droit;
	}

	public void setDroit(boolean droit) {
		this.droit = droit;
	}

	@Override
	public String toString() {
		return "Caissier [id=" + id + ", code=" + code + " numTelecite = " + numTele;
	}

	@Override
	public String getTraceInfo() {
		return this.toString();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomResponsable) {
		this.nom = nomResponsable;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenomResponsable) {
		this.prenom = prenomResponsable;
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

	public EntityStatus getStatut() {
		return statut;
	}

	public String getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}