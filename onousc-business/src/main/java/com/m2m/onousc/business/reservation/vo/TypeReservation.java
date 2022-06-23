package com.m2m.onousc.business.reservation.vo;

public enum TypeReservation {

	PAR_JOUR("JOUR"), PAR_SEMAINE("SEMAINE"), PAR_MOIS("MOIS");

	private String typeReservationCode;

	private TypeReservation(String s) {
		typeReservationCode = s;
	}

	public String getTypeReservationCode() {
		return typeReservationCode;
	}

	public void setTypeReservationCode(String typeReservationCode) {
		this.typeReservationCode = typeReservationCode;
	}

}
