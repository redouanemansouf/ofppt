/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.emission.business.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ProduitCarteDemoVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4361659558669202030L;

	/** The id. */
	private Long id;

	@NotNull
	@FixedSize(size = 3)
	private String code;

	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	private String pic = "gold";

	private String banque;

	private Integer periode;

	private String devise;

	private String codeService;

	private String systemePaiement;

	private String codePersonalisation;

	private String codeTarif;

	private String binInf;

	private String binSup;

	private Integer duree;

	private String typeCarte;

	private String typeGenerer;

	private String genreCarte;

	private Boolean debitCredit;

	private Boolean porteMonaie;

	private Boolean fidelite;

	private String renouvelement;

	private Date dateFixe;

	private Integer dureeMin;

	private Integer delaiEnvoie;

	private EntityStatus statut;

	private List<FraisServiceDemoVO> fraisService = new ArrayList<FraisServiceDemoVO>();

	private List<ModeReglementDemoVO> modesReglements = new ArrayList<ModeReglementDemoVO>();

	private ProfilOffLineDemoVO profilOffLine;

	private ProfilOnLineDemoVO profilOnLine;

	private EmvDetailDemoVO detailEmv;

	public ProduitCarteDemoVO() {
		super();
	}

	public ProduitCarteDemoVO(Long id, String code, String libelle,
			String banque, Integer periode, String devise, String codeService,
			String systemePaiement, String codePersonalisation,
			String codeTarif, String binInf, String binSup, Integer duree,
			String typeCarte, String typeGenerer, String genreCarte,
			Boolean debitCredit, Boolean porteMonaie, Boolean fidelite,
			String renouvelement, Date dateFixe, Integer dureeMin,
			Integer delaiEnvoie, EntityStatus statut,
			List<FraisServiceDemoVO> fraisService,
			List<ModeReglementDemoVO> modesReglements,
			ProfilOffLineDemoVO profilOffLine, ProfilOnLineDemoVO profilOnLine,
			EmvDetailDemoVO detailEmv, String pic) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.banque = banque;
		this.periode = periode;
		this.devise = devise;
		this.codeService = codeService;
		this.systemePaiement = systemePaiement;
		this.codePersonalisation = codePersonalisation;
		this.codeTarif = codeTarif;
		this.binInf = binInf;
		this.binSup = binSup;
		this.duree = duree;
		this.typeCarte = typeCarte;
		this.typeGenerer = typeGenerer;
		this.genreCarte = genreCarte;
		this.debitCredit = debitCredit;
		this.porteMonaie = porteMonaie;
		this.fidelite = fidelite;
		this.renouvelement = renouvelement;
		this.dateFixe = dateFixe;
		this.dureeMin = dureeMin;
		this.delaiEnvoie = delaiEnvoie;
		this.statut = statut;
		this.fraisService = fraisService;
		this.modesReglements = modesReglements;
		this.profilOffLine = profilOffLine;
		this.profilOnLine = profilOnLine;
		this.detailEmv = detailEmv;
		this.pic = pic;
	}

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public Integer getPeriode() {
		return periode;
	}

	public void setPeriode(Integer periode) {
		this.periode = periode;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeService) {
		this.codeService = codeService;
	}

	public String getSystemePaiement() {
		return systemePaiement;
	}

	public void setSystemePaiement(String systemePaiement) {
		this.systemePaiement = systemePaiement;
	}

	public String getCodePersonalisation() {
		return codePersonalisation;
	}

	public void setCodePersonalisation(String codePersonalisation) {
		this.codePersonalisation = codePersonalisation;
	}

	public String getCodeTarif() {
		return codeTarif;
	}

	public void setCodeTarif(String codeTarif) {
		this.codeTarif = codeTarif;
	}

	public String getBinInf() {
		return binInf;
	}

	public void setBinInf(String binInf) {
		this.binInf = binInf;
	}

	public String getBinSup() {
		return binSup;
	}

	public void setBinSup(String binSup) {
		this.binSup = binSup;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getTypeGenerer() {
		return typeGenerer;
	}

	public void setTypeGenerer(String typeGenerer) {
		this.typeGenerer = typeGenerer;
	}

	public String getGenreCarte() {
		return genreCarte;
	}

	public void setGenreCarte(String genreCarte) {
		this.genreCarte = genreCarte;
	}

	public Boolean getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(Boolean debitCredit) {
		this.debitCredit = debitCredit;
	}

	public Boolean getPorteMonaie() {
		return porteMonaie;
	}

	public void setPorteMonaie(Boolean porteMonaie) {
		this.porteMonaie = porteMonaie;
	}

	public Boolean getFidelite() {
		return fidelite;
	}

	public void setFidelite(Boolean fidelite) {
		this.fidelite = fidelite;
	}

	public String getRenouvelement() {
		return renouvelement;
	}

	public void setRenouvelement(String renouvelement) {
		this.renouvelement = renouvelement;
	}

	public Date getDateFixe() {
		return dateFixe;
	}

	public void setDateFixe(Date dateFixe) {
		this.dateFixe = dateFixe;
	}

	public Integer getDureeMin() {
		return dureeMin;
	}

	public void setDureeMin(Integer dureeMin) {
		this.dureeMin = dureeMin;
	}

	public Integer getDelaiEnvoie() {
		return delaiEnvoie;
	}

	public void setDelaiEnvoie(Integer delaiEnvoie) {
		this.delaiEnvoie = delaiEnvoie;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public List<FraisServiceDemoVO> getFraisService() {
		return fraisService;
	}

	public void setFraisService(List<FraisServiceDemoVO> fraisService) {
		this.fraisService = fraisService;
	}

	public List<ModeReglementDemoVO> getModesReglements() {
		return modesReglements;
	}

	public void setModesReglements(List<ModeReglementDemoVO> modesReglements) {
		this.modesReglements = modesReglements;
	}

	public ProfilOffLineDemoVO getProfilOffLine() {
		return profilOffLine;
	}

	public void setProfilOffLine(ProfilOffLineDemoVO profilOffLine) {
		this.profilOffLine = profilOffLine;
	}

	public ProfilOnLineDemoVO getProfilOnLine() {
		return profilOnLine;
	}

	public void setProfilOnLine(ProfilOnLineDemoVO profilOnLine) {
		this.profilOnLine = profilOnLine;
	}

	public EmvDetailDemoVO getDetailEmv() {
		return detailEmv;
	}

	public void setDetailEmv(EmvDetailDemoVO detailEmv) {
		this.detailEmv = detailEmv;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return libelle;
	}

}
