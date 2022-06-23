package com.m2m.onousc.business.referentiel.uc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.core.ClientParameters;
import com.m2m.technicalservices.core.FacadeControllerImpl;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.User;
/**
 * 
 * @author abousnane
 *
 */

public class GererUniversiteTest {

	/** The referentiel service. */
	@Autowired
	ReferentielService referentielService;
	
	/**
	 * Creer universite test.
	 */
	/*
	@Test
	public void creerUniversiteTest() {
		User user = new User("ID01", "CODE03");
		String domaine = Constantes.REFERENTIEL;
		String command = Constantes.COMMAND_GERER_UNIVERSITE;
		String sousCommand = Constantes.SOUS_COMMAND_CREER_UNIVERSITE;
		
		String libelle = "";
		String adresseUniv = "";
		String nomResponsableUniv= "";
		String prenomResponsableUniv= "";
		String numTeleUniv= "";
		String adresseEmailUniv= "";
		
		
		UniversiteVO vo= new UniversiteVO(libelle, adresseUniv, nomResponsableUniv, prenomResponsableUniv, numTeleUniv, adresseEmailUniv, new VilleVO());
		// preparation ds parametres
				ClientParameters clientParameters = new ClientParameters(domaine,
						command, sousCommand, user, vo);
				// appel de l'UC
				final ProcessResult result = (new FacadeControllerImpl(clientParameters))
						.useCaseProcess();
				Assert.assertNotNull(result);
	}
	*/
}
