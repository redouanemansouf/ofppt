package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

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
@Table(name = "DEMANDE_ADMIN")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "DEMANDE_ADMIN_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class DemandeAdmin extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_BORNE")
	private Borne borne;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NUM_PORTEUR")
	private Etudiants numPorteur;

	@Column(name = "MATRICULE", length = 10)
	private String matricule;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "TYPE_PERSONELLE")
	private String typePersonnelle;

	@Column(name = "TYPE_DEMANDE")
	private String typeDemande;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TYPE_ATTESTATION")
	private Restaurant typeAttestation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TYPE_RECLAMATION")
	private Restaurant typeReclamation;

	@Column(name = "RECLAMATION")
	private String reclamation;

	@Column(name = "DATE_RECLAMATION")
	private Date dateReclamation;

	@Column(name = "DATE_TRAITEMENT")
	private Date dateraitement;

	@Column(name = "STATUT_DEMANDE")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	public Borne getBorne() {
		return borne;
	}

	public void setBorne(Borne borne) {
		this.borne = borne;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getTypePersonnelle() {
		return typePersonnelle;
	}

	public void setTypePersonnelle(String typePersonnelle) {
		this.typePersonnelle = typePersonnelle;
	}

	public String getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}

	public Restaurant getTypeAttestation() {
		return typeAttestation;
	}

	public void setTypeAttestation(Restaurant typeAttestation) {
		this.typeAttestation = typeAttestation;
	}

	public Restaurant getTypeReclamation() {
		return typeReclamation;
	}

	public void setTypeReclamation(Restaurant typeReclamation) {
		this.typeReclamation = typeReclamation;
	}

	public String getReclamation() {
		return reclamation;
	}

	public void setReclamation(String reclamation) {
		this.reclamation = reclamation;
	}

	public Date getDateReclamation() {
		return dateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}

	public Date getDateraitement() {
		return dateraitement;
	}

	public void setDateraitement(Date dateraitement) {
		this.dateraitement = dateraitement;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

}
