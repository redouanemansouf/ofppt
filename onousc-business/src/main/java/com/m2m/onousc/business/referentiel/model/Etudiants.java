/*
 * Nationalite.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "ETUDIANTS")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "ETUDIANT_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Etudiants extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4902496184235339262L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "id")
	private Long id;

	@Column(name = "ann_universitaire", length = 4)
	private Long ann_universitaire;

	@Column(name = "Ndemande", length = 8)
	private String Ndemande;

	/** Nom de l'Etudiant. */
	@Column(name = "Nom", length = 70)
	private String Nom;

	/** prenom de l'Etudiant. */
	@Column(name = "Prenom", length = 70)
	private String Prenom;

	@Basic(optional = false)
	@Column(name = "Date_naissance")
	@Temporal(TemporalType.DATE)
	private Date Date_naissance;

	@Column(name = "NCIN", length = 10)
	private String NCIN;

	@Column(name = "Boursier")
	private String Boursier;

	@Column(name = "Resident")
	private Boolean Resident;

	@Column(name = "Etablissement", length = 70)
	private String Etablissement;

	@Column(name = "Sexe", length = 1)
	private String Sexe;

	@Column(name = "Ville")
	private String Ville;

	@Column(name = "Restaurant", length = 100)
	private String Restaurant2;

	@Column(name = "Email", length = 100)
	private String Email;

	@Column(name = "Image", length = 100)
	private String image;

	@Column(name = "Reve_Parents", length = 100)
	private String revenu;

	@Column(name = "tele", length = 100)
	private String tele;
	
	@Column(name = "codeProfil", length = 100)
	private String codeProfil;
	
	@Column(name = "typeCarte", length = 100)
	private String typeCarte;
	
	@Column(name = "TYPE_PERSONELLE", length = 100)
	private String typePersonelle;

//	/** Universite de la cité. */
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "CITE_ID")
//	private Cite Cite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SITE_ID")
	private Site site;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RS_ID")
	private Restaurant restaurant;

	@Column(name = "note", length = 10)
	private Float note;

	@Column(name = "CMASSAR", length = 10)
	private String codeMassar;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "NT_ID")
	private List<NoteCritere> noteCritere;

	/** annee universitaire. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AN_ID")
	private AnneeUniversitaire anneeUniversitaire;

	@Column(name = "Statut")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	public Etudiants() {
		super();
		noteCritere = new ArrayList<NoteCritere>();
	}

	public Etudiants(Long id, Long ann_universitaire, String ndemande, String nom, String prenom, Date date_naissance,
			String nCIN, String boursier, String typecarte, String etablissement, String sexe, String ville,
			String restaurant2, String email, String image, String revenu, String tele, Site site,
			Restaurant restaurant, Float note, String codeMassar, List<NoteCritere> noteCritere,
			AnneeUniversitaire anneeUniversitaire, EntityStatus statut, String TypePersonelle) {
		super();
		this.id = id;
		this.ann_universitaire = ann_universitaire;
		Ndemande = ndemande;
		Nom = nom;
		Prenom = prenom;
		Date_naissance = date_naissance;
		NCIN = nCIN;
		Boursier = boursier;
		typeCarte = typecarte;
		Etablissement = etablissement;
		Sexe = sexe;
		Ville = ville;
		Restaurant2 = restaurant2;
		Email = email;
		this.image = image;
		this.revenu = revenu;
		this.tele = tele;
		this.site = site;
		this.restaurant = restaurant;
		this.note = note;
		this.codeMassar = codeMassar;
		this.noteCritere = noteCritere;
		this.anneeUniversitaire = anneeUniversitaire;
		this.statut = statut;
		typePersonelle=TypePersonelle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalServices.audit.impl.ITracable#getTraceInfo()
	 */
	@Override
	public String getTraceInfo() {
		return "Etudiant_trace";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalServices.audit.impl.ITracable#getNameEntity()
	 */
	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public String getNdemande() {
		return Ndemande;
	}

	public void setNdemande(String ndemande) {
		Ndemande = ndemande;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getDate_naissance() {
		return Date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		Date_naissance = date_naissance;
	}

	public String getNCIN() {
		return NCIN;
	}

	public void setNCIN(String nCIN) {
		NCIN = nCIN;
	}

	public String getBoursier() {
		return Boursier;
	}

	public void setBoursier(String boursier) {
		Boursier = boursier;
	}

	public Boolean getResident() {
		return Resident;
	}

	public void setResident(Boolean resident) {
		Resident = resident;
	}

	public String getEtablissement() {
		return Etablissement;
	}

	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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

	public String getRestaurant2() {
		return Restaurant2;
	}

	@Override
	public String toString() {
		return "Etudiants [id=" + id + ", ann_universitaire=" + ann_universitaire + ", Ndemande=" + Ndemande + ", Nom="
				+ Nom + ", Prenom=" + Prenom + ", Date_naissance=" + Date_naissance + ", NCIN=" + NCIN + ", Boursier="
				+ Boursier + ", Resident=" + Resident + ", Etablissement=" + Etablissement + ", Sexe=" + Sexe
				+ ", Ville=" + Ville + ", Restaurant2=" + Restaurant2 + ", Email=" + Email + ", image=" + image
				+ ", revenu=" + revenu + ", tel=" + tele + ", site=" + site + ", restaurant="
				+ restaurant + ", note=" + note + ", codeMassar=" + codeMassar + ", noteCritere=" + noteCritere
				+ ", anneeUniversitaire=" + anneeUniversitaire + ", statut=" + statut + "]";
	}

	public void setRestaurant2(String restaurant2) {
		Restaurant2 = restaurant2;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getAnn_universitaire() {
		return ann_universitaire;
	}

	public void setAnn_universitaire(Long ann_universitaire) {
		this.ann_universitaire = ann_universitaire;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getRevenu() {
		return revenu;
	}

	public void setRevenu(String revenu) {
		this.revenu = revenu;
	}

 

	public List<NoteCritere> getNoteCritere() {
		return noteCritere;
	}

	public void setNoteCritere(List<NoteCritere> noteCritere) {
		this.noteCritere = noteCritere;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public AnneeUniversitaire getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getTypePersonelle() {
		return typePersonelle;
	}

	public void setTypePersonelle(String typePersonelle) {
		this.typePersonelle = typePersonelle;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getCodeProfil() {
		return codeProfil;
	}

	public void setCodeProfil(String codeProfil) {
		this.codeProfil = codeProfil;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

}
