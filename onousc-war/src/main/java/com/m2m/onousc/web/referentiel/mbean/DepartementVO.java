package com.m2m.onousc.web.referentiel.mbean;

public class DepartementVO {

	private String numeroCarte;

	private Long id;

	public DepartementVO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DepartementVO(Long id, String numeroCarte) {
		super();
		this.numeroCarte = numeroCarte;
		this.id = id;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

}
