package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "INSCRIPTION")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "INSCRIPTION_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Inscription extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -347473361758569362L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;
	@Column(name = "CIN")
	private String cin;
	@Column(name = "DATE_NAISSANCE")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Column(name = "NOM", length = 70)
	private String nom;
	@Column(name = "PRENOM", length = 70)
	private String prenom;
	@Column(name = "SEXE", length = 1)
	private String sexe;
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	@Column(name = "PATH")
	private String path;
	@ManyToOne
	@JoinColumn(name = "VILLE")
	private Ville ville;
	@ManyToOne
	@JoinColumn(name = "SITE")
	private Site site;
	@ManyToOne
	@JoinColumn(name = "RESTAURANT")
	private Restaurant restaurant;
	@ManyToOne
	@JoinColumn(name = "VILLE_RESTAURANT")
	private Ville villeRestaurant;
	@Column(name = "BOURSIER")
	private String boursier;
	@Column(name = "RESIDENT")
	private boolean resident;
	@Column(name = "EMAIL")
	private String email;
	@ManyToOne
	@JoinColumn(name = "ANNE_UNIVERSITAIRE")
	private AnneeUniversitaire anneUniversitaire;
	@Column(name = "CMASSAR")
	private String codeMassar;
	@Column(name = "Etablissement")
	private String Etablissement;

	@Column(name = "typePersonelle")
	private String typePersonelle;
	
	@Column(name = "CodeProfil")
	private String CodeProfil;
	
	@Column(name = "tele")
	private String tele;
	
	@Column(name = "typeCarte")
	private String typeCarte;
	
	public Inscription() {
		super();
	}

	public Inscription(Long id, String cin, Date dateNaissance, String nom, String prenom, String sexe,
			EntityStatus statut, String path, Ville ville, Site site, Restaurant restaurant, Ville villeRestaurant,
			String boursier, boolean resident, String email, AnneeUniversitaire anneUniversitaire, String codeMassar,
			String etablissement,String TypePersonelle,String codeProfil,String tel) {
		super();
		this.id = id;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.statut = statut;
		this.path = path;
		this.ville = ville;
		this.site = site;
		this.restaurant = restaurant;
		this.villeRestaurant = villeRestaurant;
		this.boursier = boursier;
		this.resident = resident;
		this.email = email;
		this.anneUniversitaire = anneUniversitaire;
		this.codeMassar = codeMassar;
		this.Etablissement = etablissement;
		this.typePersonelle = TypePersonelle;
		this.CodeProfil = codeProfil;
		this.tele = tel;
		
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Ville getVilleRestaurant() {
		return villeRestaurant;
	}

	public void setVilleRestaurant(Ville villeRestaurant) {
		this.villeRestaurant = villeRestaurant;
	}

	public AnneeUniversitaire getAnneUniversitaire() {
		return anneUniversitaire;
	}

	public void setAnneUniversitaire(AnneeUniversitaire anneUniversitaire) {
		this.anneUniversitaire = anneUniversitaire;
	}

	public String getBoursier() {
		return boursier;
	}

	public void setBoursier(String boursier) {
		this.boursier = boursier;
	}

	public boolean isResident() {
		return resident;
	}

	public void setResident(boolean resident) {
		this.resident = resident;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", cin=" + cin + ", dateNaissance=" + dateNaissance + ", nom=" + nom
				+ ", prenom=" + prenom + ", sexe=" + sexe + ", statut=" + statut + ", path=" + path + ", boursier="
				+ boursier + ", resident=" + resident + ", email=" + email + ",codeMassar=" + codeMassar + ",handicape="
				+ Etablissement + "]";
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

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public String getEtablissement() {
		return Etablissement;
	}

	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}

	public String getTypePersonelle() {
		return typePersonelle;
	}

	public void setTypePersonelle(String typePersonelle) {
		this.typePersonelle = typePersonelle;
	}

	public String getCodeProfil() {
		return CodeProfil;
	}

	public void setCodeProfil(String codeProfil) {
		CodeProfil = codeProfil;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	 
}
