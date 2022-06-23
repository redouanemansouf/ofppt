package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.vo.transformer.DemandeAdminVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class DemandeAdminVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -444481103042596588L;
	/** The id. */
	private Long id;

	private Borne borne;

	private Etudiants numPorteur;

	@NotNull
	@AlphaNum
	@Size(max = 10)
	private String matricule;

	@AlphaNum
	@Size(max = 60)
	private String nom;

	@AlphaNum
	@Size(max = 60)
	private String prenom;

	@AlphaNum
	@Size(max = 50)
	private String typePersonnelle;

	@AlphaNum
	@Size(max = 50)
	private String typeDemande;

	private Restaurant typeAttestation;

	private Restaurant typeReclamation;

	@AlphaNum
	@Size(max = 500)
	private String reclamation;

	private Date dateReclamation;

	private Date dateraitement;

	private EntityStatus statut;

	public DemandeAdminVO() {
		super();
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<DemandeAdmin, DemandeAdminVO> getTransformer() {
		return new DemandeAdminVOTransformer();
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
		DemandeAdminVO other = (DemandeAdminVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Borne getBorne() {
		return borne;
	}

	public void setBorne(Borne borne) {
		this.borne = borne;
	}

	public Etudiants getNumPorteur() {
		return numPorteur;
	}

	public void setNumPorteur(Etudiants numPorteur) {
		this.numPorteur = numPorteur;
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
