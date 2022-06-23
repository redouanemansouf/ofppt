package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class PlafondWebBean extends BaseWebBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8811654234295223277L;
private PlafondVO vo;
	
	/**
	 * The vos
	 */
	private List<PlafondVO> vos;
	
	/** The selected v os. */
	private List<PlafondVO> selectedVOs;
	
	private List<ServiceVO> serviceVOs;
	
	public List<ServiceVO> getServiceVOs() {
		return serviceVOs;
	}

	public void setServiceVOs(List<ServiceVO> serviceVOs) {
		this.serviceVOs = serviceVOs;
	}

	public PlafondWebBean(){
		super();
		vo = new PlafondVO();
		vos = new ArrayList<PlafondVO>();
		selectedVOs = new ArrayList<PlafondVO>();
	}

	public PlafondVO getVo() {
		return vo;
	}

	public void setVo(PlafondVO vo) {
		this.vo = vo;
	}

	public List<PlafondVO> getVos() {
		return vos;
	}

	public void setVos(List<PlafondVO> vos) {
		this.vos = vos;
	}

	public List<PlafondVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<PlafondVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
