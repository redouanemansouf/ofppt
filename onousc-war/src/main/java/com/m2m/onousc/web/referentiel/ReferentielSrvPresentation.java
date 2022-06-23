/*
 * ReferentielSrvPresentation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;

/**
 * The Interface ReferentielSrvPresentation.
 * 
 * @version 1.0 21 oct. 2015
 * @author mbenboubker
 */
public interface ReferentielSrvPresentation {

	/** The Constant codeMaroc. */
	static final String codeMaroc = "504";

	/**
	 * Find canal vente.
	 * 
	 * @param id the id
	 * @return the canal vente vo
	 */

	List<UserEntityVO> findUserByGroup(String group);

	CanalVenteVO findCanalVente(Long id);

	SiteVO findSite(Long id);

	List<CanalVenteVO> findCanalByCode(String code);

	DetailProfilVO findDetailProfil(Long id);

	public List<DetailProfilVO> findDetailProfilByprofil(String code);

	List<CaisseVO> findCaisseListByCode(String code);

	/**
	 * Find all canal vente for combo.
	 * 
	 * @return the list
	 */
	List<CanalVenteVO> findAllCanalVenteForCombo();

	GroupUserVO findGroupUserByID(long id);

	List<CanalVenteVO> findAllCanalVenteByClient();

	List<ProduitVO> findProduitListByCode(String code);

	/**
	 * Find all ville.
	 * 
	 * @return the list
	 */
	List<VilleVO> findAllVille();

	List<RestaurantVO> findRestaurantListByCode(String code);

	/**
	 * Find ville.
	 * 
	 * @param id the id
	 * @return the ville vo
	 */
	VilleVO findVille(Long id);

	/**
	 * Find universite.
	 * 
	 * @param id the id
	 * @return the universite vo
	 */
	UniversiteVO findUniversite(Long id);

	/**
	 * Find all universite for combo.
	 * 
	 * @return the list
	 */
	List<UniversiteVO> findAllUniversiteForCombo();

	/**
	 * Find cite.
	 * 
	 * @param id the id
	 * @return the cite vo
	 */
	CiteVO findCite(Long id);

	/**
	 * Find all cite for combo.
	 * 
	 * @return the list
	 */
	List<CiteVO> findAllCiteForCombo();

	/**
	 * Find jourferie.
	 * 
	 * @param id the id
	 * @return the cite vo
	 */
	JoursFerieVO findJoursFerie(Long id);

	/**
	 * Find all cite for combo.
	 * 
	 * @return the list
	 */
	List<JoursFerieVO> findAllJoursFerieForCombo();

	/**
	 * Find service.
	 * 
	 * @param id the id
	 * @return the service vo
	 */
	ServiceVO findService(Long id);

	/**
	 * Find all service for combo.
	 * 
	 * @return the list
	 */
	List<ServiceVO> findAllServiceForCombo();

	/**
	 * Find tarif.
	 * 
	 * @param id the id
	 * @return the tarif vo
	 */
	TarifVO findTarif(Long id);

	/**
	 * Find all tarif for combo.
	 * 
	 * @return the list
	 */
	List<TarifVO> findAllTarifForCombo();

	/**
	 * Find etudiant By id.
	 * 
	 * @param id the id
	 * @return the etudiant
	 */

	EtudiantVO findEtudiant(Long id);

	/**
	 * Find all etudiant for combo.
	 * 
	 * @return the list
	 */

	List<EtudiantVO> findAllEtudiantforCombo();

	/**
	 * Find caisse.
	 * 
	 * @param id the id
	 * @return the caisse vo
	 */
	CaisseVO findCaisse(Long id);

	/**
	 * Find all caisse for combo.
	 * 
	 * @return the list
	 */
	List<CaisseVO> findAllCaisseForCombo();

	/**
	 * Find restaurant.
	 * 
	 * @param id the id
	 * @return the restaurant vo
	 */
	RestaurantVO findRestaurant(Long id);

	/**
	 * Find all restaurant for combo.
	 * 
	 * @return the list
	 */
	List<RestaurantVO> findAllRestaurantForCombo();

	/**
	 * Find plafond.
	 * 
	 * @param id the id
	 * @return the plafond vo
	 */
	PlafondVO findPlafond(Long id);

	/**
	 * Find all plafond for combo.
	 * 
	 * @return the list
	 */
	List<PlafondVO> findAllPlafondForCombo();

	List<ServiceVO> findAllService(String type);

	/**
	 * Find AnneeUniversitaire.
	 * 
	 * @param id the id
	 * @return the anneeUniversitaire vo
	 */
	AnneeUniversitaireVO findAnneeUniversitaire(Long id);

	/**
	 * Find all anneeUniversitaire for combo.
	 * 
	 * @return the list
	 */
	List<AnneeUniversitaireVO> findAllAnneeUniversitaireForCombo();

	/**
	 * Find MotifOpposition.
	 * 
	 * @param id the id
	 * @return the motifOpposition vo
	 */
	MotifOppositionVO findMotifOpposition(Long id);

	/**
	 * Find all anneeUniversitaire for combo.
	 * 
	 * @return the list
	 */
	List<MotifOppositionVO> findAllMotifOppositionForCombo();

	/**
	 * Find MotifMainLevee.
	 * 
	 * @param id the id
	 * @return the motifMainLevee vo
	 */
	MotifMainLeveeVO findMotifMainLevee(Long id);

	/**
	 * Find all motifMainLevee for combo.
	 * 
	 * @return the list
	 */
	List<MotifMainLeveeVO> findAllMotifMainLeveeForCombo();

	/**
	 * Find CategoriePorteur.
	 * 
	 * @param id the id
	 * @return the categoriePorteur vo
	 */
	CategoriePorteurVO findCategoriePorteur(Long id);

	/**
	 * Find all categoriePorteur vo for combo.
	 * 
	 * @return the list
	 */
	List<CategoriePorteurVO> findAllCategoriePorteurForCombo();

	List<CategoriePorteurVO> findCategoriePorteurListByCode(String code);

	/**
	 * Find ParametreGeneral.
	 * 
	 * @param id the id
	 * @return the parametreGeneral vo
	 */
	ParametreGeneralVO findParametreGeneral(Long id);

	/**
	 * Find all parametreGeneral vo for combo.
	 * 
	 * @return the list
	 */
	List<ParametreGeneralVO> findAllParametreGeneralForCombo();

	/**
	 * Find service by code.
	 * 
	 * @param string the string
	 * @return the service vo
	 */
	ServiceVO findServiceByCode(String string);

	/**
	 * @param criteria
	 * @return
	 */
	/**
	 * @param criteria
	 * @return
	 */
	List<CycleVieVO> findCycleVieCriteria(CycleVieCriteria criteria);

	/**
	 * Find user by code.
	 * 
	 * @param code the code
	 * @return the user entity vo
	 */
	UserEntityVO findUserByCode(String code);

	List<RestaurantVO> findAllRestaurantByLibelleCite(String libelle);

	double findSoldeByMatricule(String matr);

	/**
	 * @return
	 */
	List<WinMenuVO> findWinMenuModule();

	List<UserEntityVO> findAllUserEnabled();

	List<CaisseVO> findAllCaisseByLibelleRestaurant(String libelle);

	List<EtudiantVO> findAllEtudiantByLibelleRestaurant(String libelle);

	List<String> findAllgroup();

	List<MenuVO> findAllMenu();

	/**
	 * Find restaurant by code.
	 * 
	 * @param codeRestaurant the code restaurant
	 * @return the restaurant vo
	 */
	RestaurantVO findRestaurantByCode(String codeRestaurant);

	/**
	 * Find tourniquet.
	 * 
	 * @param id the id
	 * @return the tourniquet vo
	 */
	TourniquetVO findTourniquet(Long id);

	/**
	 * Find all tourniquet for combo.
	 * 
	 * @return the list
	 */
	List<TourniquetVO> findAllTourniquetForCombo();

	/**
	 * Find Equipement.
	 * 
	 * @param id the id
	 * @return the Equipement vo
	 */
	EquipementVO findEquipement(Long id);

	/**
	 * Find all Equipement for combo.
	 * 
	 * @return the list
	 */
	List<EquipementVO> findAllEquipementForCombo();

	/**
	 * @param criteria
	 * @return
	 */
	List<TraceEntityVO> findTraceByEntity(TraceEntityCriteria criteria);

	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	List<ReservationVO> findByReservationByDate(Date date1, Date date2);

	/**
	 * Find caissier.
	 * 
	 * @param id the id
	 * @return the caissier vo
	 */
	CaissierVO findCaissier(Long id);

	/**
	 * Find all caissier for combo.
	 * 
	 * @return the list
	 */
	List<CaissierVO> findAllCaissierVOForCombo();

	List<CaissierVO> findCaissierListByCode(String code);

	/**
	 * @param userCriteria
	 * @return
	 */
	List<UserEntityVO> findUserByCriteria(UserEntityCriteria userCriteria);

	/**
	 * Checks if is free day.
	 * 
	 * @param date the date
	 * @return true, if is free day
	 */
	boolean isFreeDay(Date date);

	/**
	 * Find critere.
	 * 
	 * @param id the id
	 * @return the critere vo
	 */
	CritereVO findCritere(Long id);

	/**
	 * Find all critere for combo.
	 * 
	 * @return the list
	 */
	List<CritereVO> findAllCritereForCombo();

	/**
	 * Find canal vente.
	 * 
	 * @param id the id
	 * @return the canal vente vo
	 */
	NoteCritereVO findNoteCritere(Long id);

	/**
	 * Find all canal vente for combo.
	 * 
	 * @return the list
	 */
	List<NoteCritereVO> findAllNoteCritereForCombo();

	/**
	 * Find canal vente.
	 * 
	 * @param id the id
	 * @return the BorneVO
	 */
	BorneVO findBorne(Long id);

	/**
	 * Find all BorneVO for combo.
	 * 
	 * @return the list
	 */
	List<BorneVO> findAllBorneForCombo();

	/**
	 * @param menuPage
	 * @return
	 */
	String findMenuByCriteria(String menuPage);

	List<CycleVieVO> findCycleVieByCode(String string);

	List<String> getDataConnection();

	List<String> getDataMessagerie();

	List<NoteCritereVO> findNoteCritereByCodeCritere(String code);

	List<ParametreGeneralVO> findParametreGeneralByCode(String code);

	/**************************************************************************/
	/******************
	 * PARTIE OCP /
	 **************************************************************************/

	AnneeUniversitaireVO findActuelAnneeUniversitaire();

	PersonnelVO findPersonnelByMatr(String matr);

	CarteNapsVO findCarteNapsByMatricule(String matr);

	List<PersonnelVO> findAllPersonnel();

	List<AdherentVO> findAllAdherent();

	PersonnelVO findPersonnel(Long id);

	public List<AdherentVO> findAdherentByPersonnel(Long id);

	public List<ProduitVO> findProduitByFamille(Long id);

	ProduitVO findProduitByCodeBar(String codeBar);

	List<SiteVO> findAllSite();

	UserEntityVO findUserEntityByCode(String code);

	List<CanalVenteVO> findAllCanalVenteBySite(Long id);

	List<SiteVO> findSiteByCode(String code);

	List<RestaurantVO> findRestaurantByIdSite(Long idSite);

	List<CaisseVO> findCaisseListByIdSite(Long idSite);

	List<FiliereVO> findFiliereByCode(String code);
	
	Long findNbreEtudiantByStatust(EntityStatus status);

	CarteVO findCarteByEtud(Long id);
	
	EtudiantVO findResidentStudentForInscription(String cin);
	EtudiantVO findResidentStudentForInscriptionMassar(String massar);

	EtudiantVO findEtudiantByMassar(String codeMassar);

	List<BorneVO> findBorneBySite(Long idSite);

	List<RestaurantVO> findRestaurantBySite(Long siteId);

}
