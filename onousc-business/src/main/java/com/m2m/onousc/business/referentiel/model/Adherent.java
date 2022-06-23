package com.m2m.onousc.business.referentiel.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "ADHERENT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "ADHERENT_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Adherent extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1350560031903474397L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "id")
	private Long id;

	@Column(name = "MATR", length = 16)
	private String matr;

	@Column(name = "NOM_PERS", length = 40)
	private String nom;

	@Column(name = "PRENOM_PERS", length = 50)
	private String prenom;

	@Column(name = "SEXE", length = 1)
	private String sexe;

	@Column(name = "DATE_NAISSANCE")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VILLE")
	private Ville lieuNaissance;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSONEL")
	private Personnel personnel;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "MOTIF_OPPO", length = 100)
	private String motif;	
	
	@Column(name = "CNI", length = 14)
	private String cni;

	@Column(name = "DATE_DELIV")
	@Temporal(TemporalType.DATE)
	private Date dateDeliv;

	@Column(name = "TELEPHONE", length = 80)
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "CATEGORIE")
	private CategoriePorteur categorie;

	@ManyToOne
	@JoinColumn(name = "PROFIL")
	private Critere profil;
	
	@Column(name = "Age", length = 80)
	private Integer  age;


	@Column(name = "DATE_EXPIRATION")
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	
	@Column(name = "NUMCARTE")
	private String numCarte;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "REF_ADHERENT_TOURNIQUET", joinColumns = { @JoinColumn(name = "ADR_ID", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "TRQ_ID", referencedColumnName = "TRQ_ID") })
	private List<Tourniquet> tourniquet;

	public List<Tourniquet> getTourniquet() {
		return tourniquet;
	}


	public void setTourniquet(List<Tourniquet> tourniquet) {
		this.tourniquet = tourniquet;
	}


	@Transient
	private String cheminExePhoto;

	@Transient
	private String cheminEnregPhoto;

	@Transient
	private String cheminRecupPhoto;

	@Transient
	private String cheminRecupImage;

	@Transient
	private String cheminProtoRecto;

	@Transient
	private String cheminProtoVerso;

	@Transient
	private String cheminCarteRecto;

	@Transient
	private String cheminCarteVerso;

	@Transient
	private String cheminExeImpression;
	
	@Column(name = "SCOLARISE")
	private String scolarise;


	public Adherent() {

	}


	public Adherent(Long id, String matr, String nom, String prenom,
			String sexe, Date dateNaissance, Ville lieuNaissance,
			Personnel personnel, String type, String cni, Date dateDeliv,
			String telephone, CategoriePorteur categorie, Critere profil,
			Integer age, Date dateExpiration, EntityStatus statut,
			String cheminExePhoto, String cheminEnregPhoto,
			String cheminRecupPhoto, String cheminRecupImage,
			String cheminProtoRecto, String cheminProtoVerso,
			String cheminCarteRecto, String cheminCarteVerso,
			String cheminExeImpression, String scolarise) {
		super();
		this.id = id;
		this.matr = matr;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.personnel = personnel;
		this.type = type;
		this.cni = cni;
		this.dateDeliv = dateDeliv;
		this.telephone = telephone;
		this.categorie = categorie;
		this.profil = profil;
		this.age = age;
		this.dateExpiration = dateExpiration;
		this.statut = statut;
		this.cheminExePhoto = cheminExePhoto;
		this.cheminEnregPhoto = cheminEnregPhoto;
		this.cheminRecupPhoto = cheminRecupPhoto;
		this.cheminRecupImage = cheminRecupImage;
		this.cheminProtoRecto = cheminProtoRecto;
		this.cheminProtoVerso = cheminProtoVerso;
		this.cheminCarteRecto = cheminCarteRecto;
		this.cheminCarteVerso = cheminCarteVerso;
		this.cheminExeImpression = cheminExeImpression;
		this.scolarise = scolarise;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Ville getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(Ville lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public Date getDateDeliv() {
		return dateDeliv;
	}

	public void setDateDeliv(Date dateDeliv) {
		this.dateDeliv = dateDeliv;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CategoriePorteur getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePorteur categorie) {
		this.categorie = categorie;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getCheminExePhoto() {
		return cheminExePhoto;
	}

	public void setCheminExePhoto(String cheminExePhoto) {
		this.cheminExePhoto = cheminExePhoto;
	}

	public String getCheminEnregPhoto() {
		return cheminEnregPhoto;
	}

	public void setCheminEnregPhoto(String cheminEnregPhoto) {
		this.cheminEnregPhoto = cheminEnregPhoto;
	}

	public String getCheminRecupPhoto() {
		return cheminRecupPhoto;
	}

	public void setCheminRecupPhoto(String cheminRecupPhoto) {
		this.cheminRecupPhoto = cheminRecupPhoto;
	}

	public String getCheminRecupImage() {
		return cheminRecupImage;
	}

	public void setCheminRecupImage(String cheminRecupImage) {
		this.cheminRecupImage = cheminRecupImage;
	}

	public String getCheminProtoRecto() {
		return cheminProtoRecto;
	}

	public void setCheminProtoRecto(String cheminProtoRecto) {
		this.cheminProtoRecto = cheminProtoRecto;
	}

	public String getCheminProtoVerso() {
		return cheminProtoVerso;
	}

	public void setCheminProtoVerso(String cheminProtoVerso) {
		this.cheminProtoVerso = cheminProtoVerso;
	}

	public String getCheminCarteRecto() {
		return cheminCarteRecto;
	}

	public void setCheminCarteRecto(String cheminCarteRecto) {
		this.cheminCarteRecto = cheminCarteRecto;
	}

	public String getCheminCarteVerso() {
		return cheminCarteVerso;
	}

	public void setCheminCarteVerso(String cheminCarteVerso) {
		this.cheminCarteVerso = cheminCarteVerso;
	}

	public String getCheminExeImpression() {
		return cheminExeImpression;
	}

	public void setCheminExeImpression(String cheminExeImpression) {
		this.cheminExeImpression = cheminExeImpression;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", matr=" + matr + ", nom=" + nom
				+ ", prenom=" + prenom + ", sexe=" + sexe + ", dateNaissance="
				+ dateNaissance + ", lieuNaissance=" + lieuNaissance
				+ ", personnel=" + personnel + ", type=" + type + ", cni="
				+ cni + ", dateDeliv=" + dateDeliv + ", telephone=" + telephone
				+ ", categorie=" + categorie + ", dateExpiration="
				+ dateExpiration + ", statut=" + statut + ", cheminExePhoto="
				+ cheminExePhoto + ", cheminEnregPhoto=" + cheminEnregPhoto
				+ ", cheminRecupPhoto=" + cheminRecupPhoto
				+ ", cheminRecupImage=" + cheminRecupImage
				+ ", cheminProtoRecto=" + cheminProtoRecto
				+ ", cheminProtoVerso=" + cheminProtoVerso
				+ ", cheminCarteRecto=" + cheminCarteRecto
				+ ", cheminCarteVerso=" + cheminCarteVerso
				+ ", cheminExeImpression=" + cheminExeImpression + "]";
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
		Adherent other = (Adherent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
	}

	public Critere getProfil() {
		return profil;
	}

	public void setProfil(Critere profil) {
		this.profil = profil;
	}



	public String getScolarise() {
		return scolarise;
	}



	public void setScolarise(String scolarise) {
		this.scolarise = scolarise;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getNumCarte() {
		return numCarte;
	}


	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	

}
