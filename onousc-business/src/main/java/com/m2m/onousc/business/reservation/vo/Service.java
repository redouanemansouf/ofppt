package com.m2m.onousc.business.reservation.vo;

public enum Service {

	SERVICE_MIDI("MIDI"), SERVICE_SOIR("SOIR");

	private String serviceCode;

	private Service(String s) {
		serviceCode = s;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
