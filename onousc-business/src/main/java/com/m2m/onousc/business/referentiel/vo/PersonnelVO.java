package com.m2m.onousc.business.referentiel.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.vo.transformer.PersonnelVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

public class PersonnelVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5614856388431307782L;

	/** Id technique. */
	private Long id;

	@Size(max = 14)
	@AlphaNum
	private String matr;

	/** Libellé de la cite. */

	@AlphaNum
	@Size(max = 80)
	private String nom;

	@AlphaNum
	@Size(max = 80)
	private String prenom;

	private CategoriePorteurVO categorie;

	private String codecat;

	public List<TourniquetVO> getTourniquetVO() {
		return tourniquetVO;
	}

	public void setTouniquetVO(List<TourniquetVO> tourniquetVO) {
		this.tourniquetVO = tourniquetVO;
	}

	private VilleVO lieuNaissance;

	private List<TourniquetVO> tourniquetVO = new ArrayList<TourniquetVO>();

	private String numidentite;

	private String fonction;

	private String gestionDeleg;

	@Size(max = 1)
	private String sexe;

	private Date dateNaissance;

	private Date dateEmbauche;

	private String motif;

	private CritereVO profil;

	private String type;

	private String telephone;

	private Date dateDeliv;

	private Date dateExpiration;

	private String cheminExePhoto = "C:\\Carte_OCP\\Exe_Impression";

	private String cheminEnregPhoto = "C:\\Carte_OCP\\Photos_Porteurs\\Personnel";

	private String cheminRecupPhoto;

	private String cheminRecupImage;

	private String cheminProtoRecto;

	private String cheminProtoVerso;

	private String cheminCarteRecto;

	private String cheminCarteVerso;

	private String cheminExeImpression;

	private String chemindossieTxtServeur;

	private String chemindossieTxtLocal;

	private EntityStatus statut;

	private String image;

	private boolean showImage;

	private String uid;

	private String numCarte;

	private String montant, solde, matricule, numcarte;

	private String tranLundi, tranMardi, tranMercredi, tranJeudi, tranVendredi, tranSamdi, tranDimanche;

	private SiteVO siteVO;

	private String etab;

	public String getEtab() {
		return etab;
	}

	public void setEtab(String etab) {
		this.etab = etab;
	}

	/**
	 * Instantiates a new cite vo.
	 */
	public PersonnelVO() {
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

	public PersonnelVO(Long id, String matr, String nom, String prenom, CategoriePorteurVO categorie,
			VilleVO lieuNaissance, String numidentite, String sexe, Date dateNaissance, CritereVO profil,
			String telephone, Date dateDeliv, Date dateExpiration, String cheminExePhoto, String cheminEnregPhoto,
			String cheminRecupPhoto, String cheminRecupImage, String cheminProtoRecto, String cheminProtoVerso,
			String cheminCarteRecto, String cheminCarteVerso, String cheminExeImpression, EntityStatus statut) {
		super();
		this.id = id;
		this.matr = matr;
		this.nom = nom;
		this.prenom = prenom;
		this.categorie = categorie;
		this.lieuNaissance = lieuNaissance;
		this.numidentite = numidentite;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.telephone = telephone;
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
	public ITransformer<Personnel, PersonnelVO> getTransformer() {
		return new PersonnelVOTransformer();
	}

	public void setTourniquetVO(List<TourniquetVO> tourniquetVO) {
		this.tourniquetVO = tourniquetVO;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
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
		PersonnelVO other = (PersonnelVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNumidentite() {
		return numidentite;
	}

	public void setNumidentite(String numidentite) {
		this.numidentite = numidentite;
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

	public String getTranMercredi() {
		return tranMercredi;
	}

	public void setTranMercredi(String tranMercredi) {
		this.tranMercredi = tranMercredi;
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

	public String getTranDimanche() {
		return tranDimanche;
	}

	public void setTranDimanche(String tranDimanche) {
		this.tranDimanche = tranDimanche;
	}

	public String getTranSamdi() {
		return tranSamdi;
	}

	public void setTranSamdi(String tranSamdi) {
		this.tranSamdi = tranSamdi;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getNumcarte() {
		String nmCarte = "";
		if (this.matr != null)
			if (this.numCarte == null) {
//			if(this.matr.contains("H") || this.matr.contains("A"))
//			nmCarte = 147851 + ""
//					+ String.format("%010d", Integer.parseInt(this.matr.substring(1)) +"0");
//			else
				nmCarte = 147851 + "" + String.format("%010d", this.id);
			} else {

				nmCarte = this.numCarte;
			}
		return nmCarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isShowImage() {
		return showImage;
	}

	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public String getChemindossieTxtServeur() {
		return chemindossieTxtServeur;
	}

	public void setChemindossieTxtServeur(String chemindossieTxtServeur) {
		this.chemindossieTxtServeur = chemindossieTxtServeur;
	}

	public String getChemindossieTxtLocal() {
		return chemindossieTxtLocal;
	}

	public void setChemindossieTxtLocal(String chemindossieTxtLocal) {
		this.chemindossieTxtLocal = chemindossieTxtLocal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getGestionDeleg() {
		return gestionDeleg;
	}

	public void setGestionDeleg(String gestionDeleg) {
		this.gestionDeleg = gestionDeleg;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public CategoriePorteurVO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePorteurVO categorie) {
		this.categorie = categorie;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getCodecat() {
		return codecat;
	}

	public void setCodecat(String codecat) {
		this.codecat = codecat;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
