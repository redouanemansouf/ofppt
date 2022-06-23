package com.m2m.onousc.web.referentiel.mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.EvenementVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.AdherentWebBean;
import com.m2m.onousc.web.referentiel.webbean.EvenementWebBean;
import com.m2m.onousc.web.referentiel.webbean.ProduitWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class PersonnelMBean.
 */
@ManagedBean
@ViewScoped
public class EvenementMBean extends BaseMBean {

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1882730934815822504L;
	private EvenementWebBean webBean;
	



	ReferentielService referentielSrc = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	public void init() {
	
		webBean = new EvenementWebBean();
		
		
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new EvenementVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<EvenementVO>());
	}

	/**
	 * Creer.
	 * 
	 * @throws IOException
	 */
	public void creer()  {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerEvenement(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
			resetWebBeanVO();
			JSFUtils.contextExecute("_hideDialog()");
		}

		feedReport();


	}

	
	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierEvenement(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");

		}
		feedReport();
	}

	/**
	 * Activer.
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerEvenement(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	



	public String retour() {
		return "/public/login.xhtml?faces-redirect=true";
	}

	public EvenementWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(EvenementWebBean webBean) {
		this.webBean = webBean;
	}

	
	




}
