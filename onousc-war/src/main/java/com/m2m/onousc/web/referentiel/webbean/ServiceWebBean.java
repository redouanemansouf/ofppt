package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ServiceWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659891376566783601L;
	private ServiceVO vo;

	/**
	 * The vos
	 */
	private List<ServiceVO> vos;

	/** The selected v os. */
	private List<ServiceVO> selectedVOs;
	
	private List<ServiceVO> list_principal;

	private List<ServiceVO> list_dessert;
	
	private List<ServiceVO> list_entree;
	
	private List<ServiceVO> reservationVOs;
	
	private ServiceVO reservationVO;
	
	private List<PlafondVO> plafondVOs;

	public List<PlafondVO> getPlafondVOs() {
		return plafondVOs;
	}

	public void setPlafondVOs(List<PlafondVO> plafondVOs) {
		this.plafondVOs = plafondVOs;
	}

	public ServiceWebBean() {
		super();
		vo = new ServiceVO();
		setReservationVO(new ServiceVO());
		vos = new ArrayList<ServiceVO>();
		selectedVOs = new ArrayList<ServiceVO>();
		list_dessert=new ArrayList<ServiceVO>();
		list_entree=new ArrayList<ServiceVO>();
		reservationVOs=new ArrayList<ServiceVO>();
		list_principal=new ArrayList<ServiceVO>();
	}

	public ServiceVO getVo() {
		return vo;
	}

	public void setVo(ServiceVO vo) {
		this.vo = vo;
	}

	public List<ServiceVO> getVos() {
		return vos;
	}

	public void setVos(List<ServiceVO> vos) {
		this.vos = vos;
	}

	public List<ServiceVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<ServiceVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<ServiceVO> getList_principal() {
		return list_principal;
	}

	public void setList_principal(List<ServiceVO> list_principal) {
		this.list_principal = list_principal;
	}

	public List<ServiceVO> getList_dessert() {
		return list_dessert;
	}

	public void setList_dessert(List<ServiceVO> list_dessert) {
		this.list_dessert = list_dessert;
	}

	public List<ServiceVO> getList_entree() {
		return list_entree;
	}

	public void setList_entree(List<ServiceVO> list_entree) {
		this.list_entree = list_entree;
	}

	public ServiceVO getReservationVO() {
		return reservationVO;
	}

	public void setReservationVO(ServiceVO reservationVO) {
		this.reservationVO = reservationVO;
	}

	public List<ServiceVO> getReservationVOs() {
		return reservationVOs;
	}

	public void setReservationVOs(List<ServiceVO> reservationVOs) {
		this.reservationVOs = reservationVOs;
	}

}
