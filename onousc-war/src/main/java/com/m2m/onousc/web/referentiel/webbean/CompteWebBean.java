package com.m2m.onousc.web.referentiel.webbean;

import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CompteVO;
import com.m2m.technicalservices.web.BaseWebBean;


public class CompteWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4916067472931197933L;
	
	private CompteVO vo = new CompteVO();

	private List<CompteVO> vos;

	public CompteVO getVo() {
		return vo;
	}

	public void setVo(CompteVO vo) {
		this.vo = vo;
	}

	public List<CompteVO> getVos() {
		return vos;
	}

	public void setVos(List<CompteVO> vos) {
		this.vos = vos;
	}
}
