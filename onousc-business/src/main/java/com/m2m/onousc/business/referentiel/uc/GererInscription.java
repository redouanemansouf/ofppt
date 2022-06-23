package com.m2m.onousc.business.referentiel.uc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.FindFilter;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.EtudiantDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ImportInscriptionDaoJpa;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.model.Inscription;
import com.m2m.onousc.business.referentiel.rule.InscriptionBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

@Service("REFERENTIEL_GererInscription_UC")
public class GererInscription extends UseCaseController {
	/*
	 * private String destination = "C:\\Carte_UCAD\\Photos_Porteurs\\Etudiants\\";
	 private static final String path_upload = "C:\\Carte_UCAD\\Photos_Porteurs\\UPLOAD\\";
	 */
	private String destination = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/";
	private static final String path_upload = "/opt/Carte_UCAD/Photos_Porteurs/UPLOAD/";

	@Autowired
	ImportInscriptionDaoJpa importInscriptionDaoJpa;

	@Autowired
	EtudiantDaoJpa etudiantdaoJpa;

	@Autowired
	private CycleVieDaoJpa cycleVieDaoJpa;

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new InscriptionBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {

		if (UserContext.getClientParameters().isOnCollection()) {
			@SuppressWarnings("unchecked")
			List<Inscription> models = (List<Inscription>) UserContext.getSubject();
			Calendar cal = Calendar.getInstance();
			for (Inscription imp : models) {

				ImportInscription importInscription = importInscriptionDaoJpa.findByCin(imp.getCin());
				if (importInscription == null) {
					importInscription = importInscriptionDaoJpa.findByMassar(imp.getCodeMassar());
				}
				if (importInscription != null) {
					this.em.remove(importInscription);
				}

				Etudiants etd = new Etudiants();
				cal.setTime(imp.getAnneUniversitaire().getDate_debut());
				etd.setAnn_universitaire(new Long(cal.get(Calendar.YEAR)));
				etd.setAnneeUniversitaire(imp.getAnneUniversitaire());
				etd.setBoursier(imp.getBoursier());
				etd.setSite(imp.getSite());
				etd.setDate_naissance(imp.getDateNaissance());
				etd.setEmail(imp.getEmail());
				etd.setNCIN(imp.getCin());
				etd.setNdemande(
						etudiantdaoJpa.findNbrDemande() != null ? (etudiantdaoJpa.findNbrDemande().intValue() + 1 + "")
								: 0 + "");
				etd.setNom(imp.getNom());
				etd.setNote(0F);
				etd.setPrenom(imp.getPrenom());
//				etd.setRenouvellement(false);
				etd.setTypeCarte(imp.getTypeCarte());
				etd.setRestaurant(imp.getRestaurant());
				etd.setSexe(imp.getSexe());
				etd.setStatut(EntityStatus.ENABLED);
				etd.setVille(String.valueOf(imp.getVille().getId()));
				etd.setCodeMassar(imp.getCodeMassar());
				etd.setTele(imp.getTele());
				etd.setCodeProfil(imp.getCodeProfil());
				etd.setEtablissement(imp.getEtablissement());
				etd.setTypePersonelle(imp.getTypePersonelle());
				System.out.println(path_upload);
				File dir = new File(path_upload);
				String filename = "";
				File[] listFiles = dir.listFiles(new FindFilter(imp.getCodeMassar()));

				if (listFiles.length == 0) {
					System.out.println("Either dir does not exist or is not a directory");
				} else {
					for (int i = 0; i < listFiles.length;) {
						filename = listFiles[i].getName();
						break;
					}
				}
				etd.setImage(filename);
				etd = etudiantdaoJpa.getEm().merge(etd);

				File oldfile = new File(path_upload + filename);
				try {

					copyFile(etd.getId() + ".jpg", new FileInputStream(oldfile));
					oldfile.delete();
				} catch (FileNotFoundException e) {
					System.out.println("Erreur de copyFile ");
				}

				CycleVie cycleVie = new CycleVie();
				cycleVie.setDateOperation(new Date());
				cycleVie.setNumPorteur(etd);
				cycleVie.setNumSerie((etd.getId() * 43) + "");
				cycleVie.setOperation("Demande nouvelle carte");
				cycleVie.setStatut(EntityStatus.ENABLED);
				cycleVieDaoJpa.persist(cycleVie);

			}
		}

		return new ProcessResult();
	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
