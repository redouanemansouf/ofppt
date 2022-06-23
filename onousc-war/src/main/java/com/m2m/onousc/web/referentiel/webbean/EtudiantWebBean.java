package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteWebBean.
 */
public class EtudiantWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1051768576501825762L;

	/** The vo. */
	private EtudiantVO vo;

	private List<EtudiantVO> vos;

	/** The selected v os. */
	private List<EtudiantVO> selectedVOs;

	private List<VilleVO> VilleVOs;

	private List<CiteVO> citeVOs;

	private List<RestaurantVO> restaurantVOs;

	private List<NoteCritereVO> revenuVO;

	private List<NoteCritereVO> nbreEnfentsVO;

	private AnneeUniversitaireVO anneUniversitaireVO;

	private List<CategoriePorteurVO> listCategoriePorteurForCombo = new ArrayList<CategoriePorteurVO>();
	
	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	private String serverNameAndPort;

	private String groupe;

	// champ de comunication avec l'exe
	private String jSessionID;

	public EtudiantWebBean() {
		super();
		vo = new EtudiantVO();
		vos = new ArrayList<EtudiantVO>();
		selectedVOs = new ArrayList<EtudiantVO>();
		VilleVOs = new ArrayList<VilleVO>();
		citeVOs = new ArrayList<CiteVO>();
		restaurantVOs = new ArrayList<RestaurantVO>();
		revenuVO = new ArrayList<NoteCritereVO>();
		nbreEnfentsVO = new ArrayList<NoteCritereVO>();
	}

	public EtudiantVO getVo() {
		return vo;
	}

	public void setVo(EtudiantVO vo) {
		this.vo = vo;
	}

	public List<EtudiantVO> getVos() {
		return vos;
	}

	public void setVos(List<EtudiantVO> vos) {
		this.vos = vos;
	}

	public List<EtudiantVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<EtudiantVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<VilleVO> getVilleVOs() {
		return VilleVOs;
	}

	public void setVilleVOs(List<VilleVO> villeVOs) {
		VilleVOs = villeVOs;
	}

	public List<CiteVO> getCiteVOs() {
		return citeVOs;
	}

	public void setCiteVOs(List<CiteVO> citeVOs) {
		this.citeVOs = citeVOs;
	}

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> restaurantVOs) {
		this.restaurantVOs = restaurantVOs;
	}

	public List<NoteCritereVO> getRevenuVO() {
		return revenuVO;
	}

	public void setRevenuVO(List<NoteCritereVO> revenuVO) {
		this.revenuVO = revenuVO;
	}

	public List<NoteCritereVO> getNbreEnfentsVO() {
		return nbreEnfentsVO;
	}

	public void setNbreEnfentsVO(List<NoteCritereVO> nbreEnfentsVO) {
		this.nbreEnfentsVO = nbreEnfentsVO;
	}

	public AnneeUniversitaireVO getAnneUniversitaireVO() {
		return anneUniversitaireVO;
	}

	public void setAnneUniversitaireVO(AnneeUniversitaireVO anneUniversitaireVO) {
		this.anneUniversitaireVO = anneUniversitaireVO;
	}

	public String getServerNameAndPort() {
		return serverNameAndPort;
	}

	public void setServerNameAndPort(String serverNameAndPort) {
		this.serverNameAndPort = serverNameAndPort;
	}

	public String getjSessionID() {
		return jSessionID;
	}

	public void setjSessionID(String jSessionID) {
		this.jSessionID = jSessionID;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

	public List<CategoriePorteurVO> getListCategoriePorteurForCombo() {
		return listCategoriePorteurForCombo;
	}

	public void setListCategoriePorteurForCombo(List<CategoriePorteurVO> listCategoriePorteurForCombo) {
		this.listCategoriePorteurForCombo = listCategoriePorteurForCombo;
	}

}
