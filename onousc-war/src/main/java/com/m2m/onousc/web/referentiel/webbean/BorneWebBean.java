package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class BorneWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740600179370691L;
	private BorneVO vo;

	/**
	 * The vos
	 */
	private List<BorneVO> vos;

	/** The selected v os. */
	private List<BorneVO> selectedVOs;

	private List<SiteVO> siteVOs;

	public BorneWebBean() {
		super();
		vo = new BorneVO();
		vos = new ArrayList<BorneVO>();
		selectedVOs = new ArrayList<BorneVO>();
	}

	public BorneVO getVo() {
		return vo;
	}

	public void setVo(BorneVO vo) {
		this.vo = vo;
	}

	public List<BorneVO> getVos() {
		return vos;
	}

	public void setVos(List<BorneVO> vos) {
		this.vos = vos;
	}

	public List<BorneVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<BorneVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getSiteVOs() {
		return siteVOs;
	}

	public void setSiteVOs(List<SiteVO> siteVOs) {
		this.siteVOs = siteVOs;
	}

}
