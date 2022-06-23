package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class MotifMainLeveeWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private MotifMainLeveeVO vo;

	/** The vos. */
	private List<MotifMainLeveeVO> vos;

	/** The selected v os. */
	private List<MotifMainLeveeVO> selectedVOs;

	public MotifMainLeveeWebBean() {
		super();
		vo = new MotifMainLeveeVO();
		vos = new ArrayList<MotifMainLeveeVO>();
		selectedVOs = new ArrayList<MotifMainLeveeVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public MotifMainLeveeVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(MotifMainLeveeVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<MotifMainLeveeVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<MotifMainLeveeVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<MotifMainLeveeVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<MotifMainLeveeVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
