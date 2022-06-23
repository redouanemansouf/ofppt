package com.m2m.onousc.web.referentiel.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria;
import com.m2m.technicalservices.web.AbstractSearchMBean;

@ManagedBean
@ViewScoped
public class RestaurantSearchMBean extends AbstractSearchMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2704430766816832238L;
	
	/** restaurant criteria**/
	private RestaurantCriteria restaurantCriteria = new RestaurantCriteria();
	
	public RestaurantSearchMBean(){
		super();
		search = new RestaurantSearch();
		searchCriteria = restaurantCriteria;
		initData();
	}
	
	public void initData(){
		searchCriteria = restaurantCriteria;
		run();
	}
	
	@Override
	public void resetSearchCriteria() {
		this.restaurantCriteria = new RestaurantCriteria();
		searchCriteria = restaurantCriteria;
	}

	public RestaurantCriteria getRestaurantCriteria() {
		return restaurantCriteria;
	}

	public void setRestaurantCriteria(RestaurantCriteria restaurantCriteria) {
		this.restaurantCriteria = restaurantCriteria;
	}
	
	
}
