package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ParametreGeneralWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private ParametreGeneralVO vo;

	/** The vos. */
	private List<ParametreGeneralVO> vos;

	/** The selected v os. */
	private List<ParametreGeneralVO> selectedVOs;

	public ParametreGeneralWebBean() {
		super();
		vo = new ParametreGeneralVO();
		vos = new ArrayList<ParametreGeneralVO>();
		selectedVOs = new ArrayList<ParametreGeneralVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public ParametreGeneralVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(ParametreGeneralVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<ParametreGeneralVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<ParametreGeneralVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<ParametreGeneralVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<ParametreGeneralVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
