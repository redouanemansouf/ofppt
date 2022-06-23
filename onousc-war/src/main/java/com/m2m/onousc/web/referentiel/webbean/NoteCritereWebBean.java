package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class NoteCritereWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private NoteCritereVO vo;

	/** The vos. */
	private List<NoteCritereVO> vos;

	/** The selected v os. */
	private List<NoteCritereVO> selectedVOs;

	private List<CritereVO> critereVOs;

	public NoteCritereWebBean() {
		super();
		vo = new NoteCritereVO();
		vos = new ArrayList<NoteCritereVO>();
		selectedVOs = new ArrayList<NoteCritereVO>();
	}

	public List<CritereVO> getCritereVOs() {
		return critereVOs;
	}

	public void setCritereVOs(List<CritereVO> critereVOs) {
		this.critereVOs = critereVOs;
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public NoteCritereVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(NoteCritereVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<NoteCritereVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<NoteCritereVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<NoteCritereVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<NoteCritereVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
