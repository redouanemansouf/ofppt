package com.m2m.onousc.business.statistique.vo;

import java.util.Date;

import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class TransactionVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7405060154314383133L;

	private Long id;

	private String typeOperation;
	private Double total;
	private String cite;
	private String resto;
	private Date date;
	private Integer annee;
	private Integer mois;
	private Integer semaine;

	public TransactionVO() {
		super();
	}

	public TransactionVO(String typeOperation, Double total) {
		super();
		this.typeOperation = typeOperation;
		this.total = total;
	}

	public TransactionVO(String typeOperation, Double total, String cite,
			String resto, Date date, Integer annee, Integer mois,
			Integer semaine) {
		super();
		this.typeOperation = typeOperation;
		this.total = total;
		this.cite = cite;
		this.resto = resto;
		this.date = date;
		this.annee = annee;
		this.mois = mois;
		this.semaine = semaine;
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

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Integer getSemaine() {
		return semaine;
	}

	public void setSemaine(Integer semaine) {
		this.semaine = semaine;
	}

}
