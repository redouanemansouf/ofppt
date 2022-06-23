package com.m2m.onousc.business.referentiel.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class AdherentVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -711476687762960388L;

	/** Id technique. */
	private Long id;

	@NotNull
	@Size(max = 16)
	@AlphaNum
	private String matra;

	/** Libellé de la cite. */
	@NotNull
	@AlphaNum
	@Size(max = 80)
	private String nom;

	@NotNull
	@AlphaNum
	@Size(max = 80)
	private String prenom;

	private CategoriePorteurVO categorie;

	private List<TourniquetVO> tourniquetVO = new ArrayList<TourniquetVO>();

	private String solde;

	@NotNull
	private PersonnelVO personnel;

	@NotNull
	private VilleVO lieuNaissance;

	public List<TourniquetVO> getTourniquetVO() {
		return tourniquetVO;
	}

	public void setTourniquetVO(List<TourniquetVO> tourniquetVO) {
		this.tourniquetVO = tourniquetVO;
	}

	@NotNull
	@Size(max = 1)
	private String sexe;

	private Integer age;

	private Date dateNaissance;

	private String motif;

	private CritereVO profil;

	private Date dateDeliv;

	private Date dateExpiration;

	private String cheminExePhoto;

	private String cheminEnregPhoto;

	private String cheminRecupPhoto;

	private String cheminRecupImage;

	private String cheminProtoRecto;

	private String cheminProtoVerso;

	private String cheminCarteRecto;

	private String cheminCarteVerso;

	private String cheminExeImpression;

	private EntityStatus statut;

	private String type;

	private String cni;

	private String telephone;

	private String tranLundi, tranMardi, tranMercredi, tranJeudi, tranVendredi,
			tranSamdi, tranDimanche;

	private String image;

	private String scolarise;

	private String numCarte;

	private String montant, matricule, numcarte;

	/**
	 * Instantiates a new cite vo.
	 */
	public AdherentVO() {
		tranLundi = "";
		tranMardi = "";
		tranMercredi = "";
		tranJeudi = "";
		tranVendredi = "";
		tranSamdi = "";
		tranDimanche = "";
	}

	/**
	 * Instantiates a new cite vo.
	 * 
	 */

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	public AdherentVO(Long id, String matra, String nom, String prenom,
			CategoriePorteurVO categorie, PersonnelVO personnel,
			VilleVO lieuNaissance, String sexe, Date dateNaissance,
			CritereVO profil, Date dateDeliv, Date dateExpiration,
			String cheminExePhoto, String cheminEnregPhoto,
			String cheminRecupPhoto, String cheminRecupImage,
			String cheminProtoRecto, String cheminProtoVerso,
			String cheminCarteRecto, String cheminCarteVerso,
			String cheminExeImpression, EntityStatus statut, String type,
			String cni, String telephone, String tranLundi, String tranMardi,
			String tranMercredi, String tranJeudi, String tranVendredi,
			String tranSamdi, String tranDimanche, String image,
			String scolarise) {
		super();
		this.id = id;
		this.matra = matra;
		this.nom = nom;
		this.prenom = prenom;
		this.categorie = categorie;
		this.personnel = personnel;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.dateDeliv = dateDeliv;
		this.dateExpiration = dateExpiration;
		this.cheminExePhoto = cheminExePhoto;
		this.cheminEnregPhoto = cheminEnregPhoto;
		this.cheminRecupPhoto = cheminRecupPhoto;
		this.cheminRecupImage = cheminRecupImage;
		this.cheminProtoRecto = cheminProtoRecto;
		this.cheminProtoVerso = cheminProtoVerso;
		this.cheminCarteRecto = cheminCarteRecto;
		this.cheminCarteVerso = cheminCarteVerso;
		this.cheminExeImpression = cheminExeImpression;
		this.statut = statut;
		this.type = type;
		this.cni = cni;
		this.telephone = telephone;
		this.tranLundi = tranLundi;
		this.tranMardi = tranMardi;
		this.tranMercredi = tranMercredi;
		this.tranJeudi = tranJeudi;
		this.tranVendredi = tranVendredi;
		this.tranSamdi = tranSamdi;
		this.tranDimanche = tranDimanche;
		this.image = image;
		this.scolarise = scolarise;
	}

	public CategoriePorteurVO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePorteurVO categorie) {
		this.categorie = categorie;
	}

	public PersonnelVO getPersonnel() {
		return personnel;
	}

	public void setPersonnel(PersonnelVO personnel) {
		this.personnel = personnel;
	}

	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new AdherentVOTransformer();
	}

	public String getMatr() {
		return matra;
	}

	public void setMatr(String matra) {
		this.matra = matra;
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

	public VilleVO getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(VilleVO lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateDeliv() {
		return dateDeliv;
	}

	public void setDateDeliv(Date dateDeliv) {
		this.dateDeliv = dateDeliv;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getCheminExePhoto() {
		return cheminExePhoto;
	}

	public void setCheminExePhoto(String cheminExePhoto) {
		this.cheminExePhoto = cheminExePhoto;
	}

	public String getCheminEnregPhoto() {
		return cheminEnregPhoto;
	}

	public void setCheminEnregPhoto(String cheminEnregPhoto) {
		this.cheminEnregPhoto = cheminEnregPhoto;
	}

	public String getCheminRecupPhoto() {
		return cheminRecupPhoto;
	}

	public void setCheminRecupPhoto(String cheminRecupPhoto) {
		this.cheminRecupPhoto = cheminRecupPhoto;
	}

	public String getCheminRecupImage() {
		return cheminRecupImage;
	}

	public void setCheminRecupImage(String cheminRecupImage) {
		this.cheminRecupImage = cheminRecupImage;
	}

	public String getCheminProtoRecto() {
		return cheminProtoRecto;
	}

	public void setCheminProtoRecto(String cheminProtoRecto) {
		this.cheminProtoRecto = cheminProtoRecto;
	}

	public String getCheminProtoVerso() {
		return cheminProtoVerso;
	}

	public void setCheminProtoVerso(String cheminProtoVerso) {
		this.cheminProtoVerso = cheminProtoVerso;
	}

	public String getCheminCarteRecto() {
		return cheminCarteRecto;
	}

	public void setCheminCarteRecto(String cheminCarteRecto) {
		this.cheminCarteRecto = cheminCarteRecto;
	}

	public String getCheminCarteVerso() {
		return cheminCarteVerso;
	}

	public void setCheminCarteVerso(String cheminCarteVerso) {
		this.cheminCarteVerso = cheminCarteVerso;
	}

	public String getCheminExeImpression() {
		return cheminExeImpression;
	}

	public void setCheminExeImpression(String cheminExeImpression) {
		this.cheminExeImpression = cheminExeImpression;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
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
		AdherentVO other = (AdherentVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CritereVO getProfil() {
		return profil;
	}

	public void setProfil(CritereVO profil) {
		this.profil = profil;
	}

	public String getTranMercredi() {
		return tranMercredi;
	}

	public void setTranMercredi(String tranMercredi) {
		this.tranMercredi = tranMercredi;
	}

	public String getTranLundi() {
		return tranLundi;
	}

	public void setTranLundi(String tranLundi) {
		this.tranLundi = tranLundi;
	}

	public String getTranMardi() {
		return tranMardi;
	}

	public void setTranMardi(String tranMardi) {
		this.tranMardi = tranMardi;
	}

	public String getTranJeudi() {
		return tranJeudi;
	}

	public void setTranJeudi(String tranJeudi) {
		this.tranJeudi = tranJeudi;
	}

	public String getTranVendredi() {
		return tranVendredi;
	}

	public void setTranVendredi(String tranVendredi) {
		this.tranVendredi = tranVendredi;
	}

	public String getTranSamdi() {
		return tranSamdi;
	}

	public void setTranSamdi(String tranSamdi) {
		this.tranSamdi = tranSamdi;
	}

	public String getTranDimanche() {
		return tranDimanche;
	}

	public void setTranDimanche(String tranDimanche) {
		this.tranDimanche = tranDimanche;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getScolarise() {
		return scolarise;
	}

	public void setScolarise(String scolarise) {
		this.scolarise = scolarise;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNumCarte() {
		return numCarte;

	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNumcarte() {
		String nmCarte = "";
		if (this.matra != null)
			if (this.numCarte == null) {
				nmCarte = 147851 + "" + String.format("%010d", this.id);
			} else {

				nmCarte = this.numCarte;
			}
		return nmCarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

}
