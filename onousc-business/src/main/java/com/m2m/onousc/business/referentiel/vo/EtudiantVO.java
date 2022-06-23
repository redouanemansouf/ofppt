/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.vo.transformer.EtudiantVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.ISearchResultVO;
import com.m2m.technicalservices.validation.Email;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class EtudiantVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6420083613576922097L;

	/** The id. */
	private Long id;

	private Long ann_universitaire;

	private String Ndemande;

	@NotNull
	private String Nom;

	@NotNull
	private String Prenom;

	@NotNull
	private Date Date_naissance;

	@NotNull
	private String NCIN;

	//@NotNull
	private String Boursier;

	@NotNull
	private Boolean Resident;

	//@NotNull
	private String Etablissement;

	@NotNull
	private String Sexe;

	@NotNull
	private String Ville;

	private String listReservation;

	// private String Restaurant;

	@NotNull
	@Email
	private String Email;

	@NotNull
	private String image;

	// @NotNull
	private SiteVO siteVO;

	private RestaurantVO restaurantVO;

	private EntityStatus statut;

	private String revenu;

	private String tele;

	private String numCarte;

	private String id_onousc = "1697";

	@NotNull
	private List<NoteCritereVO> noteCritereVOs;

	private NoteCritereVO noteCritereVO;

	private Float note;

	// @NotNull
	private String codeMassar;

	private String nomComplet;
 
	private String typePersonelle;
	private String typeCarte;
	private String codeProfil;
	@NotNull
	private AnneeUniversitaireVO anneeUniversitaireVO;

	public EtudiantVO() {
		super();
		siteVO = new SiteVO();
		restaurantVO = new RestaurantVO();
		noteCritereVOs = new ArrayList<NoteCritereVO>();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Etudiants, EtudiantVO> getTransformer() {

		return new EtudiantVOTransformer();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	public RestaurantVO getRestaurantVO() {
		return restaurantVO;
	}

	public void setRestaurantVO(RestaurantVO restaurantVO) {
		this.restaurantVO = restaurantVO;
	}

	public String getRevenu() {
		return revenu;
	}

	public void setRevenu(String revenu) {
		this.revenu = revenu;
	}

	 
	public String getNumCarte() {
		DecimalFormat nf = new DecimalFormat("0000");
//		return id_onousc + "" + citovo.getUniversite().getCode() + id + "";
		return id_onousc + "" + siteVO.getCode() + id + "";
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public List<NoteCritereVO> getNoteCritereVOs() {
		return noteCritereVOs;
	}

	public void setNoteCritereVOs(List<NoteCritereVO> noteCritereVOs) {
		this.noteCritereVOs = noteCritereVOs;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public void addNoteCritereVOs(NoteCritereVO noteCritereVO) {
		this.noteCritereVOs.add(noteCritereVO);
	}

	public NoteCritereVO getNoteCritereVO() {
		return noteCritereVO;
	}

	public void setNoteCritereVO(NoteCritereVO noteCritereVO) {
		addNoteCritereVOs(noteCritereVO);
	}

	public AnneeUniversitaireVO getAnneeUniversitaireVO() {
		return anneeUniversitaireVO;
	}

	public void setAnneeUniversitaireVO(AnneeUniversitaireVO anneeUniversitaireVO) {
		this.anneeUniversitaireVO = anneeUniversitaireVO;
	}

	public String getNomComplet() {
		return Nom + "   " + Prenom;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public Long getAnn_universitaire() {
		return ann_universitaire;
	}

	public void setAnn_universitaire(Long ann_universitaire) {
		this.ann_universitaire = ann_universitaire;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public String getListReservation() {
		return listReservation;
	}

	public void setListReservation(String listReservation) {
		this.listReservation = listReservation;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
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

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getCodeProfil() {
		return codeProfil;
	}

	public void setCodeProfil(String codeProfil) {
		this.codeProfil = codeProfil;
	}

}
