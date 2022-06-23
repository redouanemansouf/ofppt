/*
 * ReferentielsServiceImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.m2m.onousc.business.referentiel.dao.AdherentDaoJpa;
import com.m2m.onousc.business.referentiel.dao.AnneeUniversitaireDaoJpa;
import com.m2m.onousc.business.referentiel.dao.BorneDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CaissierDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CanalVenteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteNapsDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CategoriePorteurDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ClotureCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ConsultCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ControlAccesDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CritereDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.DelivranceDaoJpa;
import com.m2m.onousc.business.referentiel.dao.DemandeAdminDaoJpa;
import com.m2m.onousc.business.referentiel.dao.DetailProfilDaoJpa;
import com.m2m.onousc.business.referentiel.dao.EquipementDaoJpa;
import com.m2m.onousc.business.referentiel.dao.EtudiantDaoJpa;
import com.m2m.onousc.business.referentiel.dao.EvenementDaoJpa;
import com.m2m.onousc.business.referentiel.dao.FiliereDaoJpa;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ImportInscriptionDaoJpa;
import com.m2m.onousc.business.referentiel.dao.JoursFerieDao;
import com.m2m.onousc.business.referentiel.dao.MenuDaoJpa;
import com.m2m.onousc.business.referentiel.dao.MotifMainLeveeDaoJpa;
import com.m2m.onousc.business.referentiel.dao.MotifOppositionDaoJpa;
import com.m2m.onousc.business.referentiel.dao.NoteCritereDaoJpa;
import com.m2m.onousc.business.referentiel.dao.OperationCaisseDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ParametreGeneralDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PlafondDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ProduitDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ProfilPorteurDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ReservationBorneDaoJpa;
import com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ServiceDaoJpa;
import com.m2m.onousc.business.referentiel.dao.SiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.SoldeDaoJpa;
import com.m2m.onousc.business.referentiel.dao.TarifDaoJpa;
import com.m2m.onousc.business.referentiel.dao.TourniquetDaoJpa;
import com.m2m.onousc.business.referentiel.dao.TraceEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UniversiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.VilleDaoJpa;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
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
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class ReferentielsServiceImpl.
 * 
 * @version 1.0 21 oct. 2015
 * @author msadik
 */
@Service("referentielService")
public class ReferentielsServiceImpl implements ReferentielService, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4494664369254215370L;

	/** The canal vente dao jpa. */
	@Autowired
	private CanalVenteDaoJpa canalVenteDaoJpa;

	/** The universite dao jpa. */
	@Autowired
	private UniversiteDaoJpa universiteDaoJpa;

	/** The Site dao jpa. */
	@Autowired
	private SiteDaoJpa siteDaoJpa;

	@Autowired
	private DemandeAdminDaoJpa demandeAdminDaoJpa;

	/** The cite dao jpa. */
	@Autowired
	private CiteDaoJpa citeDaoJpa;

	/** The etudiantdao jp. */
	@Autowired
	private EtudiantDaoJpa etudiantdaoJp;

	/** The ville dao jpa. */
	@Autowired
	private VilleDaoJpa villeDaoJpa;

	/** The user entity dao jpa. */
	@Autowired
	private UserEntityDaoJpa userEntityDaoJpa;

	/** The jours ferie dao jpa. */
	@Autowired
	private JoursFerieDao joursFerieDaoJpa;

	/** The tarif dao jpa. */
	@Autowired
	private TarifDaoJpa tarifDaoJpa;

	/** The service dao jpa impl. */
	@Autowired
	private ServiceDaoJpa serviceDaoJpaImpl;

	/** The cycle vie dao jpa. */
	@Autowired
	private CycleVieDaoJpa cycleVieDaoJpa;

	/** The service dao jpa. */
	@Autowired
	private ServiceDaoJpa serviceDaoJpa;

	/** The caisse dao jpa. */
	@Autowired
	private CaisseDaoJpa caisseDaoJpa;

	/** The restaurant dao jpa. */
	@Autowired
	private RestaurantDaoJpa restaurantDaoJpa;

	@Autowired
	private FiliereDaoJpa filiereDaoJpa;

	@Autowired
	private ReservationBorneDaoJpa reservationBorneDao;

	/** The plafond dao jpa. */
	@Autowired
	private PlafondDaoJpa plafondDaoJpa;

	/** The annee universitaire dao jpa. */
	@Autowired
	private AnneeUniversitaireDaoJpa anneeUniversitaireDaoJpa;

	/** The motif opposition dao jpa. */
	@Autowired
	private MotifOppositionDaoJpa motifOppositionDaoJpa;

	/** The motif main levee dao jpa. */
	@Autowired
	private MotifMainLeveeDaoJpa motifMainLeveeDaoJpa;

	/** The categorie porteur dao jpa. */
	@Autowired
	private CategoriePorteurDaoJpa categoriePorteurDaoJpa;

	/** The parametre general dao jpa. */
	@Autowired
	private ParametreGeneralDaoJpa parametreGeneralDaoJpa;
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private WinMenuDaoJpa winMenuDaoJpa;

	@Autowired
	private MenuDaoJpa menuDaoJpa;

	@Autowired
	private OperationCaisseDaoJpa oparationDaoJpa;

	@Autowired
	private ConsultCaisseDaoJpa consultDaoJpa;

	@Autowired
	private GroupUserDaoJpa groupDaoJpa;

	@Autowired
	private TourniquetDaoJpa tourniquetDaoJpa;

	@Autowired
	private EquipementDaoJpa equipementDaoJpa;

	@Autowired
	private TraceEntityDaoJpa traceDaoJpa;

	@Autowired
	private CaissierDaoJpa caissierDaoJpa;

	@Autowired
	private CritereDaoJpa critereDaoJpa;

	@Autowired
	private NoteCritereDaoJpa noteCritereDaoJpa;

	@Autowired
	private BorneDaoJpa borneDaoJpa;

	@Autowired
	private ParametreGeneralDaoJpa paramdao;

	@Autowired
	private DelivranceDaoJpa delivranceDaoJpa;

	@Autowired
	private ClotureCaisseDaoJpa clotureCaisseDaoJpa;

	@Autowired
	private CarteDaoJpa carteDaoJpa;

	@Autowired
	private CarteNapsDaoJpa cartenapsDaoJpa;

	@Autowired
	private SoldeDaoJpa soldeDaoJpa;

	@Autowired
	private ProfilPorteurDaoJpa profilporteurDaoJpa;

	/*************************** Parte OCP ***********************************/

	@Autowired
	private PersonnelDaoJpa personnelDaoJpa;

	@Autowired
	private AdherentDaoJpa adherentDaoJpa;

	@Autowired
	private DetailProfilDaoJpa detailProfilDaoJpa;

	@Autowired
	private ControlAccesDaoJpa controlAccesDaoJpa;

	@Autowired
	private ProduitDaoJpa produitDaoJpa;

	@Autowired
	private EvenementDaoJpa evenementDaoJpa;

	@Autowired
	private ImportInscriptionDaoJpa importInscriptionDaoJpa;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCanalVenteByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria)
	 * 
	 * @return the list
	 */
	@Override
	public List<CanalVente> findCanalVenteByCriteria(CanalVenteCriteria criteria) {
		return canalVenteDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCanalVente (java.lang.Long)
	 */
	@Override
	public CanalVente findCanalVente(Long id) {
		return canalVenteDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllCanalVenteForCombo()
	 */
	@Override
	public List<CanalVente> findAllCanalVenteForCombo() {
		return canalVenteDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria)
	 */
	@Override
	public List<Etudiants> findByCriteria(EtudiantCriteria criteria) {
		List<Etudiants> etu = etudiantdaoJp.findByCriteria(criteria);
		// Collections.sort(etu);
		return etu;
	}

	@Override
	public List<Etudiants> findEtudiantByStatus(String status) {

		return etudiantdaoJp.findEtudiantByStatus(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findForCombo
	 * ()
	 */
	@Override
	public List<Etudiants> findForCombo() {

		return etudiantdaoJp.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findAllVille
	 * ()
	 */
	@Override
	public List<Ville> findAllVille() {
		String orderClause = " ORDER BY libelle ";
		return villeDaoJpa.findAllByOrder(orderClause);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findUniversiteByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.UniversiteCriteria)
	 */
	@Override
	public List<Universite> findUniversiteByCriteria(UniversiteCriteria criteria) {
		return universiteDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findUniversite
	 * (java.lang.Long)
	 */
	@Override
	public Universite findUniversite(Long id) {
		return universiteDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllUniversiteForCombo()
	 */
	@Override
	public List<Universite> findAllUniversiteForCombo() {
		return universiteDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCiteByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.CiteCriteria)
	 */
	@Override
	public List<Cite> findCiteByCriteria(CiteCriteria criteria) {
		return citeDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#findCite
	 * (java.lang.Long)
	 */
	@Override
	public Cite findCite(Long id) {
		return citeDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllCiteForCombo()
	 */
	@Override
	public List<Cite> findAllCiteForCombo() {
		return citeDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findJoursFerieByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria)
	 */
	@Override
	public List<JoursFerie> findJoursFerieByCriteria(JoursFerieCriteria criteria) {
		return joursFerieDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findJoursFerie
	 * (java.lang.Long)
	 */
	@Override
	public JoursFerie findJoursFerie(Long id) {
		return joursFerieDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllJoursFerieForCombo()
	 */
	@Override
	public List<JoursFerie> findAllJoursFerieForCombo() {
		return joursFerieDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findTarifByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.TarifCriteria)
	 */
	@Override
	public List<Tarif> findTarifByCriteria(TarifCriteria criteria) {
		return tarifDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#findTarif
	 * (java.lang.Long)
	 */
	@Override
	public Tarif findTarif(Long id) {
		return tarifDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllTarifForCombo()
	 */
	@Override
	public List<Tarif> findAllTarifForCombo() {
		return tarifDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findServiceByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.ServiceCriteria)
	 */
	@Override
	public List<com.m2m.onousc.business.referentiel.model.Service> findServiceByCriteria(ServiceCriteria criteria) {
		return serviceDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findService
	 * (java.lang.Long)
	 */
	@Override
	public com.m2m.onousc.business.referentiel.model.Service findService(Long id) {
		return serviceDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllServiceForCombo()
	 */
	@Override
	public List<com.m2m.onousc.business.referentiel.model.Service> findAllServiceForCombo() {
		return serviceDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCaisseByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.CaisseCriteria)
	 */
	@Override
	public List<Caisse> findCaisseByCriteria(CaisseCriteria criteria) {
		return caisseDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findAllUser ()
	 */
	@Override
	public List<UserEntity> findAllUser() {

		return userEntityDaoJpa.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findUserByCriteria(java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String,
	 * com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<UserEntity> findUserByCriteria(String firstName, String lastName, String username, String email,
			String statut, String group, SearchConfig config, String sortField, String sortOrder) {
		return userEntityDaoJpa.findByCriteria(firstName, lastName, username, email, statut, group, config, sortField,
				sortOrder);
	}

	@Override
	public List<UserEntity> findUserByCriteria(UserEntityCriteria userCriteria) {

		return userEntityDaoJpa.findByCriteria(userCriteria.getFirstName(), userCriteria.getLastName(),
				userCriteria.getUsername(), userCriteria.getEmail(), userCriteria.getStatutt(),
				userCriteria.getGroupname(), userCriteria.getSearchConfig(), userCriteria.getSortField(),
				userCriteria.getSortOrder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCycleVieCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria)
	 */
	@Override
	public List<CycleVie> findCycleVieCriteria(CycleVieCriteria criteria) {
		return cycleVieDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCycleVieForCombo()
	 */
	@Override
	public List<CycleVie> findByCycleVieByDate(Date dateDebut, Date dateFin) {
		return cycleVieDaoJpa.findByCycleVieByDate(dateDebut, dateFin);
	}

	@Override
	public List<Reservation> findByReservationByDate(Date dateDebut, Date dateFin) {
		return reservationService.findReservation(dateDebut, dateFin);
	}

	@Override
	public List<CycleVie> findCycleVieForCombo() {

		return cycleVieDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findEtudiant
	 * (java.lang.Long)
	 */
	@Override
	public Etudiants findEtudiant(Long id) {
		return etudiantdaoJp.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findServiceByCode(java.lang.String)
	 */
	@Override
	public com.m2m.onousc.business.referentiel.model.Service findServiceByCode(String code) {
		return serviceDaoJpaImpl.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findCaisse
	 * (java.lang.Long)
	 */
	@Override
	public Caisse findCaisse(Long id) {
		return caisseDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllCaisseForCombo()
	 */
	@Override
	public List<Caisse> findAllCaisseForCombo() {
		return caisseDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findRestaurantByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria)
	 */
	@Override
	public List<Restaurant> findRestaurantByCriteria(RestaurantCriteria criteria) {
		return restaurantDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findRestaurant
	 * (java.lang.Long)
	 */
	@Override
	public Restaurant findRestaurant(Long id) {
		return restaurantDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllRestaurantForCombo()
	 */
	@Override
	public List<Restaurant> findAllRestaurantForCombo() {
		return restaurantDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findPlafondByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.PlafondCriteria)
	 */
	@Override
	public List<Plafond> findPlafondByCriteria(PlafondCriteria criteria) {
		return plafondDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findPlafond
	 * (java.lang.Long)
	 */
	@Override
	public Plafond findPlafond(Long id) {
		return plafondDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllPlafondForCombo()
	 */
	@Override
	public List<Plafond> findAllPlafondForCombo() {
		return plafondDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAnneeUniversitaireByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.AnneeUniversitaireCriteria)
	 */
	@Override
	public List<AnneeUniversitaire> findAnneeUniversitaireByCriteria(AnneeUniversitaireCriteria criteria) {
		return anneeUniversitaireDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAnneeUniversitaire(java.lang.Long)
	 */
	@Override
	public AnneeUniversitaire findAnneeUniversitaire(Long id) {
		return anneeUniversitaireDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllAnneeUniversitaireForCombo()
	 */
	@Override
	public List<AnneeUniversitaire> findAllAnneeUniversitaireForCombo() {
		return anneeUniversitaireDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findUniversiteByCode(java.lang.String)
	 */
	@Override
	public List<Universite> findUniversiteByCode(String code) {
		return universiteDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findCiteByCode
	 * (java.lang.String)
	 */
	@Override
	public List<Cite> findCiteByCode(String code) {
		return citeDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findJoursFerieByCode(java.lang.String)
	 */
	@Override
	public List<JoursFerie> findJoursFerieByCode(String code) {
		return joursFerieDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findTarifByCode(java.lang.String)
	 */
	@Override
	public List<Tarif> findTarifByCode(String code) {
		return tarifDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCaisseByCode(java.lang.String)
	 */
	@Override
	public List<Caisse> findCaisseByCode(String code) {
		return caisseDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findPlafondByCode(java.lang.String)
	 */
	@Override
	public List<Plafond> findPlafondByCode(String code) {
		return plafondDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAnneUniversitaireByCode(java.lang.String)
	 */
	@Override
	public List<AnneeUniversitaire> findAnneUniversitaireByCode(String code) {
		return anneeUniversitaireDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#findVille
	 * (java.lang.Long)
	 */
	@Override
	public Ville findVille(Long id) {
		return villeDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifOppositionByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.MotifOppositionCriteria)
	 */
	@Override
	public List<MotifOpposition> findMotifOppositionByCriteria(MotifOppositionCriteria criteria) {
		return motifOppositionDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifOpposition(java.lang.Long)
	 */
	@Override
	public MotifOpposition findMotifOpposition(Long id) {
		return motifOppositionDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllMotifOppositionForCombo()
	 */
	@Override
	public List<MotifOpposition> findAllMotifOppositionForCombo() {
		return motifOppositionDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifOppositionByCode(java.lang.String)
	 */
	@Override
	public List<MotifOpposition> findMotifOppositionByCode(String code) {
		return motifOppositionDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifMainLeveeByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria)
	 */
	@Override
	public List<MotifMainLevee> findMotifMainLeveeByCriteria(MotifMainLeveeCriteria criteria) {
		return motifMainLeveeDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifMainLevee(java.lang.Long)
	 */
	@Override
	public MotifMainLevee findMotifMainLevee(Long id) {
		return motifMainLeveeDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllMotifMainLeveeForCombo()
	 */
	@Override
	public List<MotifMainLevee> findAllMotifMainLeveeForCombo() {
		return motifMainLeveeDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findMotifMainLeveeByCode(java.lang.String)
	 */
	@Override
	public List<MotifMainLevee> findMotifMainLeveeByCode(String code) {
		return motifMainLeveeDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCategoriePorteurByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.CategoriePorteurCriteria)
	 */
	@Override
	public List<CategoriePorteur> findCategoriePorteurByCriteria(CategoriePorteurCriteria criteria) {
		return categoriePorteurDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCategoriePorteur(java.lang.Long)
	 */
	@Override
	public CategoriePorteur findCategoriePorteur(Long id) {
		return categoriePorteurDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllCategoriePorteurForCombo()
	 */
	@Override
	public List<CategoriePorteur> findAllCategoriePorteurForCombo() {
		return categoriePorteurDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findCategoriePorteurByCode(java.lang.String)
	 */
	@Override
	public List<CategoriePorteur> findCategoriePorteurByCode(String code) {
		return categoriePorteurDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findParametreGeneralByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.ParametreGeneralCriteria)
	 */
	@Override
	public List<ParametreGeneral> findParametreGeneralByCriteria(ParametreGeneralCriteria criteria) {
		return parametreGeneralDaoJpa.findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findParametreGeneral(java.lang.Long)
	 */
	@Override
	public ParametreGeneral findParametreGeneral(Long id) {
		return parametreGeneralDaoJpa.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllParametreGeneralForCombo()
	 */
	@Override
	public List<ParametreGeneral> findAllParametreGeneralForCombo() {
		return parametreGeneralDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findParametreGeneralByCode(java.lang.String)
	 */
	@Override
	public List<ParametreGeneral> findParametreGeneralByCode(String code) {
		return parametreGeneralDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.ReferentielService#findUserByCode
	 * (java.lang.String)
	 */
	@Override
	public UserEntity findUserByCode(String code) {
		return userEntityDaoJpa.findByCode(code);
	}

	@Override
	public List<Restaurant> findRestaurantByLibelleCite(String libelle) {
		return restaurantDaoJpa.findByLibelleCite(libelle);
	}

	@Override
	public List<WinMenu> findWinMenuByCriteria(WinMenuCriteria winMenuCriteria) {
		return winMenuDaoJpa.findByCriteria(winMenuCriteria);
	}

	@Override
	public List<WinMenu> findWinMenuModule() {
		return winMenuDaoJpa.findModuleWinMenu();
	}

	@Override
	public List<Menu> findMenuByCritere(String code, String libelle, String abbrev) {
		return menuDaoJpa.findByCriteria(code, libelle, abbrev);
	}

	@Override
	public List<Menu> findMenuByCriteria(MenuCriteria criteria) {
		return menuDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<Caisse> findCaisseByLibelleCite(String libelle) {
		return caisseDaoJpa.findByLibelleCite(libelle);
	}

	@Override
	public List<Etudiants> findEtudiantsByLibelleCite(String libelle) {
		return etudiantdaoJp.findByLibelleCite(libelle);
	}

	@Override
	public List<GroupUser> findAllGroupe() {
		return groupDaoJpa.findAllGroupNotDeleted();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findRestaurantByCode(java.lang.String)
	 */
	@Override
	public Restaurant findRestaurantByCode(String code) {
		return restaurantDaoJpa.findByCode(code);
	}

	@Override
	public List<Tourniquet> findTourniquetByCriteria(TourniquetCriteria criteria) {
		return tourniquetDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Tourniquet findTourniquet(Long id) {
		return tourniquetDaoJpa.find(id);
	}

	@Override
	public List<Tourniquet> findAllTourniquetForCombo() {
		return tourniquetDaoJpa.findForCombo();
	}

	@Override
	public List<Tourniquet> findTourniquetByCode(String code) {
		return tourniquetDaoJpa.findByCode(code);
	}

	@Override
	public List<Equipement> findEquipementByCriteria(EquipementCriteria criteria) {
		return equipementDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Equipement findEquipement(Long id) {
		return equipementDaoJpa.find(id);
	}

	@Override
	public List<Equipement> findAllEquipementForCombo() {
		return equipementDaoJpa.findForCombo();
	}

	@Override
	public List<Equipement> findEquipementByCode(String code) {
		return equipementDaoJpa.findByCode(code);
	}

	@Override
	public List<TraceEntity> findTraceByCriteria(TraceEntityCriteria criteria) {
		return traceDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<Cite> findCiteByCodeUniversite(String code) {
		return citeDaoJpa.findByUniversite(code);
	}

	@Override
	public List<Restaurant> findRestaurantByCodeCite(String code) {
		return restaurantDaoJpa.findByCodeCite(code);
	}
	@Override
	public List<Restaurant> findRestaurantByCodeSite(Long code) {
		return restaurantDaoJpa.findByIdSite(code);
	}
	@Override
	public List<Caisse> findCaisseByCodeRestaurant(String code) {
		return caisseDaoJpa.findByCodeRestaurant(code);
	}

	@Override
	public List<Tarif> findTarifByCodeService(String code) {
		return tarifDaoJpa.findByCodeService(code);
	}

	@Override
	public List<Tarif> findTarifByCodeCategoriePorteur(String code) {
		return tarifDaoJpa.findByCodeCategoriePorteur(code);
	}

	@Override
	public List<Tourniquet> findTourniquetByCodeRestaurant(String code) {
		return tourniquetDaoJpa.findByCodeRestaurant(code);
	}

	@Override
	public List<Equipement> findEquipementByCodeCite(String code) {
		return equipementDaoJpa.findByCodeCite(code);
	}

	@Override
	public List<Equipement> findEquipementByCodeRestaurant(String code) {
		return equipementDaoJpa.findByCodeRestaurant(code);
	}

	@Override
	public List<JoursFerie> findJoursFerieByCodeAnneeUniversitaire(String code) {
		return joursFerieDaoJpa.findByCodeAnneeUniversitaire(code);
	}

	@Override
	public List<OperationCaisse> findOperationCaisseByCodeCaisse(String code) {
		return oparationDaoJpa.findByCodeCaisse(code);
	}

	@Override
	public List<ConsultCaisse> findConsultCaisseByCodeCaisse(String code) {
		return consultDaoJpa.findByCodeCaisse(code);
	}

	@Override
	public List<Etudiants> findEtudiantByCodeRestaurant(String code) {
		return etudiantdaoJp.findByCodeRestaurant(code);
	}

	@Override
	public List<Tarif> findTarifInReservationDetail(String code) {
		return tarifDaoJpa.findInReservationDetail(code);
	}

	@Override
	public List<Caissier> findCaissierByCriteria(CaissierCriteria criteria) {
		return caissierDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Caissier findCaissier(Long id) {
		return caissierDaoJpa.find(id);
	}

	@Override
	public List<Caissier> findAllCaissierForCombo() {
		return caissierDaoJpa.findForCombo();
	}

	@Override
	public List<Caissier> findCaissierByCode(String code) {
		return caissierDaoJpa.findByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#isFreeDay
	 * (java.util.Date)
	 */
	@Override
	public boolean isFreeDay(Date date) {
		return joursFerieDaoJpa.isFreeDay(date);
	}

	@Override
	public List<Critere> findCritereByCriteria(CritereCriteria criteria) {
		return critereDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Critere findCritere(Long id) {
		return critereDaoJpa.find(id);
	}

	@Override
	public List<Critere> findAllCritereForCombo() {
		return critereDaoJpa.findForCombo();
	}

	@Override
	public List<Critere> findCritereByCode(String code) {
		return critereDaoJpa.findByCode(code);
	}

	@Override
	public List<NoteCritere> findNoteCritereByCriteria(NoteCritereCriteria criteria) {
		return noteCritereDaoJpa.findByCriteria(criteria);
	}

	@Override
	public NoteCritere findNoteCritere(Long id) {
		return noteCritereDaoJpa.find(id);
	}

	@Override
	public List<NoteCritere> findAllNoteCritereForCombo() {
		return noteCritereDaoJpa.findForCombo();
	}

	@Override
	public List<NoteCritere> findNoteCritereByCode(String code) {
		return noteCritereDaoJpa.findByCode(code);
	}

	@Override
	public Borne findBorne(Long id) {
		return borneDaoJpa.find(id);
	}

	@Override
	public List<Borne> findAllBorneForCombo() {
		return borneDaoJpa.findForCombo();
	}

	@Override
	public List<Borne> findBorneByCode(String code) {
		return borneDaoJpa.findByCode(code);
	}

	@Override
	public List<Borne> findBorneBySite(Long idSite) {
		return borneDaoJpa.findBySite(idSite);
	}

	@Override
	public List<Borne> findBorneByCriteria(BorneCriteria criteria) {
		return borneDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<String> getDataConnection() {
		/*
		 * List<String> data = new ArrayList<String>();
		 * data.add(paramdao.findByCode("0001").get(0).getValeur());
		 * data.add(paramdao.findByCode("0002").get(0).getValeur());
		 * data.add(paramdao.findByCode("0003").get(0).getValeur());
		 * data.add(paramdao.findByCode("0004").get(0).getValeur());
		 */

		List<String> data = new ArrayList<String>();
		data.add(paramdao.findByCode("0001").get(0).getValeur());
		data.add(paramdao.findByCode("0003").get(0).getValeur());
		data.add(paramdao.findByCode("0004").get(0).getValeur());
		data.add(paramdao.findByCode("0005").get(0).getValeur());
		data.add(paramdao.findByCode("0006").get(0).getValeur());
		data.add(paramdao.findByCode("0007").get(0).getValeur());
		data.add(paramdao.findByCode("0008").get(0).getValeur());
		data.add(paramdao.findByCode("0009").get(0).getValeur());
		return data;
	}

	@Override
	public List<CycleVie> findCycleVieByCode(String code) {
		return cycleVieDaoJpa.findByCode(code);
	}

	@Override
	public List<Restaurant> findByCodeCite(String code) {
		return restaurantDaoJpa.findByCodeCite(code);
	}

	@Override
	public List<NoteCritere> findNoteCritereByCodeCritere(String code) {
		return noteCritereDaoJpa.findByCodeCritere(code);
	}

	@Override
	public AnneeUniversitaire findActuelAnneeUniversitaire() {
		return anneeUniversitaireDaoJpa.findActuelAnneeUniversitaire();
	}

	@Override
	public List<DelivranceCarte> findDelivByCriteria(DelivranceCriteria criteria) {

		return delivranceDaoJpa.findDelivByCriteria(criteria);
	}

	@Override
	public List<DelivranceCarte> findDelivForCombo() {

		return delivranceDaoJpa.findDelivForCombo();
	}

	@Override
	public List<ClotureCaisse> findByCriteria(ClotureCaisseCriteria criteria) {
		return clotureCaisseDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<Etudiants> findByCIN(String cin) {
		return etudiantdaoJp.findByCIN(cin);
	}

	@Override
	public Carte findCarteByEtud(Long id) {
		Carte carte = new Carte();
		carte = carteDaoJpa.find_Etud_ByCarte(id).get(0);
		return carte;
	}

	@Override
	public List<CycleVie> findCycleByDeliv(CycleVieCriteria criteria) {
		return cycleVieDaoJpa.findCycleByDeliv(criteria);
	}

	@Override
	public List<Carte> findCarteByCriteria(CarteCriteria criteria) {
		return carteDaoJpa.findCarteByCriteria(criteria);
	}

	@Override
	public String findMaxLotCarte(String code) {
		return carteDaoJpa.findMaxLotCarte(code);
	}

	@Override
	public List<Carte> findCarteByCriteria(LotCarteCriteria lotcriteria) {
		return carteDaoJpa.findLotCarteByCriteria(lotcriteria);
	}

	@Override
	public List<Carte> find_Carte_By_Lot(String code) {
		return carteDaoJpa.find_Carte_By_Lot(code);
	}

	/***********************************************************
	 * ******************************PARTIE OCP
	 ***********************************************************/

	@Override
	public List<Personnel> findPersonnelByCriteria(PersonnelCriteria criteria) {
		return personnelDaoJpa.findPersonnelByCriteria(criteria);
	}

	@Override
	public List<Adherent> findAdherentByCriteria(AdherentCriteria criteria) {
		return adherentDaoJpa.findAdherentByCriteria(criteria);
	}

	@Override
	public Personnel findPersonnelByMatr(String matr) {
		return personnelDaoJpa.findPersonnelByMatr(matr);
	}

	@Override
	public List<Personnel> findAllPersonnel() {
		return personnelDaoJpa.findAllPersonnel();
	}

	@Override
	public List<Adherent> findAllAdherent() {
		return adherentDaoJpa.findAllAdherent();
	}

	@Override
	public Personnel findPersonnel(Long id) {
		return personnelDaoJpa.find(id);
	}

	@Override
	public Adherent findAdherentByNom(String matr, String nom, String prenom) {
		return adherentDaoJpa.findAdherentByNom(matr, nom, prenom);
	}

	@Override
	public List<Adherent> findAdherentByPersonnel(Long id) {
		return adherentDaoJpa.findAdherentByPersonnel(id);
	}

	@Override
	public List<DetailProfilAcces> findDetailProfilByCriteria(DetailProfilCriteria criteria) {

		return detailProfilDaoJpa.findDetailProfilByCriteria(criteria);
	}

	@Override
	public List<String> getTrancheByProfil(String jour, Long profil) {
		return personnelDaoJpa.getTrancheByProfil(jour, profil);
	}

	@Override
	public List<ControlAcces> findControlAccesByCriteria(ControlAccesCriteria criteria) {
		return controlAccesDaoJpa.findControlAccesByCriteria(criteria);
	}

	@Override
	public List<Produit> findProduitByCriteria(ProduitCriteria criteria) {
		return produitDaoJpa.findProduitByCriteria(criteria);
	}

	@Override
	public void persisthisto(String matricule, Float montant, Float solde) {
		oparationDaoJpa.persisthisto(matricule, montant, solde);

	}

	@Override
	public List<Produit> findProduitByFamille(Long id) {
		// TODO Auto-generated method stub
		return produitDaoJpa.findProduitByFamille(id);
	}

	@Override
	public void persisthistoDecharge(String matricule, Float montant, Float solde) {
		oparationDaoJpa.persisthistoDecharge(matricule, montant, solde);

	}

	@Override
	public List<OperationCaisse> findOperationCaisseByCriteria(OperCaisseCriteria criteria) {
		return oparationDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<ConsultCaisse> findConsultCaisseByCriteria(ConsultCaisseCriteria criteria) {
		return consultDaoJpa.findByCriteria(criteria);
	}

	@Override
	public List<CanalVente> findAllCanalVenteByClient() {
		return canalVenteDaoJpa.findByCode();
	}

	@Override
	public List<CanalVente> findAllCanalVenteBySite(Long idSite) {
		return canalVenteDaoJpa.findBySite(idSite);
	}

	@Override
	public List<Adherent> findAdherentByAgeNscol(String matr) {
		return adherentDaoJpa.findAdherentByAgeNscol(matr);
	}

	@Override
	public List<Adherent> findAdherentByAgescol(String matr) {
		return adherentDaoJpa.findAdherentByAgescol(matr);
	}

	@Override
	public List<String> getDataMessagerie() {
		List<String> messagerie = new ArrayList<String>();
		messagerie.add(paramdao.findByCode("0012").get(0).getValeur());
		messagerie.add(paramdao.findByCode("0013").get(0).getValeur());
		messagerie.add(paramdao.findByCode("0014").get(0).getValeur());
		messagerie.add(paramdao.findByCode("0015").get(0).getValeur());

		return messagerie;

	}

	@Override
	public Produit findProduitByCodeBar(String codeBar) {
		return produitDaoJpa.findProduitByCodeBar(codeBar);
	}

	@Override
	public List<ControlAcces> findControlAccesAccesPrincip(ControlAccesCriteria criteria) {
		return controlAccesDaoJpa.findControlAccesAccesPrincip(criteria);
	}

	@Override
	public List<Evenement> findEvenementtByCriteria(EvenementCriteria criteria) {
		return evenementDaoJpa.findEvenementtByCriteria(criteria);
	}

	@Override
	public List<com.m2m.onousc.business.referentiel.model.Service> findByType(String type) {

		return serviceDaoJpaImpl.findByType(type);
	}

	@Override
	public void persistReservation(String libelle, Double montant) {
		serviceDaoJpa.persistReservation(libelle, montant);

	}

	@Override
	public void persistReservationDetail(com.m2m.onousc.business.referentiel.model.Service idService,
			Reservation reservation) {
		serviceDaoJpa.persistReservationDetail(idService, reservation);

	}

	@Override
	public void persistReserv(Reservation reservation) {
		serviceDaoJpa.persistReserv(reservation);

	}

	public void clear() {

	}

	@Override
	public DetailProfilAcces findDetailProfil(Long id) {

		return detailProfilDaoJpa.find(id);
	}

	@Override
	public List<DetailProfilAcces> findDetailProfilByprofil(String code) {
		// TODO Auto-generated method stub
		return detailProfilDaoJpa.findDetailProfilByprofil(code);
	}

	@Override
	public double findSoldeByMatricule(String matr) {
		return oparationDaoJpa.findSoldeByMatricule(matr);
	}

	@Override
	public UserEntity findUserEntityByCode(String code) {
		// TODO Auto-generated method stub
		return userEntityDaoJpa.findByCode(code);
	}

	@Override
	public List<Personnel> findOppositionPersoByCriteria(OppositionCriteria criteria) {
		return personnelDaoJpa.findOppositionPersoByCriteria(criteria);
	}

	@Override
	public List<Carte> findOppositionByCriteria(OppositionCriteria criteria) {
		return carteDaoJpa.findOppositionByCriteria(criteria);
	}

	@Override
	public List<Adherent> findOppositionAdhByCriteria(OppositionAdhCriteria criteria) {
		return adherentDaoJpa.findOppositionAdhByCriteria(criteria);
	}

	@Override
	public List<CarteNaps> findCarteNapsByCriteria(CarteNapsCriteria criteria) {
		return cartenapsDaoJpa.findCarteNapsByCriteria(criteria);
	}

	@Override
	public List<ProfilPorteur> findProfilPorteurByCriteria(ProfilPorteurCriteria criteria) {

		return profilporteurDaoJpa.findProfilPorteurByCriteria(criteria);
	}

	@Override
	public CarteNaps findCarteNapsByMatricule(String matr) {
		return cartenapsDaoJpa.findCarteNapsByMatricule(matr);
	}

	@Override
	public CarteNaps findCarteNapsByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solde> findSoldeByCriteria(SoldeCriteria criteria) {

		return soldeDaoJpa.findSoldeByCriteria(criteria);
	}

	@Override
	public List<Restaurant> findRestaurantByIdProduit(Long idProd) {
		return restaurantDaoJpa.findRestaurantByIdProduit(idProd);
	}

	@Override
	public Restaurant findRestaurantByLongId(Long id) {
		return restaurantDaoJpa.findRestaurantByLongId(id);
	}

	@Override
	public CanalVente findCanalVenteByCode(String code) {

		return canalVenteDaoJpa.findCanalByCode(code);
	}

	@Override
	public List<Caissier> findCaissierByNumcarte(String numcarte) {
		return caissierDaoJpa.findByNumcarte(numcarte);
	}

	@Override
	public List<CanalVente> findCanalListByCode(String code) {
		return canalVenteDaoJpa.findCanalListByCode(code);
	}

	@Override
	public List<Site> findSiteByCode(String code) {
		return siteDaoJpa.findSiteListByCode(code);
	}

	@Override
	public List<Produit> findProduitByCode(String code) {
		return produitDaoJpa.findProduitListByCode(code);
	}

	@Override
	public List<Restaurant> findRestaurantListByCode(String code) {
		return restaurantDaoJpa.findRestaurantListByCode(code);
	}

	@Override
	public List<Caisse> findCaisseListByCode(String code) {
		return caisseDaoJpa.findCaisseListByCode(code);
	}

	@Override
	public List<Caisse> findCaisseListByIdSite(Long idSite) {
		return caisseDaoJpa.findByIdSite(idSite);
	}

	@Override
	public GroupUser findGroupUserByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findUserByGroup(String group) {
		return userEntityDaoJpa.findUserByGroup(group);
	}

	@Override
	public List<Site> findSiteByCriteria(SiteCriteria criteria) {
		// TODO Auto-generated method stub
		return siteDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Site findSite(Long id) {
		return siteDaoJpa.find(id);
	}

	@Override
	public List<Site> findAllSite() {
		return siteDaoJpa.findAll();
	}

	@Override
	public List<Restaurant> findRestaurantByIdSite(Long idSite) {
		// TODO Auto-generated method stub
		return restaurantDaoJpa.findByIdSite(idSite);
	}

//	@Override
//	public GroupUser findGroupUserByID(long id) {
//		return groupDaoJpa.findGroupUserByID(id);
//	}	

	@Override
	public List<Filiere> findFiliereByIdSite(Long idSite) {
		// TODO Auto-generated method stub
		return filiereDaoJpa.findByIdSite(idSite);
	}

	@Override
	public List<Filiere> findFiliereByCriteria(FiliereCriteria criteria) {
		return filiereDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Filiere findFiliere(Long id) {
		return filiereDaoJpa.find(id);
	}

	@Override
	public List<Filiere> findAllFiliereForCombo() {
		return filiereDaoJpa.findForCombo();
	}

	@Override
	public Filiere findFiliereByCode(String code) {
		return filiereDaoJpa.findByCode(code);
	}

	@Override
	public Filiere findFiliereByLongId(Long id) {
		return filiereDaoJpa.findFiliereByLongId(id);
	}

	@Override
	public List<Filiere> findFiliereListByCode(String code) {
		return filiereDaoJpa.findFiliereListByCode(code);
	}

	@Override
	public Long findNbreEtudiantByStatus(EntityStatus status) {
		return etudiantdaoJp.findNbrByStatus(status);
	}

	@Override
	public List<ReservationBorne> findReservationBorneByCriteria(ReservationBorneCriteria criteria) {
		return reservationBorneDao.findByCriteria(criteria);
	}

	@Override
	public List<ImportInscription> findImportInscription(ImportCriteria criteria) {
		return importInscriptionDaoJpa.findByCriteria(criteria);
	}

	@Override
	public Etudiants findResidentStudentForInscription(String cin) {
		List<Etudiants> etudiants = etudiantdaoJp.findResidentStudentForInscription(cin);

		if (etudiants.size() > 0) {
			return etudiants.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Etudiants findResidentStudentForInscriptionByMassar(String codeMassar) {
		List<Etudiants> etudiants = etudiantdaoJp.findResidentStudentForInscriptionByMassar(codeMassar);

		if (etudiants.size() > 0) {
			return etudiants.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Carte> findToRefabricateByCriteria(EtudiantCriteria criteria) {
		List<Carte> etu = carteDaoJpa.findToRefabricateByCriteria(criteria);
		return etu;
	}

	@Override
	public Etudiants findEtudiantByMassar(String codeMassar) {

		return etudiantdaoJp.findEtudiantByMassar(codeMassar);
	}

	@Override
	public List<DemandeAdmin> findDemandeAdminByCriteria(DemandeAdminCriteria criteria) {
		return demandeAdminDaoJpa.findByCriteria(criteria);
	}

}
