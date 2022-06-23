package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class UniversiteWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6114020506657354853L;

	/**
	 * The vo
	 */

	private UniversiteVO vo;

	/**
	 * The vos
	 */
	private List<UniversiteVO> vos;

	/** The selected v os. */
	private List<UniversiteVO> selectedVOs;

	private List<VilleVO> villeVOs;

	public List<VilleVO> getVilleVOs() {
		return villeVOs;
	}

	public void setVilleVOs(List<VilleVO> villeVOs) {
		this.villeVOs = villeVOs;
	}

	public UniversiteWebBean() {
		super();
		vo = new UniversiteVO();
		vos = new ArrayList<UniversiteVO>();
		selectedVOs = new ArrayList<UniversiteVO>();
	}

	public UniversiteVO getVo() {
		return vo;
	}

	public void setVo(UniversiteVO vo) {
		this.vo = vo;
	}

	public List<UniversiteVO> getVos() {
		return vos;
	}

	public void setVos(List<UniversiteVO> vos) {
		this.vos = vos;
	}

	public List<UniversiteVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<UniversiteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

}
