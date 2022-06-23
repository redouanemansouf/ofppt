package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DepartementMBean {

	private static final long serialVersionUID = -4443247616736526460L;

	private List<DepartementVO> departementVOs = new ArrayList<DepartementVO>();

	private boolean state = true;

	public DepartementMBean() {
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {
		departementVOs.add(new DepartementVO(0L, "123456"));
		departementVOs.add(new DepartementVO(1L, "123456"));
		departementVOs.add(new DepartementVO(2L, "123456"));
		departementVOs.add(new DepartementVO(3L, "123456"));
	}

	public List<DepartementVO> getdepartementVOs() {
		return departementVOs;
	}

	public void setdepartementVOs(List<DepartementVO> departementVOs) {
		this.departementVOs = departementVOs;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
