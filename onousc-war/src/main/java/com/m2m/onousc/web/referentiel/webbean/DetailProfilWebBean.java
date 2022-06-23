package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class DetailProfilWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6886796373195791875L;

	

	/** The vo. */
	private DetailProfilVO vo;

	private List<DetailProfilVO> vos;

	/** The selected v os. */
	private List<DetailProfilVO> selectedVOs;

	private List<CritereVO> criterevos;
	
	private List<TourniquetVO> tourniquetVOs;
	
	

	public DetailProfilWebBean() {
		vo = new DetailProfilVO();
		vos = new ArrayList<DetailProfilVO>();
		selectedVOs = new ArrayList<DetailProfilVO>();
		criterevos = new ArrayList<CritereVO>();
		tourniquetVOs=new ArrayList<TourniquetVO>();

	}

	public DetailProfilVO getVo() {
		return vo;
	}

	public void setVo(DetailProfilVO vo) {
		this.vo = vo;
	}

	public List<DetailProfilVO> getVos() {
		return vos;
	}

	public void setVos(List<DetailProfilVO> vos) {
		this.vos = vos;
	}

	public List<DetailProfilVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<DetailProfilVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CritereVO> getCriterevos() {
		return criterevos;
	}

	public void setCriterevos(List<CritereVO> criterevos) {
		this.criterevos = criterevos;
	}

	public List<TourniquetVO> getTourniquetVOs() {
		return tourniquetVOs;
	}

	public void setTourniquetVOs(List<TourniquetVO> tourniquetVOs) {
		this.tourniquetVOs = tourniquetVOs;
	}

}
