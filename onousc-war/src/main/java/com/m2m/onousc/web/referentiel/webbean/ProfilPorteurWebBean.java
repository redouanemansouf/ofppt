package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.EvenementVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.ProfilPorteurVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class ProfilPorteurWebBean extends BaseWebBean {



	/** The vo. */
	private ProfilPorteurVO vo;
	private List<ProfilPorteurVO> vos;
	private List<ProfilPorteurVO> selectedVOs;
	

	public ProfilPorteurWebBean() {
	vo=new ProfilPorteurVO();
	vos=new ArrayList<ProfilPorteurVO>();
	selectedVOs=new ArrayList<ProfilPorteurVO>();
	}


	public ProfilPorteurVO getVo() {
		return vo;
	}


	public void setVo(ProfilPorteurVO vo) {
		this.vo = vo;
	}


	public List<ProfilPorteurVO> getVos() {
		return vos;
	}


	public void setVos(List<ProfilPorteurVO> vos) {
		this.vos = vos;
	}


	public List<ProfilPorteurVO> getSelectedVOs() {
		return selectedVOs;
	}


	public void setSelectedVOs(List<ProfilPorteurVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}




}
