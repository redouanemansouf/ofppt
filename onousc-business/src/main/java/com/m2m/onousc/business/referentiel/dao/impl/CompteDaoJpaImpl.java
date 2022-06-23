/**
 * 
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;





import com.m2m.onousc.business.referentiel.dao.CompteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Compte;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;


/**
 * @author msadik
 *
 */
public class CompteDaoJpaImpl extends GenericDaoJpaImpl<Compte, Long>
implements CompteDaoJpa {

	@Override
	public List<Compte> findByCode(String matricule, SearchConfig config) {
		Object[] parameters = new Object[] { matricule };
		String queryString = Queries.FIND_COMPTE_BY_CODE;
		return findByCriteria(queryString, config, parameters);
	}
	
	

}
