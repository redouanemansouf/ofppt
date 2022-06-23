package com.m2m.onousc.web.referentiel.mbean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.binding.message.Severity;

import au.com.bytecode.opencsv.CSVWriter;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.FieldsControler;
import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
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
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.UserSession;

/**
 * The Class PersonnelMBean.
 */

public class FileBrowser {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		String filename = file.getName();
		System.out.println("You have selected: " + filename);
	}

}
