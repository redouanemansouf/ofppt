package com.m2m.onousc.web.administration.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class TraceEntitySearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762928174124428067L;
	private TraceEntityCriteria traceEntityCriteria = new TraceEntityCriteria();

	public TraceEntitySearchMBean() {
		super();
		search = new TraceEnitySearch();
		searchCriteria = traceEntityCriteria;
		initData();
	}

	public void initData() {
		searchCriteria = traceEntityCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.traceEntityCriteria = new TraceEntityCriteria();
		searchCriteria = traceEntityCriteria;
	}

	public TraceEntityCriteria getTraceEntityCriteria() {
		return traceEntityCriteria;
	}

	public void setTraceEntityCriteria(TraceEntityCriteria traceEntityCriteria) {
		this.traceEntityCriteria = traceEntityCriteria;
	}



}
