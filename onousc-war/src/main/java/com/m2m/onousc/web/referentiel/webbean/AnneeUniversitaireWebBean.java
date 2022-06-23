package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class AnneeUniversitaireWebBean extends BaseWebBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5376553007534425026L;
	/** The vo. */
	private AnneeUniversitaireVO vo;

	/** The vos. */
	private List<AnneeUniversitaireVO> vos;

	/** The selected v os. */
	private List<AnneeUniversitaireVO> selectedVOs;

	public AnneeUniversitaireWebBean() {
		super();
		vo = new AnneeUniversitaireVO();
		vos = new ArrayList<AnneeUniversitaireVO>();
		selectedVOs = new ArrayList<AnneeUniversitaireVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public AnneeUniversitaireVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(AnneeUniversitaireVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<AnneeUniversitaireVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<AnneeUniversitaireVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<AnneeUniversitaireVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<AnneeUniversitaireVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
