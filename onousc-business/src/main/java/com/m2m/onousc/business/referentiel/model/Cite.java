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
@Table(name = "REF_CITE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CITE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Cite extends GenericEntity implements ITracable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4832363861734341966L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "CITE_ID")
	private Long id;
	
	/** Identifiant de la cité. */
	@Column(name = "CITE_CODE")
	private String code;
	
	/** Libellé de la cité. */
	@Column(name = "CITE_LIBELLE", length = 30)
	private String libelle;
	
	/** Universite de la cité. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UNIV_ID")
	private Universite universite;
	
	/** Adresse de la cité. */
	@Column(name = "CITE_ADRESSE", length = 300)
	private String adresseCite;

	/** Nom responsable de la cité. */
	@Column(name = "CITE_NOMRES", length = 100)
	private String nomResponsableCite;
	
	/** Prenom responsable de la cité. */
	@Column(name = "CITE_PRENRES", length = 100)
	private String prenomResponsableCite;
	
	/** Numéro tele de la cité. */
	@Column(name = "CITE_NUMTELE", length = 10)
	private String numTeleCite;
	
	/** Adresse email de la cité. */
	@Column(name = "CITE_ADREMAIL", length = 100)
	private String adresseEmailCite;
	
	/** Ville. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VILL_CODE")
	private Ville ville;
	
	/** Statut. */
	@Column(name = "CITE_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	
	
	/**
	 * Gets the code.
	 * 
	 * @return the code 
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle 
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * Sets the libelle.
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * Gets the nomResponsableCite.
	 * 
	 * @return the nomResponsableCite 
	 */
	public String getNomResponsableCite() {
		return nomResponsableCite;
	}
	
	/**
	 * Sets the nomResponsableCite.
	 * 
	 * @param nomResponsableCite the nomResponsableCite to set
	 */
	public void setNomResponsableCite(String nomResponsableCite) {
		this.nomResponsableCite = nomResponsableCite;
	}
	
	/**
	 * Gets the prenomResponsableCite.
	 * 
	 * @return the prenomResponsableCite 
	 */
	public String getPrenomResponsableCite() {
		return prenomResponsableCite;
	}
	
	/**
	 * Sets the prenomResponsableCite.
	 * 
	 * @param prenomResponsableCite the prenomResponsableCite to set
	 */
	public void setPrenomResponsableCite(String prenomResponsableCite) {
		this.prenomResponsableCite = prenomResponsableCite;
	}
	
	/**
	 * Gets the numTeleCite.
	 * 
	 * @return the numTeleCite 
	 */
	public String getNumTeleCite() {
		return numTeleCite;
	}

	/**
	 * Sets the numTeleCite.
	 * 
	 * @param numTeleCite the numTeleCite to set
	 */
	public void setNumTeleCite(String numteleCite) {
		this.numTeleCite = numteleCite;
	}
	
	
	/**
	 * Gest the universite
	 * 
	 * @return universite
	 */
	public Universite getUniversite() {
		return universite;
	}

	/**
	 * Set the universite to set
	 * 
	 * @param universite the 
	 */
	public void setUniversite(Universite universite) {
		this.universite = universite;
	}
	
	/**
	 * Gest the adresseCite
	 * 
	 * @return adresseCite
	 */
	public String getAdresseCite() {
		return adresseCite;
	}
	
	/**
	 * set the adresseCite
	 * 
	 * @param adresseCite the adresseCite to set
	 */
	public void setAdresseCite(String adresseCite) {
		this.adresseCite = adresseCite;
	}
	
	/**
	 * Gets the statut.
	 *
	 * @return the statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 *
	 * @param statut the statut to set
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}
	
	/**
	 * get adresseEmailCite
	 * 
	 * @return adresseEmailCite
	 */
	public String getAdresseEmailCite() {
		return adresseEmailCite;
	}
	
	/**
	 * set adresseEmailCite
	 * 
	 * @param adresseEmailCite
	 */
	public void setAdresseEmailCite(String adresseEmailCite) {
		this.adresseEmailCite = adresseEmailCite;
	}

	@Override
	public String toString(){
		return "CITE [id="+id+", code=" +code + ", libelle="
				+libelle +" numTelecite = " +numTeleCite;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
}
