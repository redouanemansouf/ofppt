/*
 * ReservationMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.reservation.mbean;

import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.ToggleEvent;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationParJourVO;
import com.m2m.onousc.business.reservation.vo.ReservationParMoisVO;
import com.m2m.onousc.business.reservation.vo.ReservationParSemaineVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.business.reservation.vo.Service;
import com.m2m.onousc.business.reservation.vo.TypeReservation;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.reservation.IReservationBusDelegate;
import com.m2m.onousc.web.reservation.ReservationSrvPresentation;
import com.m2m.onousc.web.reservation.impl.ReservationBusDelegate;
import com.m2m.onousc.web.reservation.webbean.ReservationWebBean;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;
import com.m2m.technicalservices.web.UserSessionHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class ReservationMBean.
 * 
 * @author msadik
 * @version 1.0 9 oct. 2015
 */
@ManagedBean
@ViewScoped
public class ReservationMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148933612381819373L;

	/** The web bean. */
	ReservationWebBean webBean = new ReservationWebBean();

	/** The referentiel service. */
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	/** The reservation service. */
	ReservationSrvPresentation reservationService = (ReservationSrvPresentation) BeansLookuper
			.lookup("reservationSrvPresentation");

	/** The type reservation. */
	private String typeReservation = "JOUR";

	/** The action. */
	private String action = "";

	/** The service midi. */
	private boolean serviceMidi = false;

	/** The service soir. */
	private boolean serviceSoir = false;

	/** The date service. */
	private Date dateService = new Date();

	/** The numero carte. */
	private String numeroCarte;

	/** The date expiration. */
	private String dateExpiration;

	/** The validity of card. */
	private boolean validityOfCard = false;

	/** The code restaurant. */
	private String codeRestaurant;

	/** The nom usager. */
	private String nomUsager;

	/** The prenom usager. */
	private String prenomUsager;

	/** The solde usager. */
	private String soldeUsager;

	/** The debut reservation. */
	private Date debutReservation;

	/** The fin reservation. */
	private Date finReservation;

	/** The date derniere connexion. */
	private String dateDerniereConnexion;

	/** The service. */
	private String service;

	/** The list reservation. */
	private String listOfReservationAsString = "";

	/** The montant. */
	private String montant;

	/** The usager panel visibility. */
	private boolean usagerPanelVisibility;

	/** The reservation panel visibility. */
	private boolean reservationPanelVisibility;

	private Double montTotal=0.0;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.BaseMBean#init()
	 */
	/**
	 * Inits the.
	 */
	public void init() {
		
		webBean.setVos(reservationService.findReservationByDate(null, null));
		System.out.println("Size"+webBean.getVos().size());

	/*	// Remplir la liste des semaines universitaires
		this.webBean.setSemaineUniversitaireVOs(reservationService
				.findAllSemaineUniversitaireForCombo());

		// Remplir la liste des services
		this.webBean.setServiceListForCombo(referentielService
				.findAllServiceForCombo());

		// Remplir la liste des services à checker
		this.webBean.getServices().add(Service.SERVICE_MIDI.toString());
		this.webBean.getServices().add(Service.SERVICE_SOIR.toString());
		this.getUsager();*/

	}

	/**
	 * Gets the ip addr.
	 * 
	 * @param request
	 *            the request
	 * @return the ip addr
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * Reset menu.
	 */
	public void resetMenu() {
		this.setTypeReservation(null);
		this.setAction(null);
	}

	/**
	 * Redirect to home.
	 * 
	 * @return the string
	 */
	public String redirectToHome() {
		return "/pages/reservation/reservationForm.xhtml?faces-redirect=true";
	}

	/**
	 * Check validity of card.
	 * 
	 * @return true, if successful
	 */
	public void checkValidityOfCard() {
		validityOfCard = false;
		Date dateSystem = new Date();
		CarteVO carteVO = reservationService
				.findCarteByNumero(this.numeroCarte);
		if (carteVO != null && carteVO.getDateExpiration().after(dateSystem)) {
			validityOfCard = true;
		}
	}

	/**
	 * Gets the reservation par semaine as string.
	 * 
	 * @return the reservation par semaine as string
	 */
	private void getReservationParSemaineAsString() {
		listOfReservationAsString = "";
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateToString = " ";
		Date dateDebut = this.webBean.getReservationParSemaineVO()
				.getDateDebut();
		Date dateFin = this.webBean.getReservationParSemaineVO().getDateFin();
		Date date = dateDebut;
		while (date.before(DateUtil.addJours(dateFin, 1))) {
			dateToString = formatter.format(date);
			listOfReservationAsString += "|" + dateToString + this.getService();
			date = DateUtil.addJours(date, 1);
		}
	}

	/**
	 * Gets the reservation par jour as string.
	 * 
	 * @return the reservation par jour as string
	 */
	private void getReservationParJourAsString() {
		listOfReservationAsString = "";
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateToString = " ";
		Date dateDebut = this.webBean.getReservationParJourVO()
				.getDateReservation();
		Date dateFin = this.webBean.getReservationParJourVO()
				.getDateReservation();
		Date date = dateDebut;
		while (date.before(DateUtil.addJours(dateFin, 1))) {
			dateToString = formatter.format(date);
			listOfReservationAsString += "|" + dateToString + this.getService();
			date = DateUtil.addJours(date, 1);
		}
	}

	/**
	 * Gets the reservation par mois as string.
	 * 
	 * @return the reservation par mois as string
	 */
	public void getReservationParMoisAsString() {
		listOfReservationAsString = "";
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateToString = " ";
		Date dateDebut = this.webBean.getReservationParMoisVO().getDateDebut();
		Date dateFin = this.webBean.getReservationParMoisVO().getDateFin();
		Date date = dateDebut;
		while (date.before(DateUtil.addJours(dateFin, 1))) {
			dateToString = formatter.format(date);
			listOfReservationAsString += "|" + dateToString + this.getService();
			date = DateUtil.addJours(date, 1);
		}
	}

	/**
	 * Gets the annulation as string.
	 * 
	 * @return the annulation as string
	 */
	private void getAnnulationAsString() {
		listOfReservationAsString = "";
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateToString = " ";
		for (ReservationDetailVO vo : this.webBean
				.getListOfReservationsForAnnulation()) {
			dateToString = formatter.format(vo.getDateService());
			listOfReservationAsString += "|" + dateToString + "A";
		}
	}

	/**
	 * Gets the usager.
	 * 
	 * @return the usager
	 */
	private void getUsager() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		numeroCarte = params.get("numeroCarte");
		nomUsager = params.get("nomUsager");
		prenomUsager = params.get("prenomUsager");
		soldeUsager = params.get("soldeUsager");
	//	soldeUsager=Math.round(tonDouble * 100) / 100+"";
		dateDerniereConnexion = params.get("dateDerniereConnexion");

	}

	/**
	 * Gets the user connecte.
	 * 
	 * @return the user connecte
	 */
	public String getUserConnecte() {
		String user = UserSessionHelper.getUserConecte().getCode();
		return user == null ? "" : user;
	}

	/**
	 * Calculer montant.
	 * 
	 * @return the double
	 */
	public void calculerMontant1() {
		
		double montant = this.webBean.getVo().getReservationDetail().size() * 1.40;
		montant = (double) Math.round(montant * 100) / 100;
		this.webBean.getVo().setMontant(montant);
		this.montant = String.valueOf(montant);
	}
	
public void calculerMontant() {
		
	 TarifVO tarifS=new TarifVO();
	 double montant =0.0;
	for(ReservationDetailVO resvo:this.webBean.getVo().getReservationDetail())
	{
		if(reservationService.findTarifByCodeService(resvo.getService().getCode()).size()!=0)
		 tarifS = reservationService.findTarifByCodeService(resvo.getService().getCode()).get(0);
		 montant += tarifS.getTarif();
	}
		montant = (double) Math.round(montant * 100) / 100;
		this.webBean.getVo().setMontant(montant);
		this.montant = String.valueOf(montant);
	
}

	/**
	 * Preparer semaines. Le nombre de semaine doit être parametrable
	 */
	public void preparerSemaines() {
		int i;
		Date dateDebut = new Date();
		Date dateFin = DateUtil.addJours(dateDebut, 5);
		for (i = 1; i <= 5; i++) {
			this.webBean.getReservationParSemaineVOs().add(
					new ReservationParSemaineVO("S" + i, dateDebut, dateFin,
							true, true));
			dateDebut = DateUtil.addJours(dateFin, 1);
			dateFin = DateUtil.addJours(dateDebut, 5);
		}
	}

	/**
	 * Adds the jour reserve.
	 */
	public void addJourReserve() {
		// Récupérer le jour de la semaine
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.webBean.getReservationParJourVO().getDateReservation());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// Les réservations sont effectuées 48h à l’avance au moins
		Date dateOperation = new Date();
		Date dateService = DateUtil.addJours(dateOperation, 1);
		if (this.webBean.getReservationParJourVO().getDateReservation()
				.after(dateService)) {
			if (dayOfWeek == Calendar.SUNDAY) {
				addCollectorErrorMessage("reservation.nonAutoriseeDimanche");
				return;
			}
			// Service de soir n'est pas ouvert le samedi
			if (dayOfWeek == Calendar.SATURDAY) {
				for (String s : this.webBean.getCheckedServices()) {
					if (s.equals("02")) {
						addCollectorErrorMessage("reservation.ServiceSoirNonOuvertSamedi");
						return;
					}
				}

			} else {
				// Les services du midi et du soir ne sont pas ouvert le
				// dimanche.
				this.webBean.getReservationParJourVOs().add(
						this.webBean.getReservationParJourVO());
				this.webBean
						.setReservationParJourVO(new ReservationParJourVO());
			}
		} else {
			addCollectorErrorMessage("reservation.dateReservation");
		}

	}

	/** The on select semaine universitaire. */
	public void onSelectSemaineUniversitaire() {
		long idSemaineUniversitaire = this.webBean.getSemaineUniversitaireVO()
				.getId();
		SemaineUniversitaireVO semaineUniversitaireVO = reservationService
				.findSemaineUniversitaireById(idSemaineUniversitaire);
		this.webBean.getReservationParSemaineVO().setDateDebut(
				semaineUniversitaireVO.getDateDebut());
		this.webBean.getReservationParSemaineVO().setDateFin(
				semaineUniversitaireVO.getDateFin());
		this.webBean.getReservationParSemaineVO().setSemaine(
				semaineUniversitaireVO.getLibelle());
	}

	/**
	 * Adds the semaine reservee.
	 */
	public void addSemaineReservee() {
		this.webBean.getReservationParSemaineVOs().add(
				this.webBean.getReservationParSemaineVO());
		this.webBean.setReservationParSemaineVO(new ReservationParSemaineVO());
	}

	/**
	 * Removes the jour reserve.
	 * 
	 * @param reservationParJourVO
	 *            the reservation par jour vo
	 */
	public void removeJourReserve(ReservationParJourVO reservationParJourVO) {
		this.webBean.getReservationParJourVOs().remove(reservationParJourVO);
	}

	/**
	 * Removes the semaine reservee.
	 * 
	 * @param reservationParSemaineVO
	 *            the reservation par semaine vo
	 */
	public void removeSemaineReservee(
			ReservationParSemaineVO reservationParSemaineVO) {
		this.webBean.getReservationParSemaineVOs().remove(
				reservationParSemaineVO);
	}

	/**
	 * Gets the month for int.
	 * 
	 * @param num
	 *            the num
	 * @return the month for int
	 */
	private String getMonthForInt(int num) {
		String month = "";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 1) {
			month = months[num - 1];
		}
		return month;
	}

	/**
	 * Preparer mois. Les réservations peuvent être effectuées à partir du mois
	 * prochain
	 */
	public void preparerMois() {
		int monthNumber = DateUtil.getMonth(new Date());
		for (int i = monthNumber + 1; i < 12; i++) {
			this.webBean.getReservationParMoisVOs().add(
					new ReservationParMoisVO(i,
							getMonthForInt(i).toUpperCase(), true, true));
		}
	}

	/**
	 * Reserver par jour.
	 */
	public void reserverParJour() {
		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_JOUR);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);
		// for (ReservationParJourVO reservationParJourVO : this.webBean
		// .getReservationParJourVOs()) {
		// for (ServiceVO service : reservationParJourVO.getServices()) {
		// ReservationDetailVO detailVO = new ReservationDetailVO(service,
		// reservationParJourVO.getDateReservation(),
		// EtatReservation.NON_CONSOMEE);
		// detailVO.setReservation(this.webBean.getVo());
		// this.webBean.getVo().getReservationDetail().add(detailVO);
		//
		// }
		// Si service midi
		// if (reservationParJourVO.getServices().contains(
		// Service.SERVICE_MIDI.toString())) {
		// ReservationDetailVO detailVO = new ReservationDetailVO(
		// Service.SERVICE_MIDI,
		// reservationParJourVO.getDateReservation(),
		// EtatReservation.NON_CONSOMEE);
		// // Set parent
		// detailVO.setReservation(this.webBean.getVo());
		// this.webBean.getVo().getReservationDetail().add(detailVO);
		// }
		// Si service soir
		// if (reservationParJourVO.getServices().contains(
		// Service.SERVICE_SOIR.toString())) {
		// ReservationDetailVO detailVO = new ReservationDetailVO(
		// Service.SERVICE_SOIR,
		// reservationParJourVO.getDateReservation(),
		// EtatReservation.NON_CONSOMEE);
		// // Set parent
		// detailVO.setReservation(this.webBean.getVo());
		// this.webBean.getVo().getReservationDetail().add(detailVO);
		// }
		// }
		calculerMontant();
	}

	/**
	 * Reserver par semaine.
	 */
	public void reserverParSemaine() {
		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_SEMAINE);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);
		// Calendar pour récupérer le jour de la semaine
		Calendar cal = Calendar.getInstance();
		// Parcourir les semaines réservées
		for (ReservationParSemaineVO reservationParSemaineVO : this.webBean
				.getReservationParSemaineVOs()) {
			// Si service midi
			if (reservationParSemaineVO.getServices().contains(
					Service.SERVICE_MIDI.toString())) {
				Date temp = reservationParSemaineVO.getDateDebut();
				while (temp.before(DateUtil.addJours(
						reservationParSemaineVO.getDateFin(), 1))) {
					cal.setTime(temp);
					// if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					// this.webBean
					// .getVo()
					// .getReservationDetail()
					// .add(new ReservationDetailVO(
					// Service.SERVICE_MIDI, temp,
					// EtatReservation.NON_CONSOMEE));
					// }
					temp = DateUtil.addJours(temp, 1);
				}
			}
			// Si service soir
			if (reservationParSemaineVO.getServices().contains(
					Service.SERVICE_SOIR.toString())) {
				Date temp = reservationParSemaineVO.getDateDebut();
				while (temp.before(DateUtil.addJours(
						reservationParSemaineVO.getDateFin(), 1))) {
					cal.setTime(temp);
					if ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
							&& (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
						// this.webBean
						// .getVo()
						// .getReservationDetail()
						// .add(new ReservationDetailVO(
						// Service.SERVICE_SOIR, temp,
						// EtatReservation.NON_CONSOMEE));
					}
					temp = DateUtil.addJours(temp, 1);
				}
			}
		}
		// Calculer le montant à débiter
		calculerMontant();
	}

	/**
	 * Reserver par mois.
	 */
	public void reserverParMois() {
		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_MOIS);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);

		// Récupération premier jour et fin jour du mois
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, DateUtil.currentYear());
		cal.set(Calendar.MONTH, this.webBean.getReservationParMoisVO()
				.getCode());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDayOfMonth = cal.getTime();

		// Stockage des réservations
		Date temp = firstDayOfMonth;
		// Stocker les réservation service midi
		if (this.webBean.getReservationParMoisVO().getServices()
				.contains(Service.SERVICE_MIDI.toString())) {
			while (temp.before(DateUtil.addJours(lastDayOfMonth, 1))) {
				cal.setTime(temp);
				if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					// ReservationDetailVO detailVO = new ReservationDetailVO(
					// Service.SERVICE_MIDI, temp,
					// EtatReservation.NON_CONSOMEE);
					// Set parent
					// detailVO.setReservation(this.webBean.getVo());
					// this.webBean.getVo().getReservationDetail().add(detailVO);
				}
				temp = DateUtil.addJours(temp, 1);
			}
		}

		// init temp
		temp = firstDayOfMonth;
		// Stocker les réservation service soir
		if (this.webBean.getReservationParMoisVO().getServices()
				.contains(Service.SERVICE_SOIR.toString())) {
			while (temp.before(DateUtil.addJours(lastDayOfMonth, 1))) {
				cal.setTime(temp);
				if ((cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
						&& (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
					// ReservationDetailVO detailVO = new ReservationDetailVO(
					// Service.SERVICE_SOIR, temp,
					// EtatReservation.NON_CONSOMEE);
					// Set parent
					// detailVO.setReservation(this.webBean.getVo());
					// this.webBean.getVo().getReservationDetail().add(detailVO);
				}
				temp = DateUtil.addJours(temp, 1);
			}
		}
		// Calculer le montant à payer
		calculerMontant();

	}

	/**
	 * Gets the reservations by usager.
	 * 
	 * @return the reservations by usager
	 */
	public void getReservationsByUsager() {
		this.webBean.setVos(reservationService
				.findReservationByNumeroCarte(numeroCarte));
	}

	/**
	 * On row toggle.
	 * 
	 * @param event
	 *            the event
	 */
	public void onRowToggle(ToggleEvent event) {
		ReservationVO reservationVO = (ReservationVO) event.getData();
		this.webBean.setReservationDetailVOs(reservationService
				.findDetailByReservation(reservationVO.getId()));
	}

	/**
	 * Gets the date in customized format.
	 * 
	 * @param date
	 *            the date
	 * @return the date in customized format
	 */
	public String getDateInCustomizedFormat(Date date) {
		return  new SimpleDateFormat("EEEE").format(date)+" le "+new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	/**
	 * preparer la liste des jours de la semaine en cours.
	 */
	public void preparerReservationParJour() {
		// init réservation vo
		this.webBean.setVo(new ReservationVO());
		this.webBean
				.setReservationsParJour(new ArrayList<ReservationParJourVO>());
		Calendar cal = Calendar.getInstance();
		Date currentDate = new Date();
		Date dateService = DateUtil.addJours(currentDate, 2);
		cal.setTime(dateService);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// Si dimanche
		if (dayOfWeek == 1) {
			dateService = DateUtil.addJours(dateService, 1);
			cal.setTime(dateService);
			dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			while (dayOfWeek != 1) {
				this.webBean.getReservationsParJour().add(
						new ReservationParJourVO(dateService, dayOfWeek));
				dateService = DateUtil.addJours(dateService, 1);
				cal.setTime(dateService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			}

		}
		// Sinon
		else {
			while (dayOfWeek != 1) {
				if (!isFreeDay(dateService)) {
					this.webBean.getReservationsParJour().add(
							new ReservationParJourVO(dateService, dayOfWeek));
				}
				dateService = DateUtil.addJours(dateService, 1);
				cal.setTime(dateService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			}
		}
	}

	/**
	 * Preparer reservation par semaine.
	 */
	public void preparerReservationParSemaine() {
		// init réservation vo
		this.webBean.setVo(new ReservationVO());
		// Vider la liste des réservations par semaine
		this.webBean
				.setReservationsParSemaine(new ArrayList<ReservationParSemaineVO>());
		Calendar cal = Calendar.getInstance();
		Date dateReservation = new Date();
		Date dateDebutService = DateUtil.addJours(dateReservation, 2);
		Date dateFinService = new Date();
		cal.setTime(dateDebutService);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int currentMonth = cal.get(Calendar.MONTH);
		int nextMonth = cal.get(Calendar.MONTH) + 1;
		while (currentMonth != nextMonth) {
			switch (dayOfWeek) {
			// Case day of the week is sunday
			case 1:
				dateDebutService = DateUtil.addJours(dateDebutService, 1);
				// cal.setTime(dateDebutService);
				// dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				// dateFinService = DateUtil.addJours(dateDebutService, 5);
				dateFinService = dateDebutService;
				int moisCourant = DateUtil.getMonth(DateUtil.addJours(
						dateFinService, 1)) - 1;
				for (int i = 0; i <= 5; i++) {
					if (moisCourant == nextMonth) {
						break;
					} else {
						dateFinService = DateUtil.addJours(dateFinService, 1);
						moisCourant = DateUtil.getMonth(DateUtil.addJours(
								dateFinService, 1)) - 1;
					}
				}
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week is monday
			case 2:
				// dateFinService = DateUtil.addJours(dateDebutService, 5);
				dateFinService = dateDebutService;
				int moisCourant2 = DateUtil.getMonth(DateUtil.addJours(
						dateFinService, 1)) - 1;
				for (int i = 0; i <= 5; i++) {
					if (moisCourant2 == nextMonth) {
						break;
					} else {
						dateFinService = DateUtil.addJours(dateFinService, 1);
						moisCourant = DateUtil.getMonth(DateUtil.addJours(
								dateFinService, 1)) - 1;
					}
				}
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week is tuesday
			case 3:
				dateFinService = DateUtil.addJours(dateDebutService, 4);
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week wedesday
			case 4:
				dateFinService = DateUtil.addJours(dateDebutService, 3);
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week thursday
			case 5:
				dateFinService = DateUtil.addJours(dateDebutService, 2);
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week thursday friday
			case 6:
				dateFinService = DateUtil.addJours(dateDebutService, 1);
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			// Case day of the week thursday saturday
			case 7:
				dateFinService = DateUtil.addJours(dateDebutService, 0);
				this.webBean.getReservationsParSemaine().add(
						new ReservationParSemaineVO("S"
								+ cal.get(Calendar.WEEK_OF_MONTH),
								dateDebutService, dateFinService));
				dateDebutService = DateUtil.addJours(dateFinService, 1);
				cal.setTime(dateDebutService);
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				currentMonth = cal.get(Calendar.MONTH);
				break;
			}

		}
	}

	/**
	 * Preparer reservation par mois.Les réservations peuvent être effectuées à
	 * partir du mois prochain
	 */
	public void preparerReservationParMois() {
		// init réservation vo
		this.webBean.setVo(new ReservationVO());
		this.webBean
				.setReservationsParMois(new ArrayList<ReservationParMoisVO>());
		Date currentDate = new Date();
		int currentMonth = DateUtil.getMonth(currentDate);
		Date dateDebut = new Date();
		Date dateFin = new Date();
		Calendar cal = Calendar.getInstance();
		// à partir du mois prochain
		currentMonth++;
		for (int i = currentMonth; i <= 12; i++) {
			cal.add(Calendar.MONTH, i);
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.YEAR, DateUtil.getYear(currentDate));
			dateDebut = cal.getTime();
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
			dateFin = cal.getTime();
			this.webBean.getReservationsParMois()
					.add(new ReservationParMoisVO(i, getMonthForInt(i)
							.toUpperCase(), dateDebut, dateFin));
		}
	}

	/**
	 * Checks if is saturday.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is saturday
	 */
	public boolean isSaturday(Date date) {
		if (date == null) {
			return true;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				return true;
			} else
				return false;
		}
	}

	/**
	 * Checks if is free day.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is free day
	 */
	public boolean isFreeDay(Date date) {
		boolean b = referentielService.isFreeDay(date);
		if (date != null && b) {
			return true;
		} else
			return false;
	}

	/**
	 * Reserver.
	 */
	public void reserverJour() {
		// préparation du vo
		Date dateService = this.webBean.getReservationParJourVO()
				.getDateReservation();
		String libelle = "";
		Calendar cal = Calendar.getInstance();
		this.getReservationParJourAsString();
		// Case only one service
		if (this.webBean.getServiceVO() != null) {
			// Check if day of service is not a free day
			if (!isFreeDay(dateService)) {
				this.webBean
						.getVo()
						.getReservationDetail()
						.add(new ReservationDetailVO(this.webBean
								.getServiceVO(), dateService,
								EtatReservation.NON_CONSOMEE, this.webBean
										.getVo()));
			}
		}
		// Case all services
		else {
			for (ServiceVO s : this.webBean.getServiceListForCombo()) {
				// Check if day of service is not a free day
				if (!isFreeDay(dateService)) {
					this.webBean
							.getVo()
							.getReservationDetail()
							.add(new ReservationDetailVO(s, dateService,
									EtatReservation.NON_CONSOMEE, this.webBean
											.getVo()));
				}
			}
		}

		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_JOUR);
		cal.setTime(dateService);
		libelle = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
				Locale.CANADA_FRENCH).toUpperCase()
				+ "-S"
				+ cal.get(Calendar.WEEK_OF_MONTH)
				+ "-"
				+ getMonthForInt(DateUtil.getMonth(dateService)).toUpperCase();
		this.webBean.getVo().setLibelle(libelle);
		this.webBean.getVo().setEtat(EtatReservation.NON_CONSOMEE);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);
		RestaurantVO restaurant = referentielService
				.findRestaurantByCode(codeRestaurant);
		this.webBean.getVo().setRestaurant(restaurant);
		calculerMontant();
	}

	/**
	 * Reserver semaine.
	 */
	@SuppressWarnings("unused")
	public void reserverSemaine() {
		// préparation du vo
		String libelle = "";
		Calendar cal = Calendar.getInstance();
		Date dateDebut = this.webBean.getReservationParSemaineVO()
				.getDateDebut();
		Date dateFin = this.webBean.getReservationParSemaineVO().getDateFin();
		getReservationParSemaineAsString();
		// Cas un seul service est selectionné
		if (this.webBean.getServiceVO() != null) {
			Date date = dateDebut;
			while (date.before(DateUtil.addJours(dateFin, 1))) {
				if ((!isSaturday(date))
						&& (!this.webBean.getServiceVO().getCode().equals("S"))
						&& !isFreeDay(date)) {
					this.webBean
							.getVo()
							.getReservationDetail()
							.add(new ReservationDetailVO(this.webBean
									.getServiceVO(), date,
									EtatReservation.NON_CONSOMEE, this.webBean
											.getVo()));
				}
				if ((isSaturday(date)) && (!this.service.equals("S"))
						&& !isFreeDay(date)) {
					this.webBean
							.getVo()
							.getReservationDetail()
							.add(new ReservationDetailVO(this.webBean
									.getServiceVO(), date,
									EtatReservation.NON_CONSOMEE, this.webBean
											.getVo()));
				}
				date = DateUtil.addJours(date, 1);
			}
		}
		// Si l'utilisateur a sélectionné tous les services
		else {
			for (ServiceVO s : this.webBean.getServiceListForCombo()) {
				Date date = dateDebut;
				while (date.before(DateUtil.addJours(dateFin, 1))) {
					if ((!isSaturday(date)) && !isFreeDay(date)) {
						this.webBean
								.getVo()
								.getReservationDetail()
								.add(new ReservationDetailVO(s, date,
										EtatReservation.NON_CONSOMEE,
										this.webBean.getVo()));
					}
					if ((isSaturday(date)) && (s.getCode().equals("M"))
							&& (!isFreeDay(date))) {
						this.webBean
								.getVo()
								.getReservationDetail()
								.add(new ReservationDetailVO(s, date,
										EtatReservation.NON_CONSOMEE,
										this.webBean.getVo()));
					}
					date = DateUtil.addJours(date, 1);
				}
			}
		}
		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_SEMAINE);
		libelle = this.webBean.getReservationParSemaineVO().getSemaine()
				+ "-"
				+ getMonthForInt(
						DateUtil.getMonth(this.webBean
								.getReservationParSemaineVO().getDateDebut()))
						.toUpperCase();
		this.webBean.getVo().setLibelle(libelle);
		this.webBean.getVo().setEtat(EtatReservation.NON_CONSOMEE);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);
		RestaurantVO restaurant = referentielService
				.findRestaurantByCode(codeRestaurant);
		this.webBean.getVo().setRestaurant(restaurant);
		calculerMontant();
	}

	/**
	 * Reserver mois.
	 */
	public void reserverMois() {
		// préparation du vo
		String libelle = "";
		// Calendar cal = Calendar.getInstance();
		Date dateDebut = this.webBean.getReservationParMoisVO().getDateDebut();
		Date dateFin = this.webBean.getReservationParMoisVO().getDateFin();
		this.getReservationParMoisAsString();
		// Case one Service
		if (this.webBean.getServiceVO() != null) {
			Date date = dateDebut;
			while (date.before(DateUtil.addJours(dateFin, 1))) {
				// from Monday to Sanday
				if ((!isSaturday(date))
						&& (!this.webBean.getServiceVO().getCode().equals("S"))
						&& !isFreeDay(date)) {
					this.webBean
							.getVo()
							.getReservationDetail()
							.add(new ReservationDetailVO(this.webBean
									.getServiceVO(), date,
									EtatReservation.NON_CONSOMEE, this.webBean
											.getVo()));
				}
				// Saturday
				if ((isSaturday(date)) && (!this.service.equals("S"))
						&& !isFreeDay(date)) {
					this.webBean
							.getVo()
							.getReservationDetail()
							.add(new ReservationDetailVO(this.webBean
									.getServiceVO(), date,
									EtatReservation.NON_CONSOMEE, this.webBean
											.getVo()));
				}
				date = DateUtil.addJours(date, 1);
			}
		}
		// Case all services
		else {
			for (ServiceVO s : this.webBean.getServiceListForCombo()) {
				Date date = dateDebut;
				while (date.before(DateUtil.addJours(dateFin, 1))) {
					if ((!isSaturday(date)) && !isFreeDay(date)) {
						this.webBean
								.getVo()
								.getReservationDetail()
								.add(new ReservationDetailVO(s, date,
										EtatReservation.NON_CONSOMEE,
										this.webBean.getVo()));
					}
					if ((isSaturday(date)) && (s.getCode().equals("M"))
							&& (!isFreeDay(date))) {
						this.webBean
								.getVo()
								.getReservationDetail()
								.add(new ReservationDetailVO(s, date,
										EtatReservation.NON_CONSOMEE,
										this.webBean.getVo()));
					}
					date = DateUtil.addJours(date, 1);
				}
			}
		}
		this.webBean.getVo().setDateOperation(new Date());
		this.webBean.getVo().setTypeReservation(TypeReservation.PAR_MOIS);
		libelle = this.webBean.getReservationParMoisVO().getMois();
		this.webBean.getVo().setLibelle(libelle);
		this.webBean.getVo().setEtat(EtatReservation.NON_CONSOMEE);
		CarteVO carte = reservationService.findCarteByNumero(numeroCarte);
		this.webBean.getVo().setCarte(carte);
		RestaurantVO restaurant = referentielService
				.findRestaurantByCode(codeRestaurant);
		this.webBean.getVo().setRestaurant(restaurant);
		calculerMontant();

	}

	/**
	 * Gets the reservations non consomees.
	 * 
	 * @return the reservations non consomees
	 */
	public void getReservationsNonConsomees() {
//		
		System.out.println("numero carte"+numeroCarte);
		if(numeroCarte!=null)
			this.webBean.setListOfReservationsNonConsomees(reservationService
					.findReservationByEtat(EtatReservation.NON_CONSOMEE,numeroCarte));
		else
			
		this.webBean.setListOfReservationsNonConsomees(reservationService
				.findReservationByEtat(EtatReservation.NON_CONSOMEE,webBean.getVo().getCarte().getNumeroCarte()));
	}

	/**
	 * Annuler selected reservation.
	 */
	public void annulerSelectedReservation() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
	double mont=0.0;
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
		 TarifVO tarifS=new TarifVO();
		IReservationBusDelegate delegate = new ReservationBusDelegate();
		
		error = delegate.annulerReservation(webBean);
		
		
		if (!error) {
			for(ReservationDetailVO resvo:this.webBean
					.getListOfReservationsForAnnulation())
			{
				if(reservationService.findTarifByCodeService(resvo.getService().getCode()).size()!=0)
				 tarifS = reservationService.findTarifByCodeService(resvo.getService().getCode()).get(0);
				mont += tarifS.getTarif();
			}
			montant = String.valueOf(mont);
			this.getAnnulationAsString();
			this.webBean
					.setListOfReservationsForAnnulation(new ArrayList<ReservationDetailVO>());
			getReservationsNonConsomees();
			//addPrezMsgInfo("ANNULATION_CREATE_SUCCESS", null);
			addInfoMessage("ANNULATION_CREATE_SUCCESS", FacesMessage.SEVERITY_INFO);
			
		}
		else
		{
			addInfoMessage("RESERVATION_ANNULATION_ERROR", FacesMessage.SEVERITY_ERROR);
		}
		
		getReservationsNonConsomees();
		getReservationsByUsager();
	//	feedReport();
	//	userSession.setUserConecte(null);
	//	FacesContext fc = FacesContext.getCurrentInstance();
	//	fc.getExternalContext().getSessionMap().clear();
	}

	/**
	 * Creer.
	 */
	public void creer() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
		
		// controler le solde
		double solde = Double.valueOf(soldeUsager);
		double montant = this.webBean.getVo().getMontant();
		if (solde < montant) {
			addCollectorErrorMessage("SOLDE_INSUFFISANT");
		} else {
			IReservationBusDelegate delegate = new ReservationBusDelegate();
			error = delegate.creerReservation(webBean);
			if (!error) {
				//addPrezMsgInfo("RESERVATION_CREATE_SUCCESS", null);
				addInfoMessage("RESERVATION_CREATE_SUCCESS", FacesMessage.SEVERITY_INFO);
				this.webBean.setVo(new ReservationVO());
			}
			else
			{
				addInfoMessage("RESERVATION_CREATE_ERROR", FacesMessage.SEVERITY_ERROR);
			}
		}
		
		
		

		
	//	feedReport();
		//userSession.setUserConecte(null);
	//	FacesContext fc = FacesContext.getCurrentInstance();
		//fc.getExternalContext().getSessionMap().clear();
	//	System.out.println("numvarte"+numeroCarte);
	

	}
	
	
	public void modifer() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
		
	
			IReservationBusDelegate delegate = new ReservationBusDelegate();
			error = delegate.annulerReservation(webBean);
			if (!error) {
				//addPrezMsgInfo("RESERVATION_CREATE_SUCCESS", null);
				addInfoMessage("RESERVATION_VALIDE_SUCCESS", FacesMessage.SEVERITY_INFO);
				//this.webBean.setVo(new ReservationVO());
				webBean.setVos(reservationService.findReservationByDate(null, null));
			}
			else
			{
				addInfoMessage("RESERVATION_VALIDER_ERROR", FacesMessage.SEVERITY_ERROR);
			}
			
		}
		
		
		
	
	
	
	public void creerRes() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
		
		// controler le solde
		double solde = Double.valueOf(soldeUsager);
		double montant = this.webBean.getVo().getMontant();
		if (solde < montant) {
			addCollectorErrorMessage("SOLDE_INSUFFISANT");
		} else {
			IReservationBusDelegate delegate = new ReservationBusDelegate();
			error = delegate.creerReservation(webBean);
			if (!error) {
				//addPrezMsgInfo("RESERVATION_CREATE_SUCCESS", null);
				addInfoMessage("RESERVATION_CREATE_SUCCESS", FacesMessage.SEVERITY_INFO);
				this.webBean.setVo(new ReservationVO());
			}
			else
			{
				addInfoMessage("RESERVATION_CREATE_ERROR", FacesMessage.SEVERITY_ERROR);
			}
		}
		
		
	//	feedReport();
		//userSession.setUserConecte(null);
	//	FacesContext fc = FacesContext.getCurrentInstance();
		//fc.getExternalContext().getSessionMap().clear();
	//	System.out.println("numvarte"+numeroCarte);
	

	}

	/**
	 * Gets the web bean.
	 * 
	 * @return the web bean
	 */
	public ReservationWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean
	 *            the new web bean
	 */
	public void setWebBean(ReservationWebBean webBean) {
		this.webBean = webBean;
	}

	/**
	 * Gets the type reservation.
	 * 
	 * @return the type reservation
	 */
	public String getTypeReservation() {
		return typeReservation;
	}

	/**
	 * Sets the type reservation.
	 * 
	 * @param typeReservation
	 *            the new type reservation
	 */
	public void setTypeReservation(String typeReservation) {
		this.typeReservation = typeReservation;
	}

	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 * 
	 * @param action
	 *            the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Gets the date service.
	 * 
	 * @return the date service
	 */
	public Date getDateService() {
		return dateService;
	}

	/**
	 * Sets the date service.
	 * 
	 * @param dateService
	 *            the new date service
	 */
	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}

	/**
	 * Checks if is service midi.
	 * 
	 * @return true, if is service midi
	 */
	public boolean isServiceMidi() {
		return serviceMidi;
	}

	/**
	 * Sets the service midi.
	 * 
	 * @param serviceMidi
	 *            the new service midi
	 */
	public void setServiceMidi(boolean serviceMidi) {
		this.serviceMidi = serviceMidi;
	}

	/**
	 * Checks if is service soir.
	 * 
	 * @return true, if is service soir
	 */
	public boolean isServiceSoir() {
		return serviceSoir;
	}

	/**
	 * Sets the service soir.
	 * 
	 * @param serviceSoir
	 *            the new service soir
	 */
	public void setServiceSoir(boolean serviceSoir) {
		this.serviceSoir = serviceSoir;
	}

	/**
	 * Gets the referentiel service.
	 * 
	 * @return the referentiel service
	 */
	public ReferentielSrvPresentation getReferentielService() {
		return referentielService;
	}

	/**
	 * Sets the referentiel service.
	 * 
	 * @param referentielService
	 *            the new referentiel service
	 */
	public void setReferentielService(
			ReferentielSrvPresentation referentielService) {
		this.referentielService = referentielService;
	}

	/**
	 * Gets the reservation service.
	 * 
	 * @return the reservation service
	 */
	public ReservationSrvPresentation getReservationService() {
		return reservationService;
	}

	/**
	 * Sets the reservation service.
	 * 
	 * @param reservationService
	 *            the new reservation service
	 */
	public void setReservationService(
			ReservationSrvPresentation reservationService) {
		this.reservationService = reservationService;
	}

	/**
	 * Gets the numero carte.
	 * 
	 * @return the numero carte
	 */
	public String getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * Sets the numero carte.
	 * 
	 * @param numeroCarte
	 *            the new numero carte
	 */
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * Gets the nom usager.
	 * 
	 * @return the nom usager
	 */
	public String getNomUsager() {
		return nomUsager;
	}

	/**
	 * Sets the nom usager.
	 * 
	 * @param nomUsager
	 *            the new nom usager
	 */
	public void setNomUsager(String nomUsager) {
		this.nomUsager = nomUsager;
	}

	/**
	 * Gets the prenom usager.
	 * 
	 * @return the prenom usager
	 */
	public String getPrenomUsager() {
		return prenomUsager;
	}

	/**
	 * Sets the prenom usager.
	 * 
	 * @param prenomUsager
	 *            the new prenom usager
	 */
	public void setPrenomUsager(String prenomUsager) {
		this.prenomUsager = prenomUsager;
	}

	/**
	 * Gets the solde usager.
	 * 
	 * @return the solde usager
	 */
	public String getSoldeUsager() {
		return soldeUsager;
	}

	/**
	 * Sets the solde usager.
	 * 
	 * @param soldeUsager
	 *            the new solde usager
	 */
	public void setSoldeUsager(String soldeUsager) {
		this.soldeUsager = soldeUsager;
	}

	/**
	 * Gets the service.
	 * 
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * Sets the service.
	 * 
	 * @param service
	 *            the new service
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * Gets the debut reservation.
	 * 
	 * @return the debut reservation
	 */
	public Date getDebutReservation() {
		return debutReservation;
	}

	/**
	 * Sets the debut reservation.
	 * 
	 * @param debutReservation
	 *            the new debut reservation
	 */
	public void setDebutReservation(Date debutReservation) {
		this.debutReservation = debutReservation;
	}

	/**
	 * Gets the fin reservation.
	 * 
	 * @return the fin reservation
	 */
	public Date getFinReservation() {
		return finReservation;
	}

	/**
	 * Sets the fin reservation.
	 * 
	 * @param finReservation
	 *            the new fin reservation
	 */
	public void setFinReservation(Date finReservation) {
		this.finReservation = finReservation;
	}

	/**
	 * Gets the date derniere connexion.
	 * 
	 * @return the date derniere connexion
	 */
	public String getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	/**
	 * Sets the date derniere connexion.
	 * 
	 * @param dateDerniereConnexion
	 *            the new date derniere connexion
	 */
	public void setDateDerniereConnexion(String dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	/**
	 * Gets the list of reservation as string.
	 * 
	 * @return the list of reservation as string
	 */
	public String getListOfReservationAsString() {
		return listOfReservationAsString;
	}

	/**
	 * Sets the list of reservation as string.
	 * 
	 * @param listOfReservationAsString
	 *            the new list of reservation as string
	 */
	public void setListOfReservationAsString(String listOfReservationAsString) {
		this.listOfReservationAsString = listOfReservationAsString;
	}

	/**
	 * Gets the montant.
	 * 
	 * @return the montant
	 */
	public String getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 * 
	 * @param montant
	 *            the new montant
	 */
	public void setMontant(String montant) {
		this.montant = montant;
	}

	/**
	 * Gets the code restaurant.
	 * 
	 * @return the code restaurant
	 */
	public String getCodeRestaurant() {
		return codeRestaurant;
	}

	/**
	 * Sets the code restaurant.
	 * 
	 * @param codeRestaurant
	 *            the new code restaurant
	 */
	public void setCodeRestaurant(String codeRestaurant) {
		this.codeRestaurant = codeRestaurant;
	}

	/**
	 * Gets the date expiration.
	 * 
	 * @return the date expiration
	 */
	public String getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Sets the date expiration.
	 * 
	 * @param dateExpiration
	 *            the new date expiration
	 */
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * Checks if is validity of card.
	 * 
	 * @return true, if is validity of card
	 */
	public boolean isValidityOfCard() {
		return validityOfCard;
	}

	/**
	 * Sets the validity of card.
	 * 
	 * @param validityOfCard
	 *            the new validity of card
	 */
	public void setValidityOfCard(boolean validityOfCard) {
		this.validityOfCard = validityOfCard;
	}

	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.BaseMBean#isAutorise()
	 */
//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_RES);
//	}

	/**
	 * Checks if is usager panel visibility.
	 * 
	 * @return true, if is usager panel visibility
	 */
	public boolean isUsagerPanelVisibility() {
		return usagerPanelVisibility;
	}

	/**
	 * Sets the usager panel visibility.
	 * 
	 * @param usagerPanelVisibility
	 *            the new usager panel visibility
	 */
	public void setUsagerPanelVisibility(boolean usagerPanelVisibility) {
		this.usagerPanelVisibility = usagerPanelVisibility;
	}

	/**
	 * Checks if is reservation panel visibility.
	 * 
	 * @return true, if is reservation panel visibility
	 */
	public boolean isReservationPanelVisibility() {
		return reservationPanelVisibility;
	}

	/**
	 * Sets the reservation panel visibility.
	 * 
	 * @param reservationPanelVisibility
	 *            the new reservation panel visibility
	 */
	public void setReservationPanelVisibility(boolean reservationPanelVisibility) {
		this.reservationPanelVisibility = reservationPanelVisibility;
	}

	public Double getMontTotal() {
		return montTotal;
	}

	public void setMontTotal(Double montTotal) {
		this.montTotal = montTotal;
	}
	
}
