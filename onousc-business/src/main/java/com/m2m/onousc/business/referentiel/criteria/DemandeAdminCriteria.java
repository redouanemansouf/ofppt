package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.technicalservices.web.SearchConfig;

public class DemandeAdminCriteria extends BaseCriteria implements Serializable {

	private static final long serialVersionUID = -3162716953660036812L;

	private Borne borne;

	private Etudiants numPorteur;

	private String matricule;

	private String nom;

	private String prenom;

	private String typePersonnelle;

	private String typeDemande;

	@SuppressWarnings("rawtypes")
	public void activeCriteria() {
		boolean filter = false;
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			Object v = null;
			try {
				v = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TO-DO
			}
			if (t == EntityStatus.class && v != null) {
				filter = true;
				break;
			} else if (!t.isPrimitive() && !"sortField".equals(field) && !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

	}

	public DemandeAdminCriteria(Borne borne, Etudiants numPorteur, String matricule, String nom, String prenom,
			String typePersonnelle, String typeDemande, SearchConfig config) {
		super();
		this.borne = borne;
		this.numPorteur = numPorteur;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.typePersonnelle = typePersonnelle;
		this.typeDemande = typeDemande;
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public DemandeAdminCriteria() {
		super();
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

}
