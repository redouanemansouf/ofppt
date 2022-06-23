/*
 * ReservationWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.reservation.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationParJourVO;
import com.m2m.onousc.business.reservation.vo.ReservationParMoisVO;
import com.m2m.onousc.business.reservation.vo.ReservationParSemaineVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
public class ReservationWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private ReservationVO vo = new ReservationVO();

	/** The vos. */
	private List<ReservationVO> vos = new ArrayList<ReservationVO>();

	/** The reservation detail v os. */
	private List<ReservationDetailVO> reservationDetailVOs = new ArrayList<ReservationDetailVO>();

	/** The reservation par semaine v os. */
	private List<ReservationParSemaineVO> reservationParSemaineVOs = new ArrayList<ReservationParSemaineVO>();

	/** The reservation par jour vo. */
	private ReservationParJourVO reservationParJourVO = new ReservationParJourVO();

	/** The reservation par semaine vo. */
	private ReservationParSemaineVO reservationParSemaineVO = new ReservationParSemaineVO();

	/** The reservation par jour v os. */
	private List<ReservationParJourVO> reservationParJourVOs = new ArrayList<ReservationParJourVO>();

	/** The reservation par mois vo. */
	private ReservationParMoisVO reservationParMoisVO = new ReservationParMoisVO();

	/** The reservation par mois v os. */
	private List<ReservationParMoisVO> reservationParMoisVOs = new ArrayList<ReservationParMoisVO>();

	/** The semaine universitaire vo. */
	private SemaineUniversitaireVO semaineUniversitaireVO = new SemaineUniversitaireVO();

	/** The semaine universitaire v os. */
	private List<SemaineUniversitaireVO> semaineUniversitaireVOs = new ArrayList<SemaineUniversitaireVO>();

	/** The service list for combo. */
	private List<ServiceVO> serviceListForCombo = new ArrayList<ServiceVO>();

	/** The checked services. */
	private List<String> checkedServices = new ArrayList<String>();

	/** The service vo. */
	private ServiceVO serviceVO = new ServiceVO();

	/** The services. */
	private List<String> services = new ArrayList<String>();

	/** The reservation par jour. */
	private List<ReservationParJourVO> reservationsParJour = new ArrayList<ReservationParJourVO>();

	/** The reservations par semaine. */
	private List<ReservationParSemaineVO> reservationsParSemaine = new ArrayList<ReservationParSemaineVO>();

	/** The reservations par mois. */
	private List<ReservationParMoisVO> reservationsParMois = new ArrayList<ReservationParMoisVO>();

	/** The list of reservations non consomees. */
	private List<ReservationDetailVO> listOfReservationsNonConsomees = new ArrayList<ReservationDetailVO>();

	/** The list of reservations for annulation. */
	private List<ReservationDetailVO> listOfReservationsForAnnulation = new ArrayList<ReservationDetailVO>();

	/**
	 * Gets the reservation par semaine v os.
	 * 
	 * @return the reservation par semaine v os
	 */
	public List<ReservationParSemaineVO> getReservationParSemaineVOs() {
		return reservationParSemaineVOs;
	}

	/**
	 * Sets the reservation par semaine v os.
	 * 
	 * @param reservationParSemaineVOs
	 *            the new reservation par semaine v os
	 */
	public void setReservationParSemaineVOs(
			List<ReservationParSemaineVO> reservationParSemaineVOs) {
		this.reservationParSemaineVOs = reservationParSemaineVOs;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<ReservationVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the new vos
	 */
	public void setVos(List<ReservationVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the reservation detail v os.
	 * 
	 * @return the reservation detail v os
	 */
	public List<ReservationDetailVO> getReservationDetailVOs() {
		return reservationDetailVOs;
	}

	/**
	 * Sets the reservation detail v os.
	 * 
	 * @param reservationDetailVOs
	 *            the new reservation detail v os
	 */
	public void setReservationDetailVOs(
			List<ReservationDetailVO> reservationDetailVOs) {
		this.reservationDetailVOs = reservationDetailVOs;
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public ReservationVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the new vo
	 */
	public void setVo(ReservationVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the reservation par mois v os.
	 * 
	 * @return the reservation par mois v os
	 */
	public List<ReservationParMoisVO> getReservationParMoisVOs() {
		return reservationParMoisVOs;
	}

	/**
	 * Sets the reservation par mois v os.
	 * 
	 * @param reservationParMoisVOs
	 *            the new reservation par mois v os
	 */
	public void setReservationParMoisVOs(
			List<ReservationParMoisVO> reservationParMoisVOs) {
		this.reservationParMoisVOs = reservationParMoisVOs;
	}

	/**
	 * Gets the reservation par jour vo.
	 * 
	 * @return the reservation par jour vo
	 */
	public ReservationParJourVO getReservationParJourVO() {
		return reservationParJourVO;
	}

	/**
	 * Sets the reservation par jour vo.
	 * 
	 * @param reservationParJourVO
	 *            the new reservation par jour vo
	 */
	public void setReservationParJourVO(
			ReservationParJourVO reservationParJourVO) {
		this.reservationParJourVO = reservationParJourVO;
	}

	/**
	 * Gets the reservation par jour v os.
	 * 
	 * @return the reservation par jour v os
	 */
	public List<ReservationParJourVO> getReservationParJourVOs() {
		return reservationParJourVOs;
	}

	/**
	 * Sets the reservation par jour v os.
	 * 
	 * @param reservationParJourVOs
	 *            the new reservation par jour v os
	 */
	public void setReservationParJourVOs(
			List<ReservationParJourVO> reservationParJourVOs) {
		this.reservationParJourVOs = reservationParJourVOs;
	}

	/**
	 * Gets the reservation par mois vo.
	 * 
	 * @return the reservation par mois vo
	 */
	public ReservationParMoisVO getReservationParMoisVO() {
		return reservationParMoisVO;
	}

	/**
	 * Sets the reservation par mois vo.
	 * 
	 * @param reservationParMoisVO
	 *            the new reservation par mois vo
	 */
	public void setReservationParMoisVO(
			ReservationParMoisVO reservationParMoisVO) {
		this.reservationParMoisVO = reservationParMoisVO;
	}

	/**
	 * Gets the reservation par semaine vo.
	 * 
	 * @return the reservation par semaine vo
	 */
	public ReservationParSemaineVO getReservationParSemaineVO() {
		return reservationParSemaineVO;
	}

	/**
	 * Sets the reservation par semaine vo.
	 * 
	 * @param reservationParSemaineVO
	 *            the new reservation par semaine vo
	 */
	public void setReservationParSemaineVO(
			ReservationParSemaineVO reservationParSemaineVO) {
		this.reservationParSemaineVO = reservationParSemaineVO;
	}

	/**
	 * Gets the semaine universitaire v os.
	 * 
	 * @return the semaine universitaire v os
	 */
	public List<SemaineUniversitaireVO> getSemaineUniversitaireVOs() {
		return semaineUniversitaireVOs;
	}

	/**
	 * Sets the semaine universitaire v os.
	 * 
	 * @param semaineUniversitaireVOs
	 *            the new semaine universitaire v os
	 */
	public void setSemaineUniversitaireVOs(
			List<SemaineUniversitaireVO> semaineUniversitaireVOs) {
		this.semaineUniversitaireVOs = semaineUniversitaireVOs;
	}

	/**
	 * Gets the semaine universitaire vo.
	 * 
	 * @return the semaine universitaire vo
	 */
	public SemaineUniversitaireVO getSemaineUniversitaireVO() {
		return semaineUniversitaireVO;
	}

	/**
	 * Sets the semaine universitaire vo.
	 * 
	 * @param semaineUniversitaireVO
	 *            the new semaine universitaire vo
	 */
	public void setSemaineUniversitaireVO(
			SemaineUniversitaireVO semaineUniversitaireVO) {
		this.semaineUniversitaireVO = semaineUniversitaireVO;
	}

	/**
	 * Gets the services.
	 * 
	 * @return the services
	 */
	public List<String> getServices() {
		return services;
	}

	/**
	 * Sets the services.
	 * 
	 * @param services
	 *            the new services
	 */
	public void setServices(List<String> services) {
		this.services = services;
	}

	/**
	 * Gets the service list for combo.
	 * 
	 * @return the service list for combo
	 */
	public List<ServiceVO> getServiceListForCombo() {
		return serviceListForCombo;
	}

	/**
	 * Sets the service list for combo.
	 * 
	 * @param serviceListForCombo
	 *            the new service list for combo
	 */
	public void setServiceListForCombo(List<ServiceVO> serviceListForCombo) {
		this.serviceListForCombo = serviceListForCombo;
	}

	/**
	 * Gets the service vo.
	 * 
	 * @return the service vo
	 */
	public ServiceVO getServiceVO() {
		return serviceVO;
	}

	/**
	 * Sets the service vo.
	 * 
	 * @param serviceVO
	 *            the new service vo
	 */
	public void setServiceVO(ServiceVO serviceVO) {
		this.serviceVO = serviceVO;
	}

	/**
	 * Gets the checked services.
	 * 
	 * @return the checked services
	 */
	public List<String> getCheckedServices() {
		return checkedServices;
	}

	/**
	 * Sets the checked services.
	 * 
	 * @param checkedServices
	 *            the new checked services
	 */
	public void setCheckedServices(List<String> checkedServices) {
		this.checkedServices = checkedServices;
	}

	/**
	 * Gets the reservations par jour.
	 * 
	 * @return the reservations par jour
	 */
	public List<ReservationParJourVO> getReservationsParJour() {
		return reservationsParJour;
	}

	/**
	 * Sets the reservations par jour.
	 * 
	 * @param reservationsParJour
	 *            the new reservations par jour
	 */
	public void setReservationsParJour(
			List<ReservationParJourVO> reservationsParJour) {
		this.reservationsParJour = reservationsParJour;
	}

	/**
	 * Gets the reservations par semaine.
	 * 
	 * @return the reservations par semaine
	 */
	public List<ReservationParSemaineVO> getReservationsParSemaine() {
		return reservationsParSemaine;
	}

	/**
	 * Sets the reservations par semaine.
	 * 
	 * @param reservationsParSemaine
	 *            the new reservations par semaine
	 */
	public void setReservationsParSemaine(
			List<ReservationParSemaineVO> reservationsParSemaine) {
		this.reservationsParSemaine = reservationsParSemaine;
	}

	public List<ReservationParMoisVO> getReservationsParMois() {
		return reservationsParMois;
	}

	public void setReservationsParMois(
			List<ReservationParMoisVO> reservationsParMois) {
		this.reservationsParMois = reservationsParMois;
	}

	public List<ReservationDetailVO> getListOfReservationsNonConsomees() {
		return listOfReservationsNonConsomees;
	}

	public void setListOfReservationsNonConsomees(
			List<ReservationDetailVO> listOfReservationsNonConsomees) {
		this.listOfReservationsNonConsomees = listOfReservationsNonConsomees;
	}

	public List<ReservationDetailVO> getListOfReservationsForAnnulation() {
		return listOfReservationsForAnnulation;
	}

	public void setListOfReservationsForAnnulation(
			List<ReservationDetailVO> listOfReservationsForAnnulation) {
		this.listOfReservationsForAnnulation = listOfReservationsForAnnulation;
	}

}
