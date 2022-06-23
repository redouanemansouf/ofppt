package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class OppositionAdhWebBean extends BaseWebBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6195558298542787855L;

	
	private AdherentVO vo;
	private List<AdherentVO> avos;
	private List<AdherentVO> adherentVOs;
	private AdherentVO adherentVO;
	
	
	
	private List<MotifOppositionVO> opposVOs;

	private List<MotifMainLeveeVO> motifMainVOs;
	
	public OppositionAdhWebBean() {
		super();
		vo = new AdherentVO();		
		avos = new ArrayList<AdherentVO>();
		adherentVOs = new ArrayList<AdherentVO>();

	}


	public List<MotifOppositionVO> getOpposVOs() {
		return opposVOs;
	}

	public void setOpposVOs(List<MotifOppositionVO> opposVOs) {
		this.opposVOs = opposVOs;
	}

	public List<MotifMainLeveeVO> getMotifMainVOs() {
		return motifMainVOs;
	}

	public void setMotifMainVOs(List<MotifMainLeveeVO> motifMainVOs) {
		this.motifMainVOs = motifMainVOs;
	}


	public List<AdherentVO> getAdherentVOs() {
		return adherentVOs;
	}


	public void setAdherentVOs(List<AdherentVO> adherentVOs) {
		this.adherentVOs = adherentVOs;
	}


	public AdherentVO getAdherentVO() {
		return adherentVO;
	}


	public void setAdherentVO(AdherentVO adherentVO) {
		this.adherentVO = adherentVO;
	}


	public AdherentVO getVo() {
		return vo;
	}


	public void setVo(AdherentVO vo) {
		this.vo = vo;
	}


	public List<AdherentVO> getAvos() {
		return avos;
	}


	public void setAvos(List<AdherentVO> avos) {
		this.avos = avos;
	}
	
	

}
