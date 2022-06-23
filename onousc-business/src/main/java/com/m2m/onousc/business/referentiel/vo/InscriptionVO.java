package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Inscription;
import com.m2m.onousc.business.referentiel.vo.transformer.InscriptionVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

public class InscriptionVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3053581560694596412L;

	private Long id;
	private String cin;
	private Date dateNaissance;
	private String nom;
	private String prenom;
	private String sexe;
	private EntityStatus statut;
	private String path;
	private VilleVO villeVO;
	private SiteVO siteVO;
	private RestaurantVO restaurantVO;
	private VilleVO villeRestaurantVO;
	/* Telephone */
 	private String tele;
 	/* NAPS ou priva */
 	private String typeCarte;
	private String email;
	private AnneeUniversitaireVO anneUniversitaireVO;
	private String codeMassar;
	private String typePersonelle;
	private String  Etablissement;
	private String  CodeProfil;
	public InscriptionVO() {
		super();
	}


	public InscriptionVO(String cin, Date dateNaissance, String nom, String prenom, String sexe, EntityStatus statut,
			String path, VilleVO villeVO, SiteVO siteVO, RestaurantVO restaurantVO, VilleVO villeRestaurantVO,
			String email, AnneeUniversitaireVO anneUniversitaireVO, String codeMassar, String typePersonelle,String etablissement,String codeProfil,String Tele,String TypeCarte) {
		super();
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.statut = statut;
		this.path = path;
		this.villeVO = villeVO;
		this.siteVO = siteVO;
		this.restaurantVO = restaurantVO;
		this.villeRestaurantVO = villeRestaurantVO;
		this.email = email;
		this.anneUniversitaireVO = anneUniversitaireVO;
		this.codeMassar = codeMassar;
		this.typePersonelle = typePersonelle;
		this.Etablissement = etablissement;
		this.CodeProfil = codeProfil;
		this.tele = Tele;
		this.typeCarte =TypeCarte;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public VilleVO getVilleVO() {
		return villeVO;
	}

	public void setVilleVO(VilleVO villeVO) {
		this.villeVO = villeVO;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

	public RestaurantVO getRestaurantVO() {
		return restaurantVO;
	}

	public void setRestaurantVO(RestaurantVO restaurantVO) {
		this.restaurantVO = restaurantVO;
	}

	public VilleVO getVilleRestaurantVO() {
		return villeRestaurantVO;
	}

	public void setVilleRestaurantVO(VilleVO villeRestaurantVO) {
		this.villeRestaurantVO = villeRestaurantVO;
	}

	public AnneeUniversitaireVO getAnneUniversitaireVO() {
		return anneUniversitaireVO;
	}

	public void setAnneUniversitaireVO(AnneeUniversitaireVO anneUniversitaireVO) {
		this.anneUniversitaireVO = anneUniversitaireVO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Inscription, InscriptionVO> getTransformer() {
		return new InscriptionVOTransformer();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscriptionVO other = (InscriptionVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}


 


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	 


	public String getTypeCarte() {
		return typeCarte;
	}


	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}


	public String getTypePersonelle() {
		return typePersonelle;
	}


	public void setTypePersonelle(String typePersonelle) {
		this.typePersonelle = typePersonelle;
	}


	public String getEtablissement() {
		return Etablissement;
	}


	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}


	public String getCodeProfil() {
		return CodeProfil;
	}


	public void setCodeProfil(String codeProfil) {
		CodeProfil = codeProfil;
	}

 
}
