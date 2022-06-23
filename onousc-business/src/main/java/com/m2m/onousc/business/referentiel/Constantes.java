/*
 * Constantes.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel;

// TODO: Auto-generated Javadoc
/**
 * The Interface Constantes.
 * 
 * @version 1.0 19 mars 2015
 * @author msadik
 */
public interface Constantes {

	/** The referentiel. */

	String REFERENTIEL = "REFERENTIEL";

	// *************************** commands
	// *****************************************************************
	// **************************************la valeur de la constantes
	// correspond au nom de la classe UC*******

	// Canal Vente
	/** The command gerer canal vente. */
	String COMMAND_GERER_CANAL_VENTE = "GererCanalVente";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_CANAL_VENTE = "creerCanalVente";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_CANAL_VENTE = "editerCanalVente";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_CANAL_VENTE = "supprimerCanalVente";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CANAL_VENTE = "supprimerCollectionCanalVente";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_CANAL_VENTE = "activerCanalVente";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_CANAL_VENTE = "desactiverCanalVente";

	// Compte
	/** The command gerer compte. */
	String COMMAND_GERER_COMPTE = "GererCompte";

	/** The sous command creer compte. */
	String SOUS_COMMAND_CREER_COMPTE = "creerCompte";

	// Site
	/** The command gerer site. */
	String COMMAND_GERER_SITE = "GererSite";

	/** The sous command creer site. */
	String SOUS_COMMAND_CREER_SITE = "creerSite";

	/** The sous command editer site. */
	String SOUS_COMMAND_EDITER_SITE = "editerSite";

	/** The sous command supprimer site */
	String SOUS_COMMAND_SUPPRIMER_SITE = "supprimerSite";

	// ETUDIANT
	/** The command gerer Etudiant. */
	String COMMAND_GERER_ETUDIANT = "GererEtudiant";

	/** The sous command creer Etudiant. */
	String SOUS_COMMAND_CREER_ETUDIANT = "creerEtudiant";

	/** The sous command editer Etudiant. */
	String SOUS_COMMAND_EDITER_ETUDIANT = "editerEtudiant";

	/** The sous command supprimer Etudiant. */
	String SOUS_COMMAND_SUPPRIMER_ETUDIANT = "supprimerEtudiant";

	/** The sous command activer Etudiant. */
	String SOUS_COMMAND_ACTIVER_ETUDIANT = "activerEtudiant";

	/** The sous command desactiver Etudiant. */
	String SOUS_COMMAND_DESACTIVER_ETUDIANT = "desactiverEtudiant";

	String SOUS_COMMAND_APPLY_RENEWAL = "appliquerRenouvellement";

	String SOUS_COMMAND_VALIDATE_ETUDIANT_RNV = "valideretudiantrnv";

	// String SOUS_COMMAND_SUPPRIMER_COLLECTION_ETUDIANT =
	// "supprimerCollectionEtudiant";
	/** The sous command validate etudiant. */
	String SOUS_COMMAND_VALIDATE_ETUDIANT = "valideretudiant";
	// String SOUS_COMMAND_SUPPRIMER_COLLECTION_ETUDIANT =
	/** The sous command validate etudiant. */
	String SOUS_COMMAND_VALIDATE_COLLECTION_ETUDIANT = "validerCollectionEtudiant";

	// "supprimerCollectionEtudiant";
	/** The sous command supprimer collection etudiant. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_ETUDIANT = "supprimerCollectionEtudiant";

	/** The sous command personnaliser etudiant. */
	String SOUS_COMMAND_PERSONNALISER_ETUDIANT = "Personnaliseretudiant";

	String SOUS_COMMAND_PERSONNALISER_COLLECTION_ETUDIANT = "PersonnaliserCollectionetudiant";

	// DEMANDE_ADMIN ENTITY

	String COMMAND_GERER_DEMANDE_ADMIN = "GererDemandeAdmin";

	String SOUS_COMMAND_VALIDER_DEMANDE_ADMIN = "validerDemandeAdmin";

	String SOUS_COMMAND_REJETER_DEMANDE_ADMIN = "rejeterDemandeAdmin";

	// USER ENTITY
	/** The command gerer user. */
	String COMMAND_GERER_USER = "GererUser";

	/** The sous command creer user. */
	String SOUS_COMMAND_CREER_USER = "creerUser";

	/** The sous command editer user. */
	String SOUS_COMMAND_EDITER_USER = "editerUser";

	/** The sous command supprimer user. */
	String SOUS_COMMAND_SUPPRIMER_USER = "supprimerUser";

	// Universite
	/** The command gerer universite. */
	String COMMAND_GERER_UNIVERSITE = "GererUniversite";

	/** The sous command creer universite. */
	String SOUS_COMMAND_CREER_UNIVERSITE = "creerUniversite";

	/** The sous command editer nationalite. */
	String SOUS_COMMAND_EDITER_UNIVERSITE = "editerUniversite";

	/** The sous command supprimer universite. */
	String SOUS_COMMAND_SUPPRIMER_UNIVERSITE = "supprimerUniversite";

	/** The sous command activer nationalite. */
	// String SOUS_COMMAND_ACTIVER_UNIVERSITE = "activerUniversite";
	/** The sous command activer universite. */
	String SOUS_COMMAND_ACTIVER_UNIVERSITE = "activerUniversite";

	/** The sous command desactiver universite. */
	String SOUS_COMMAND_DESACTIVER_UNIVERSITE = "desactiverUniversite";

	/** The sous command supprimer collection universite. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_UNIVERSITE = "supprimerCollectionUniversite";

	// Cite
	/** The command gerer cite. */
	String COMMAND_GERER_CITE = "GererCite";

	/** The sous command creer cite. */
	String SOUS_COMMAND_CREER_CITE = "creerCite";

	/** The sous command editer cite. */
	String SOUS_COMMAND_EDITER_CITE = "editerCite";

	/** The sous command supprimer cite. */
	String SOUS_COMMAND_SUPPRIMER_CITE = "supprimerCite";

	/** The sous command activer cite. */
	String SOUS_COMMAND_ACTIVER_CITE = "activerCite";

	/** The sous command desactiver cite. */
	String SOUS_COMMAND_DESACTIVER_CITE = "desactiverCite";

	/** The sous command supprimer collection cite. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CITE = "supprimerCollectionCite";

	// JoursFerie
	/** The command gerer joursFerie. */
	String COMMAND_GERER_JOURS_FERIE = "GererJoursFerie";

	/** The sous command creer joursFerie. */
	String SOUS_COMMAND_CREER_JOURS_FERIE = "creerJoursFerie";

	/** The sous command editer joursFerie. */
	String SOUS_COMMAND_EDITER_JOURS_FERIE = "editerJoursFerie";

	/** The sous command supprimer joursFerie. */
	String SOUS_COMMAND_SUPPRIMER_JOURS_FERIE = "supprimerJoursFerie";

	/** The sous command activer joursFerie. */
	String SOUS_COMMAND_ACTIVER_JOURS_FERIE = "activerJoursFerie";

	/** The sous command desactiver joursFerie. */
	String SOUS_COMMAND_DESACTIVER_JOURS_FERIE = "desactiverJoursFerie";

	/** The sous command supprimer collection joursFerie. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_JOURS_FERIE = "supprimerCollectionJoursFerie";

	// Tarif
	/** The command gerer tarif. */
	String COMMAND_GERER_TARIF = "GererTarif";

	/** The sous command creer tarif. */
	String SOUS_COMMAND_CREER_TARIF = "creerTarif";

	/** The sous command editer tarif. */
	String SOUS_COMMAND_EDITER_TARIF = "editerTarif";

	/** The sous command supprimer tarif. */
	String SOUS_COMMAND_SUPPRIMER_TARIF = "supprimerTarif";

	/** The sous command desactiver cite. */
	String SOUS_COMMAND_DESACTIVER_TARIF = "desactiverTarif";
	/** The sous command activer tarif. */
	String SOUS_COMMAND_ACTIVER_TARIF = "activerTarif";

	/** The sous command supprimer collection cite. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_TARIF = "supprimerCollectionTarif";
	// JoursFerie
	/** The command gerer cite. */
	String COMMAND_GERER_SERVICE = "GererService";

	/** The sous command creer cite. */
	String SOUS_COMMAND_CREER_SERVICE = "creerService";

	/** The sous command editer cite. */
	String SOUS_COMMAND_EDITER_SERVICE = "editerService";

	/** The sous command supprimer cite. */
	String SOUS_COMMAND_SUPPRIMER_SERVICE = "supprimerService";

	/** The sous command activer cite. */
	String SOUS_COMMAND_ACTIVER_SERVICE = "activerService";

	/** The sous command desactiver cite. */
	String SOUS_COMMAND_DESACTIVER_SERVICE = "desactiverService";

	/** The sous command supprimer collection cite. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_SERVICE = "supprimerCollectionService";

	// Cycle de Vie **************************************************//

	// ETUDIANT
	/** The command gerer CycleVie. */
	String COMMAND_GERER_CYCLE_VIE = "GererCycleVie";

	/** The sous command creer CycleVie. */
	String SOUS_COMMAND_CREER_CYCLE_VIE = "creerCycleVie";

	/** The sous command editer CycleVie. */
	String SOUS_COMMAND_EDITER_CYCLE_VIE = "editerCycleVie";

	/** The sous command supprimer CycleVie. */
	String SOUS_COMMAND_SUPPRIMER_CYCLE_VIE = "supprimerCycleVie";

	/** The sous command activer CycleVie. */
	String SOUS_COMMAND_ACTIVER_CYCLE_VIE = "activerCycleVie";

	/** The sous command desactiver CycleVie. */
	String SOUS_COMMAND_DESACTIVER_CYCLE_VIE = "desactiverCycleVie";

	/** The sous command supprimer collection cycle vie. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CYCLE_VIE = "supprimerCycleVie";

	/** The sous command validate cycle vie. */
	String SOUS_COMMAND_VALIDATE_CYCLE_VIE = "validerCycleVie";

	/** The sous command personnaliser cycle vie. */
	String SOUS_COMMAND_DELIVRER_CYCLE_VIE = "delivrerCycleVie";

	/** The sous command deliver collection cycleVie. */
	String SOUS_COMMAND_DELIVRER_COLLECTION_CYCLE_VIE = "delivrerCollectionCycleVie";

	String SOUS_COMMAND_METTRE_EN_OPPOSITION = "metterEnOpposition";

	//
	/** The command gerer caisse. */
	String COMMAND_GERER_CAISSE = "GererCaisse";

	/** The sous command creer caisse. */
	String SOUS_COMMAND_CREER_CAISSE = "creerCaisse";

	/** The sous command editer caisse. */
	String SOUS_COMMAND_EDITER_CAISSE = "editerCaisse";

	/** The sous command supprimer caisse. */
	String SOUS_COMMAND_SUPPRIMER_CAISSE = "supprimerCaisse";

	/** The sous command activer caisse. */
	String SOUS_COMMAND_ACTIVER_CAISSE = "activerCaisse";

	/** The sous command desactiver caisse. */
	String SOUS_COMMAND_DESACTIVER_CAISSE = "desactiverCaisse";

	/** The sous command supprimer collection caisse. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CAISSE = "supprimerCollectionCaisse";

	// Restaurant
	/** The command gerer restaurant. */
	String COMMAND_GERER_RESTAURANT = "GererRestaurant";

	/** The sous command creer restaurant. */
	String SOUS_COMMAND_CREER_RESTAURANT = "creerRestaurant";

	/** The sous command editer restaurant. */
	String SOUS_COMMAND_EDITER_RESTAURANT = "editerRestaurant";

	/** The sous command supprimer restaurant. */
	String SOUS_COMMAND_SUPPRIMER_RESTAURANT = "supprimerRestaurant";

	/** The sous command activer restaurant. */
	String SOUS_COMMAND_ACTIVER_RESTAURANT = "activerRestaurant";

	/** The sous command desactiver restaurant. */
	String SOUS_COMMAND_DESACTIVER_RESTAURANT = "desactiverRestaurant";

	/** The sous command supprimer collection restaurant. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_RESTAURANT = "supprimerCollectionRestaurant";

	// Plafond
	/** The command gerer plafond. */
	String COMMAND_GERER_PLAFOND = "GererPlafond";

	/** The sous command creer plafond. */
	String SOUS_COMMAND_CREER_PLAFONDT = "creerPlafond";

	/** The sous command editer plafond. */
	String SOUS_COMMAND_EDITER_PLAFOND = "editerPlafond";

	/** The sous command supprimer plafond. */
	String SOUS_COMMAND_SUPPRIMER_PLAFOND = "supprimerPlafond";

	/** The sous command activer plafond. */
	String SOUS_COMMAND_ACTIVER_PLAFOND = "activerPlafond";

	/** The sous command desactiver plafond. */
	String SOUS_COMMAND_DESACTIVER_PLAFOND = "desactiverPlafond";

	/** The sous command supprimer collection restaurant. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_PLAFOND = "supprimerCollectionPlafond";

	// Annee Universitaire
	/** The command gerer anneeUniversitaire. */
	String COMMAND_GERER_ANNEE_UNIVERSITAIRE = "GererAnneeUniversitaire";
	/** The command gerer anneeUniversitaire. */
	// String COMMAND_GERER_ANNEE_UNIVERSITAIRE = "GererAnneeUniversitaire";

	/** The sous command creer anneeUniversitaire. */
	String SOUS_COMMAND_CREER_ANNEE_UNIVERSITAIRE = "creerAnneeUniversitaire";

	/** The sous command editer anneeUniversitaire. */
	String SOUS_COMMAND_EDITER_ANNEE_UNIVERSITAIRE = "editerAnneeUniversitaire";

	/** The sous command supprimer anneeUniversitaire. */
	String SOUS_COMMAND_SUPPRIMER_ANNEE_UNIVERSITAIRE = "supprimerAnneeUniversitaire";

	/** The sous command activer anneeUniversitaire. */
	String SOUS_COMMAND_ACTIVER_ANNEE_UNIVERSITAIRE = "activerAnneeUniversitaire";

	/** The sous command desactiver anneeUniversitaire. */
	String SOUS_COMMAND_DESACTIVER_ANNEE_UNIVERSITAIRE = "desactiverAnneeUniversitaire";

	/** The sous command supprimer collection anneeUniversitaire. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_ANNEE_UNIVERSITAIRE = "supprimerCollectionAnneeUniversitaire";

	// MotifOpposition
	/** The command gerer motifOpposition. */
	String COMMAND_GERER_MOTIF_OPPOSITION = "GererMotifOpposition";

	/** The sous command creer anneeUniversitaire. */
	String SOUS_COMMAND_CREER_MOTIF_OPPOSITION = "creerMotifOpposition";

	/** The sous command editer anneeUniversitaire. */
	String SOUS_COMMAND_EDITER_MOTIF_OPPOSITION = "editerMotifOpposition";

	/** The sous command supprimer anneeUniversitaire. */
	String SOUS_COMMAND_SUPPRIMER_MOTIF_OPPOSITION = "supprimerMotifOpposition";

	/** The sous command activer anneeUniversitaire. */
	String SOUS_COMMAND_ACTIVER_MOTIF_OPPOSITION = "activerMotifOpposition";

	/** The sous command desactiver anneeUniversitaire. */
	String SOUS_COMMAND_DESACTIVER_MOTIF_OPPOSITION = "desactiverMotifOpposition";

	/** The sous command supprimer collection anneeUniversitaire. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_MOTIF_OPPOSITION = "supprimerCollectionMotifOpposition";

	// MotifMainLevee
	/** The command gerer motifMainLevee. */
	String COMMAND_GERER_MOTIF_MAIN_LEVEE = "GererMotifMainLevee";

	/** The sous command creer motifMainLevee. */
	String SOUS_COMMAND_CREER_MOTIF_MAIN_LEVEE = "creerMotifMainLevee";

	/** The sous command editer motifMainLevee. */
	String SOUS_COMMAND_EDITER_MOTIF_MAIN_LEVEE = "editerMotifMainLevee";

	/** The sous command supprimer motifMainLevee. */
	String SOUS_COMMAND_SUPPRIMER_MOTIF_MAIN_LEVEE = "supprimerMotifMainLevee";

	/** The sous command activer motifMainLevee. */
	String SOUS_COMMAND_ACTIVER_MOTIF_MAIN_LEVEE = "activerMotifMainLevee";

	/** The sous command desactiver motifMainLevee. */
	String SOUS_COMMAND_DESACTIVER_MOTIF_MAIN_LEVEE = "desactiverMotifMainLevee";

	/** The sous command supprimer collection motifMainLevee. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_MOTIF_MAIN_LEVEE = "supprimerCollectionMotifMainLevee";

	// CategoriePorteur
	/** The command gerer categoriePorteur. */
	String COMMAND_GERER_CATEGORIE_PORTEUR = "GererCategoriePorteur";

	/** The sous command creer categoriePorteur. */
	String SOUS_COMMAND_CREER_CATEGORIE_PORTEUR = "creerCategoriePorteur";

	/** The sous command editer categoriePorteur. */
	String SOUS_COMMAND_EDITER_CATEGORIE_PORTEUR = "editerCategoriePorteur";

	/** The sous command supprimer categoriePorteur. */
	String SOUS_COMMAND_SUPPRIMER_CATEGORIE_PORTEUR = "supprimerCategoriePorteur";

	/** The sous command activer categoriePorteur. */
	String SOUS_COMMAND_ACTIVER_CATEGORIE_PORTEUR = "activerCategoriePorteur";

	/** The sous command desactiver categoriePorteur. */
	String SOUS_COMMAND_DESACTIVER_CATEGORIE_PORTEUR = "desactiverCategoriePorteur";

	/** The sous command supprimer collection categoriePorteur. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CATEGORIE_PORTEUR = "supprimerCollectionCategoriePorteur";

	// ParametreGeneral
	/** The command gerer parametreGeneral. */
	String COMMAND_GERER_PARAMETRE_GENERAL = "GererParametreGeneral";

	/** The sous command creer parametreGeneral. */
	String SOUS_COMMAND_CREER_PARAMETRE_GENERAL = "creerParametreGeneral";

	/** The sous command editer parametreGeneral. */
	String SOUS_COMMAND_EDITER_PARAMETRE_GENERAL = "editerParametreGeneral";

	/** The sous command supprimer parametreGeneral. */
	String SOUS_COMMAND_SUPPRIMER_PARAMETRE_GENERAL = "supprimerParametreGeneral";

	/** The sous command activer parametreGeneral. */
	String SOUS_COMMAND_ACTIVER_PARAMETRE_GENERAL = "activerParametreGeneral";

	/** The sous command desactiver parametreGeneral. */
	String SOUS_COMMAND_DESACTIVER_PARAMETRE_GENERAL = "desactiverParametreGeneral";

	/** The sous command supprimer collection parametreGeneral. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_PARAMETRE_GENERAL = "supprimerCollectionParametreGeneral";

	/** The command gerer reservatione. */
	String COMMAND_GERER_RESERVATIONE = "GererReservation";

	/** The sous command creer reservation. */
	String SOUS_COMMAND_CREER_RESERVATION = "creerReservation";

	/** The command gerer user entity. */
	String COMMAND_GERER_USER_ENTITY = "GererUserEntity";

	/** The sous command creer user entity. */
	String SOUS_COMMAND_CREER_USER_ENTITY = "creerUserEntity";

	/** The sous command modifier user entity. */
	String SOUS_COMMAND_MODIFIER_USER_ENTITY = "modifierUserEntity";

	/** The sous command supprimer user entity. */
	String SOUS_COMMAND_SUPPRIMER_USER_ENTITY = "supprimerUserEntity";

	/** The sous command supprimer user entity. */
	String SOUS_COMMAND_CHANGEPWD_USER_ENTITY = "changerPWDUserEntity";

	/** The command gerer win menu. */
	String COMMAND_GERER_WIN_MENU = "GererWinMenu";

	/** The sous command modifier win menu. */
	String SOUS_COMMAND_MODIFIER_WIN_MENU = "modifierWinMenu";

	/** The sous command creer win menu. */
	String SOUS_COMMAND_CREER_WIN_MENU = "creerWinMenu";

	/** The sous command supprimer win menu. */
	String SOUS_COMMAND_SUPPRIMER_WIN_MENU = "supprimerWinMenu";

	/** The command gerer menu. */
	String COMMAND_GERER_MENU = "GererMenu";

	/** The sous commande creer menu. */
	String SOUS_COMMANDE_CREER_MENU = "CreerMenu";

	/** The sous commande modifier menu. */
	String SOUS_COMMANDE_MODIFIER_MENU = "ModifierMenu";

	/** The sous commande supprimer menu. */
	String SOUS_COMMANDE_SUPPRIMER_MENU = "SupprimerMenu";

	/** The sous command annuler reservation. */
	String SOUS_COMMAND_ANNULER_RESERVATION = "annulerReservation";

	// Tourniquet
	/** The command gerer canal vente. */
	String COMMAND_GERER_TOURNIQUET = "GererTourniquet";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_TOURNIQUET = "creerTourniquet";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_TOURNIQUET = "editerTourniquet";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_TOURNIQUET = "supprimerTourniquet";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_TOURNIQUET = "supprimerCollectionTourniquet";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_TOURNIQUET = "activerTourniquet";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_TOURNIQUET = "desactiverTourniquet";

	// Equipement
	/** The command gerer canal vente. */
	String COMMAND_GERER_EQUIPEMENT = "GererEquipement";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_EQUIPEMENT = "creerEquipement";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_EQUIPEMENT = "editerEquipement";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_EQUIPEMENT = "supprimerEquipement";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_EQUIPEMENT = "supprimerCollectionEquipement";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_EQUIPEMENT = "activerEquipement";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_EQUIPEMENT = "desactiverEquipement";

	// Caissier
	/** The command gerer Caissier. */
	String COMMAND_GERER_CAISSIER = "GererCaissier";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_CAISSIER = "creerCaissier";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_CAISSIER = "editerCaissier";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_PERSONNALISER_CAISSIER = "personnaliserCaissier";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_CAISSIER = "supprimerCaissier";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CAISSIER = "supprimerCollectionCaissier";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_CAISSIER = "activerCaissier";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_CAISSIER = "desactiverCaissier";

	// Critere
	/** The command gerer canal vente. */
	String COMMAND_GERER_CRITERE = "GererCritere";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_CRITERE = "creerCritere";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_CRITERE = "editerCritere";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_CRITERE = "supprimerCritere";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_CRITERE = "supprimerCollectionCritere";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_CRITERE = "activerCritere";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_CRITERE = "desactiverCritere";

	// NoteCritere
	/** The command gerer canal vente. */
	String COMMAND_GERER_NOTE_CRITERE = "GererNoteCritere";

	/** The sous command creer canal vente. */
	String SOUS_COMMAND_CREER_NOTE_CRITERE = "creerNoteCritere";

	/** The sous command editer canal vente. */
	String SOUS_COMMAND_EDITER_NOTE_CRITERE = "editerNoteCritere";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_NOTE_CRITERE = "supprimerNoteCritere";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_NOTE_CRITERE = "supprimerCollectionNoteCritere";

	/** The sous command activer canal vente. */
	String SOUS_COMMAND_ACTIVER_NOTE_CRITERE = "activerNoteCritere";

	/** The sous command desactiver canal vente. */
	String SOUS_COMMAND_DESACTIVER_NOTE_CRITERE = "desactiverNoteCritere";

	// Borne
	String COMMAND_GERER_BORNE = "GererBorne";

	String SOUS_COMMAND_CREER_BORNE = "creerBorne";

	String SOUS_COMMAND_SUPPRIMER_BORNE = "supprimerBorne";

	String SOUS_COMMAND_EDITER_BORNE = "editerBorne";

	/** The command gerer user. */
	String COMMAND_GERER_CARTE = "GererCarte";
	String COMMAND_GERER_SOLDE = "GererSolde";
	String SOUS_COMMAND_METTRE_AJOURS = "MAJ";
	/** The sous command creer user. */
	String SOUS_COMMAND_DELIVRER_LOT = "deliverLot";

	// Code Ecran
	// ADMINISTRATION
	String CODE_ADM_USER_ENTITY = "000001";
	//
	String CODE_ADM_WIN_MENU = "000012";
	String CODE_ADM_WIN_MENUG = "000013";
	String CODE_ADM_LOG_TRA = "000014";
	// CONSULTATION SOLDE
	String CODE_REF_CONSULT_SOLDE = "000002";
	// GESTION PROFIL PORTEUR
	String CODE_REF_CAT_PORT = "000003";
	// IMPORT PERSONNEL
	String CODE_IMP_PERSO_IMP = "000004";
	//
	String CODE_IMP_PERSO_LIST = "000041";
	String CODE_IMP_PERSO_REJET = "0000042";
	// OPPOSITION PERSONNEL
	String CODE_OPPO_PERSO = "000005";
	// GESTION RESTAURANT
	String CODE_REF_RESTAURANT = "000006";
	//
	String CODE_REF_CAISSE = "000061";
	String CODE_REF_CAISSIER = "000062";
	// CONSULTATION DES OPERATIONS
	String CODE_REF_CONSLT_OPERATION = "000007";
	// GESTION DES VENTES
	String CODE_GESTION_VENTES_FPROD = "000008";
	//
	String CODE_GESTION_VENTES_PROD = "000081";
	// GESTION DES ENROLEMENTS
	String CODE_GESTION_ENROL_M = "000009";
	//
	String CODE_GESTION_MODIF_M = "000091";
	// ENROLLEMENT PERSONNEL
	String CODE_ENROL_P = "000011";
	//
	String CODE_ENROL_M = "000112";

//	String CODE_REF_ANNEE_UNIV = "000111"; 
//	String CODE_REF_GESTION_UNIV = "000211"; 
//	String CODE_REF_CITE = "000311"; 
//	String CODE_REF_REST = "000411"; 
//	
//	String CODE_REF_JF = "000611"; 
//	String CODE_REF_PLAF = "000121"; 
//	String CODE_REF_GSERV = "000221"; 
//	String CODE_REF_TARIF = "000321"; 
//	String CODE_REF_TOURNIQUET = "000071"; 
//	String CODE_REF_EQUIPEMENT = "000081"; 
//	String CODE_REF_CRITERE_MERETE = "000091"; 
//	String CODE_ENR_ET = "000012"; 
//	String CODE_ENR_CYV = "000013"; 
//	String CODE_ENR_DEL = "000032"; 
//	String CODE_ENR_LOT = "000042"; 
//	String CODE_RES = "000003"; 
//	String CODE_SUIVI = "000004"; 
//	String CODE_SUIVI_CONS_AGC = "000014"; 
//	String CODE_SUIVI_CONS_RES = "000024"; 
//	String CODE_SUIVI_CONS_SYN = "000034"; 
//	String CODE_CONS_SYN_RES = "000044"; 
//	String CODE_SUIVI_CONS_PAL = "000054"; 
//	String CODE_ADM = "000005"; 
//	String CODE_DEL = "000006"; 
//	String CODE_EDI = "000008"; 
//	String CODE_EDI_CARTE = "000018"; 
//	String CODE_EDI_RESERVATION = "000038"; 
//	String CODE_EDI_DEMANDE = "000048"; 
//	String CODE_REF_NOTE_CRITERE = "000291"; 
//	
//	String CODE_REF_MLV = "000041"; 
//	String CODE_REF_OPP = "000031"; 
//	String CODE_REF_PARAM = "000061"; 
//	String CODE_SUIVI_TAB_BORD = "000028"; 

//	String CODE_ADM_USER_ENTITY = "000061";
//	String CODE_ADM_WIN_MENU = "000063";
//	String CODE_ADM_WIN_MENUG = "000062";
//	String CODE_ADM_LOG_TRA = "000064";
//	String CODE_REF_ANNEE_UNIV = "000011";
//	String CODE_REF_GESTION_UNIV = "000211";
//	String CODE_REF_CITE = "000012";
//	String CODE_REF_REST = "000013";
//	String CODE_REF_CAISSE = "000181";
//	String CODE_REF_JF = "000141";
//	String CODE_REF_GREVE = "000142";
//	String CODE_REF_PLAF = "000151";
//	String CODE_REF_GSERV = "000152";
//	String CODE_REF_TARIF = "000153";
//	String CODE_REF_TOURNIQUET = "000071";
//	String CODE_REF_EQUIPEMENT = "000018";
//	String CODE_REF_CRITERE_MERETE = "000019";
//	String CODE_ENR_ET = "000002";
//	String CODE_ENR_CYV = "000022";
//	String CODE_ENR_DEL = "000032";
//	String CODE_ENR_LOT = "000042";
//	String CODE_RES = "000003";
//	String CODE_SUIVI = "000004";
//	String CODE_SUIVI_CONS_AGC = "000014";
//	String CODE_SUIVI_CONS_RES = "000024";
//	String CODE_SUIVI_CONS_SYN = "000034";
//	String CODE_CONS_SYN_RES = "000044";
//	String CODE_SUIVI_CONS_PAL = "000054";
//	String CODE_ADM = "000005";
//	String CODE_DEL = "000006";
//	String CODE_EDI = "000007";
//	String CODE_EDI_CARTE = "000018";
//	String CODE_EDI_RESERVATION = "000038";
//	String CODE_EDI_DEMANDE = "000048";
//	String CODE_REF_NOTE_CRITERE = "000192";
//	String CODE_REF_CAT_PORT = "000051";
//	String CODE_REF_MLV = "000162";
//	String CODE_REF_OPP = "000161";
//	String CODE_REF_PARAM = "000016";
//	String CODE_SUIVI_TAB_BORD = "000028";

	/**************************************************************************************************************
	 *************************************** PARTIE OCP**********************************************************
	 */

	/** The command gerer Personnel. */
	String COMMAND_GERER_PERSONNEL = "GererPersonnel";

	/** The sous command creer Personnel. */
	String SOUS_COMMAND_CREER_PERSONNEL = "creerPersonnel";

	/** The command gerer Personnel opposed. */
	String COMMAND_GERER_PERSONNEL_OPP = "GererPersonnel";

	/** The sous command creer Personnel opposed. */
	String SOUS_COMMAND_VALIDATE_PERSONNEL_OPP = "validerPersonnelOp";

	String SOUS_COMMAND_METTRE_PERSONNEL_OPP = "mettrePersonnelOp";

	/** The sous command editer Personnel. */
	String SOUS_COMMAND_EDITER_PERSONNEL = "editerPersonnel";

	/** The sous command supprimer Personnel. */
	String SOUS_COMMAND_SUPPRIMER_PERSONNEL = "supprimerPersonnel";

	/** The sous command activer Personnel. */
	String SOUS_COMMAND_ACTIVER_PERSONNEL = "activerPersonnel";

	/** The sous command desactiver Personnel. */
	String SOUS_COMMAND_DESACTIVER_PERSONNEL = "desactiverPersonnel";

	/** The sous command validate Personnel. */
	String SOUS_COMMAND_VALIDATE_PERSONNEL = "validerPersonnel";

	/** The sous command validate Personnel. */
	String SOUS_COMMAND_VALIDATE_COLLECTION_PERSONNEL = "validerCollectionPersonnel";

	// "supprimerCollectionEtudiant";
	/** The sous command supprimer collection Personnel. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_PERSONNEL = "supprimerCollectionPersonnel";

	/** The sous command personnaliser Personnel. */
	String SOUS_COMMAND_PERSONNALISER_PERSONNEL = "PersonnaliserPersonnel";

	String SOUS_COMMAND_PERSONNALISER_COLLECTION_PERSONNEL = "PersonnaliserCollectionPersonnel";

	String SOUS_COMMAND_RECHARGER_PERSONNEL = "rechargerPersonnel";

	/*******************************************
	 * ADHERENT
	 *******************************************************/

	/** The command gerer Adherent. */
	String COMMAND_GERER_ADHERENT = "GererAdherent";

	/** The sous command creer Adherent. */
	String SOUS_COMMAND_CREER_ADHERENT = "creerAdherent";

	/** The sous command editer Adherent. */
	String SOUS_COMMAND_EDITER_ADHERENT = "editerAdherent";

	/** The sous command supprimer Adherent. */
	String SOUS_COMMAND_SUPPRIMER_ADHERENT = "supprimerAdherent";

	/** The sous command activer Adherent. */
	String SOUS_COMMAND_ACTIVER_ADHERENT = "activerAdherent";

	/** The sous command desactiver Adherent. */
	String SOUS_COMMAND_DESACTIVER_ADHERENT = "desactiverAdherent";

	/** The sous command validate Adherent. */
	String SOUS_COMMAND_VALIDATE_ADHERENT = "validerAdherent";

	/** The sous command validate Adherent. */
	String SOUS_COMMAND_VALIDATE_COLLECTION_ADHERENT = "validerCollectionAdherent";

	// "supprimerCollectionEtudiant";
	/** The sous command supprimer collection Adherent. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_ADHERENT = "supprimerCollectionAdherent";

	/** The sous command personnaliser Adherent. */
	String SOUS_COMMAND_PERSONNALISER_ADHERENT = "PersonnaliserAdherent";

	/** The sous command validat oppo Adherent. */
	String SOUS_COMMAND_VALIDATE_ADHERENT_OPP = "validerOppAdherent";

	/** The sous command mettre oppo Adherent. */
	String SOUS_COMMAND_METTRE_ADHERENT_OPP = "mettreOppAdherent";

	/** The sous command main lever oppo Adherent. */
	String SOUS_COMMAND_CARTE_ADH_MAIN_LEVEE = "mainleverOppAdherent";

	String SOUS_COMMAND_PERSONNALISER_COLLECTION_ADHERENT = "PersonnaliserCollectionAdherent";

	/**********************************************************************************/
	/** The command gerer DetailProfil. */
	String COMMAND_GERER_DETAILPROFIL = "GererDetailProfil";

	/** The sous command creer DetailProfil. */
	String SOUS_COMMAND_CREER_DETAILPROFIL = "creerDetailProfil";

	/** The sous command editer DetailProfil. */
	String SOUS_COMMAND_EDITER_DETAILPROFIL = "editerDetailProfil";

	/** The sous command supprimer canal vente. */
	String SOUS_COMMAND_SUPPRIMER_DETAILPROFIL = "supprimerDetailProfil";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_DETAILPROFIL = "supprimerCollectionDetailProfil";

	// Produit
	/** The command gerer Produit. */
	String COMMAND_GERER_PRODUIT = "GererProduit";

	/** The sous command creer Produit. */
	String SOUS_COMMAND_CREER_PRODUIT = "creerProduit";

	/** The sous command editer Produit. */
	String SOUS_COMMAND_EDITER_PRODUIT = "editerProduit";

	/** The sous command supprimer Produit. */
	String SOUS_COMMAND_SUPPRIMER_PRODUIT = "supprimerProduit";

	/** The sous command supprimer collection canal vente. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_PRODUIT = "supprimerCollectionProduit";

	// Evenement
	/** The command gerer Evenemet. */
	String COMMAND_GERER_EVENEMENT = "GererEvenement";

	/** The sous command creer Evenement. */
	String SOUS_COMMAND_CREER_EVENEMENT = "creerEvenement";

	/** The sous command editer Evenement. */
	String SOUS_COMMAND_EDITER_EVENEMENT = "editerEvenement";

	/** The sous command supprimer Evenement. */
	String SOUS_COMMAND_SUPPRIMER_EVENEMENT = "supprimerEvenement";

	/** The sous command supprimer collection Evenement. */
	String SOUS_COMMAND_SUPPRIMER_COLLECTION_EVENEMENT = "supprimerCollectionProduit";

	String SOUS_COMMAND_METTRE_CARTE_PERSO_EN_OPPOSITION = "metterCartePersoEnOpposition";
	String SOUS_COMMAND_CARTE_PERSO_MAIN_LEVEE = "cartePersoMainLevee";

	String COMMAND_GERER_CARTENAPS = "gererCarteNaps";
	String SOUS_COMMAND_CREER_CARTENAPS = "creerCarteNaps";
	String SOUS_COMMAND_MODIFIER_CARTENAPS = "editerCarteNaps";

	String COMMAND_GERER_PROFIL_PORTEUR = "GererProfilPorteur";
	String SOUS_COMMAND_CREER_PROFIL_PORTEUR = "creerProfilPorteur";
	String SOUS_COMMAND_EDITER_PROFIL_PORTEUR = "editerProfilPorteur";
	String SOUS_COMMAND_SUPPRIMER_PROFIL_PORTEUR = "supprimerProfilPorteur";

	/** The command gerer user entity. */
	String COMMAND_GERER_GROUP_USER = "GererGroupUser";

	/** The sous command creer group user. */
	String SOUS_COMMAND_CREER_GROUP_USER = "creerGroupUser";

	/** The sous command modifier group user. */
	String SOUS_COMMAND_MODIFIER_GROUP_USER = "modifierGroupUser";

	/** The sous command supprimer group user. */
	String SOUS_COMMAND_SUPPRIMER_GROUP_USER = "supprimerGroupUser";

	// Site
	/** The command gerer site. */
	String COMMAND_GERER_FILIERE = "GererFiliere";

	/** The sous command creer site. */
	String SOUS_COMMAND_CREER_FILIERE = "creerFiliere";

	/** The sous command editer site. */
	String SOUS_COMMAND_EDITER_FILIERE = "editerFiliere";

	/** The sous command supprimer site */
	String SOUS_COMMAND_SUPPRIMER_FILIERE = "supprimerFiliere";

	String ENROLEMENT = "ENROLEMENT";

	String COMMAND_GERER_MONITORING_ECHANGE = "GererMonitoringEchange";
	String SOUS_COMMAND_CREER_MONITORING_ECHANGE = "CreerMonitoringEchange";

	String COMMAND_GERER_INSCRIPTION = "GererInscription";
	String SOUS_COMMAND_CREER_INSCRIPTION = "CreerInscription";

	String COMMAND_GERER_IMPORT_INSCRIPTION = "GererImportInscription";
	String SOUS_COMMAND_IMPORT_INSCRIPTION = "CreerImportInscription";

	String COMMAND_GERER_ETUDIANT_INSCRIPTION = "GererEtudiantInscription";
	String SOUS_COMMAND_CREER_ETUDIANT_INSCRIPTION = "CreerEtudiantInscription";

	/** The command gerer opposition. */
	String SOUS_COMMAND_METTRE_CARTE_EN_OPPOSITION = "metterCarteEnOpposition";

	String SOUS_COMMAND_CARTE_MAIN_LEVEE = "carteMainLevee";

	String SOUS_COMMAND_REFABRIQUER_CARTE = "refabriquerCarte";

}