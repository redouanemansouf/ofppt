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
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_UNIVERSITE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "UNIVERSITE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Universite extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3229406610394096125L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "UNIV_ID")
	private Long id;

	/** Identifiant de l'universite. */
	@Column(name = "UNIV_CODE", length = 30)
	private String code;

	/** Libellé d'universite. */
	@Column(name = "UNIV_LIBELLE", length = 30)
	private String libelle;

	/** Adresse de l'universite. */
	@Column(name = "UNIV_ADRESSE", length = 300)
	private String adresseUniv;

	/** Nom responsable de l'universite. */
	@Column(name = "UNIV_NOMRES", length = 100)
	private String nomResponsableUniv;

	/** Prenom responsable de l'universite. */
	@Column(name = "UNIV_PRENRES", length = 100)
	private String prenomResponsableUniv;

	/** Numéro tele de l'universite.. */
	@Column(name = "UNIV_NUMTELE", length = 10)
	private String numTeleUniv;

	/** Adresse email de l'universite. */
	@Column(name = "UNIV_ADREMAIL", length = 100)
	private String adresseEmailUniv;

	/** Ville. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VILL_CODE")
	private Ville ville;

	/** Statut. */
	@Column(name = "UNIV_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	/**
	 * Get the code
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set code
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get the libelle
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * set the libelle
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * get the adresseUniv
	 * 
	 * @return adresseUniv
	 */
	public String getAdresseUniv() {
		return adresseUniv;
	}

	/**
	 * set the adresseUniv
	 * 
	 * @param adresseUniv
	 */
	public void setAdresseUniv(String adresseUniv) {
		this.adresseUniv = adresseUniv;
	}

	/**
	 * get nomResponsableUniv
	 * 
	 * @returnnomResponsableUniv
	 */
	public String getNomResponsableUniv() {
		return nomResponsableUniv;
	}

	/**
	 * set the nomResponsableUniv
	 * 
	 * @param nomResponsableUniv
	 */
	public void setNomResponsableUniv(String nomResponsableUniv) {
		this.nomResponsableUniv = nomResponsableUniv;
	}

	/**
	 * get the prenomResponsable
	 * 
	 * @return prenomResponsable
	 */
	public String getPrenomResponsableUniv() {
		return prenomResponsableUniv;
	}

	/**
	 * set prenomResponsable
	 * 
	 * @param prenomResponsableUniv
	 */
	public void setPrenomResponsableUniv(String prenomResponsableUniv) {
		this.prenomResponsableUniv = prenomResponsableUniv;
	}

	/**
	 * get numTeleUniv
	 * 
	 * @return numTeleUniv
	 */
	public String getNumTeleUniv() {
		return numTeleUniv;
	}

	/**
	 * set the numTeleUniv
	 * 
	 * @param numTeleUniv
	 */
	public void setNumTeleUniv(String numTeleUniv) {
		this.numTeleUniv = numTeleUniv;
	}

	/**
	 * get the adresseEmailUniv
	 * 
	 * @return
	 */
	public String getAdresseEmailUniv() {
		return adresseEmailUniv;
	}

	/**
	 * set adresseEmailUniv
	 * 
	 * @param adresseEmailUniv
	 */
	public void setAdresseEmailUniv(String adresseEmailUniv) {
		this.adresseEmailUniv = adresseEmailUniv;
	}

	/**
	 * get the statut
	 * 
	 * @return statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "UNIVERSITE [id=" + ", code=" + code + ", libelle=" + libelle
				+ " numTeleUniv = " + numTeleUniv;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

}
