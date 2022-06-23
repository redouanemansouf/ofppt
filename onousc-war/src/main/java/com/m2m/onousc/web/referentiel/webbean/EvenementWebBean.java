package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.EvenementVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class EvenementWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493691124071564759L;

	/** The vo. */
	private EvenementVO vo;
	private List<EvenementVO> vos;
	private List<EvenementVO> selectedVOs;
	

	public EvenementWebBean() {
	vo=new EvenementVO();
	vos=new ArrayList<EvenementVO>();
	selectedVOs=new ArrayList<EvenementVO>();
	}


	public EvenementVO getVo() {
		return vo;
	}


	public void setVo(EvenementVO vo) {
		this.vo = vo;
	}


	public List<EvenementVO> getVos() {
		return vos;
	}


	public void setVos(List<EvenementVO> vos) {
		this.vos = vos;
	}


	public List<EvenementVO> getSelectedVOs() {
		return selectedVOs;
	}


	public void setSelectedVOs(List<EvenementVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}


}
