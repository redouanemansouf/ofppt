package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.OperationCaisseVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class PersonnelWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8676876173161101683L;

	/** The vo. */
	private String perso;
	
	private PersonnelVO vo;
	
	private double solde;

	private List<PersonnelVO> vos;
	
	private String MatrSearch;

	/** The selected v os. */
	private List<PersonnelVO> selectedVOs;
	
	private String Categoriecode;

	private List<VilleVO> villevos;

	private List<CategoriePorteurVO> categorievos;
	
	private List<CritereVO> profilvos;
	
	private PersonnelVO selectedVO;
	
	private String tranche;
	private List<DetailProfilVO> detailProfilVOs;
	private List<TourniquetVO> selectedTourniquets;
	
	private String jSessionID;

	private String serverNameAndPort;


	public String getjSessionID() {
		return jSessionID;
	}

	public void setjSessionID(String jSessionID) {
		this.jSessionID = jSessionID;
	}

	public String getServerNameAndPort() {
		return serverNameAndPort;
	}

	public void setServerNameAndPort(String serverNameAndPort) {
		this.serverNameAndPort = serverNameAndPort;
	}

	public PersonnelWebBean() {
		vo = new PersonnelVO();
		MatrSearch="";
		vos = new ArrayList<PersonnelVO>();
		selectedVOs = new ArrayList<PersonnelVO>();
		villevos = new ArrayList<VilleVO>();
		categorievos = new ArrayList<CategoriePorteurVO>();
		profilvos=new ArrayList<CritereVO>();
		 detailProfilVOs=new ArrayList<DetailProfilVO>();
		 selectedTourniquets=new ArrayList<TourniquetVO>();
	}

	public PersonnelVO getVo() {
		return vo;
	}

	public void setVo(PersonnelVO vo) {
		this.vo = vo;
	}

	public List<PersonnelVO> getVos() {
		return vos;
	}

	public void setVos(List<PersonnelVO> vos) {
		this.vos = vos;
	}

	public List<PersonnelVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<PersonnelVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<VilleVO> getVillevos() {
		return villevos;
	}

	public void setVillevos(List<VilleVO> villevos) {
		this.villevos = villevos;
	}

	public List<CategoriePorteurVO> getCategorievos() {
		return categorievos;
	}

	public void setCategorievos(List<CategoriePorteurVO> categorievos) {
		this.categorievos = categorievos;
	}

	public String getMatrSearch() {
		return MatrSearch;
	}

	public void setMatrSearch(String matrSearch) {
		MatrSearch = matrSearch;
	}

	public List<CritereVO> getProfilvos() {
		return profilvos;
	}

	public void setProfilvos(List<CritereVO> profilvos) {
		this.profilvos = profilvos;
	}

	public String getTranche() {
		return tranche;
	}

	public void setTranche(String tranche) {
		this.tranche = tranche;
	}

	public List<DetailProfilVO> getDetailProfilVOs() {
		return detailProfilVOs;
	}

	public void setDetailProfilVOs(List<DetailProfilVO> detailProfilVOs) {
		this.detailProfilVOs = detailProfilVOs;
	}
	public List<TourniquetVO> getSelectedTourniquets() {
		return selectedTourniquets;
	}

	public void setSelectedTourniquets(List<TourniquetVO> selectedTourniquets) {
		this.selectedTourniquets = selectedTourniquets;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getPerso() {
		return perso;
	}

	public void setPerso(String perso) {
		this.perso = perso;
	}

	public String getCategoriecode() {
		return Categoriecode;
	}

	public void setCategoriecode(String categoriecode) {
		Categoriecode = categoriecode;
	}

	public PersonnelVO getSelectedVO() {
		return selectedVO;
	}

	public void setSelectedVO(PersonnelVO selectedVO) {
		this.selectedVO = selectedVO;
	}

}
