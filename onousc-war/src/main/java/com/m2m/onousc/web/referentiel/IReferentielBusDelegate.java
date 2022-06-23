package com.m2m.onousc.web.referentiel;

import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.ImportInscriptionVO;
import com.m2m.onousc.business.referentiel.vo.InscriptionVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.web.referentiel.webbean.AdherentWebBean;
import com.m2m.onousc.web.referentiel.webbean.AnneeUniversitaireWebBean;
import com.m2m.onousc.web.referentiel.webbean.BorneWebBean;
import com.m2m.onousc.web.referentiel.webbean.CaisseWebBean;
import com.m2m.onousc.web.referentiel.webbean.CaissierWebBean;
import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CarteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CategoriePorteurWebBean;
import com.m2m.onousc.web.referentiel.webbean.CritereWebBean;
import com.m2m.onousc.web.referentiel.webbean.DetailProfilWebBean;
import com.m2m.onousc.web.referentiel.webbean.EquipementWebBean;
import com.m2m.onousc.web.referentiel.webbean.EtudiantWebBean;
import com.m2m.onousc.web.referentiel.webbean.CiteWebBean;
import com.m2m.onousc.web.referentiel.webbean.CycleVieWebBean;
import com.m2m.onousc.web.referentiel.webbean.DemandeAdminWebBean;
import com.m2m.onousc.web.referentiel.webbean.EvenementWebBean;
import com.m2m.onousc.web.referentiel.webbean.FiliereWebBean;
import com.m2m.onousc.web.referentiel.webbean.InscriptionWebBean;
import com.m2m.onousc.web.referentiel.webbean.JoursFerieWebBean;
import com.m2m.onousc.web.referentiel.webbean.MotifMainLeveeWebBean;
import com.m2m.onousc.web.referentiel.webbean.MotifOppositionWebBean;
import com.m2m.onousc.web.referentiel.webbean.NoteCritereWebBean;
import com.m2m.onousc.web.referentiel.webbean.OppositionAdhWebBean;
import com.m2m.onousc.web.referentiel.webbean.OppositionWebBean;
import com.m2m.onousc.web.referentiel.webbean.ParametreGeneralWebBean;
import com.m2m.onousc.web.referentiel.webbean.PersonnelWebBean;
import com.m2m.onousc.web.referentiel.webbean.PlafondWebBean;
import com.m2m.onousc.web.referentiel.webbean.ProduitWebBean;
import com.m2m.onousc.web.referentiel.webbean.ProfilPorteurWebBean;
import com.m2m.onousc.web.referentiel.webbean.RestaurantWebBean;
import com.m2m.onousc.web.referentiel.webbean.ServiceWebBean;
import com.m2m.onousc.web.referentiel.webbean.SiteWebBean;
import com.m2m.onousc.web.referentiel.webbean.SoldeWebBean;
import com.m2m.onousc.web.referentiel.webbean.TarifWebBean;
import com.m2m.onousc.web.referentiel.webbean.TourniquetWebBean;
import com.m2m.onousc.web.referentiel.webbean.UniversiteWebBean;
import com.m2m.technicalservices.core.User;

/**
 * The Interface IReferentielBusDelegate.
 */
public interface IReferentielBusDelegate {

	// canal vent
	/**
	 * Creer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean creerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Supprimer collection canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean supprimerCollectionCanalVente(CanalVenteWebBean webBean);

	/**
	 * Desactiver canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean desactiverCanalVente(CanalVenteWebBean webBean);

	/**
	 * Activer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean activerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Supprimer canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean supprimerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Modifier canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean modifierCanalVente(CanalVenteWebBean webBean);

	public boolean delivrer_Carte(CarteWebBean webBean);

	// Universite
	boolean creeUniversite(UniversiteWebBean webBean);

	boolean supprimerCollectionUniversite(UniversiteWebBean webBean);

	boolean desactiverUniversite(UniversiteWebBean webBean);

	boolean activerUniversite(UniversiteWebBean webBean);

	boolean supprimerUniversite(UniversiteWebBean webBean);

	boolean modifierUniversite(UniversiteWebBean webBean);

	// Cite
	boolean creeCite(CiteWebBean webBean);

	boolean supprimerCollectionCite(CiteWebBean webBean);

	boolean desactiverCite(CiteWebBean webBean);

	boolean activerCite(CiteWebBean webBean);

	boolean supprimerCite(CiteWebBean webBean);

	boolean modifierCite(CiteWebBean webBean);

	boolean creerEtudiant(EtudiantWebBean webBean);

	boolean supprimerEtudiant(EtudiantWebBean webBean);

	boolean supprimerCollectionEtudiant(EtudiantWebBean webBean);

	boolean modifierEtudiant(EtudiantWebBean webBean);

	boolean validerCollectionEtudiant(EtudiantWebBean webBean);

	// JoursFerie

	// Tarif

	// Tarif

	// Caisse
	boolean creerCaisse(CaisseWebBean webBean);

	boolean supprimerCollectionCaisse(CaisseWebBean webBean);

	boolean desactiverCaisse(CaisseWebBean webBean);

	boolean activerCaisse(CaisseWebBean webBean);

	boolean supprimerCaisse(CaisseWebBean webBean);

	boolean modifierCaisse(CaisseWebBean webBean);

	// Restaurant
	boolean creerRestaurant(RestaurantWebBean webBean);

	boolean supprimerCollectionRestaurant(RestaurantWebBean webBean);

	boolean desactiverRestaurant(RestaurantWebBean webBean);

	boolean activerRestaurant(RestaurantWebBean webBean);

	boolean supprimerRestaurant(RestaurantWebBean webBean);

	boolean modifierRestaurant(RestaurantWebBean webBean);

	// Plafond
	boolean creerPlafond(PlafondWebBean webBean);

	boolean supprimerCollectionPlafond(PlafondWebBean webBean);

	boolean desactiverPlafond(PlafondWebBean webBean);

	boolean activerPlafond(PlafondWebBean webBean);

	boolean supprimerPlafond(PlafondWebBean webBean);

	boolean modifierPlafond(PlafondWebBean webBean);

	// AnneeUniversitaire
	boolean creerAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	boolean supprimerCollectionAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	boolean desactiverAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	boolean activerAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	boolean supprimerAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	boolean modifierAnneeUniversitaire(AnneeUniversitaireWebBean webBean);

	// MotifOpposition
	boolean creerMotifOpposition(MotifOppositionWebBean webBean);

	boolean supprimerCollectionMotifOpposition(MotifOppositionWebBean webBean);

	boolean desactiverMotifOpposition(MotifOppositionWebBean webBean);

	boolean activerMotifOpposition(MotifOppositionWebBean webBean);

	boolean supprimerMotifOpposition(MotifOppositionWebBean webBean);

	boolean modifierMotifOpposition(MotifOppositionWebBean webBean);

	// MotifMainLevee
	boolean creerMotifMainLevee(MotifMainLeveeWebBean webBean);

	boolean supprimerCollectionMotifMainLevee(MotifMainLeveeWebBean webBean);

	boolean desactiverMotifMainLevee(MotifMainLeveeWebBean webBean);

	boolean activerMotifMainLevee(MotifMainLeveeWebBean webBean);

	boolean supprimerMotifMainLevee(MotifMainLeveeWebBean webBean);

	boolean modifierMotifMainLevee(MotifMainLeveeWebBean webBean);

	// CategoriePorteur
	boolean creerCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean supprimerCollectionCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean desactiverCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean activerCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean supprimerCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean modifierCategoriePorteur(CategoriePorteurWebBean webBean);

	boolean validateEtudiant(EtudiantWebBean webBean);

	boolean desactiverEtudiant(EtudiantWebBean webBean);

	boolean personnaliserEtudiant(EtudiantWebBean webBean);

	// JoursFerie
	boolean creerJoursFerie(JoursFerieWebBean webBean);

	boolean supprimerCollectionJoursFerie(JoursFerieWebBean webBean);

	boolean desactiverJoursFerie(JoursFerieWebBean webBean);

	boolean activerJoursFerie(JoursFerieWebBean webBean);

	boolean supprimerJoursFerie(JoursFerieWebBean webBean);

	boolean modifierJoursFerie(JoursFerieWebBean webBean);

	// Tarif
	boolean creerTarif(TarifWebBean webBean);

	boolean supprimerCollectionTarif(TarifWebBean webBean);

	boolean desactiverTarif(TarifWebBean webBean);

	boolean activerTarif(TarifWebBean webBean);

	boolean supprimerTarif(TarifWebBean webBean);

	boolean modifierTarif(TarifWebBean webBean);

	// Tarif
	boolean creerService(ServiceWebBean webBean);

	boolean supprimerCollectionService(ServiceWebBean webBean);

	boolean desactiverService(ServiceWebBean webBean);

	boolean activerService(ServiceWebBean webBean);

	boolean supprimerService(ServiceWebBean webBean);

	boolean modifierService(ServiceWebBean webBean);

	// ParametreGeneral
	boolean creerParametreGeneral(ParametreGeneralWebBean webBean);

	boolean supprimerCollectionParametreGeneral(ParametreGeneralWebBean webBean);

	boolean desactiverParametreGeneral(ParametreGeneralWebBean webBean);

	boolean activerParametreGeneral(ParametreGeneralWebBean webBean);

	boolean supprimerParametreGeneral(ParametreGeneralWebBean webBean);

	boolean modifierParametreGeneral(ParametreGeneralWebBean webBean);

	/**
	 * Modifier canal vente.
	 * 
	 * @param webBean the web bean
	 * @return true, if successful
	 */
	boolean delivrerCarte(CycleVieWebBean webBean);

	// Tourniquet
	boolean creerTourniquet(TourniquetWebBean webBean);

	boolean supprimerCollectionTourniquet(TourniquetWebBean webBean);

	boolean desactiverTourniquet(TourniquetWebBean webBean);

	boolean activerTourniquet(TourniquetWebBean webBean);

	boolean supprimerTourniquet(TourniquetWebBean webBean);

	boolean modifierTourniquet(TourniquetWebBean webBean);

	// Tourniquet
	boolean creerEquipement(EquipementWebBean webBean);

	boolean supprimerCollectionEquipement(EquipementWebBean webBean);

	boolean desactiverEquipement(EquipementWebBean webBean);

	boolean activerEquipement(EquipementWebBean webBean);

	boolean supprimerEquipement(EquipementWebBean webBean);

	boolean modifierEquipement(EquipementWebBean webBean);

	// Caissier
	boolean creeCaissier(CaissierWebBean webBean);

	boolean supprimerCollectionCaissier(CaissierWebBean webBean);

	boolean desactiverCaissier(CaissierWebBean webBean);

	boolean activerCaissier(CaissierWebBean webBean);

	boolean supprimerCaissier(CaissierWebBean webBean);

	boolean modifierCaissier(CaissierWebBean webBean);

	boolean personnaliserCaissier(CaissierWebBean webBean);

	// Critere
	boolean creeCritere(CritereWebBean webBean);

	boolean supprimerCritere(CritereWebBean webBean);

	boolean modifierCritere(CritereWebBean webBean);

	// NoteCritere
	boolean creeNoteCritere(NoteCritereWebBean webBean);

	boolean supprimerNoteCritere(NoteCritereWebBean webBean);

	boolean modifierNoteCritere(NoteCritereWebBean webBean);

	// Borne
	boolean creeBorne(BorneWebBean webBean);

	boolean supprimerBorne(BorneWebBean webBean);

	boolean modifierBorne(BorneWebBean webBean);

	boolean mettreEnOpposition(CycleVieWebBean webBean);

	boolean personnaliserCollectionEtudiant(EtudiantWebBean webBean);

	boolean delivrerCollectionCarte(CycleVieWebBean webBean);

	boolean delivrerCollectionCarte(CarteWebBean webBean);

	/**************************************
	 * PARTIE OCP
	 *****************************************************/

	boolean creerPersonnel(PersonnelWebBean webBean);

	boolean supprimerPersonnel(PersonnelWebBean webBean);

	boolean supprimerCollectionPersonnel(PersonnelWebBean webBean);

	boolean modifierPersonnel(PersonnelWebBean webBean);

	boolean modifierPersonnelMass(PersonnelVO vo);

	boolean validerCollectionPersonnel(PersonnelWebBean webBean);

	boolean validatePersonnel(PersonnelWebBean webBean);

	boolean desactiverPersonnel(PersonnelWebBean webBean);

	boolean personnaliserPersonnel(PersonnelWebBean webBean);

	boolean rechargerPersonnel(PersonnelWebBean webBean);

	/****************************** ADHERENT *****************************/
	boolean creerAdherent(AdherentWebBean webBean);

	boolean supprimerAdherent(AdherentWebBean webBean);

	boolean supprimerCollectionAdherent(AdherentWebBean webBean);

	boolean modifierAdherent(AdherentWebBean webBean);

	boolean validerCollectionAdherent(AdherentWebBean webBean);

	boolean validateAdherent(AdherentWebBean webBean);

	boolean desactiverAdherent(AdherentWebBean webBean);

	boolean personnaliserAdherent(AdherentWebBean webBean);

	/*******************************************************************/
	boolean creerDetailProfil(DetailProfilWebBean webBean);

	boolean supprimerCollectionDetailProfil(DetailProfilWebBean webBean);

	boolean supprimerDetailProfil(DetailProfilWebBean webBean);

	boolean modifierDetailProfil(DetailProfilWebBean webBean);

	/*******************************************************************/
	boolean creerProduit(ProduitWebBean webBean);

	boolean supprimerCollectionProduit(ProduitWebBean webBean);

	boolean supprimerProduit(ProduitWebBean webBean);

	boolean modifierProduit(ProduitWebBean webBean);

	boolean modifierStatusProduit(ProduitWebBean webBean);

	boolean creerEvenement(EvenementWebBean webBean);

	boolean supprimerCollectionEvenement(EvenementWebBean webBean);

	boolean supprimerEvenement(EvenementWebBean webBean);

	boolean modifierEvenement(EvenementWebBean webBean);

	boolean mettreCartePersoEnOpposition(OppositionWebBean webBean);

	boolean cartePersoMainLevee(OppositionWebBean webBean);

	boolean validatePersonnelOp(PersonnelWebBean webBean);

	boolean validateAdherentOp(AdherentWebBean webBean);

	boolean mettreCarteAdhEnOpposition(OppositionAdhWebBean webBean);

	boolean carteAdhMainLevee(OppositionAdhWebBean webBean);

	boolean creerCarteNaps(CarteNapsVO vo, User user);

	boolean creerProfilPorteur(ProfilPorteurWebBean webBean);

	boolean modifierProfilPorteur(ProfilPorteurWebBean webBean);

	boolean supprimerProfilPorteur(ProfilPorteurWebBean webBean);

	boolean ajoutMassImportPerso(CarteNapsVO vo);

	boolean creerPersoFromCarteNaps(PersonnelVO vo);

	boolean modifierCarteNaps(CarteNapsVO vo);

	boolean creerSite(SiteWebBean webBean);

	boolean modifierSite(SiteWebBean webBean);

	boolean supprimerSite(SiteWebBean webBean);

	boolean creerFiliere(FiliereWebBean webBean);

	boolean modifierFiliere(FiliereWebBean webBean);

	boolean supprimerFiliere(FiliereWebBean webBean);

	boolean applyRnvEtudiant(EtudiantWebBean webBean);

	boolean creerMonitoringEchange(InscriptionWebBean webBean);

	boolean creerInscription(List<InscriptionVO> list, User user);

	boolean creerImportInscription(List<ImportInscriptionVO> list, User user);

	boolean creerEtudiantByInscription(List<EtudiantVO> list, User user);

	boolean mettreCarteEnOpposition(OppositionWebBean webBean);

	boolean carteMainLevee(OppositionWebBean webBean);

	boolean refabriquerCarte(CarteWebBean webBean);

	boolean rejeterDemandeAdmin(DemandeAdminWebBean webBean);

	boolean validerDemandeAdmin(DemandeAdminWebBean webBean);

	boolean AddSolde(SoldeWebBean webBean);

}
