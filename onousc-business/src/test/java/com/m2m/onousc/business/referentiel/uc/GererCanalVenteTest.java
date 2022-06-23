/*
 * GererCanalVenteTest.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.uc;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.m2m.onousc.business.referentiel.service.ReferentielService;

/**
 * The Class GererCanalVenteTest.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */

@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = { "classpath:/dbunit/dataset-canal-vente.xml" })
public class GererCanalVenteTest  {

	/** The referentiel service. */
	@Autowired
	ReferentielService referentielService;

	/**
	 * Creer canal vente test.
	 */
	/*
	@Test
	public void creerCanalVenteTest() {
		User user = new User("ID01", "CODE03");
		String domaine = Constantes.REFERENTIEL;
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_CANAL_VENTE;

		String libelle = "cv lib test";
		String descpription = "cv desc test";
		CanalVenteVO vo = new CanalVenteVO(libelle, descpription);

		// preparation ds parametres
		ClientParameters clientParameters = new ClientParameters(domaine,
				command, sousCommand, user, vo);

		// appel de l'UC
		final ProcessResult result = (new FacadeControllerImpl(clientParameters))
				.useCaseProcess();
		Assert.assertNotNull(result);
	}

	/**
	 * Activer canal ventee.
	 */
	/*
	@Test
	@Rollback
	public void activerCanalVentee() {
		User user = new User("ID01", "CODE03");
		String domaine = Constantes.REFERENTIEL;
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_ACTIVER_CANAL_VENTE;

		String libelle = null;
		String description = null;
		SearchConfig config = new SearchConfig();
		String sortField = null;
		String sortOrder = null;
		CanalVenteCriteria criteria = new CanalVenteCriteria(libelle,
				description, null, config);
		List<CanalVente> models = new ArrayList<CanalVente>();
		models = referentielService.findCanalVenteByCriteria(criteria);

		CanalVenteVOTransformer canalVenteVOTransformer = new CanalVenteVOTransformer();

		List<CanalVenteVO> vos = canalVenteVOTransformer
				.model2VO(models, false);
		for (CanalVenteVO vo : vos) {
			vo.setStatut(EntityStatus.ENABLED);
		}
		@SuppressWarnings("unchecked")
		List<ValueObject> listvos = (List<ValueObject>) (List<?>) vos;
		// preparation ds parametres
		ClientParameters clientParameters = new ClientParameters(domaine,
				command, sousCommand, user, listvos);

		// appel de l'UC
		final ProcessResult result = (new FacadeControllerImpl(clientParameters))
				.useCaseProcess();
		Assert.assertNotNull(result);
	}

	/**
	 * Desactiver canal vente test.
	 */
	/*
	@Test
	public void desactiverCanalVenteTest() {
		User user = new User("ID01", "CODE03");
		String domaine = Constantes.REFERENTIEL;
		String command = Constantes.COMMAND_GERER_CANAL_VENTE;
		String sousCommand = Constantes.SOUS_COMMAND_DESACTIVER_CANAL_VENTE;

		String libelle = null;
		String description = null;
		SearchConfig config = new SearchConfig();
		String sortField = null;
		String sortOrder = null;
		CanalVenteCriteria criteria = new CanalVenteCriteria(libelle,
				description, null, config);
		List<CanalVente> models = new ArrayList<CanalVente>();
		models = referentielService.findCanalVenteByCriteria(criteria);

		CanalVenteVOTransformer canalVenteVOTransformer = new CanalVenteVOTransformer();

		List<CanalVenteVO> vos = canalVenteVOTransformer
				.model2VO(models, false);
		for (CanalVenteVO vo : vos) {
			vo.setStatut(EntityStatus.DISABLED);
		}
		@SuppressWarnings("unchecked")
		List<ValueObject> listvos = (List<ValueObject>) (List<?>) vos;
		// preparation ds parametres
		ClientParameters clientParameters = new ClientParameters(domaine,
				command, sousCommand, user, listvos);

		// appel de l'UC
		final ProcessResult result = (new FacadeControllerImpl(clientParameters))
				.useCaseProcess();
		Assert.assertNotNull(result);
	}
	*/
}
