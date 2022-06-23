package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.ProfilOffLineDemoVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ProfilOffLineDemoWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2843457151665778521L;

	/** The vo. */
	private ProfilOffLineDemoVO vo;

	/** The vos. */
	private List<ProfilOffLineDemoVO> vos;

	/** The selected v os. */
	private List<ProfilOffLineDemoVO> selectedVOs;

	public ProfilOffLineDemoWebBean() {
		super();
		vo = new ProfilOffLineDemoVO();
		vos = new ArrayList<ProfilOffLineDemoVO>();
		selectedVOs = new ArrayList<ProfilOffLineDemoVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public ProfilOffLineDemoVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(ProfilOffLineDemoVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<ProfilOffLineDemoVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<ProfilOffLineDemoVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<ProfilOffLineDemoVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<ProfilOffLineDemoVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

}
