
package com.m2m.onousc.business.referentiel.dao.impl;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.dao.VilleDaoJpa;
import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("villeDaoJpa")
public class VilleDaoJpaImpl extends GenericDaoJpaImpl<Ville, Long> implements VilleDaoJpa {
}
