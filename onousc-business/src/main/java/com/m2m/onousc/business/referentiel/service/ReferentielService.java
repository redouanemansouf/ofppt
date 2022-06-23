/*
 * ReferentielService.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.service;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria;
import com.m2m.onousc.business.referentiel.criteria.BorneCriteria;
import com.m2m.onousc.business.referentiel.criteria.CaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.CaissierCriteria;
import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.CarteNapsCriteria;
import com.m2m.onousc.business.referentiel.criteria.CategoriePorteurCriteria;
import com.m2m.onousc.business.referentiel.criteria.CiteCriteria;
import com.m2m.onousc.business.referentiel.criteria.ClotureCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.ConsultCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.ControlAccesCriteria;
import com.m2m.onousc.business.referentiel.criteria.CritereCriteria;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.DelivranceCriteria;
import com.m2m.onousc.business.referentiel.criteria.DemandeAdminCriteria;
import com.m2m.onousc.business.referentiel.criteria.DetailProfilCriteria;
import com.m2m.onousc.business.referentiel.criteria.EquipementCriteria;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.criteria.EvenementCriteria;
import com.m2m.onousc.business.referentiel.criteria.FiliereCriteria;
import com.m2m.onousc.business.referentiel.criteria.ImportCriteria;
import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria;
import com.m2m.onousc.business.referentiel.criteria.MotifOppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.NoteCritereCriteria;
import com.m2m.onousc.business.referentiel.criteria.OperCaisseCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionAdhCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.criteria.PlafondCriteria;
import com.m2m.onousc.business.referentiel.criteria.ProduitCriteria;
import com.m2m.onousc.business.referentiel.criteria.ProfilPorteurCriteria;
import com.m2m.onousc.business.referentiel.criteria.ReservationBorneCriteria;
import com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria;
import com.m2m.onousc.business.referentiel.criteria.ServiceCriteria;
import com.m2m.onousc.business.referentiel.criteria.SiteCriteria;
import com.m2m.onousc.business.referentiel.criteria.SoldeCriteria;
import com.m2m.onousc.business.referentiel.criteria.TarifCriteria;
import com.m2m.onousc.business.referentiel.criteria.TourniquetCriteria;
import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.ClotureCaisse;
import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.DelivranceCarte;
import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Evenement;
import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.onousc.business.referentiel.model.MotifOpposition;
import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.onousc.business.referentiel.model.ProfilPorteur;
import com.m2m.onousc.business.referentiel.model.ReservationBorne;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.web.SearchConfig;

public interface ReferentielService {

	// Canaux de vente
	/**
	 * Find canal vente by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<CanalVente> findCanalVenteByCriteria(CanalVenteCriteria criteria);

	List<Site> findSiteByCriteria(SiteCriteria criteria);

	/**
	 * Find canal vente.
	 * 
	 * @param id the id
	 * @return the canal vente
	 * 
	 */

	List<UserEntity> findUserByGroup(String group);

	CanalVente findCanalVente(Long id);

	List<CanalVente> findCanalListByCode(String code);

	CanalVente findCanalVenteByCode(String code);

	DetailProfilAcces findDetailProfil(Long id);

	List<Produit> findProduitByCode(String code);

	List<Caisse> findCaisseListByCode(String code);

	/**
	 * Find all canal vente for combo.
	 * 
	 * @return the list
	 */
	List<CanalVente> findAllCanalVenteForCombo();

	List<CanalVente> findAllCanalVenteByClient();

	List<Restaurant> findRestaurantListByCode(String code);

	// Universite
	/**
	 * Find universite by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Universite> findUniversiteByCriteria(UniversiteCriteria criteria);

	/**
	 * Find universite.
	 * 
	 * @param id the id
	 * @return the universite
	 */
	Universite findUniversite(Long id);

	public List<Etudiants> findByCriteria(EtudiantCriteria criteria);

	public List<Etudiants> findForCombo();

	public Etudiants findEtudiant(Long id);

	// ville
	List<Ville> findAllVille();

	public List<UserEntity> findUserByCriteria(String firstName, String lastName, String username, String email,
			String statut, String group, SearchConfig config, String sortField, String sortOrder);

	public List<UserEntity> findAllUser();

	/**
	 * Find all universite for combo.
	 * 
	 * @return the list
	 */
	List<Universite> findAllUniversiteForCombo();

	List<Universite> findUniversiteByCode(String code);

	// Cite
	/**
	 * Find cite by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Cite> findCiteByCriteria(CiteCriteria criteria);

	/**
	 * Find cite.
	 * 
	 * @param id the id
	 * @return the cite
	 */
	Cite findCite(Long id);

	/**
	 * Find all cite for combo.
	 * 
	 * @return the list
	 */
	List<Cite> findAllCiteForCombo();

	// Jours ferie
	/**
	 * Find joursferie by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<JoursFerie> findJoursFerieByCriteria(JoursFerieCriteria criteria);

	List<Cite> findCiteByCode(String code);

	public List<CycleVie> findCycleVieCriteria(CycleVieCriteria criteria);

	public Restaurant findRestaurantByLongId(Long id);

	/**
	 * Find joursferie.
	 * 
	 * @param id the id
	 * @return the joursferie
	 */
	JoursFerie findJoursFerie(Long id);

	public List<CycleVie> findCycleVieForCombo();

	/**
	 * Find all joursferie for combo.
	 * 
	 * @return the list
	 */
	List<JoursFerie> findAllJoursFerieForCombo();

	// Tarif

	List<JoursFerie> findJoursFerieByCode(String code);

	// Tarif

	/**
	 * Find tarif by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Tarif> findTarifByCriteria(TarifCriteria criteria);

	/**
	 * Find joursferie.
	 * 
	 * @param id the id
	 * @return the tarif
	 */
	Tarif findTarif(Long id);

	/**
	 * Find all tarif for combo.
	 * 
	 * @return the list
	 */
	List<Tarif> findAllTarifForCombo();

	List<Tarif> findTarifByCode(String code);

	// Service
	/**
	 * Find Service by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Service> findServiceByCriteria(ServiceCriteria criteria);

	/**
	 * Find Service.
	 * 
	 * @param id the id
	 * @return the Service
	 */
	Service findService(Long id);

	/**
	 * Find all Service for combo.
	 * 
	 * @return the list
	 */
	List<Service> findAllServiceForCombo();

	com.m2m.onousc.business.referentiel.model.Service findServiceByCode(String code);

	// Caisse
	/**
	 * Find canal caisse by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Caisse> findCaisseByCriteria(CaisseCriteria criteria);

	/**
	 * Find caisse.
	 * 
	 * @param id the id
	 * @return the caisse
	 */
	Caisse findCaisse(Long id);

	/**
	 * Find all caisse for combo.
	 * 
	 * @return the list
	 */
	List<Caisse> findAllCaisseForCombo();

	List<Caisse> findCaisseByCode(String code);

	// Restaurant
	/**
	 * Find restaurant by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list restaurant
	 */
	List<Restaurant> findRestaurantByCriteria(RestaurantCriteria criteria);

	List<Restaurant> findRestaurantByIdProduit(Long idProd);

	/**
	 * Find restaurant.
	 * 
	 * @param id the id
	 * @return the restaurant
	 */
	Restaurant findRestaurant(Long id);

	/**
	 * Find all restaurant for combo.
	 * 
	 * @return the list
	 */
	List<Restaurant> findAllRestaurantForCombo();

	/**
	 * Find restaurant by code.
	 * 
	 * @param code the code
	 * @return the restaurant
	 */
	Restaurant findRestaurantByCode(String code);

	List<Restaurant> findRestaurantByLibelleCite(String libelle);

	// Plafond
	/**
	 * Find plafond by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list plafond
	 */
	List<Plafond> findPlafondByCriteria(PlafondCriteria criteria);

	/**
	 * Find plafond.
	 * 
	 * @param id the id
	 * @return the plafond
	 */
	Plafond findPlafond(Long id);

	/**
	 * Find all plafond for combo.
	 * 
	 * @return the list
	 */
	List<Plafond> findAllPlafondForCombo();

	List<Plafond> findPlafondByCode(String code);

	// AnneeUniversitaire
	/**
	 * Find anneeUniversitaire by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list anneeUniversitaire
	 */
	List<AnneeUniversitaire> findAnneeUniversitaireByCriteria(AnneeUniversitaireCriteria criteria);

	/**
	 * Find anneeUniversitaire.
	 * 
	 * @param id the id
	 * @return the anneeUniversitaire
	 */
	AnneeUniversitaire findAnneeUniversitaire(Long id);

	/**
	 * Find all anneeUniversitaire for combo.
	 * 
	 * @return the list
	 */
	List<AnneeUniversitaire> findAllAnneeUniversitaireForCombo();

	List<AnneeUniversitaire> findAnneUniversitaireByCode(String code);

	Ville findVille(Long id);

	// MotifOpposition
	/**
	 * Find motifOpposition by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list motifOpposition
	 */
	List<MotifOpposition> findMotifOppositionByCriteria(MotifOppositionCriteria criteria);

	/**
	 * Find motifOpposition.
	 * 
	 * @param id the id
	 * @return the motifOpposition
	 */
	MotifOpposition findMotifOpposition(Long id);

	/**
	 * Find all motifOpposition for combo.
	 * 
	 * @return the list
	 */
	List<MotifOpposition> findAllMotifOppositionForCombo();

	List<MotifOpposition> findMotifOppositionByCode(String code);

	// MotifMainLevee
	/**
	 * Find motifMainLevee by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list motifMainLevee
	 */
	List<MotifMainLevee> findMotifMainLeveeByCriteria(MotifMainLeveeCriteria criteria);

	/**
	 * Find motifMainLevee.
	 * 
	 * @param id the id
	 * @return the motifMainLevee
	 */
	MotifMainLevee findMotifMainLevee(Long id);

	/**
	 * Find all motifMainLevee for combo.
	 * 
	 * @return the list
	 */
	List<MotifMainLevee> findAllMotifMainLeveeForCombo();

	List<MotifMainLevee> findMotifMainLeveeByCode(String code);

	// CategoriePorteur
	/**
	 * Find CategoriePorteur by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list categoriePorteur
	 */
	List<CategoriePorteur> findCategoriePorteurByCriteria(CategoriePorteurCriteria criteria);

	List<CarteNaps> findCarteNapsByCriteria(CarteNapsCriteria criteria);

	CarteNaps findCarteNapsByID(String id);

	List<ProfilPorteur> findProfilPorteurByCriteria(ProfilPorteurCriteria criteria);

	/**
	 * Find categoriePorteur.
	 * 
	 * @param id the id
	 * @return the categoriePorteur
	 */
	CategoriePorteur findCategoriePorteur(Long id);

	/**
	 * Find all categoriePorteur for combo.
	 * 
	 * @return the list
	 */
	List<CategoriePorteur> findAllCategoriePorteurForCombo();

	List<CategoriePorteur> findCategoriePorteurByCode(String code);

	// ParametreGeneral
	/**
	 * Find ParametreGeneral by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list parametreGeneral
	 */
	List<ParametreGeneral> findParametreGeneralByCriteria(ParametreGeneralCriteria criteria);

	/**
	 * Find parametreGeneral.
	 * 
	 * @param id the id
	 * @return the parametreGeneral
	 */
	ParametreGeneral findParametreGeneral(Long id);

	/**
	 * Find all parametreGeneral for combo.
	 * 
	 * @return the list
	 */
	List<ParametreGeneral> findAllParametreGeneralForCombo();

	List<ParametreGeneral> findParametreGeneralByCode(String code);

	List<CycleVie> findByCycleVieByDate(Date dateDebut, Date dateFin);

	List<Reservation> findByReservationByDate(Date dateDebut, Date dateFin);

	/**
	 * Find user by code.
	 * 
	 * @param code the code
	 * @return the user entity
	 */
	UserEntity findUserByCode(String code);

	/**
	 * @param status
	 * @return
	 */
	List<Etudiants> findEtudiantByStatus(String status);

	/**
	 * @param userCriteria
	 * @return
	 */
	List<UserEntity> findUserByCriteria(UserEntityCriteria userCriteria);

	/**
	 * @param winMenuCriteria
	 * @return
	 */
	List<WinMenu> findWinMenuByCriteria(WinMenuCriteria winMenuCriteria);

	/**
	 * @return
	 */
	List<WinMenu> findWinMenuModule();

	/**
	 * @param code
	 * @param libelle
	 * @param abbrev
	 * @return
	 */
	List<Menu> findMenuByCritere(String code, String libelle, String abbrev);

	List<Menu> findMenuByCriteria(MenuCriteria criteria);

	List<OperationCaisse> findOperationCaisseByCriteria(OperCaisseCriteria criteria);

	List<ConsultCaisse> findConsultCaisseByCriteria(ConsultCaisseCriteria criteria);

	List<Caisse> findCaisseByLibelleCite(String libelle);

	List<Etudiants> findEtudiantsByLibelleCite(String libelle);

	List<GroupUser> findAllGroupe();

	GroupUser findGroupUserByID(long id);

	// Tourniquet
	/**
	 * Find tourniquet by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Tourniquet> findTourniquetByCriteria(TourniquetCriteria criteria);

	/**
	 * Find tourniquet.
	 * 
	 * @param id the id
	 * @return the tourniquet
	 */
	Tourniquet findTourniquet(Long id);

	/**
	 * Find all canal vente for combo.
	 * 
	 * @return the list
	 */
	List<Tourniquet> findAllTourniquetForCombo();

	List<Tourniquet> findTourniquetByCode(String code);

	// Equipement
	/**
	 * Find equipement by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Equipement> findEquipementByCriteria(EquipementCriteria criteria);

	/**
	 * Find equipement.
	 * 
	 * @param id the id
	 * @return the equipement
	 */
	Equipement findEquipement(Long id);

	/**
	 * Find all canal vente for combo.
	 * 
	 * @return the list
	 */
	List<Equipement> findAllEquipementForCombo();

	List<Equipement> findEquipementByCode(String code);

	/**
	 * @param criteria
	 * @return
	 */
	List<TraceEntity> findTraceByCriteria(TraceEntityCriteria criteria);

	List<Cite> findCiteByCodeUniversite(String code);

	List<Restaurant> findRestaurantByCodeCite(String code);

	List<Caisse> findCaisseByCodeRestaurant(String code);

	List<Tarif> findTarifByCodeService(String code);

	List<Tarif> findTarifByCodeCategoriePorteur(String code);

	List<Tourniquet> findTourniquetByCodeRestaurant(String code);

	List<Equipement> findEquipementByCodeCite(String code);

	List<Equipement> findEquipementByCodeRestaurant(String code);

	List<JoursFerie> findJoursFerieByCodeAnneeUniversitaire(String code);

	List<OperationCaisse> findOperationCaisseByCodeCaisse(String code);

	List<ConsultCaisse> findConsultCaisseByCodeCaisse(String code);

	List<Etudiants> findEtudiantByCodeRestaurant(String code);

	List<Tarif> findTarifInReservationDetail(String code);

	// Caissier
	/**
	 * Find Caissier by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list
	 */
	List<Caissier> findCaissierByCriteria(CaissierCriteria criteria);

	/**
	 * Find caissier.
	 * 
	 * @param id the id
	 * @return the caissier
	 */
	Caissier findCaissier(Long id);

	/**
	 * Find all caissier for combo.
	 * 
	 * @return the list
	 */
	List<Caissier> findAllCaissierForCombo();

	List<Caissier> findCaissierByCode(String code);

	List<Caissier> findCaissierByNumcarte(String numcarte);

	/**
	 * Checks if is free day.
	 * 
	 * @param date the date
	 * @return true, if is free day
	 */
	boolean isFreeDay(Date date);

	double findSoldeByMatricule(String matr);

	// critere
	/**
	 * Find critere by criteria.
	 * 
	 * @param criteria the criteria
	 * @return the list critere
	 */
	List<Critere> findCritereByCriteria(CritereCriteria criteria);

	/**
	 * Find Critere.
	 * 
	 * @param id the id
	 * @return the Critere
	 */
	Critere findCritere(Long id);

	/**
	 * Find all Critere for combo.
	 * 
	 * @return the list
	 */
	List<Critere> findAllCritereForCombo();

	List<Critere> findCritereByCode(String code);

	// Notecritere
	/**
	 * Find Notecritere by criteria.
	 * 
	 * @param Notecritere the criteria
	 * @return the list Notecritere
	 */
	List<NoteCritere> findNoteCritereByCriteria(NoteCritereCriteria criteria);

	/**
	 * Find Critere.
	 * 
	 * @param id the id
	 * @return the Notecritere
	 */
	NoteCritere findNoteCritere(Long id);

	/**
	 * Find all Critere for combo.
	 * 
	 * @return the list NoteCritere
	 */
	List<NoteCritere> findAllNoteCritereForCombo();

	List<NoteCritere> findNoteCritereByCode(String code);

	List<Borne> findBorneByCriteria(BorneCriteria criteria);

	/**
	 * Find Borne.
	 * 
	 * @param id the id
	 * @return the Borne
	 */
	Borne findBorne(Long id);

	/**
	 * Find all Borne for combo.
	 * 
	 * @return the list Borne
	 */
	List<Borne> findAllBorneForCombo();

	List<Borne> findBorneByCode(String code);

	List<CycleVie> findCycleVieByCode(String code);

	List<Restaurant> findByCodeCite(String code);

	List<String> getDataConnection();

	List<String> getDataMessagerie();

	List<NoteCritere> findNoteCritereByCodeCritere(String code);

	AnneeUniversitaire findActuelAnneeUniversitaire();

	public List<DelivranceCarte> findDelivByCriteria(DelivranceCriteria criteria);

	public List<DelivranceCarte> findDelivForCombo();

	public List<ClotureCaisse> findByCriteria(ClotureCaisseCriteria criteria);

	public List<Etudiants> findByCIN(String cin);

	public Carte findCarteByEtud(Long id);

	public List<CycleVie> findCycleByDeliv(CycleVieCriteria criteria);

	public List<Carte> findCarteByCriteria(CarteCriteria criteria);

	public String findMaxLotCarte(String code);

	public List<Carte> findCarteByCriteria(LotCarteCriteria lotcriteria);

	public List<Carte> find_Carte_By_Lot(String code);

	/*************************************
	 * PARTIE OCP
	 *********************************************/
	public List<Personnel> findPersonnelByCriteria(PersonnelCriteria criteria);

	public List<Solde> findSoldeByCriteria(SoldeCriteria criteria);

	public List<Adherent> findAdherentByCriteria(AdherentCriteria criteria);

	public Personnel findPersonnelByMatr(String matr);

	public CarteNaps findCarteNapsByMatricule(String matr);

	public List<Personnel> findAllPersonnel();

	public List<Adherent> findAllAdherent();

	public Personnel findPersonnel(Long id);

	Adherent findAdherentByNom(String matr, String nom, String prenom);

	public List<Adherent> findAdherentByPersonnel(Long id);

	public List<DetailProfilAcces> findDetailProfilByCriteria(DetailProfilCriteria criteria);

	public List<String> getTrancheByProfil(String jour, Long profil);

	public List<ControlAcces> findControlAccesByCriteria(ControlAccesCriteria criteria);

	public List<Produit> findProduitByCriteria(ProduitCriteria criteria);

	public void persisthisto(String matricule, Float montant, Float solde);

	public List<Produit> findProduitByFamille(Long id);

	public void persisthistoDecharge(String matricule, Float montant, Float solde);

	public List<Adherent> findAdherentByAgeNscol(String matr);

	public List<Adherent> findAdherentByAgescol(String matr);

	public Produit findProduitByCodeBar(String codeBar);

	public List<ControlAcces> findControlAccesAccesPrincip(ControlAccesCriteria criteria);

	public List<Evenement> findEvenementtByCriteria(EvenementCriteria criteria);

	public List<Service> findByType(String type);

	public void persistReservationDetail(Service idService, Reservation reservation);

	public void persistReservation(String libelle, Double montant);

	public void persistReserv(Reservation reservation);

	public List<DetailProfilAcces> findDetailProfilByprofil(String code);

	public List<Personnel> findOppositionPersoByCriteria(OppositionCriteria criteria);

	public List<Adherent> findOppositionAdhByCriteria(OppositionAdhCriteria criteria);

	Site findSite(Long id);

	List<Site> findAllSite();

	UserEntity findUserEntityByCode(String code);

	List<CanalVente> findAllCanalVenteBySite(Long idSite);

	List<Site> findSiteByCode(String code);

	List<Restaurant> findRestaurantByIdSite(Long idSite);

	List<Caisse> findCaisseListByIdSite(Long idSite);

	List<Filiere> findFiliereByCriteria(FiliereCriteria criteria);

	List<Filiere> findFiliereByIdSite(Long idSite);

	List<Filiere> findFiliereListByCode(String code);

	public Filiere findFiliereByLongId(Long id);

	Filiere findFiliere(Long id);

	List<Filiere> findAllFiliereForCombo();

	Filiere findFiliereByCode(String code);

	Long findNbreEtudiantByStatus(EntityStatus status);

	List<ReservationBorne> findReservationBorneByCriteria(ReservationBorneCriteria criteria);
	
	List<ImportInscription> findImportInscription(ImportCriteria criteria);
	
	Etudiants findResidentStudentForInscription(String cin);
	
	Etudiants findResidentStudentForInscriptionByMassar(String codeMassar);

	List<Carte> findOppositionByCriteria(OppositionCriteria criteria);

	List<Carte> findToRefabricateByCriteria(EtudiantCriteria criteria);

	Etudiants findEtudiantByMassar(String codeMassar);

	List<Borne> findBorneBySite(Long idSite);

	List<DemandeAdmin> findDemandeAdminByCriteria(DemandeAdminCriteria criteria);

	List<Restaurant> findRestaurantByCodeSite(Long code);
}