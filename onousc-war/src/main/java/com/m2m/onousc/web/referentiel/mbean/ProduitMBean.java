package com.m2m.onousc.web.referentiel.mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.ProduitWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class PersonnelMBean.
 */
@ManagedBean
@ViewScoped
public class ProduitMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 818314416127019088L;

	private ProduitVO vo = new ProduitVO();
	private ProduitWebBean webBean;
	private Double montTotal = 0.0;
	private int size = 0;
	private Double price;

	ReferentielService referentielSrc = (ReferentielService) BeansLookuper.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	public void init() {

		webBean = new ProduitWebBean();
		webBean.setFamProduitvos(referentielService.findAllCanalVenteByClient());
		size = webBean.getSelectedVOs().size();
		webBean.setListSiteForCombo(referentielService.findAllSite());
		this.vo.setSub(false);
		// webBean.setVos(referentielService.findAllp);

	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new ProduitVO());
	}
	
	public void updateFamilleProduit() {
		webBean.setFamProduitvos(referentielService.findAllCanalVenteBySite(webBean.getVo().getSiteVO().getId()));

	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ProduitVO>());
	}

	/**
	 * Creer.
	 * 
	 * @throws IOException
	 */
	public void creer() {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		List<ProduitVO> check = referentielService.findProduitListByCode(webBean.getVo().getCode());
		if (check.size() == 0) {
			webBean.getVo().getSubaf();
			if (webBean.getVo().getRatio() != null) {
				webBean.getVo().setSub(true);
				webBean.getVo().setMontant(webBean.getVo().getPrixSub() * webBean.getVo().getRatio() / 100);
			}
			if (webBean.getVo().getRatio() == null) {
				webBean.getVo().setSub(false);
				webBean.getVo().setMontant(webBean.getVo().getPrixSub());
			}
			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());

			error = delegate.creerProduit(webBean);
			if (!error) {
				addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
				resetWebBeanVO();
				JSFUtils.contextExecute("_hideDialog()");
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

		feedReport();

	}

	public void onRowSelect(SelectEvent event) {

	}

	public void onChangeMontant() {
		montTotal = 0.0;
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (ProduitVO vo : webBean.getSelectedVOs()) {
				montTotal += vo.getTotalMont();
			}
		}

	}

	public void initMontant() {
		montTotal = 0.0;
	}

	public void onChMontant() {

		montTotal = 0.0;
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (ProduitVO vo : webBean.getSelectedVOs()) {
				montTotal -= vo.getTotalMont();
			}
		}

	}

	public void onproduitChange() {

		if (webBean.getVo().getFamilleProd().getId() != null) {

			webBean.setVos(referentielService.findProduitByFamille(webBean.getVo().getFamilleProd().getId()));

		}
	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		webBean.getVo().getSubaf();
		if (webBean.getVo().getRatio() != null) {
			webBean.getVo().setSub(true);
			webBean.getVo().setMontant(webBean.getVo().getPrixSub() * webBean.getVo().getRatio() / 100);
		}
		if (webBean.getVo().getRatio() == null) {
			webBean.getVo().setSub(false);
			webBean.getVo().setMontant(webBean.getVo().getPrixSub());
		}
		
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());

		error = delegate.modifierProduit(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");

		}
		feedReport();
	}

	public void modifierstatus() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierStatusProduit(webBean);

		if (!error) {
			JSFUtils.contextExecute("_showMessage()");

		}
		feedReport();
	}

	/**
	 * Activer.
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerProduit(webBean);
		if (error) {

		} else {
			JSFUtils.contextExecute("_showMessage()");
		}
		feedReport();
	}

	public String retour() {
		return "/public/login.xhtml?faces-redirect=true";
	}

	public ProduitWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(ProduitWebBean webBean) {
		this.webBean = webBean;
	}

	public Double getMontTotal() {
		return montTotal;
	}

	public void setMontTotal(Double montTotal) {
		this.montTotal = montTotal;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void selectCBarProduit() {
		System.out.println("Code bar" + webBean.getVo().getCodeBar());
		montTotal = 0.0;
		if (webBean.getVo().getCodeBar() != null) {
			ProduitVO pvo = referentielService.findProduitByCodeBar(webBean.getVo().getCodeBar());
			webBean.getVos().add(pvo);
			webBean.getSelectedVOs().add(pvo);
			webBean.getVo().setCodeBar("");

			if (!webBean.getSelectedVOs().isEmpty()) {
				for (ProduitVO vo : webBean.getSelectedVOs()) {
					montTotal += vo.getTotalMont();
				}
			}
			// DataTable dataTable = (DataTable)
			// FacesContext.getCurrentInstance().getViewRoot().findComponent("recharge:critere-dtbl");
			// System.out.println("rowindex"+dataTable.getRowCount());
		}

	}

	public void initvos() {
		initMontant();
		webBean.setVos(new ArrayList<ProduitVO>());
		webBean.setSelectedVOs(new ArrayList<ProduitVO>());
	}

	public ProduitVO getVo() {
		return vo;
	}

	public void setVo(ProduitVO vo) {
		this.vo = vo;
	}

	public void initfalse() {
		this.vo.setSub(false);
	}

	//

	public void RecupPrixSub() {
		if (webBean.getVo().getPrixSub() != null) {
			price = webBean.getVo().getPrixSub();

		}
	}

	// methode compter le prix subventionner selon le ratio

	public void CompterPrixSub() {

		if (webBean.getVo().getRatio() != null && webBean.getVo().getRatio() < 101) {
//    	   webBean.getVo().setPrixSub(price * webBean.getVo().getRatio()/100);
			webBean.getVo().setMontant(price * webBean.getVo().getRatio() / 100);
		}
		if (webBean.getVo().getRatio() == null) {
			webBean.getVo().setMontant(webBean.getVo().getPrixSub());
		}

//       else
//       {
//    	   webBean.getVo().setRatio(0.0);
//       }
	}

	public void resetRatio() {

		webBean.getVo().setRatio(null);

	}

	public void codevalidator() {

		List<ProduitVO> check = referentielService.findProduitListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Operation effectuée avec succès"));
		feedReport();
	}

	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_GESTION_VENTES_FPROD);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}
}
