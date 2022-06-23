package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ReservationBorneCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class ReservationBorneSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166464540212473995L;

	/** ReservationBorne criteria **/
	private ReservationBorneCriteria reservationBorneCriteria = new ReservationBorneCriteria();

	public ReservationBorneSearchMBean() {
		// super();
		search = new ReservationBorneSearch();
		searchCriteria = reservationBorneCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = reservationBorneCriteria;
		run();
	}

	public ReservationBorneCriteria getReservationBorneCriteria() {
		return reservationBorneCriteria;
	}

	public void setReservationBorneCriteria(ReservationBorneCriteria ReservationBorneCriteria) {
		this.reservationBorneCriteria = ReservationBorneCriteria;
	}

	@Override
	public void resetSearchCriteria() {
		this.reservationBorneCriteria = new ReservationBorneCriteria();
		searchCriteria = reservationBorneCriteria;
	}

}
