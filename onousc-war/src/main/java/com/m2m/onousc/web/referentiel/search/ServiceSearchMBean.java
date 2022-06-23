package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ServiceCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class ServiceSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2110281960891537732L;
	
	private ServiceCriteria serviceCriteria = new ServiceCriteria();
	
	public ServiceSearchMBean(){
		super();
		search = new ServiceSearch();
		searchCriteria = serviceCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = serviceCriteria;
		run();
	}
	@Override
	public void resetSearchCriteria() {
		this.serviceCriteria = new ServiceCriteria();
		searchCriteria = serviceCriteria;
		
	}

	public ServiceCriteria getServiceCriteria() {
		return serviceCriteria;
	}

	public void setServiceCriteria(ServiceCriteria serviceCriteria) {
		this.serviceCriteria = serviceCriteria;
	}

}
