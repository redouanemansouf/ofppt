package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.MotifMainLeveeCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class MotifMainLeveeSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492524574458538073L;
	private MotifMainLeveeCriteria MotifMainLeveeCriteria = new MotifMainLeveeCriteria();
	
	public MotifMainLeveeSearchMBean(){
		search = new MotifMainLeveeSearch();
		searchCriteria = MotifMainLeveeCriteria;
		initData();
	}
	
	public void initData() {

		searchCriteria = MotifMainLeveeCriteria;
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.MotifMainLeveeCriteria = new MotifMainLeveeCriteria();
		searchCriteria = MotifMainLeveeCriteria;
		
	}

	public MotifMainLeveeCriteria getMotifMainLeveeCriteria() {
		return MotifMainLeveeCriteria;
	}

	public void setMotifMainLeveeCriteria(MotifMainLeveeCriteria MotifMainLeveeCriteria) {
		this.MotifMainLeveeCriteria = MotifMainLeveeCriteria;
	}
}
