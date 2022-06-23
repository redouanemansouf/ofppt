package com.m2m.onousc.business.referentiel.dao.impl;

import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.spring.BeansLookuper;

public class TestDAO {
	
	static ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carte carte=((Carte)referentielService.findCarteByEtud(1000L));
		System.out.println(carte.getNumeroCarte());
		
		

	}

}
