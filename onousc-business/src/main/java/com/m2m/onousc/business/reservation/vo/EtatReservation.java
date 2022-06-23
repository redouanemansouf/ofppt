package com.m2m.onousc.business.reservation.vo;

public enum EtatReservation {

	CONSOMEE("CONSOMEE"), NON_CONSOMEE("NON CONSOMEE"), ANNULEE("ANNULEE");

	private String etatReservation;

	private EtatReservation(String s) {
		etatReservation = s;
	}

	public String getEtatReservation() {
		return etatReservation;
	}

	public void setEtatReservation(String etatReservation) {
		this.etatReservation = etatReservation;
	}

}
