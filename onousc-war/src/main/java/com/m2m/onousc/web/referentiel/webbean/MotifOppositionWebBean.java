package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class MotifOppositionWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private MotifOppositionVO vo;

	/** The vos. */
	private List<MotifOppositionVO> vos;

	/** The selected v os. */
	private List<MotifOppositionVO> selectedVOs;

	public MotifOppositionWebBean() {
		super();
		vo = new MotifOppositionVO();
		vos = new ArrayList<MotifOppositionVO>();
		selectedVOs = new ArrayList<MotifOppositionVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public MotifOppositionVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(MotifOppositionVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<MotifOppositionVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<MotifOppositionVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<MotifOppositionVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<MotifOppositionVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
