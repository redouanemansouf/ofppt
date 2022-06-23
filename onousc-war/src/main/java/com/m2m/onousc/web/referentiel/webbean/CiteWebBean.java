package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class CiteWebBean extends BaseWebBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5228703506421949141L;
	/**
	 * The vo
	 */
	
	private CiteVO vo;
	
	/**
	 * The vos
	 */
	private List<CiteVO> vos;
	
	/** The selected v os. */
	private List<CiteVO> selectedVOs;
	
	private List<UniversiteVO> UniversiteVOs;
	
	private List<VilleVO> villeVOs;
	
	public List<VilleVO> getVilleVOs() {
		return villeVOs;
	}

	public void setVilleVOs(List<VilleVO> villeVOs) {
		this.villeVOs = villeVOs;
	}

	public List<UniversiteVO> getUniversiteVOs() {
		return UniversiteVOs;
	}

	public void setUniversiteVOs(List<UniversiteVO> universiteVOs) {
		UniversiteVOs = universiteVOs;
	}

	public CiteWebBean(){
		super();
		vo = new CiteVO();
		vos = new ArrayList<CiteVO>();
		selectedVOs = new ArrayList<CiteVO>();
	}

	public CiteVO getVo() {
		return vo;
	}

	public void setVo(CiteVO vo) {
		this.vo = vo;
	}

	public List<CiteVO> getVos() {
		return vos;
	}

	public void setVos(List<CiteVO> vos) {
		this.vos = vos;
	}

	public List<CiteVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CiteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
