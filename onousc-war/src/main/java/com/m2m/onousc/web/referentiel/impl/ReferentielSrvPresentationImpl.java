/*
 * ReferentielSrvPresentationImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.onousc.business.referentiel.criteria.UserEntityCriteria;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.AnneeUniversitaireVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.BorneVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CaisseVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CaissierVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteNapsVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CategoriePorteurVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CritereVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CiteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.CycleVieVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.DetailProfilVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.EquipementVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.EtudiantVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.FiliereVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.GroupUserVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.JoursFerieVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.MenuVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.MotifMainLeveeVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.MotifOppositionVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.NoteCritereVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ParametreGeneralVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.PersonnelVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.PlafondVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ProduitVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.RestaurantVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ServiceVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.SiteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.TarifVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.TourniquetVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.TraceEntityVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.UniversiteVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.UserEntityVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.VilleVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.WinMenuVOTransformer;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.business.reservation.vo.transformer.ReservationVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.web.SearchConfig;

@Service("referentielSrvPresentation")
@Transactional(readOnly = true)
public class ReferentielSrvPresentationImpl implements ReferentielSrvPresentation, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7634666256645513198L;

	/** The referentielservice. */
	@Autowired
	private ReferentielService referentielservice;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.referentiel.ReferentielSrvPresentation#findCanalVente
	 * (java.lang.Long)
	 */
	@Override
	public CanalVenteVO findCanalVente(Long id) {
		CanalVente model = referentielservice.findCanalVente(id);
		return new CanalVenteVOTransformer().model2VO(model, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.referentiel.ReferentielSrvPresentation#
	 * findAllCanalVenteForCombo()
	 */
	@Override
	public List<CanalVenteVO> findAllCanalVenteForCombo() {
		List<CanalVente> models = referentielservice.findAllCanalVenteForCombo();
		return new CanalVenteVOTransformer().model2VO(models, true);
	}

	@Override
	public List<VilleVO> findAllVille() {
		List<Ville> models = referentielservice.findAllVille();
		return new VilleVOTransformer().model2VO(models, false);

	}

	@Override
	public UniversiteVO findUniversite(Long id) {
		Universite model = referentielservice.findUniversite(id);
		return new UniversiteVOTransformer().model2VO(model, false);
	}

	@Override
	public List<UniversiteVO> findAllUniversiteForCombo() {
		List<Universite> models = referentielservice.findAllUniversiteForCombo();
		return new UniversiteVOTransformer().model2VO(models, true);
	}

	@Override
	public CiteVO findCite(Long id) {
		Cite model = referentielservice.findCite(id);
		return new CiteVOTransformer().model2VO(model, false);
	}

	@Override
	public List<CiteVO> findAllCiteForCombo() {
		List<Cite> models = referentielservice.findAllCiteForCombo();
		return new CiteVOTransformer().model2VO(models, true);
	}

	@Override
	public JoursFerieVO findJoursFerie(Long id) {
		JoursFerie model = referentielservice.findJoursFerie(id);
		return new JoursFerieVOTransformer().model2VO(model, false);
	}

	@Override
	public List<JoursFerieVO> findAllJoursFerieForCombo() {
		List<JoursFerie> models = referentielservice.findAllJoursFerieForCombo();
		return new JoursFerieVOTransformer().model2VO(models, true);
	}

	@Override
	public ServiceVO findService(Long id) {
		com.m2m.onousc.business.referentiel.model.Service model = referentielservice.findService(id);
		return new ServiceVOTransformer().model2VO(model, false);
	}

	@Override
	public List<ServiceVO> findAllServiceForCombo() {
		List<com.m2m.onousc.business.referentiel.model.Service> models = referentielservice.findAllServiceForCombo();
		return new ServiceVOTransformer().model2VO(models, false);
	}

	@Override
	public TarifVO findTarif(Long id) {
		return new TarifVOTransformer().model2VO(referentielservice.findTarif(id), false);
	}

	@Override
	public List<TarifVO> findAllTarifForCombo() {
		return new TarifVOTransformer().model2VO(referentielservice.findAllTarifForCombo(), false);
	}

	@Override
	public EtudiantVO findEtudiant(Long id) {
		Etudiants model = referentielservice.findEtudiant(id);
		return new EtudiantVOTransformer().model2VO(model, false);
	}

	@Override
	public List<EtudiantVO> findAllEtudiantforCombo() {
		List<Etudiants> models = referentielservice.findForCombo();
		return new EtudiantVOTransformer().model2VO(models, true);
	}

	@Override
	public CaisseVO findCaisse(Long id) {
		return new CaisseVOTransformer().model2VO(referentielservice.findCaisse(id), false);
	}

	@Override
	public List<CaisseVO> findAllCaisseForCombo() {
		return new CaisseVOTransformer().model2VO(referentielservice.findAllCaisseForCombo(), false);
	}

	@Override
	public RestaurantVO findRestaurant(Long id) {
		return new RestaurantVOTransformer().model2VO(referentielservice.findRestaurant(id), false);
	}

	@Override
	public List<RestaurantVO> findAllRestaurantForCombo() {
		return new RestaurantVOTransformer().model2VO(referentielservice.findAllRestaurantForCombo(), false);
	}

	@Override
	public PlafondVO findPlafond(Long id) {
		return new PlafondVOTransformer().model2VO(referentielservice.findPlafond(id), false);
	}

	@Override
	public List<PlafondVO> findAllPlafondForCombo() {
		return new PlafondVOTransformer().model2VO(referentielservice.findAllPlafondForCombo(), false);
	}

	@Override
	public AnneeUniversitaireVO findAnneeUniversitaire(Long id) {
		return new AnneeUniversitaireVOTransformer().model2VO(referentielservice.findAnneeUniversitaire(id), false);
	}

	@Override
	public List<AnneeUniversitaireVO> findAllAnneeUniversitaireForCombo() {
		return new AnneeUniversitaireVOTransformer().model2VO(referentielservice.findAllAnneeUniversitaireForCombo(),
				false);
	}

	@Override
	public VilleVO findVille(Long id) {
		return new VilleVOTransformer().model2VO(referentielservice.findVille(id), false);
	}

	@Override
	public MotifOppositionVO findMotifOpposition(Long id) {
		return new MotifOppositionVOTransformer().model2VO(referentielservice.findMotifOpposition(id), false);
	}

	@Override
	public List<MotifOppositionVO> findAllMotifOppositionForCombo() {
		return new MotifOppositionVOTransformer().model2VO(referentielservice.findAllMotifOppositionForCombo(), false);
	}

	@Override
	public MotifMainLeveeVO findMotifMainLevee(Long id) {
		return new MotifMainLeveeVOTransformer().model2VO(referentielservice.findMotifMainLevee(id), false);
	}

	@Override
	public List<MotifMainLeveeVO> findAllMotifMainLeveeForCombo() {
		return new MotifMainLeveeVOTransformer().model2VO(referentielservice.findAllMotifMainLeveeForCombo(), false);
	}

	@Override
	public CategoriePorteurVO findCategoriePorteur(Long id) {
		return new CategoriePorteurVOTransformer().model2VO(referentielservice.findCategoriePorteur(id), false);
	}

	@Override
	public List<CategoriePorteurVO> findAllCategoriePorteurForCombo() {
		return new CategoriePorteurVOTransformer().model2VO(referentielservice.findAllCategoriePorteurForCombo(),
				false);
	}

	@Override
	public ParametreGeneralVO findParametreGeneral(Long id) {
		return new ParametreGeneralVOTransformer().model2VO(referentielservice.findParametreGeneral(id), false);
	}

	@Override
	public List<ParametreGeneralVO> findAllParametreGeneralForCombo() {
		return new ParametreGeneralVOTransformer().model2VO(referentielservice.findAllParametreGeneralForCombo(),
				false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.web.referentiel.ReferentielSrvPresentation#findServiceByCode
	 * (java.lang.String)
	 */
	@Override
	public ServiceVO findServiceByCode(String code) {
		return new ServiceVOTransformer().model2VO(referentielservice.findServiceByCode(code), false);
	}

	@Override
	public List<CycleVieVO> findCycleVieCriteria(CycleVieCriteria criteria) {
		return new CycleVieVOTransformer().model2VO(referentielservice.findCycleVieCriteria(criteria));
	}

	@Override
	public UserEntityVO findUserByCode(String code) {
		return new UserEntityVOTransformer().model2VO(referentielservice.findUserByCode(code), false);
	}

	@Override
	public List<RestaurantVO> findAllRestaurantByLibelleCite(String libelle) {
		return new RestaurantVOTransformer().model2VO(referentielservice.findRestaurantByLibelleCite(libelle), false);
	}

	@Override
	public List<WinMenuVO> findWinMenuModule() {
		List<WinMenu> models = referentielservice.findWinMenuModule();
		return new WinMenuVOTransformer().model2VO(models, true);
	}

	@Override
	public List<UserEntityVO> findAllUserEnabled() {
		UserEntityCriteria userCriteria = new UserEntityCriteria();
		userCriteria.setSearchConfig(new SearchConfig());
		List<UserEntity> allUser = referentielservice.findUserByCriteria(userCriteria);
		return new UserEntityVOTransformer().model2VO(allUser, true);
	}

	@Override
	public List<UserEntityVO> findUserByCriteria(UserEntityCriteria userCriteria) {
		userCriteria.setSearchConfig(new SearchConfig());
		List<UserEntity> users = referentielservice.findUserByCriteria(userCriteria);
		return new UserEntityVOTransformer().model2VO(users, true);
	}

	@Override
	public List<CaisseVO> findAllCaisseByLibelleRestaurant(String libelle) {
		return new CaisseVOTransformer().model2VO(referentielservice.findCaisseByLibelleCite(libelle), false);
	}

	@Override
	public List<EtudiantVO> findAllEtudiantByLibelleRestaurant(String libelle) {
		return new EtudiantVOTransformer().model2VO(referentielservice.findEtudiantsByLibelleCite(libelle), false);
	}

	@Override
	public List<String> findAllgroup() {
		List<String> result = new ArrayList<String>();
		List<GroupUser> gusers = referentielservice.findAllGroupe();
		for (GroupUser groupUser : gusers) {
			result.add(groupUser.getGroupname());
		}
		return result;
	}

	@Override
	public List<MenuVO> findAllMenu() {
		List<Menu> menus = referentielservice.findMenuByCritere(null, null, null);
		return new MenuVOTransformer().model2VO(menus, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.referentiel.ReferentielSrvPresentation#
	 * findRestaurantByCode(java.lang.String)
	 */
	@Override
	public RestaurantVO findRestaurantByCode(String code) {
		return new RestaurantVOTransformer().model2VO(referentielservice.findRestaurantByCode(code), false);
	}
	@Override
	public List<RestaurantVO> findRestaurantBySite(Long siteId) {
		return new RestaurantVOTransformer().model2VO(referentielservice.findRestaurantByCodeSite(siteId), false);
	}

	@Override
	public TourniquetVO findTourniquet(Long id) {
		return new TourniquetVOTransformer().model2VO(referentielservice.findTourniquet(id), false);
	}

	@Override
	public List<TourniquetVO> findAllTourniquetForCombo() {
		return new TourniquetVOTransformer().model2VO(referentielservice.findAllTourniquetForCombo(), false);
	}

	@Override
	public EquipementVO findEquipement(Long id) {
		return new EquipementVOTransformer().model2VO(referentielservice.findEquipement(id), false);
	}

	@Override
	public List<EquipementVO> findAllEquipementForCombo() {
		return new EquipementVOTransformer().model2VO(referentielservice.findAllEquipementForCombo(), false);
	}

	@Override
	public List<TraceEntityVO> findTraceByEntity(TraceEntityCriteria criteria) {
		return new TraceEntityVOTransformer().model2VO(referentielservice.findTraceByCriteria(criteria), false);
	}

	@Override
	public CaissierVO findCaissier(Long id) {
		return new CaissierVOTransformer().model2VO(referentielservice.findCaissier(id), false);
	}

	@Override
	public List<CaissierVO> findAllCaissierVOForCombo() {
		return new CaissierVOTransformer().model2VO(referentielservice.findAllCaissierForCombo(), false);
	}

	@Override
	public List<ReservationVO> findByReservationByDate(Date date1, Date date2) {
		return new ReservationVOTransformer().modelToVO(referentielservice.findByReservationByDate(date1, date2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.referentiel.ReferentielSrvPresentation#isFreeDay(java
	 * .util.Date)
	 */
	@Override
	public boolean isFreeDay(Date date) {
		return referentielservice.isFreeDay(date);
	}

	@Override
	public CritereVO findCritere(Long id) {
		return new CritereVOTransformer().model2VO(referentielservice.findCritere(id), false);
	}

	@Override
	public List<CritereVO> findAllCritereForCombo() {
		return new CritereVOTransformer().model2VO(referentielservice.findAllCritereForCombo(), false);
	}

	@Override
	public NoteCritereVO findNoteCritere(Long id) {
		return new NoteCritereVOTransformer().model2VO(referentielservice.findNoteCritere(id), false);
	}

	@Override
	public List<NoteCritereVO> findAllNoteCritereForCombo() {
		return new NoteCritereVOTransformer().model2VO(referentielservice.findAllNoteCritereForCombo(), false);
	}

	@Override
	public String findMenuByCriteria(String menuPage) {
		MenuCriteria criteria = new MenuCriteria(null, null, null, "%" + menuPage + ".xhtml");
		criteria.setSearchConfig(new SearchConfig());
		List<MenuVO> menus = new MenuVOTransformer().model2VO(referentielservice.findMenuByCriteria(criteria));
		if (menus != null && menus.size() > 0)
			return menus.get(0).getCode();
		return null;
	}

	@Override
	public BorneVO findBorne(Long id) {
		return new BorneVOTransformer().model2VO(referentielservice.findBorne(id), false);
	}
	
	@Override
	public List<BorneVO> findBorneBySite(Long idSite) {
		return new BorneVOTransformer().model2VO(referentielservice.findBorneBySite(idSite), false);
	}

	@Override
	public List<BorneVO> findAllBorneForCombo() {
		return new BorneVOTransformer().model2VO(referentielservice.findAllBorneForCombo(), false);
	}

	@Override
	public List<CycleVieVO> findCycleVieByCode(String string) {
		return new CycleVieVOTransformer().model2VO(referentielservice.findCycleVieByCode(string), false);
	}

	@Override
	public List<String> getDataConnection() {
		return referentielservice.getDataConnection();
	}

	@Override
	public List<NoteCritereVO> findNoteCritereByCodeCritere(String code) {
		return new NoteCritereVOTransformer().model2VO(referentielservice.findNoteCritereByCodeCritere(code), false);
	}

	@Override
	public List<ParametreGeneralVO> findParametreGeneralByCode(String code) {
		return new ParametreGeneralVOTransformer().model2VO(referentielservice.findParametreGeneralByCode(code), false);
	}

	@Override
	public AnneeUniversitaireVO findActuelAnneeUniversitaire() {
		return new AnneeUniversitaireVOTransformer().model2VO(referentielservice.findActuelAnneeUniversitaire(), false);
	}

	@Override
	public PersonnelVO findPersonnelByMatr(String matr) {
		return new PersonnelVOTransformer().model2VO(referentielservice.findPersonnelByMatr(matr), false);
	}

	@Override
	public List<PersonnelVO> findAllPersonnel() {
		List<Personnel> models = referentielservice.findAllPersonnel();
		return new PersonnelVOTransformer().model2VO(models, true);
	}

	@Override
	public List<AdherentVO> findAllAdherent() {
		List<Adherent> models = referentielservice.findAllAdherent();
		return new AdherentVOTransformer().model2VO(models, true);
	}

	@Override
	public PersonnelVO findPersonnel(Long id) {
		Personnel model = referentielservice.findPersonnel(id);
		return new PersonnelVOTransformer().model2VO(model, false);
	}

	@Override
	public List<AdherentVO> findAdherentByPersonnel(Long id) {
		List<Adherent> models = referentielservice.findAdherentByPersonnel(id);
		return new AdherentVOTransformer().model2VO(models, false);
	}

	@Override
	public List<ProduitVO> findProduitByFamille(Long id) {
		List<Produit> models = referentielservice.findProduitByFamille(id);
		return new ProduitVOTransformer().model2VO(models, true);
	}

	@Override
	public List<CanalVenteVO> findAllCanalVenteByClient() {
		List<CanalVente> models = referentielservice.findAllCanalVenteByClient();
		return new CanalVenteVOTransformer().model2VO(models, true);
	}

	@Override
	public List<String> getDataMessagerie() {
		return referentielservice.getDataMessagerie();
	}

	@Override
	public ProduitVO findProduitByCodeBar(String codeBar) {
		Produit produit = referentielservice.findProduitByCodeBar(codeBar);
		return new ProduitVOTransformer().model2VO(produit, false);
	}

	@Override
	public List<ServiceVO> findAllService(String type) {
		List<com.m2m.onousc.business.referentiel.model.Service> models = referentielservice.findByType(type);
		return new ServiceVOTransformer().model2VO(models, true);
	}

	@Override
	public DetailProfilVO findDetailProfil(Long id) {
		DetailProfilAcces model = referentielservice.findDetailProfil(id);
		return new DetailProfilVOTransformer().model2VO(model, false);
	}

	@Override
	public List<DetailProfilVO> findDetailProfilByprofil(String code) {
		List<DetailProfilAcces> models = referentielservice.findDetailProfilByprofil(code);
		return new DetailProfilVOTransformer().model2VO(models, false);
	}

	@Override
	public UserEntityVO findUserEntityByCode(String code) {
		UserEntity models = referentielservice.findUserEntityByCode(code);
		if (models != null) {
			return new UserEntityVOTransformer().model2VO(models, false);
		}
		return null;
	}

	@Override
	public double findSoldeByMatricule(String matr) {
		return referentielservice.findSoldeByMatricule(matr);
	}

	@Override
	public CarteNapsVO findCarteNapsByMatricule(String matr) {
		return new CarteNapsVOTransformer().model2VO(referentielservice.findCarteNapsByMatricule(matr), false);
	}

	@Override
	public List<CanalVenteVO> findCanalByCode(String code) {
		List<CanalVente> models = referentielservice.findCanalListByCode(code);
		return new CanalVenteVOTransformer().model2VO(models, false);
	}

	@Override
	public List<SiteVO> findSiteByCode(String code) {
		List<Site> models = referentielservice.findSiteByCode(code);
		return new SiteVOTransformer().model2VO(models, false);
	}

	@Override
	public List<ProduitVO> findProduitListByCode(String code) {
		List<Produit> models = referentielservice.findProduitByCode(code);
		return new ProduitVOTransformer().model2VO(models, false);
	}

	@Override
	public List<RestaurantVO> findRestaurantListByCode(String code) {
		List<Restaurant> models = referentielservice.findRestaurantListByCode(code);
		return new RestaurantVOTransformer().model2VO(models, false);
	}

	@Override
	public List<RestaurantVO> findRestaurantByIdSite(Long idSite) {
		List<Restaurant> models = referentielservice.findRestaurantByIdSite(idSite);
		return new RestaurantVOTransformer().model2VO(models, false);
	}

	@Override
	public List<CaisseVO> findCaisseListByCode(String code) {
		List<Caisse> models = referentielservice.findCaisseListByCode(code);
		return new CaisseVOTransformer().model2VO(models, false);
	}

	@Override
	public List<CaisseVO> findCaisseListByIdSite(Long idSite) {
		List<Caisse> models = referentielservice.findCaisseListByIdSite(idSite);
		return new CaisseVOTransformer().model2VO(models, false);
	}

	@Override
	public List<CaissierVO> findCaissierListByCode(String code) {
		List<Caissier> models = referentielservice.findCaissierByCode(code);
		return new CaissierVOTransformer().model2VO(models, false);
	}

	@Override
	public List<CategoriePorteurVO> findCategoriePorteurListByCode(String code) {
		List<CategoriePorteur> models = referentielservice.findCategoriePorteurByCode(code);
		return new CategoriePorteurVOTransformer().model2VO(models, false);
	}

	@Override
	public GroupUserVO findGroupUserByID(long id) {
		return new GroupUserVOTransformer().model2VO(referentielservice.findGroupUserByID(id), false);
	}

	@Override
	public List<UserEntityVO> findUserByGroup(String group) {
		List<UserEntity> models = referentielservice.findUserByGroup(group);
		return new UserEntityVOTransformer().model2VO(models, false);
	}

	@Override
	public SiteVO findSite(Long id) {
		Site model = referentielservice.findSite(id);
		return new SiteVOTransformer().model2VO(model, false);
	}

	@Override
	public List<SiteVO> findAllSite() {
		List<Site> model = referentielservice.findAllSite();
		return new SiteVOTransformer().model2VO(model, false);
	}

	@Override
	public List<CanalVenteVO> findAllCanalVenteBySite(Long idSite) {
		List<CanalVente> models = referentielservice.findAllCanalVenteBySite(idSite);
		return new CanalVenteVOTransformer().model2VO(models, true);
	}

	@Override
	public List<FiliereVO> findFiliereByCode(String code) {
		List<Filiere> models = referentielservice.findFiliereListByCode(code);
		return new FiliereVOTransformer().model2VO(models, false);
	}

	@Override
	public Long findNbreEtudiantByStatust(EntityStatus status) {
		return referentielservice.findNbreEtudiantByStatus(status);
	}

	@Override
	public CarteVO findCarteByEtud(Long id) {
		Carte model = referentielservice.findCarteByEtud(id);
		return new CarteVOTransformer().model2VO(model, false);
	}

	@Override
	public EtudiantVO findResidentStudentForInscription(String cin) {
		Etudiants model = referentielservice.findResidentStudentForInscription(cin);
		if (model != null)
			return new EtudiantVOTransformer().model2VO(model, false);
		return null;
	}

	@Override
	public EtudiantVO findResidentStudentForInscriptionMassar(String massar) {
		Etudiants model = referentielservice.findResidentStudentForInscriptionByMassar(massar);
		if (model != null)
			return new EtudiantVOTransformer().model2VO(model, false);
		return null;
	}
	

	@Override
	public EtudiantVO findEtudiantByMassar(String codeMassar) {
		return new EtudiantVOTransformer().model2VO(referentielservice
				.findEtudiantByMassar(codeMassar), false);
	}

}
