package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * 
 * @author abousnane
 *
 */
public class JoursFerieWebBean extends BaseWebBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7587772463269855779L;
	/** The vo. */
	private JoursFerieVO vo;

	/** The vos. */
	private List<JoursFerieVO> vos;

	/** The selected v os. */
	private List<JoursFerieVO> selectedVOs;
	
	private List<AnneeUniversitaireVO> anneeUniversitaireVOs;
	
	

	public List<AnneeUniversitaireVO> getAnneeUniversitaireVOs() {
		return anneeUniversitaireVOs;
	}

	public void setAnneeUniversitaireVOs(
			List<AnneeUniversitaireVO> anneeUniversitaireVOs) {
		this.anneeUniversitaireVOs = anneeUniversitaireVOs;
	}

	public JoursFerieWebBean() {
		super();
		vo = new JoursFerieVO();
		vos = new ArrayList<JoursFerieVO>();
		selectedVOs = new ArrayList<JoursFerieVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public JoursFerieVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(JoursFerieVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<JoursFerieVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<JoursFerieVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<JoursFerieVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<JoursFerieVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
