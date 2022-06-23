/*
 * Queries.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.Etudiants;

/**
 * The Interface Queries.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenbouker
 */
public interface Queries {

	String FIND_USER_BY_GROUP = "SELECT x From   UserEntity x " + " where (?1 is null  or  x.groupname = ?1)"
			+ "  and  (x.statut !='DELETED')";

	/** The group user queries. */

	String FIND_ONLY_GROUP_BY_CRITERIA = " From   GroupUser   x  " + "  where  (?1 is null  or  x.groupname like ?1)"
			+ "  and  (x.statut !='DELETED')";

	String FIND_ALL_GROUP_NOT_DELETED = " From   GroupUser   x  " + "  where x.statut !='DELETED'";

	String FIND_GROUP_USER_BY_LIBELLE = "SELECT x From   GroupUser x " + " where (?1 is null  or  x.id = ?1)"
			+ "  and  (x.statut !='DELETED')";

	// Canaux Vente
	/** The find canal vente by criteria. */
	String FIND_CANAL_VENTE_BY_CRITERIA = "From CanalVente x inner join x.site site where (?1 is null or site.id like ?1)"
			+ " and (?2 is null or upper(x.libelle) like upper(?2))" + "and  x.statut !='DELETED' ";

	/** The find all canal vente for combo. */
	String FIND_ALL_CANAL_VENTE_FOR_COMBO = "SELECT x FROM  CanalVente x WHERE x.statut = 'ENABLED' ";

	/** The find canal vente by code. */
	String FIND_CANAL_VENTE_BY_CODE = "SELECT x FROM  CanalVente x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find canal vente by code. */
	String FIND_CANAL_VENTE_BY_CLIENT = "SELECT x FROM  CanalVente x WHERE x.statut != 'DELETED' ";

	String FIND_CANAL_VENTE_BY_SITE = "SELECT x FROM  CanalVente x inner join x.site site where (?1 is null or site.id like ?1) and x.statut != 'DELETED' ";

	// Universite
	// String FIND_UNIVERSITE_BY_CRITERIA =
	// "From Universite x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null )"
	// +" and ( UPPER(x.adresseUniv) like UPPER(?2) or ?2 is null ) "
	// +" and (?3 is null or UPPER(x.nomResponsableUniv) like UPPER(?3))"
	// +" and (?4 is null or UPPER(x.prenomResponsableUniv) like UPPER(?4))"
	// +" and (?5 is null or UPPER(x.numTeleUniv) like UPPER(?5))"
	// +" and (?6 is null or UPPER(x.adresseEmailUniv) like UPPER(?6))"
	// +" and ( ?7 is null or x.statut = ?7 ) and x.statut !='DELETED' ";

	/** The find universite by code. */
	// String FIND_UNIVERSITE_BY_CODE =
	// "SELECT x FROM Universite x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_UNIVERSITE_FOR_COMBO =
	// "SELECT x FROM Universite x WHERE x.statut = 'ENABLED' ";

	// Site
	/** The find Site by criteria. */
	String FIND_SITE_BY_CRITERIA = "From Site x where x.libelle = ?1 or ?1 is null and x.statut = 'ENABLED' ";
//			+ " and  x.statut !='DELETED' ";

	/** The find all Site for combo. */
	String FIND_ALL_SITE_FOR_COMBO = "SELECT x FROM  Site x WHERE x.statut = 'ENABLED' ";

	/** The find Site by code. */
	String FIND_SITE_BY_CODE = "SELECT x FROM  Site x WHERE x.code like ?1 and x.statut = 'ENABLED'";

	String FIND_ALL_RESTAURANT_BY_PRODUIT = "Select distinct fil FROM CanalVente x inner join x.restaurant fil where (?1 is null or x.id = ?1)";

	/** The find cite by code. */
	// String FIND_CITE_BY_CODE =
	// "SELECT x FROM Cite x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_CITE_FOR_COMBO =
	// "FROM Cite x WHERE x.statut = 'ENABLED' ";
	String FIND_UNIVERSITE_BY_CRITERIA = "From Universite x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and ( UPPER(x.adresseUniv) like UPPER(?3) or ?3 is null ) "
			+ " and (?4 is null or UPPER(x.nomResponsableUniv) like UPPER(?4))"
			+ " and (?5 is null or UPPER(x.prenomResponsableUniv) like UPPER(?5))"
			+ " and (?6 is null or UPPER(x.numTeleUniv) like UPPER(?6))"
			+ " and (?7 is null or UPPER(x.adresseEmailUniv) like UPPER(?7))"
			+ " and (?8 is null or UPPER(x.ville.libelle) like UPPER(?8))"
			+ " and (  ?9 is null or x.statut = ?9  ) and  x.statut !='DELETED' ";

	/** The find universite by code. */
	String FIND_UNIVERSITE_BY_CODE = "SELECT x FROM Universite x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_UNIVERSITE_FOR_COMBO = "SELECT x FROM  Universite x WHERE x.statut = 'ENABLED' ";

	// Cite
	/** The find cite by criteria. */
	String FIND_CITE_BY_CRITERIA = "From Cite x where (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + " and (?3 is null or UPPER(x.universite.libelle) like UPPER(?3))"
			+ " and (?4 is null or x.adresseCite like UPPER(?4))"
			+ " and (?5 is null or UPPER(x.nomResponsableCite) like UPPER(?5))"
			+ " and (?6 is null or UPPER(x.prenomResponsableCite) like UPPER(?6))"
			+ " and (?7 is null or UPPER(x.numTeleCite) like UPPER(?7))"
			+ " and (?8 is null or UPPER(x.adresseEmailCite) like UPPER(?8))"
			+ " and (?9 is null or UPPER(x.ville.libelle) like UPPER(?9))"
			+ " and (?10 is null or x.statut like ?10) and  x.statut !='DELETED' ";

	/** The find cite by code. */
	String FIND_CITE_BY_CODE = "SELECT x FROM Cite x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_CITE_FOR_COMBO = "SELECT x FROM  Cite x WHERE x.statut = 'ENABLED' ";

	/** The find demande by criteria. */
	String FIND_DEMANDE_BY_CRITERIA = " FROM  Etudiants x  inner join  x.site  s left join x.restaurant r  WHERE "
			+ "  (?1 is null or x.ann_universitaire = ?1 )" + " and  (?2 is null or x.Ndemande like ?2)"
			+ " and  (?3 is null or x.Nom like ?3)" + " and  (?4 is null or x.Prenom like ?4)"
			+ " and  (?5 is null or x.NCIN like ?5)" + " and  (?6 is null or x.Boursier = ?6)"
			+ " and  (?7 is null or x.Email like ?7)" + " and  (?8 is null or x.Resident = ?8)"
			+ " and  (?9 is null or x.Etablissement like ?9)" + " and  (?10 is null or x.statut like ?10)"
			+ " and  (?11 is null or s.id  = ?11)" + " and  (?12 is null or r.id  = ?12)";
//			+ " and  (x.statut != 'DELETED' )";

	/** The find all etudiant for combo. */
	String FIND_ALL_ETUDIANT_FOR_COMBO = "SELECT x FROM  Etudiants x WHERE  x.statut <> 'CLOSED' ";

	/** The find demandee by criteria. */
	String FIND_DEMANDEE_BY_CRITERIA = "FROM  Etudiants x WHERE " + "  (?1 is null )"
			+ "  and (?2 is null or x.Ndemande like ?2)" + " and  (?3 is null or x.Nom like ?3)" + " and  (?4 is null )"
			+ " and  (?5 is null )" + " and  (?6 is null )" + " and  (?7 is null )" + " and  (?8 is null )"
			+ " and  (?9 is null)" + " and  (x.statut <> 'DELETED' )";

	/** The find all etudiant by status. */
	String FIND_ALL_ETUDIANT_BY_STATUS = "FROM  Etudiants x  WHERE" + " (?1 is null or x.statut like ?1)";
	// **********************************************//

	/** The find user by criteria. */
	String FIND_USER_BY_CRITERIA = " From   UserEntity   x    where     " + "  (?1 is null  or  x.firstName like ?1)"
			+ "  and (?2 is null  or  x.lastName like ?2)" + "  and (?3 is null   or  x.username like ?3)"
			+ "  and (?4 is null  or  x.email like ?4)" + " and  (?5 is null  or  x.statut like ?5)"
			+ " and  (?6 is null  or  x.groupname like ?6)" + "  and  (x.statut <> 'DELETED')";

	/** The find all user. */
	String FIND_ALL_USER = " From   UserEntity   x    where     " + "  (x.statut not like 'DELETED')";

	/** The find user not admin. */
	String FIND_USER_NOT_ADMIN = " From   UserEntity   x    where     " + "   (x.username <> 'ADMINIST')";

	String FIND_ETUDIANT_BY_CIN = "  FROM Etudiants  x  WHERE  x.NCIN like ?1 and x.statut <> 'CLOSED'";

	String FIND_NB_ETUDIANT_BY_STATUS = "SELECT COUNT(x) FROM Etudiants  x  WHERE" + " x.statut like ?1";

	/**
	 * ***************************************** CYCLE VIE
	 * *********************************************.
	 */

	String FIND_CYCLE_VIE__BY_CRITERIA = " FROM  CycleVie x  inner join  x.numPorteur  e WHERE "
			+ "  (?1 is null or x.numSerie like ?1 )" + " and  (?2 is null or x.operation like ?2)"
			+ " and  (?3 is null or x.dateOperation = ?3)" + " and  (?4 is null or x.operateur like ?4)"
			+ " and  (?5 is null or x.statut like ?5)" + " and  (?6 is null or e.id  = ?6)"
			+ " and  (?7 is null or e.NCIN  = ?7)" + " and  (?8 is null or e.codeMassar  = ?8)"
			+ " and (?9 is null or e.site.id like ?9)" + " and  (x.statut <> 'DELETED' )";

	/** The find cycle vie by date. */
	String FIND_CYCLE_VIE__BY_DATE = " FROM  CycleVie x  inner join  x.numPorteur  e    WHERE "
			+ " (?1 is null or x.dateOperation >= ?1)" + " and  (?2 is null or x.dateOperation <= ?2)"
			+ " and  (x.statut != 'DELETED' )" + "and  (x.operation != 'ENCOURS' ) " + " order by x.operation";

	/** The find all cyclevie for combo. */
	String FIND_ALL_CYCLEVIE_FOR_COMBO = "SELECT x FROM  CycleVie x WHERE x.statut = 'ENABLED' ";

	/** The find reservation by date. */
	String FIND_RESERVATION__BY_DATE = " FROM  Reservation x  WHERE " + " (?1 is null or x.dateOperation >= ?1)"
			+ " and  (?2 is null or x.dateOperation <= ?2)" + " and x.etat = 'NON_CONSOMEE' ";

	// + " order by x.etat";
	// + " order by x.dateOperation"

	/**
	 * *************************************************************************
	 * *********************************.
	 */

	// Jours ferie
	// String FIND_JOURS_FERIE_BY_CRITERIA =
	// "From JoursFerie x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null )"
	// +" and ( x.date_debut = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.date_fin = ?3)"
	// +" and (?4 is null or YEAR(x.date_debut) =?4)"
	// +" and (?5 is null or x.statut = ?5 ) and x.statut !='DELETED' ";

	/** The find universite by code. */
	// String FIND_JOURS_FERIE_BY_CODE =
	// "SELECT x FROM JoursFerie x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_JOURS_FERIE_FOR_COMBO =
	// "SELECT x FROM JoursFerie x WHERE x.statut = 'ENABLED' ";

	// Tarif
	// String FIND_TARIF_BY_CRITERIA =
	// "From Tarif x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null )"
	// +" and ( x.tarif = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.statut = ?3 ) and x.statut !='DELETED' ";

	/** The find universite by code. */
	// String FIND_TARIF_BY_CODE =
	// "SELECT x FROM Tarif x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_TARIF_FOR_COMBO =
	// "SELECT x FROM Tarif x WHERE x.statut = 'ENABLED' ";

	// Service
	// String FIND_SERVICE_BY_CRITERIA =
	// "From Service x where (?1 is null or UPPER(x.libelle) like UPPER(?1))"
	// +" and ( x.date_debut = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.date_fin = ?3)"
	// +" and (?4 is null or x.tarif.libelle = ?4)"
	// +" and (?5 is null or x.statut like ?5) and x.statut !='DELETED' ";
	/** The find universite by code. */
	// String FIND_SERVICE_BY_CODE =
	// "SELECT x FROM Service x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_SERVICE_FOR_COMBO =
	// "SELECT x FROM Service x WHERE x.statut = 'ENABLED' ";

	// Jours ferie
	// String FIND_JOURS_FERIE_BY_CRITERIA =
	// "From JoursFerie x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null )"
	// +" and ( x.date_debut = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.date_fin = ?3)"
	// +" and (?4 is null or YEAR(x.date_debut) =?4)"
	// +" and (?5 is null or x.statut = ?5 ) and x.statut !='DELETED' ";

	/** The find universite by code. */
	// String FIND_JOURS_FERIE_BY_CODE =
	// "SELECT x FROM JoursFerie x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_JOURS_FERIE_FOR_COMBO =
	// "SELECT x FROM JoursFerie x WHERE x.statut = 'ENABLED' ";

	// Tarif
	// String FIND_TARIF_BY_CRITERIA =
	// "From Tarif x where ( UPPER(x.libelle) like UPPER(?1) or ?1 is null )"
	// +" and ( x.tarif = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.statut = ?3 ) and x.statut !='DELETED' ";

	/** The find universite by code. */
	// String FIND_TARIF_BY_CODE =
	// "SELECT x FROM Tarif x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_TARIF_FOR_COMBO =
	// "SELECT x FROM Tarif x WHERE x.statut = 'ENABLED' ";

	// Service
	// String FIND_SERVICE_BY_CRITERIA =
	// "From Service x where (?1 is null or UPPER(x.libelle) like UPPER(?1))"
	// +" and ( x.date_debut = ?2 or ?2 is null ) "
	// +" and (?3 is null or x.date_fin = ?3)"
	// +" and (?4 is null or x.tarif.libelle = ?4)"
	// +" and (?5 is null or x.statut like ?5) and x.statut !='DELETED' ";
	/** The find universite by code. */
	// String FIND_SERVICE_BY_CODE =
	// "SELECT x FROM Service x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	// String FIND_ALL_SERVICE_FOR_COMBO =
	// "SELECT x FROM Service x WHERE x.statut = 'ENABLED' ";

	// String FIND_USER_NOT_ADMIN = " From UserEntity x where "
	// + " (x.username <> 'ADMINIST')";

	// Jours ferie
	String FIND_JOURS_FERIE_BY_CRITERIA = "From JoursFerie x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and ( x.date_debut = ?3 or ?3 is null ) "
			+ " and (?4 is null or x.date_fin = ?4)" + " and (?5 is null or YEAR(x.date_debut) = ?5)"
			+ " and (?6 is null or x.anneeUniversitaire.libelle = ?6)"
			+ " and (?7 is null or x.statut = ?7  ) and  x.statut !='DELETED' ";

	/** The find universite by code. */
	String FIND_JOURS_FERIE_BY_CODE = "SELECT x FROM JoursFerie x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_JOURS_FERIE_FOR_COMBO = "SELECT x FROM  JoursFerie x WHERE x.statut = 'ENABLED' ";

	// Tarif
	/** The find tarif by criteria. */
	String FIND_TARIF_BY_CRITERIA = "From Tarif x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and ( x.tarif = ?3 or ?3 is null ) "
			+ " and (?4 is null or x.service.libelle = ?4)" + " and (?5 is null or x.categoriePorteur.libelle = ?5)"
			+ " and (?6 is null or x.statut = ?6  ) and  x.statut !='DELETED' ";

	/** The find universite by code. */
	String FIND_TARIF_BY_CODE = "SELECT x FROM Tarif x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_TARIF_FOR_COMBO = "SELECT x FROM  Tarif x WHERE x.statut = 'ENABLED' ";

	// Service
	/** The find service by criteria. */
	String FIND_SERVICE_BY_CRITERIA = "From Service x where (x.code = ?1 or ?1 is null ) "
			+ " and (UPPER(x.libelle) like UPPER(?2) or ?2 is null)" + " and (x.heureDebut = ?3 or ?3 is null) "
			+ " and (x.heureFin = ?4 or ?4 is null)" + " and (x.statut like ?5 or ?5 is null) "
			+ " and  x.statut !='DELETED' ";

	/** The find universite by code. */
	String FIND_SERVICE_BY_CODE = "SELECT x FROM Service x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_SERVICE_FOR_COMBO = "SELECT x FROM Service x WHERE x.statut = 'ENABLED' ";

	// Caisse
	/** The find caisse by criteria. */
	String FIND_CAISSE_BY_CRITERIA = "From Caisse x inner join x.site site where (?5 is null or site.id like ?5) and "
			+ "(?2 is null or UPPER(x.libelle) like UPPER(?2))" + "and (x.code = ?1 or ?1 is null ) "
			+ "and (?3 is null or UPPER(x.restaurant.libelle) like UPPER(?3))"
			+ " and (?4 is null or x.statut like ?4) and  x.statut !='DELETED' ";

	/** The find all semaine universitaire for combo. */
	String FIND_ALL_SEMAINE_UNIVERSITAIRE_FOR_COMBO = "FROM SemaineUniversitaire x";

	/** The find semaine universitaire by id. */
	String FIND_SEMAINE_UNIVERSITAIRE_BY_ID = "SELECT x FROM  SemaineUniversitaire x WHERE x.id like ?1";

	/** The find reservation by user. */
	String FIND_RESERVATION_BY_USER = "SELECT x FROM  Reservation x" + " WHERE x.user.username like ?1";

	/** The find reservation detail by id reservation. */
	String FIND_RESERVATION_DETAIL_BY_ID_RESERVATION = "SELECT DISTINCT x FROM  ReservationDetail x"
			+ " WHERE x.reservation.id like ?1";

	/** The find caisse by code. */
	String FIND_CAISSE_BY_CODE = "SELECT x FROM Caisse x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all caisse for combo. */
	String FIND_ALL_CAISSE_FOR_COMBO = "SELECT x FROM Caisse x WHERE x.statut = 'ENABLED' ";

	String FIND_ALL_CAISSE_BY_IDSITE = "SELECT x FROM Caisse x inner join x.site site WHERE x.site.id like ?1 and x.statut = 'ENABLED' ";

	// Restaurant
	/** The find restaurant by criteria. */
	String FIND_RESTAURANT_BY_CRITERIA = "From Restaurant x inner join x.site site where (?10 is null or site.id like ?10) and (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (?3 is null )"
			+ "and (?4 is null or UPPER(x.nomResponsable) like UPPER(?4))"
			+ "and (?5 is null or UPPER(x.prenomResponsable) like UPPER(?5))"
			+ "and (?6 is null or UPPER(x.numTele) like UPPER(?6))"
			+ "and (?7 is null or UPPER(x.adresseEmail) like UPPER(?7))"
//			+ "and (?8 is null or UPPER(x.ville.libelle) like UPPER(?8))"
			+ "and (?8 is null or UPPER(x.adresse) like UPPER(?8))"
			+ "and (?9 is null or x.statut like ?9) and  x.statut !='DELETED' ";
	/** The find restaurant by code. */
	String FIND_RESTAURANT_BY_CODE = "FROM Restaurant x WHERE x.code = ?1 and x.statut != 'DELETED' ";

	String FIND_RESTAURANT_LIST_BY_CODE = "FROM Restaurant x WHERE x.code = ?1 and x.statut != 'DELETED' ";

	String FIND_CANAL_BY_CODE = "FROM CanalVente x WHERE x.code = ?1 and x.statut != 'DELETED' ";

	String COUNT_CANAL_BY_CODE = "select count(x) from CanalVente x " + " where trim(x.code) = trim(?1)";

	String FIND_CANAL_VENTE_CODE_CONVERT = "SELECT CONVERT(SUBSTRING_INDEX(x.code,'-',-1),UNSIGNED) AS num FROM CanalVente WHERE x.code = ?1 and x.statut != 'DELETED'";

	String FIND_RESTAURANT_BY_ID = "FROM Restaurant x WHERE x.id = ?1 and x.statut != 'DELETED'";

	/** The find all rstaurant for combo. */
	String FIND_ALL_RESTAURANT_FOR_COMBO = "SELECT x FROM Restaurant x WHERE x.statut = 'ENABLED' ";

	// Plafond
	/** The find plafond by criteria. */
	String FIND_PLAFOND_BY_CRITERIA = "From Plafond x where (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + " and (?3 is null or x.statut like ?3) and  x.statut !='DELETED' ";
	/** The find plafond by code. */
	String FIND_PLAFOND_BY_CODE = "SELECT x FROM Plafond x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all plafond for combo. */
	String FIND_ALL_PLAFOND_FOR_COMBO = "SELECT x FROM Plafond x WHERE x.statut = 'ENABLED' ";

	// AnneeUniversitaire
	/** The find annee universitaire by criteria. */
	String FIND_ANNEE_UNIVERSITAIRE_BY_CRITERIA = "From AnneeUniversitaire x where (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + " and ( x.date_debut = ?3 or ?3 is null ) "
			+ " and (?4 is null or x.date_fin = ?4)" + " and (?5 is null or YEAR(x.date_debut) = ?5)"
			+ " and (?6 is null or x.statut like ?6) and  x.statut !='DELETED' ";
	/** The find plafond by code. */
	String FIND_ANNEE_UNIVERSITAIRE_BY_CODE = "SELECT x FROM AnneeUniversitaire x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all plafond for combo. */
	String FIND_ALL_ANNEE_UNIVERSITAIRE_FOR_COMBO = "SELECT x FROM AnneeUniversitaire x WHERE x.statut = 'ENABLED' ";

	// MotifOpposition
	/** The find motif opposition by criteria. */
	String FIND_MOTIF_OPPOSITION_BY_CRITERIA = "From MotifOpposition x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and (?3 is null or x.statut = ?3  ) and  x.statut !='DELETED' ";

	/** The find universite by code. */
	String FIND_MOTIF_OPPOSITION_BY_CODE = "SELECT x FROM MotifOpposition x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_MOTIF_OPPOSITION_FOR_COMBO = "SELECT x FROM  MotifOpposition x WHERE x.statut = 'ENABLED' ";

	// MotifMainLevee
	/** The find motif main levee by criteria. */
	String FIND_MOTIF_MAIN_LEVEE_BY_CRITERIA = "From MotifMainLevee x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and (?3 is null or x.statut = ?3  ) and  x.statut !='DELETED' ";

	/** The find MotifMainLevee by code. */
	String FIND_MOTIF_MAIN_LEVEE_BY_CODE = "SELECT x FROM MotifMainLevee x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all MotifMainLevee for combo. */
	String FIND_ALL_MOTIF_MAIN_LEVEE_FOR_COMBO = "SELECT x FROM  MotifMainLevee x WHERE x.statut = 'ENABLED' ";

	// CategoriePorteur
	/** The find categorie porteur by criteria. */
	String FIND_CATEGORIE_PORTEUR_BY_CRITERIA = "From CategoriePorteur x inner join x.site site where (?9 is null or site.id like ?9) and ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (x.categorie = ?3 or ?3 is null )"
			+ "and (x.ratio = ?4 or ?4 is null)" + "and (x.plafJour = ?5 or ?5 is null)"
			+ "and (x.dated = ?6 or ?6 is null)" + "and (x.datef = ?7 or ?7 is null)"
			+ " and (?8 is null or x.statut = ?8  ) and  x.statut !='DELETED' ";

	/** The find CategoriePorteur by code. */
	String FIND_CATEGORIE_PORTEUR_BY_CODE = "SELECT x FROM CategoriePorteur x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all CategoriePorteur for combo. */
	String FIND_ALL_CATEGORIE_PORTEUR_FOR_COMBO = "SELECT x FROM  CategoriePorteur x WHERE x.statut = 'ENABLED' ";

	// ParametreGeneral
	/** The find parametre general by criteria. */
	String FIND_PARAMETRE_GENERAL_BY_CRITERIA = "From ParametreGeneral x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + " and (?3 is null or x.statut = ?3  ) and  x.statut !='DELETED' ";

	/** The find MotifMainLevee by code. */
	String FIND_PARAMETRE_GENERAL_BY_CODE = "SELECT x FROM ParametreGeneral x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all MotifMainLevee for combo. */
	String FIND_ALL_PARAMETRE_GENERAL_FOR_COMBO = "SELECT x FROM  ParametreGeneral x WHERE x.statut = 'ENABLED' ";

	// Statistique
	/** The find statistique by jour. */
	String FIND_STATISTIQUE_BY_JOUR = "SELECT dateOperation, COUNT(*) as nbreReservation, restaurant.cite.libelle, restaurant.libelle FROM Reservation WHERE ( (dateOperation BETWEEN ?1 and ?2) or (dateOperation = CURRENT_DATE and ?1 is null and ?2 is null)) AND (restaurant.libelle = ?3 or ?3 is null) AND (restaurant.cite.libelle like ?4 or ?4 is null)";

	/** The FIN d_ statistiqu e_ b y_ jou r_2. */
	String FIND_STATISTIQUE_BY_JOUR_2 = "SELECT r.dateService, COUNT(*) as nbreRepasConsomme, SUM(t.tarif) as montantRepasConsomme, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle  FROM ReservationDetail as r, Tarif as t  WHERE (r.service = t.service AND t.categoriePorteur.libelle = 'Etudiant') AND ( (r.dateService BETWEEN ?1 and ?2) or (r.dateService = CURRENT_DATE and ?1 is null and ?2 is null)) AND (r.etat = 'CONSOMEE') AND (r.reservation.restaurant.libelle = ?3 or ?3 is null) AND (r.reservation.restaurant.cite.libelle like ?4 or ?4 is null)";

	/** The find statistique by mois. */
	String FIND_STATISTIQUE_BY_MOIS = "SELECT YEAR(r.dateService), MONTH(r.dateService), r.dateService, COUNT(*) as nbreRepasConsomme, SUM(t.tarif) as montantRepasConsomme, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle FROM ReservationDetail as r, Tarif as t  WHERE (r.service = t.service and t.categoriePorteur.libelle = 'Etudiant') AND (( r.dateService BETWEEN ?1 and ?2 ) or (r.dateService = CURRENT_DATE and ?1 is null and ?2 is null)) AND r.etat = 'CONSOMEE' AND (r.reservation.restaurant.libelle = ?3 or ?3 is null) AND (r.reservation.restaurant.cite.libelle like ?4 or ?4 is null)";

	/** The find statistique by annee. */
	String FIND_STATISTIQUE_BY_ANNEE = "SELECT YEAR(r.dateService), r.dateService, COUNT(*) as nbreRepasConsomme, SUM(t.tarif)  as montantRepasConsomme, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle FROM ReservationDetail as r, Tarif as t  WHERE (r.service = t.service and t.categoriePorteur.libelle = 'Etudiant') AND (( r.dateService BETWEEN ?1 and ?2) or (r.dateService = CURRENT_DATE and ?1 is null and ?2 is null)) AND (r.etat = 'CONSOMEE') AND (r.reservation.restaurant.libelle = ?3 or ?3 is null) AND (r.reservation.restaurant.cite.libelle like ?4 or ?4 is null)";

	/** The find statistique by week. */
	String FIND_STATISTIQUE_BY_WEEK = "SELECT YEAR(r.dateService), WEEKOFYEAR(r.dateService), r.dateService, COUNT(*) as nbreRepasConsomme, SUM(t.tarif) as montantRepasConsomme, r.reservation.restaurant.cite.libelle, r.reservation.restaurant.libelle FROM ReservationDetail as r, Tarif as t  WHERE (r.service = t.service and t.categoriePorteur.libelle = 'Etudiant') AND (( r.dateService BETWEEN ?1 and ?2) or (r.dateService = CURRENT_DATE and ?1 is null and ?2 is null)) AND r.etat = 'CONSOMEE' AND (r.reservation.restaurant.libelle = ?3 or ?3 is null) AND (r.reservation.restaurant.cite.libelle like ?4 or ?4 is null)";
	String FIND_NBR_JOUR_CONSOMMATION = "SELECT COUNT(DISTINCT dateService) FROM ReservationDetail WHERE etat = 'CONSOMEE'";
	/** The find user by code. */
	String FIND_USER_BY_CODE = "SELECT x FROM UserEntity x WHERE x.username = ?1";

	/** The find restaurant by cite. */
	String FIND_RESTAURANT_BY_CITE = "SELECT x FROM Restaurant x WHERE x.cite.libelle like ?1 and x.statut != 'DELETED' ";

	/** The find winmenu by criteria. */
//	String FIND_WINMENU_BY_CRITERIA = " From   WinMenu   x    where     "
//			+ "  (?1 is null  or  x.code like ?1)"
//			+ "  and (?2 is null  or  x.libelle like ?2)"
//			+ "  and (?3 is null   or  x.abbrev like ?3)"
//			+ "  and (?4 is null  or  x.operateur like ?4)"
//			+ "  and (?5 is null  or  x.type like ?5)"
//			+ " and x.statut !='DELETED' ";

	String FIND_WINMENU_BY_CRITERIA = " From   WinMenu   x    where     " + "  (?1 is null  or  x.code like ?1)"
			+ "  and (?2 is null  or  x.libelle like ?2)" + "  and (?3 is null   or  x.abbrev like ?3)"
			+ "  and (?4 is null  or  x.operateur like ?4)" + "  and (?5 is null  or  x.type like ?5)"
			+ " and x.statut !='DELETED' " + " order by amn_oper,convert(convert(amn_code,unsigned),char)";

	/** The find winmenu libelle. */
	String FIND_WINMENU_LIBELLE = "SELECT DISTINCT x FROM  WinMenu x ";
	// + " x group by x.code";

	/** The find menu by criteria. */
	String FIND_MENU_BY_CRITERIA = " From   Menu   x    where     " + "  (?1 is null  or  x.code like ?1)"
			+ "  or (?2 is null  or  x.libelle like ?2)" + "  or (?3 is null   or  x.abbrev like ?3)";

	/** The FIN d_ men u_ b y_ criteri a2. */
	String FIND_MENU_BY_CRITERIA2 = " From   Menu   x    where     " + "  (?1 is null  or  x.code like ?1)"
			+ "  and (?2 is null  or  x.libelle like ?2)" + "  and (?3 is null   or  x.abbrev like ?3)"
			+ "  and (?4 is null   or  x.pageName like ?4)" + " and x.statut !='DELETED' ";

	/** The find winmenu by groupuser. */
	String FIND_WINMENU_BY_GROUPUSER = "SELECT x FROM  WinMenu x where" + " (?1 is null  or  x.operateur like ?1)"
			+ " and x.statut !='DELETED' ";

	/** The find transaction by criteria. */
	String FIND_TRANSACTION_BY_CRITERIA = "From OperationCaisse x where (?1 is null or UPPER(x.caisse.libelle) like UPPER(?1))"
			+ "and (x.caisse.restaurant.libelle like ?2 or ?2 is null ) "
			+ " and (x.dateOperation like ?3 or ?3 is null ) " + " and (?4 is null or x.etudiant.id = ?4) "
			+ " and (?5 is null or x.caisse.restaurant.cite.libelle = ?5) "
			+ " and (?6 is null or x.caissier.code = ?6) " + " and (?7 is null or x.typeOperation = ?7) ";

	String FIND_TRANSACTION_BY_CRITER = " From OperationCaisse x inner join x.site site where (?6 is null or site.id like ?6) and "
			+ "  (x.dateOperation >= ?1 or  ?1 is null ) " + " and  (x.dateOperation <= ?2 or  ?2 is null ) "
			+ " and (?3 is null or x.matricule = ?3) " + " and (?4 is null or x.typeOperation = ?4) "
			+ " and (?5 is null or x.caisse.id= ?5)";

	String FIND_TRANSACTIONC_BY_CRITER = " From ConsultCaisse x where " + "  (x.dateOperation >= ?1 or  ?1 is null ) "
			+ " and  (x.dateOperation <= ?2 or  ?2 is null ) " + " and (?3 is null or x.matricule = ?3) "
			+ " and (?4 is null or x.typeOperation = ?4) " + " and (?5 is null or x.id_caisse= ?5)";

	/** The find totale transaction. */
	String FIND_TOTALE_TRANSACTION = "SELECT x.typeOperation, SUM(x.montant) FROM OperationCaisse x WHERE (?1 is null or UPPER(x.caisse.libelle) like UPPER(?1))"
			+ "and (x.caisse.restaurant.libelle like ?2 or ?2 is null ) "
			+ " and (x.dateOperation like ?3 or ?3 is null ) " + " and (?4 is null or x.etudiant.id = ?4) "
			+ " and (?5 is null or x.typeOperation = ?5) ";

	/** The find caisse by cite. */
	String FIND_CAISSE_BY_CITE = "SELECT x FROM Caisse x WHERE x.restaurant.libelle like ?1 and x.statut != 'DELETED' ";

	/** The find etudiant by cite. */
	String FIND_ETUDIANT_BY_CITE = "SELECT x FROM Etudiants x WHERE x.restaurant.libelle like ?1 and x.statut != 'DELETED' ";

	/** The find reservation detail by etat. */
	String FIND_RESERVATION_DETAIL_BY_ETAT = "SELECT DISTINCT x FROM  ReservationDetail x"
			+ " WHERE x.etat like ?1  and x.reservation.carte.numeroCarte = ?2  order by x.dateService";

	/** The find carte by numero. */
	String FIND_CARTE_BY_NUMERO = "FROM Carte x WHERE trim(x.numeroCarte) = trim(?1)";

	/** The find reservation by porteur. */
	String FIND_RESERVATION_BY_PORTEUR = "SELECT x FROM  Reservation x"
			+ " WHERE x.carte.numeroCarte = ?1 order by x.dateOperation DESC  ";

	// Tourniquet
	/** The find tourniquet by criteria. */
	String FIND_TOURNIQUET_BY_CRITERIA = "From Tourniquet x where (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (?3 is null )"
			+ "and (?4 is null or UPPER(x.reference) like UPPER(?4))"
			+ " and (?5 is null or x.statut like ?5) and  x.statut !='DELETED' ";

	/** The find Equipement by code. */
	String FIND_TOURNIQUET_BY_CODE = "SELECT x FROM Tourniquet x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all Equipement for combo. */
	String FIND_ALL_TOURNIQUET_FOR_COMBO = "SELECT x FROM Tourniquet x WHERE x.statut = 'ENABLED'  ";

	// EQUIPEMENT
	String FIND_EQUIPEMENT_BY_CRITERIA = "From Equipement x where (?2 is null or UPPER(x.marque) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (?3 is null or UPPER(x.fournisseur) like UPPER(?3))"
			+ "and (?4 is null or UPPER(x.reference) like UPPER(?4))"
			+ "and (?5 is null or UPPER(x.numSerie) like UPPER(?5))" + "and (?6 is null or x.dateAchat like ?6)"
			+ "and (?7 is null or UPPER(x.type) like UPPER(?7))"
			+ "and (?8 is null or UPPER(x.cite.libelle) like UPPER(?8))"
			+ "and (?8 is null or UPPER(x.restaurant.cite.libelle) like UPPER(?8))"
			+ "and (?9 is null or UPPER(x.restaurant.libelle) like UPPER(?9))"
			+ " and (?10 is null or x.statut like ?10) and  x.statut !='DELETED' ";
	String FIND_TRACE_BY_CRITERIA = " From   TraceEntity   x    where     " + "  (?1 is null  or  x.userID like ?1)"
			+ "  and (?2 is null  or  x.action like ?2)" + "  and (?3 is null   or  x.actionWhen >= ?3)"
			+ "  and (?4 is null  or  x.actionWhen <= ?4)";
	/** The find count reservation by code. */
	String FIND_COUNT_RESERVATION_BY_CODE = "select count(x) from Reservation x " + " where trim(x.libelle) = trim(?1)";

	/** The find Equipement by code. */
	String FIND_EQUIPEMENT_BY_CODE = "SELECT x FROM Equipement x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all Equipement for combo. */
	String FIND_ALL_EQUIPEMENT_FOR_COMBO = "SELECT x FROM Equipement x WHERE x.statut = 'ENABLED' ";

	/** The find reservation detail by date by service. */
	String FIND_RESERVATION_DETAIL_BY_DATE_BY_SERVICE = "select count(x) from ReservationDetail x "
			+ " where DAY(x.dateService) = ?1" + " and MONTH(x.dateService) = ?2" + " and YEAR(x.dateService) = ?3"
			+ " and x.service.id = ?4" + " and x.reservation.carte.numeroCarte = ?5" + " and  x.etat <> 'ANNULEE' 	";

	String FIND_CITE_BY_CODE_UNIVERSITE = "SELECT x FROM Cite x WHERE x.universite.code like ?1 and x.statut != 'DELETED' ";

	String FIND_RESTAURANT_BY_CODE_CITE = "SELECT x FROM Restaurant x WHERE x.cite.code like ?1 and x.statut != 'DELETED' ";

	String FIND_RESTAURANT_BY_IDSITE = "SELECT x FROM Restaurant x inner join x.site site WHERE x.site.id like ?1 and x.statut != 'DELETED' ";

	String FIND_CAISSE_BY_CODE_RESTAURANT = "SELECT x FROM Caisse x WHERE x.restaurant.code like ?1 and x.statut != 'DELETED' ";

	String FIND_TARIF_BY_CODE_SERVICE = "SELECT x FROM Tarif x WHERE x.service.code like ?1 and x.statut != 'DELETED' ";

	String FIND_TARIF_BY_CODE_CATEGORIE_PORTEUR = "SELECT x FROM Tarif x WHERE x.categoriePorteur.code like ?1 and x.statut != 'DELETED' ";

	String FIND_JOURS_FERIE_BY_CODE_ANNEE_UNIVERSITAIRE = "SELECT x FROM JoursFerie x WHERE x.anneeUniversitaire.code like ?1 and x.statut != 'DELETED' ";

	String FIND_TOURNIQUET_BY_CODE_RESTAURANT = "SELECT x FROM Tourniquet x WHERE x.restaurant.code like ?1 and x.statut != 'DELETED' ";

	String FIND_EQUIPEMENT_BY_CODE_RESTAURANT = "SELECT x FROM Equipement x WHERE x.restaurant.code like ?1 and x.statut != 'DELETED' ";

	String FIND_EQUIPEMENT_BY_CODE_CITE = "SELECT x FROM Equipement x WHERE x.cite.code like ?1 and x.statut != 'DELETED' ";

	String FIND_OPERATION_CAISSE_BY_CODE_CAISSE = "SELECT x FROM OperationCaisse x WHERE x.caisse.code like ?1 ";

	String FIND_SOLDE_BY_MATR = "SELECT x FROM OperationCaisse x WHERE x.matricule = ?1 AND x.typeOperation in ('R','V','A') order by x.id desc";

	String FIND_ETUDIANTS_BY_CODE_RESTAURANT = "SELECT x FROM Etudiants x WHERE x.restaurant.code like ?1 AND x.statut <> 'CLOSED' ";

	String FIND_RESERVATION_BY_CODE_RESTAURANT = "SELECT x FROM Reservation x WHERE x.restaurant.code like ?1 ";

	String FIND_RESERVATION_DETAIL_BY_CODE_SERVICE = "SELECT x FROM ReservationDetail x WHERE x.service.code like ?1 ";

	String FIND_TARIF_IN_RESERVATION_DETAIL = "SELECT x FROM Tarif x, ReservationDetail r WHERE x.service = r.service AND x.categoriePorteur.libelle = 'Etudiant' and x.code like ?1";

	// Service
	/** The find Caissier by criteria. */
	String FIND_CAISSIER_BY_CRITERIA = "From Caissier x inner join x.site site where (?8 is null or site.id like ?8) and (x.code = ?1 or ?1 is null ) "
			+ " and (UPPER(x.nom) like UPPER(?2) or ?2 is null)" + " and (UPPER(x.prenom) like UPPER(?3) or ?3 is null)"
			+ " and (UPPER(x.numTele) like UPPER(?4) or ?4 is null)"
			+ " and (UPPER(x.adresseEmail) like UPPER(?5) or ?5 is null)"
			+ " and (x.caisse.libelle like ?6 or ?6 is null) " + " and (x.statut like ?7 or ?7 is null) "
			+ " and  x.statut !='DELETED' ";

	/** The find Caissier by code. */
	String FIND_CAISSIER_BY_CODE = "SELECT x FROM Caissier x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find Caissier by numcarte. */
	String FIND_CAISSIER_BY_NUMCARTE = "SELECT x FROM Caissier x WHERE x.numCarte like ?1 and x.statut != 'DELETED' ";

	/** The find all universite for combo. */
	String FIND_ALL_CAISSIER_FOR_COMBO = "SELECT x FROM Caissier x WHERE x.statut = 'ENABLED' ";

	/** The find jour ferie by date. */
	String FIND_JOUR_FERIE_BY_DATE = "select count(x) from JoursFerie x "
			+ " where ?1 between x.date_debut and x.date_fin";

	String FIND_TRANSACTION_BY_JOUR = "SELECT dateOperation, typeOperation, SUM(montant), caisse.restaurant.cite.libelle, caisse.restaurant.libelle FROM OperationCaisse x WHERE ((dateOperation BETWEEN ?1 and ?2) OR (dateOperation = CURRENT_DATE and ?1 is null and ?2 is null) )"
			+ "AND (x.caisse.restaurant.libelle like ?3 or ?3 is null)"
			+ "AND (x.caisse.restaurant.cite.libelle like ?4 or ?4 is null)"
			+ "AND (x.typeOperation = ?5 or ?5 is null )" + "AND (?6 is null or x.etudiant.id = ?6)";
	String FIND_TRANSACTION_BY_MOIS = "SELECT YEAR(dateOperation), MONTH(dateOperation), dateOperation, typeOperation, SUM(montant), caisse.restaurant.cite.libelle, caisse.restaurant.libelle FROM OperationCaisse x WHERE ((dateOperation BETWEEN ?1 and ?2) OR (dateOperation = CURRENT_DATE and ?1 is null and ?2 is null) )"
			+ "AND (x.caisse.restaurant.libelle like ?3 or ?3 is null)"
			+ "AND (x.caisse.restaurant.cite.libelle like ?4 or ?4 is null)"
			+ "AND (x.typeOperation = ?5 or ?5 is null )" + "AND (?6 is null or x.etudiant.id = ?6)";

	String FIND_TRANSACTION_BY_ANNEE = "SELECT YEAR(dateOperation), dateOperation, typeOperation, SUM(montant), caisse.restaurant.cite.libelle, caisse.restaurant.libelle FROM OperationCaisse x WHERE ((dateOperation BETWEEN ?1 and ?2) OR (dateOperation = CURRENT_DATE and ?1 is null and ?2 is null) )"
			+ "AND (x.caisse.restaurant.libelle like ?3 or ?3 is null)"
			+ "AND (x.caisse.restaurant.cite.libelle like ?4 or ?4 is null)"
			+ "AND (x.typeOperation = ?5 or ?5 is null )" + "AND (?6 is null or x.etudiant.id = ?6)";
	String FIND_TRANSACTION_BY_SEMAINE = "SELECT YEAR(dateOperation), WEEKOFYEAR(dateOperation), dateOperation, typeOperation, SUM(montant), caisse.restaurant.cite.libelle, caisse.restaurant.libelle FROM OperationCaisse x WHERE ((dateOperation BETWEEN ?1 and ?2) OR (dateOperation = CURRENT_DATE and ?1 is null and ?2 is null) )"
			+ "AND (x.caisse.restaurant.libelle like ?3 or ?3 is null)"
			+ "AND (x.caisse.restaurant.cite.libelle like ?4 or ?4 is null)"
			+ "AND (x.typeOperation = ?5 or ?5 is null )" + "AND (?6 is null or x.etudiant.id = ?6)";

	// Critere
	/** The find CRITERE by criteria. */
	String FIND_CRITERE_BY_CRITERIA = "From Critere x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) "
//			+ "and (x.coefficient = ?3 or ?3 is null ) "
			+ " and (?3 is null or x.statut = ?3  ) and  x.statut <>'DELETED' ";

	/** The find CRITERE by code. */
	String FIND_CRITERE_BY_CODE = "SELECT x FROM Critere x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all CRITERE for combo. */
	String FIND_ALL_CRITERE_FOR_COMBO = "SELECT x FROM  Critere x WHERE x.statut = 'ENABLED' ";

	// Critere
	/** The find CRITERE by criteria. */
	String FIND_NOTE_CRITERE_BY_CRITERIA = "From NoteCritere x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (x.max = ?3 or ?3 is null ) "
			+ "and (x.min = ?4 or ?4 is null ) " + "and (x.critere.libelle = ?5 or ?5 is null ) "
			+ "and (x.note = ?6 or ?6 is null ) " + " and (?7 is null or x.statut = ?7  ) and  x.statut !='DELETED' ";

	/** The find CRITERE by code. */
	String FIND_NOTE_CRITERE_BY_CODE = "SELECT x FROM NoteCritere x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	/** The find all CRITERE for combo. */
	String FIND_ALL_NOTE_CRITERE_FOR_COMBO = "SELECT x FROM  NoteCritere x WHERE x.statut = 'ENABLED' ";

	String FIND_BORNE_BY_CRITERIA = "From Borne x where ( UPPER(x.libelle) like UPPER(?2) or ?2 is null  )"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (x.site.libelle = ?4 or ?4 is null ) "
			+ "and (x.ip = ?3 or ?3 is null ) " + " and (?5 is null or x.statut = ?5  ) and  x.statut !='DELETED' ";

	/** The find CRITERE by code. */
	String FIND_BORNE_BY_CODE = "SELECT x FROM Borne x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	String FIND_BORNE_BY_SITE = "SELECT x FROM Borne x WHERE x.site.id like ?1 and x.statut != 'DELETED' ";

	/** The find all CRITERE for combo. */
	String FIND_ALL_BORNE_FOR_COMBO = "SELECT x FROM  Borne x WHERE x.statut = 'ENABLED' ";

	/** The find universite by code. */
	String FIND_CYCLE_VIE_BY_CODE = "SELECT x FROM CycleVie x WHERE x.numSerie like ?1 and x.statut != 'DELETED' ";

	/** The find NOTE_CRITERE by code critere. */
	String FIND_NOTE_CRITERE_BY_CODE_CRITERE = "SELECT x FROM NoteCritere x WHERE x.critere.code like ?1 and x.statut != 'DELETED' ";

	/** The find plafond by code. */
	String FIND_ANNEE_UNIVERSITAIRE_ACTUEL = "SELECT x FROM AnneeUniversitaire x WHERE x.date_debut <= NOW() AND x.date_fin >= NOW() AND x.statut != 'DELETED' ";

	/** The find plafond by criteria. */
	String FIND_DELIVRANCE_BY_CRITERIA = " FROM  DelivranceCarte  x  inner join  x.etudiant  e  WHERE "
			+ " (?1 is null  or STR_TO_DATE(DATE_FORMAT(x.dateDelivrance, '%Y-%m-%d'),'%Y-%m-%d') >= ?1 )"
			+ " and (?2 is null  or STR_TO_DATE(DATE_FORMAT(x.dateDelivrance, '%Y-%m-%d'),'%Y-%m-%d') <= ?2 )"
			+ " and  (?3 is null or x.categorie like ?3)" + " and  (?4 is null or e.id  = ?4)"
			+ " and (?5 is null or e.site.id like ?5)" + " and  (x.statut != 'DELETED' )";

	/** The find all CRITERE for combo. */
	String FIND_ALL_DELIVRANCE_FOR_COMBO = "SELECT x FROM  DelivranceCarte x WHERE x.statut = 'ENABLED' ";

	/** The find cloture by criteria. */
	String FIND_CLOTURE_BY_CRITERIA = " FROM  ClotureCaisse  x  inner join  x.caisse  c  inner join  x.caissier cai  WHERE "
			+ "  (?1 is null  or c.id = ?1 )" + "  and  (?2 is null or cai.id = ?2)"
			+ "  and  (?3 is null or x.dateCloture  = ?3)";

	String FIND_CARTE_BY_PORTEUR = "SELECT x From Carte x  inner join  x.numPorteur p  WHERE"
			+ "  (?1 is null  or p.id = ?1 )" + " and  (x.statut != 'DELETED' ) and (x.statut != 'RESCIND' )";

	// recette maitrise d'ouevre********************************************//

	String FIND_CYCLE_VIE__BY_CRITERIA_FABR = "  FROM  CycleVie x  inner join  x.numPorteur  e    WHERE "
			+ "  (?1 is null or x.numSerie like ?1 )" + " and  (?2 is null or x.operation like ?2)"
			+ " and  (?3 is null or x.dateOperation = ?3)" + " and  (?4 is null or x.operateur like ?4)"
			+ " and  (?5 is null or x.statut like ?5)" + " and  (?6 is null or e.id  = ?6)"
			+ " and  (x.statut <> 'DILIVRED' )  and x.operation='Fabrication'";

	String FIND_CARTE_BY_CRITERIA = "  FROM  Carte x  inner join  x.numPorteur  e    WHERE "
			+ "  (?1 is null or x.numeroCarte like ?1 )" + " and  (?2 is null or x.numSerie like ?2)"
			+ " and  (?3 is null or x.operation like  ?3)" + " and  (?4 is null or e.id  = ?4)"
			+ " and (?5 is null or e.site.id like ?5)" + " and  (?6 is null or e.NCIN  = ?6)"
			+ " and  (?7 is null or e.codeMassar  = ?7)" + " and  (x.statut = 'PERSONALIZED' )";

	String FIND_CARTE_NAPS_BY_CRITERIA = "FROM CarteNaps x inner join x.site site where (?5 is null or site.id like ?5) and "
			+ "(?1 is null or x.nom like ?1)" + " and (?2 is null or x.prenom like ?2)"
			+ " and (?3 is null or x.numidentite like ?3)" + " and (?4 is null or x.matr like ?4)"
			+ " and (x.statut = 'ENABLED')";

	String FIND_SOLDE_BY_CRITERIA = "FROM Solde x inner join x.site site where (?4 is null or site.id like ?4) and "
			+ "(?1 is null or x.matr like ?1)" + "and (?2 is null or x.date >= ?2)"
			+ "and (?3 is null or x.date <= ?3)";

	String FIND_CARTE_NAPS_BY_ID = "FROM CarteNaps x WHERE " + "(?1 is null or x.numidentite like ?1)"
			+ " and (x.statut = 'ENABLED')";

	String FIND_PROFIL_PORTEUR_BY_CRITERIA = "FROM ProfilPorteur x WHERE " + "(?1 is null or x.code like ?1)"
			+ " and (?2 is null or x.libelle like ?2)" + " and (?3 is null or x.categorie like ?3)"
			+ " and (?4 is null or x.ratio like ?4)" + " and (x.statut = 'ENABLED')";

	String FIND_MAX_LOT_CARTE = "  SELECT coalesce(MAX(x.operateur),CONCAT(LPAD(x.numPorteur.Cite.code,4,'0'),1))  FROM  Carte x  WHERE "
			+ "   x.numPorteur.Cite.code =  ?1";

	String FIND_LOT_CARTE_BY_CRITERIA = "  FROM  Carte x  inner join  x.numPorteur  e    WHERE "
			+ "  (?1 is null or x.numeroCarte like ?1 )" + " and  (?2 is null or x.numSerie like ?2)"
			+ " and  (?3 is null or x.operation like  ?3)" + " and  (?4 is null or e.id  = ?4)"
			+ " and  (?5 is null or x.numPorteur.Cite.id =  ?5)" + " and  (?6 is null or x.operateur =  ?6)"
			+ " and  (x.statut = 'PERSONALIZED' )" + " group by x.operateur";

	String FIND_CARTE_BY_LOT = " FROM  Carte x  WHERE " + "  (?1 is null or x.operateur = ?1 )"
			+ " and  (x.statut = 'PERSONALIZED' )"
	// + " group by x.operateur "
	;
	/************************************************
	 * PROJET OCP
	 *********************************************************************/

	String FIND_PERSONNEL_BY_CRIERIA = " FROM  Personnel x WHERE  " + "  (?1 is null or x.matr like ?1 )"
			+ " and  (?2 is null or x.nom like ?2)" + " and  (?3 is null or x.prenom like  ?3)"
			+ " and  (?4 is null or x.numidentite like  ?4)" + " and (?5 is null or x.categorie.code like ?5)"
			+ " and (?6 is null or UPPER(x.etab) like UPPER(?6))"
			+ " and ((x.dateEmbauche between  ?7 and ?8) or (?7 is null or ?8 is null))";

	String FIND_OPPOSITION_PERSO_BY_CRITERIA = " FROM  Personnel x inner join x.site site where (?5 is null or site.id like ?5) and "
			+ "  (?1 is null or x.matr like ?1 )" + " and  (?2 is null or x.nom like ?2)"
			+ " and  (?3 is null or x.statut = ?3)" + " and  (?4 is null or x.prenom like  ?4)"
			+ " and  (x.statut in ('PERSONALIZED','VALIDATED','OPPOSED') )";

	String FIND_OPPOSITION_ADH_BY_CRITERIA = " FROM  Adherent x WHERE  " + "  (?1 is null or x.matr like ?1 )"
			+ " and  (?2 is null or x.nom like ?2)" + " and  (?3 is null or x.statut = ?3)"
			+ " and  (?4 is null or x.prenom like  ?4)" + " and  (x.statut in ('PERSONALIZED','VALIDATED','OPPOSED') )";

	String FIND_ADHERNT_BY_CRIERIA = " FROM  Adherent x inner join x.personnel p  WHERE  "
			+ "  (?1 is null or x.matr = ?1 )" + " and  (?2 is null or x.nom like ?2)"
			+ " and  (?3 is null or x.prenom like  ?3)" + " and  (?4 is null or x.cni =  ?4)"
			+ " and  (?5 is null or p.id  = ?5)" + " and   p.profil  is not null";

	String FIND_COMPTE_BY_CODE = "SELECT x FROM  COMPTE x WHERE x.code like ?1 and x.statut != 'DELETED' ";

	String FIND_PERSONNEL_BY_MATRICULE = "SELECT x FROM  Personnel x WHERE (?1 is null or  x.matr =?1) ";
	String FIND_PERSONNEL_CARTE_NAPS_BY_MATRICULE = "SELECT x FROM  CarteNaps x WHERE (?1 is null or  x.matr =?1) ";
	String FIND_ADHERENT_BY_MATRICULE = "SELECT x FROM  Adherent x WHERE   x.matr = ?1   "
			+ "  and ( (?2 is null or x.nom  like ?2) and (?3 is null or x.prenom like ?3))";
	String FIND_ALL_PERSONNEL_FOR_COMBO = "SELECT x FROM  Personnel x  ";

	String FIND_ALL_ADHERENT_FOR_COMBO = "SELECT x FROM  Adherent x  ";

	String FIND_ADHERENT_BY_PERSONNEL = "SELECT x FROM  Adherent x WHERE x.personnel.id = ?1";

	String FIND_DETAILPROFIL_BY_CRITERIA = " FROM DetailProfilAcces x inner join x.profil p WHERE"
			+ "  (?1 is null or x.tranche = ?1 )" + " and  (?2 is null or x.jour = ?2)"
			+ " and  (?3 is null or x.dateDebut =  ?3)" + " and  (?4 is null or x.dateFin =  ?4)"
			+ " and  (?5 is null or p.id  = ?5)" + " and  (?6 is null or p.libelle  = ?6)"
			+ " and x.statut <> 'DELETED'";

	String FIND_DETAILPROFIL_BY_profil = "SELECT x FROM DetailProfilAcces x inner join x.profil p WHERE"
			+ "  ( p.code  = ?1)" + " and x.statut <> 'DELETED'";

	String FIND_TRANCHE_BYPROFI = "SELECT" + "  " + "  STUFF("
			+ "   (SELECT    right(replicate('0',4)+cast((datepart(HOUR, DATE_DEBUT)*60+ datepart(MINUTE, DATE_DEBUT)) as varchar(15)),4)+right(replicate('0',4)+cast((datepart(HOUR, DATE_FIN)*60+ datepart(MINUTE, DATE_FIN)) as varchar(15)),4)  "
			+ "     FROM DETAIL_PROFIL" + "    WHERE JOUR = a.JOUR " + "       FOR XML PATH ('') )"
			+ "     , 1, 0, '')  AS TRANCHE" + "    FROM DETAIL_PROFIL AS a"
			+ "    WHERE JOUR=:JOUR  AND PROFIL =:PROFIL"
			// + " FROM DETAIL_PROFIL AS a"
			+ "   GROUP BY JOUR";

	String FIND_TRANCHE_BYPROFIL = "SELECT  right(replicate('0',4)+cast((datepart(HOUR, DATE_DEBUT)*60+ datepart(MINUTE, DATE_DEBUT)) as varchar(15)),4)+right(replicate('0',4)+cast((datepart(HOUR, DATE_FIN)*60+ datepart(MINUTE, DATE_FIN)) as varchar(15)),4) FROM DETAIL_PROFIL  "
			// + " "
			// + " right(replicate('0',4)+(datepart(HOUR, DATE_DEBUT)*60+ datepart(MINUTE,
			// DATE_DEBUT)),4)+right(replicate('0',4)+cast((datepart(HOUR, DATE_FIN)*60+
			// datepart(MINUTE, DATE_FIN)) as varchar(15)),4) "
			// + " FROM DETAIL_PROFIL AS a"
			+ "    WHERE JOUR=:JOUR  AND PROFIL =:PROFIL";
//					+ "    GROUP BY JOUR"
//					+ "   ORDER BY  JOUR";

	String FIND_CONTROLACCES_BY_CRITERIA = " FROM   ControlAcces x  WHERE" + "  (?1 is null or x.matricule = ?1 )"
			+ " and  (?2 is null or x.dateAcces = ?2)" + " and  (?3 is null or x.heureAcces =  ?3)"
			+ "  and  (?4 is null  or  x.dateAcces>=?4)  AND   (?5 is null  or  x.dateAcces<=?5)"
			+ "  and ( ?6 is null   or x.tourniquet.id=?6 ) ";

	String FIND_PRODUIT_BY_CRITERIA = " FROM   Produit x inner join x.site site where (?7 is null or site.id like ?7)"
			+ " and (?1 is null or x.code = ?1 )" + " and  (?2 is null or x.libelle like  ?2)" + " and  (?3 is null)"
			// + " and (?4 is null or x.dateAcces>=?4) AND (?5 is null or x.dateAcces<=?5)"
			+ " and  (?4 is null)" + " and  (?5 is null or x.codeBar =  ?5)"
			+ "  and ( ?6 is null   or x.familleProd.id=?6 ) " + " and x.statut <> 'DELETED'";

	String FIND_PRODUIT_BY_FAMILLE = "SELECT x FROM Produit x WHERE   x.familleProd.id like ?1 and x.statut <> 'DELETED' ";
	String FIND_ALL_Produit = "SELECT x FROM  Produit x WHERE x.statut = 'ENABLED' ";

	String FIND_Produit_BY_CODEBAR = "SELECT x FROM  Produit x WHERE x.codeBar=?1 AND x.statut = 'ENABLED' ";
	String FIND_PRODUIT_BY_CODE = "SELECT x FROM  Produit x WHERE x.code=?1 AND x.statut in ('ENABLED' , 'DISABLED') ";

	String FIND_ADH_AGE_NSCOLARISE = "SELECT x FROM Adherent x WHERE x.matr= ?1 and x.scolarise='N' and "
			+ " x.type='E' and " + " DATEDIFF(x.dateNaissance, SYSDATE() )>21 ";

	String FIND_ADH_AGE_SCOLARISE = "SELECT x FROM Adherent x WHERE x.matr= ?1 and x.scolarise='O' and "
			+ " x.type='E' and " + " DATEDIFF(x.dateNaissance, SYSDATE() )>26 ";

	String FIND_CONTROLACCES_ACCESPRINCIPAL = " FROM   ControlAcces x  WHERE" + "  (?1 is null or x.matricule = ?1 )"
			+ "  and  (?2 is null )" + "  and  (?3 is null )" + "  and  (?4 is null  )  AND   (?5 is null  )"
			+ "  and ( ?6 is null   ) "
			+ "  and x.tourniquet.id in (11 ,14) and x.dateAcces =convert(date,SYSDATETIME())";

	String FIND_EVENEMENT_BY_CRITERIA = " FROM   Evenement x  WHERE" + "  (?1 is null or x.code = ?1 )"
			+ "  and  (?2 is null or x.etat = ?2)"
			+ "  and  (?3 is null  or  x.dateDebut>=?3)  AND   (?4 is null  or  x.dateFin<=?4)"
			+ " AND x.statut = 'ENABLED' ";

	String FIND_SERVICE_BY_TYPE = "From Service x where (x.type = ?1 ) " + " and  x.statut !='DELETED' ";

	// FILIERE
	/** The find FILIERE by criteria. */
	String FIND_FILIERE_BY_CRITERIA = "From Filiere x inner join x.site site where (?4 is null or site.id like ?4) and (?2 is null or UPPER(x.libelle) like UPPER(?2))"
			+ "and (x.code = ?1 or ?1 is null ) " + "and (?3 is null )" + "and  x.statut !='DELETED' ";

	/** The find all filier for combo. */
	String FIND_ALL_FILIERE_FOR_COMBO = "SELECT x FROM Filiere x WHERE x.statut = 'ENABLED' ";

	/** The find filier by code. */
	String FIND_FILIERE_BY_CODE = "FROM Filiere x WHERE x.code = ?1 and x.statut != 'DELETED' ";

	String FIND_FILIERE_BY_IDSITE = "SELECT x FROM Filiere x inner join x.site site WHERE x.site.id like ?1 and x.statut != 'DELETED' ";

	String FIND_FILIERE_LIST_BY_CODE = "FROM Filiere x WHERE x.code = ?1 and x.statut != 'DELETED' ";

	// RESERVATION_BORNE
	/** The find RESERVATION_BORNE by criteria. */
	String FIND_RESERVATION_BORNE_BY_CRITERIA = "From ReservationBorne x inner join x.borne borne where  (?1 is null or x.montant like ?1)"
			+ "and  (?2 is null or x.cartePorteur  = ?2)"
			+ "and  (?3 is null or borne.id  = ?3) and  (?4 is null or borne.site.id = ?4)";

	String FIND_ALL_RESERVATION_BORNE_FOR_COMBO = "From ReservationBorne x where x.statut !='DELETED'";

	String FIND_IMPORT_INSCRIPTION_BY_CIN = " FROM ImportInscription x" + " where (?1 = x.cin)";

	String FIND_IMPORT_INSCRIPTION_BY_CRITERIA = " FROM ImportInscription x" + " where (?1 = x.cin or ?1 is null)"
			+ " and (?2 = x.codeMassar or ?2 is null)" + " and (?3 = x.userName or ?3 is null)";

	String FIND_IMPORT_INSCRIPTION_BY_CODE_MASSAR = " FROM ImportInscription x" + " where (?1 = x.codeMassar)";

	String FIND_NBR_DEMANDE = "SELECT COUNT(x) FROM Etudiants  x ";

	String FIND_RESIDENT_STUDENT_FOR_INSCRIPTION = "SELECT x FROM Etudiants x " + " WHERE  x.NCIN = ?1 "
			+ " and x.statut not in('DELETED','CLOSED')" + " order by x.id desc";
	String FIND_RESIDENT_STUDENT_FOR_INSCRIPTION_BY_MASSAR = "SELECT x FROM Etudiants x " + " WHERE  x.codeMassar = ?1 "
			+ " and x.statut not in('DELETED','CLOSED')" + " order by x.id desc";

	String FIND_OPPOSITION_BY_CRITERIA = "  FROM  Carte x  inner join  x.numPorteur  e    WHERE "
			+ "  (?1 is null or e.NCIN = ?1 )" + " and  (?2 is null or e.id  = ?2)"
			+ " and  (?3 is null or x.statut = ?3)" + " and  (?4 is null or e.codeMassar =  ?4)"
			+ " and  (x.statut in ('PERSONALIZED','DELIVRED','ACTIVATED','PERSONALIZEDOPPO','DELIVREDOPPO','ACTIVATEDOPPO') )"
			+ " and (?5 is null or e.site.id like ?5)";

	String FIND_DEMANDE_TO_REFABRICARTE_BY_CRITERIA = " FROM  Carte x inner join  x.numPorteur e WHERE "
			+ " x.statut in('PERSONALIZEDOPPO','DELIVREDOPPO','ACTIVATEDOPPO') "
			+ " and (?1 is null or e.ann_universitaire = ?1 )" + " and  (?2 is null or e.Nom like ?2)"
			+ " and  (?3 is null or e.Prenom like ?3)" + " and  (?4 is null or e.NCIN like ?4)"
			+ " and  (?5 is null or e.Email like ?5)" + " and (?6 is null or e.site.id like ?6)"
			+ " and  (e.statut != 'DELETED' )";

	String FIND_RESERVATION_BY_IDPORTEUR = "SELECT x FROM Reservation x WHERE x.user = ?1 and  x.etat='N'";
	String FIND_BY_CODE_MASSAR = "From Etudiants x where (trim(x.codeMassar) = trim(?1))";

	// DemandeAdmin
	/** The find DemandeAdmin by criteria. */
	String FIND_DEMANDE_ADMIN_BY_CRITERIA = "From DemandeAdmin x inner join x.borne borne where (?1 is null or borne.id like ?1) and "
			+ "(?2 is null or UPPER(x.matricule) like UPPER(?2))" + "and (?3 is null or UPPER(x.nom) like UPPER(?3))"
			+ "and (?4 is null or UPPER(x.prenom) like UPPER(?4))"
			+ "and (?5 is null or UPPER(x.typePersonnelle) like UPPER(?5))"
			+ "and (?6 is null or UPPER(x.typeDemande) like UPPER(?6)) and x.statut ='ENABLED' ";
}