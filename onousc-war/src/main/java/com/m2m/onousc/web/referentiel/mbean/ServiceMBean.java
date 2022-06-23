package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.transformer.ServiceVOTransformer;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.ServiceWebBean;
import com.m2m.onousc.web.reservation.IReservationBusDelegate;
import com.m2m.onousc.web.reservation.impl.ReservationBusDelegate;
import com.m2m.onousc.web.reservation.webbean.ReservationWebBean;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

@ManagedBean
@ViewScoped
public class ServiceMBean extends BaseMBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404377474255586439L;
	
	private ServiceWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	ReferentielService referentielSrc = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	private Double montTotal=0.0;
	private ReservationWebBean webBeanRes;
	private String matricule;
	
	
	public void init(){
		webBean = new ServiceWebBean();
		webBean.setPlafondVOs(referentielService.findAllPlafondForCombo());
		webBean.setList_principal(referentielService.findAllService("pp"));
		webBean.setList_dessert(referentielService.findAllService("d"));
		webBean.setList_entree(referentielService.findAllService("e"));
	}
	
	public void resetWebBeanVO() {
		webBean.setVo(new ServiceVO());
	}
	
	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ServiceVO>());
	
	}
	
	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerService(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE_1", null);
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
		error = delegate.modifierService(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Activer.
	 */
	
	public void creerReservation() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
          Reservation reservation=new Reservation();
		
		  reservation.setDateOperation(new Date());
		  reservation.setEtat(EtatReservation.NON_CONSOMEE);
		reservation.setMontant(montTotal);
		reservation.setLibelle(matricule);
		referentielSrc.persistReserv(reservation);
		
	 for(ServiceVO ser:webBean.getReservationVOs())
	       {
				referentielSrc.persistReservationDetail(new ServiceVOTransformer().vo2Model(ser), reservation);
	    	 
	       }
		
	   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "LA RESERVATION EFFECTUEE.", "LA RESERVATION EFFECTUEE."));
			
			
		}
	
	public void ValiderReservation() {
		User user = new User("Borne","Borne");
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
          Reservation reservation=new Reservation();
		
		  reservation.setDateOperation(new Date());
		  reservation.setEtat(EtatReservation.NON_CONSOMEE);
		reservation.setMontant(montTotal);
		reservation.setLibelle(matricule);
		referentielSrc.persistReserv(reservation);
		
	 for(ServiceVO ser:webBean.getReservationVOs())
	       {
				referentielSrc.persistReservationDetail(new ServiceVOTransformer().vo2Model(ser), reservation);
	    	 
	       }
		
	   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "LA RESERVATION EFFECTUEE.", "LA RESERVATION EFFECTUEE."));
			
			
		}
		
		
	public void addReservation() {
		
		
       webBean.getReservationVOs().add(webBean.getVo());
       
       List<ServiceVO> list_reserv=new ArrayList<ServiceVO>();
       list_reserv.addAll( webBean.getReservationVOs());
       montTotal=0.0;
       for(ServiceVO ser:list_reserv)
       {
    	   montTotal+=ser.getPrix();
       }
	}
	public void activer() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.activerService(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_ENABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	/**
	 * Desactiver.
	 */
	public void desactiver() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.desactiverService(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DISABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerService(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerCollectionService(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public ServiceWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(ServiceWebBean webBean) {
		this.webBean = webBean;
	}

	public Double getMontTotal() {
		return montTotal;
	}

	public void setMontTotal(Double montTotal) {
		this.montTotal = montTotal;
	}

	public ReservationWebBean getWebBeanRes() {
		return webBeanRes;
	}

	public void setWebBeanRes(ReservationWebBean webBeanRes) {
		this.webBeanRes = webBeanRes;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	

}
