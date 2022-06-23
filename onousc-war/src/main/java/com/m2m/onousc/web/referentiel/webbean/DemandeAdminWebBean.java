package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.DemandeAdminVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class DemandeAdminWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740611239370691L;
	private DemandeAdminVO vo;

	/**
	 * The vos
	 */
	private List<DemandeAdminVO> vos;

	/** The selected v os. */
	private List<DemandeAdminVO> selectedVOs;


	public DemandeAdminWebBean() {
		super();
		vo = new DemandeAdminVO();
		vos = new ArrayList<DemandeAdminVO>();
		selectedVOs = new ArrayList<DemandeAdminVO>();
	}

	public DemandeAdminVO getVo() {
		return vo;
	}

	public void setVo(DemandeAdminVO vo) {
		this.vo = vo;
	}

	public List<DemandeAdminVO> getVos() {
		return vos;
	}

	public void setVos(List<DemandeAdminVO> vos) {
		this.vos = vos;
	}

	public List<DemandeAdminVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<DemandeAdminVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
	
	
}
