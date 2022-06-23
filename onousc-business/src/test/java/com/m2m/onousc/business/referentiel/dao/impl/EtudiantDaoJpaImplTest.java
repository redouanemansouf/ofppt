///*
//* CanalVenteDaoJpaImplTest.java
//*
//* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
//*/
//package com.m2m.onousc.business.referentiel.dao.impl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//
//import com.github.springtestdbunit.annotation.DatabaseOperation;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
//import com.m2m.onousc.business.common.AbstractDaoTest;
//import com.m2m.onousc.business.common.EntityStatus;
//import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
//import com.m2m.onousc.business.referentiel.dao.CanalVenteDaoJpa;
//import com.m2m.onousc.business.referentiel.dao.EtudiantDaoJpa;
//import com.m2m.onousc.business.referentiel.model.Etudiants;
//import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteDaoJpaImplTest.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
/*@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = { "classpath:/dbunit/dataset-Etudiant.xml" })
public class EtudiantDaoJpaImplTest extends AbstractDaoTest {

	
	@Autowired
	CanalVenteDaoJpa canalVenteDaoJpa;

	
	@Autowired
	EtudiantDaoJpa etudiantDaoJpa;
	/**
	 * Persist test.
	 */
	/*
	 * @Test
	 * 
	 * @Rollback(true) public void persistTest() { String libelle =
	 * "Libelle test"; String description = "Desc test"; CanalVente canalVente =
	 * new CanalVente(libelle, description);
	 * canalVenteDaoJpa.persist(canalVente);
	 * Assert.assertNotNull(canalVente.getId()); }
	 * 
	 * /** Update test.
	 */
	/*
	 * @Test
	 * 
	 * @Rollback(true) public void updateTest() { CanalVente canalVente =
	 * canalVenteDaoJpa.find(1L); canalVente.setLibelle("Libelle test");
	 * canalVenteDaoJpa.persist(canalVente); CanalVente canalVente2 =
	 * canalVenteDaoJpa.find(1L); Assert.assertEquals("Libelle test",
	 * canalVente2.getLibelle()); }
	 * 
	 * /** Find by criteria test.
	 */
	/*
	 * @Test public void findByCriteriaTest() { List<CanalVente> canalVentes;
	 * String libelle = "cv"; String description = "cv"; CanalVenteCriteria
	 * criteria= new CanalVenteCriteria(libelle, description, null, new
	 * SearchConfig()); canalVentes = canalVenteDaoJpa.findByCriteria(criteria);
	 * Assert.assertNotNull(canalVentes); }
	 */
/*
	@Test
	@Rollback(true)
	public void persistTest() {
		
		Long ann_universitaire=2015L;

		String ndemande="00000002";

		String nom="SADIK";

		String prenom="JAMAL";

		Date date_naissance=new Date();

		String nCIN="BK123654";

		Boolean boursier=true;

		Boolean resident=false;

		String etablissement="Universite Trik jdida";

		String sexe="M";

		String ville="Casablanaca";

		String restaurant="Res1";

		String email="msadik01@gmail.com";

		String image="";

		EntityStatus statut=EntityStatus.ENABLED;

		Etudiants etudiants=new Etudiants( ann_universitaire, ndemande, nom, prenom, date_naissance, nCIN, boursier, resident, etablissement, sexe, ville, restaurant, email, image, statut);
				etudiantDaoJpa.persist(etudiants);
		Assert.assertNotNull(etudiants.getId());
	}
	*/
	/*
	@Test
	public void findByCriteriaTest() {
		List<Etudiants> etudiants;
		//String nom = "SADIK";
		String Ndemande = "00000002";
		
		EtudiantCriteria criteria=new EtudiantCriteria(null, null, null, null, null, null, null, null, null,null,null, new SearchConfig());
		etudiants = etudiantDaoJpa.findByCriteria(criteria);
		Assert.assertNotNull(etudiants);
		System.out.println(etudiants.size());
	}

}*/
