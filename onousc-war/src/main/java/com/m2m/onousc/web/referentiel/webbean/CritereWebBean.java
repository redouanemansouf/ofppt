package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class CritereWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private CritereVO vo;

	/** The vos. */
	private List<CritereVO> vos;

	/** The selected v os. */
	private List<CritereVO> selectedVOs;

	public CritereWebBean() {
		super();
		vo = new CritereVO();
		vos = new ArrayList<CritereVO>();
		selectedVOs = new ArrayList<CritereVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public CritereVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(CritereVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<CritereVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<CritereVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<CritereVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<CritereVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
