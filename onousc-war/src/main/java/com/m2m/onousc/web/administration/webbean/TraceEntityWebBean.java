/*
 * TraceEntityWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 24 oct. 2015
 * @author iissouani
 */
public class TraceEntityWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	/** The vo. */
	private TraceEntityVO vo = new TraceEntityVO();

	/** The vos. */
	private List<TraceEntityVO> vos = new ArrayList<TraceEntityVO>();
	
	private List<TraceEntityVO> selectedVOs = new ArrayList<TraceEntityVO>();

	/** The service list for combo. */
	private List<ServiceVO> serviceListForCombo = new ArrayList<ServiceVO>();


	/**
	 * Gets the service list for combo.
	 * 
	 * @return the service list for combo
	 */
	public List<ServiceVO> getServiceListForCombo() {
		return serviceListForCombo;
	}

	/**
	 * Sets the service list for combo.
	 * 
	 * @param serviceListForCombo
	 *            the new service list for combo
	 */
	public void setServiceListForCombo(List<ServiceVO> serviceListForCombo) {
		this.serviceListForCombo = serviceListForCombo;
	}

	public TraceEntityVO getVo() {
		return vo;
	}

	public void setVo(TraceEntityVO vo) {
		this.vo = vo;
	}

	public List<TraceEntityVO> getVos() {
		return vos;
	}

	public void setVos(List<TraceEntityVO> vos) {
		this.vos = vos;
	}

	public List<TraceEntityVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<TraceEntityVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}


}
