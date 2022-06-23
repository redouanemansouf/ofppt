package com.m2m.onousc.web.referentiel.webbean;

import java.util.List;

import com.m2m.onousc.business.referentiel.vo.MonitoringEchangeVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class InscriptionWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7574951084326053892L;

	private MonitoringEchangeVO vo = new MonitoringEchangeVO();
	private List<MonitoringEchangeVO> vos;
	private List<MonitoringEchangeVO> selectedVOs;

	public MonitoringEchangeVO getVo() {
		return vo;
	}

	public void setVo(MonitoringEchangeVO vo) {
		this.vo = vo;
	}

	public List<MonitoringEchangeVO> getVos() {
		return vos;
	}

	public void setVos(List<MonitoringEchangeVO> vos) {
		this.vos = vos;
	}

	public List<MonitoringEchangeVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<MonitoringEchangeVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

}
