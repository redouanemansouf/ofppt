/*
 * ReferentielBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.reservation.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.validation.groups.Default;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.onousc.web.reservation.IReservationBusDelegate;
import com.m2m.onousc.web.reservation.webbean.ReservationWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.web.BaseBusDelegate;

public class ReservationBusDelegate extends BaseBusDelegate implements
		IReservationBusDelegate {

	/**
	 * Instantiates a new referentiel bus delegate.
	 */
	public ReservationBusDelegate() {

		domaine = "RESERVATION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

	/**
	 * Creer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean creerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.ENABLED);
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Modifier canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean modifierCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_EDITER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Supprimer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	public boolean supprimerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_CANAL_VENTE;
		CanalVenteVO vo = webBean.getVo();
		vo.setStatut(EntityStatus.DELETED);
		CanalVenteVO returnVO = (CanalVenteVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	/**
	 * Activer canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean activerCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.ENABLED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(
					vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}

		return error;
	}

	/**
	 * Desactiver canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean desactiverCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!vos.isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.DISABLED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(
					vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	/**
	 * Supprimer collection canal vente.
	 * 
	 * @param webBean
	 *            the web bean
	 * @return true, if successful
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean supprimerCollectionCanalVente(CanalVenteWebBean webBean) {
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_SUPPRIMER_COLLECTION_CANAL_VENTE;
		List<CanalVenteVO> vos = webBean.getSelectedVOs();
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CanalVenteVO vo : vos) {
				vo.setStatut(EntityStatus.DELETED);
			}
			List<CanalVenteVO> returnVOs = (List<CanalVenteVO>) executeCommand(
					vos, command, sousCommand);
			if (!error) {
				webBean.setSelectedVOs(returnVOs);
			}
		}
		return error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.web.reservation.IReservationBusDelegate#creerReservation
	 * (com.m2m.onousc.web.reservation.webbean.ReservationWebBean)
	 */
	@Override
	public boolean creerReservation(ReservationWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESERVATIONE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_RESERVATION;
		// List<ReservationVO> vos = webBean.getVos();
		ReservationVO vo = webBean.getVo();
		ReservationVO returnVO = (ReservationVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		return error;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean annulerReservation(ReservationWebBean webBean) {
		String command = Constantes.COMMAND_GERER_RESERVATIONE;
		String sousCommand = Constantes.SOUS_COMMAND_ANNULER_RESERVATION;
		ReservationVO vo = webBean.getVo();
		vo.setEtat(EtatReservation.CONSOMEE);
		ReservationVO returnVO = (ReservationVO) executeCommand(vo, command,
				sousCommand);
		if (!error) {
			webBean.setVo(returnVO);
		}
		
		/*List<ReservationVO> vos = webBean
				.getVos();
		if (!webBean.getListOfReservationsForAnnulation().isEmpty()) {
			for (ReservationVO vo : vos) {
				vo.setEtat(EtatReservation.CONSOMEE);
			}
			List<ReservationDetailVO> returnVOs = (List<ReservationDetailVO>) executeCommand(
					vos, command, sousCommand);
			if (!error) {
				webBean.setListOfReservationsForAnnulation(returnVOs);
			}
		}
		*/
		return error;
		
			
			
	

	}
}
