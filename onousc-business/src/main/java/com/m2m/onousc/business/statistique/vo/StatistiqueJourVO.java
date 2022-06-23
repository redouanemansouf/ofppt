package com.m2m.onousc.business.statistique.vo;

import java.util.Date;

import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class StatistiqueJourVO implements ValueObject, ISearchResultVO,
		Comparable<StatistiqueJourVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4120315411855244899L;
	private Long id;
	private Date dateOperation;
	private Long nbreReservation;
	private Long nbreRepasConsomme;
	private Double montantRepasConsomme;
	private Integer annee;
	private Integer mois;
	private Integer semain;
	private String cite;
	private String resto;

	public StatistiqueJourVO() {
		super();
	}

	public StatistiqueJourVO(Date dateOperation, Long nbreReservation,
			Long nbreRepasConsomme, Double montantRepasConsomme, Integer annee,
			Integer mois, Integer semain) {
		super();
		this.dateOperation = dateOperation;
		this.nbreReservation = nbreReservation;
		this.nbreRepasConsomme = nbreRepasConsomme;
		this.montantRepasConsomme = montantRepasConsomme;
		this.annee = annee;
		this.mois = mois;
		this.semain = semain;
	}

	public StatistiqueJourVO(Date dateOperation, Long nbreReservation,
			Long nbreRepasConsomme, Double montantRepasConsomme, Integer annee,
			Integer mois, Integer semain, String cite, String resto) {
		super();
		this.dateOperation = dateOperation;
		this.nbreReservation = nbreReservation;
		this.nbreRepasConsomme = nbreRepasConsomme;
		this.montantRepasConsomme = montantRepasConsomme;
		this.annee = annee;
		this.mois = mois;
		this.semain = semain;
		this.cite = cite;
		this.resto = resto;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNbreReservation() {
		return nbreReservation;
	}

	public void setNbreReservation(Long nbreReservation) {
		this.nbreReservation = nbreReservation;
	}

	public Long getNbreRepasConsomme() {
		return nbreRepasConsomme;
	}

	public void setNbreRepasConsomme(Long nbreRepasConsomme) {
		this.nbreRepasConsomme = nbreRepasConsomme;
	}

	public Double getMontantRepasConsomme() {
		return montantRepasConsomme;
	}

	public void setMontantRepasConsomme(Double montantRepasConsomme) {
		this.montantRepasConsomme = montantRepasConsomme;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getMois() {
		return mois;
	}

	public void setMois(Integer mois) {
		this.mois = mois;
	}

	public Integer getSemain() {
		return semain;
	}

	public void setSemain(Integer semain) {
		this.semain = semain;
	}

	public String getCite() {
		return cite;
	}

	public void setCite(String cite) {
		this.cite = cite;
	}

	public String getResto() {
		return resto;
	}

	public void setResto(String resto) {
		this.resto = resto;
	}

	@Override
	public int compareTo(StatistiqueJourVO o) {
		if (this.getDateOperation()
				.after(((StatistiqueJourVO) o).dateOperation))
			return 1;
		else if (this.getDateOperation().before(
				((StatistiqueJourVO) o).dateOperation))
			return -1;
		else
			return 0;
	}

}
