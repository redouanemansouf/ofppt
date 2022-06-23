package com.m2m.onousc.web.referentiel.mbean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hsqldb.util.CSVWriter;
import org.primefaces.event.FileUploadEvent;
import org.springframework.binding.message.Severity;

import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.onousc.web.referentiel.IReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.search.TourniquetSearchMBean;
import com.m2m.onousc.web.referentiel.webbean.AdherentWebBean;
import com.m2m.onousc.web.referentiel.webbean.CarteNapsWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

/**
 * The Class PersonnelMBean.
 */

public class CarteNapsStructure {

	private String nomprenom;


	private String nom;

	
	private String prenom;


	private String numidentite;

	
	private String tel;

	
	private String etab;

	private String matr;
	
	private String numcarte;

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumidentite() {
		return numidentite;
	}

	public void setNumidentite(String numidentite) {
		this.numidentite = numidentite;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEtab() {
		return etab;
	}

	public void setEtab(String etab) {
		this.etab = etab;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public String getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

}
