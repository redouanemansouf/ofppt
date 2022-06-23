package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.ReservationBorneVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ReservationBorneWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740600179370691L;
	private ReservationBorneVO vo;

	private List<BorneVO> borneVOs;

	/**
	 * The vos
	 */
	private List<ReservationBorneVO> vos;

	/** The selected v os. */
	private List<ReservationBorneVO> selectedVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public ReservationBorneWebBean() {
		super();
		vo = new ReservationBorneVO();
		vos = new ArrayList<ReservationBorneVO>();
		selectedVOs = new ArrayList<ReservationBorneVO>();
	}

	public ReservationBorneVO getVo() {
		return vo;
	}

	public void setVo(ReservationBorneVO vo) {
		this.vo = vo;
	}

	public List<ReservationBorneVO> getVos() {
		return vos;
	}

	public void setVos(List<ReservationBorneVO> vos) {
		this.vos = vos;
	}

	public List<ReservationBorneVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<ReservationBorneVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<BorneVO> getBorneVOs() {
		return borneVOs;
	}

	public void setBorneVOs(List<BorneVO> borneVOs) {
		this.borneVOs = borneVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
