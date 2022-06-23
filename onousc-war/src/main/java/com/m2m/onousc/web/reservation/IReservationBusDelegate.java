/*
 * IReservationBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.reservation;

import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.onousc.web.reservation.webbean.ReservationWebBean;

/**
 * The Interface IReservationBusDelegate.
 * 
 * @version 1.0 27 oct. 2015
 * @author user
 */
public interface IReservationBusDelegate {

	/**
	 * Creer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean creerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Supprimer collection canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean supprimerCollectionCanalVente(CanalVenteWebBean webBean);

	/**
	 * Desactiver canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean desactiverCanalVente(CanalVenteWebBean webBean);

	/**
	 * Activer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean activerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Supprimer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean supprimerCanalVente(CanalVenteWebBean webBean);

	/**
	 * Modifier canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean modifierCanalVente(CanalVenteWebBean webBean);

	/**
	 * Creer reservation.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean creerReservation(ReservationWebBean webBean);

	/**
	 * Annuler reservation.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	boolean annulerReservation(ReservationWebBean webBean);

}
