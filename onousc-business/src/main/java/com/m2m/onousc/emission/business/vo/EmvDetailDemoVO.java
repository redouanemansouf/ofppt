/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.emission.business.vo;

import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class EmvDetailDemoVO implements ValueObject, ISearchResultVO {

	private static final long serialVersionUID = -3683758129815731090L;

	/** The id. */
	private Long id;

	private String applicationIDE;
	private String namePrefered;
	private String typeSelection;
	private String versionNumber;
	private String priority;
	private Integer priorityRank;
	private String enteringPin;
	private String aipProfile;
	private String langagePreferenceProfil;
	private String cvmListProfile;
	private String issuer;
	private String aflProfile;
	private String applicationUsageControlProfile;
	private String offlineFloorLimitProfile;
	private String currencyApplicationProfile;
	private String cdole1Profile;
	private String cdole2Profile;
	private String pdolProfile;
	private String ddolProfile;
	private String tdolProfile;
	private String sdaTagListProfile;
	private String profileKeysEmv;
	private String cardTvrActionCodeProfile;
	private String issuerActionCodeProfile;
	private String adaProfile;

	public EmvDetailDemoVO() {
		super();
	}

	public EmvDetailDemoVO(Long id, String applicationIDE, String namePrefered,
			String typeSelection, String versionNumber, String priority,
			Integer priorityRank, String enteringPin, String aipProfile,
			String langagePreferenceProfil, String cvmListProfile,
			String issuer, String aflProfile,
			String applicationUsageControlProfile,
			String offlineFloorLimitProfile, String currencyApplicationProfile,
			String cdole1Profile, String cdole2Profile, String pdolProfile,
			String ddolProfile, String tdolProfile, String sdaTagListProfile,
			String profileKeysEmv, String cardTvrActionCodeProfile,
			String issuerActionCodeProfile, String adaProfile) {
		super();
		this.id = id;
		this.applicationIDE = applicationIDE;
		this.namePrefered = namePrefered;
		this.typeSelection = typeSelection;
		this.versionNumber = versionNumber;
		this.priority = priority;
		this.priorityRank = priorityRank;
		this.enteringPin = enteringPin;
		this.aipProfile = aipProfile;
		this.langagePreferenceProfil = langagePreferenceProfil;
		this.cvmListProfile = cvmListProfile;
		this.issuer = issuer;
		this.aflProfile = aflProfile;
		this.applicationUsageControlProfile = applicationUsageControlProfile;
		this.offlineFloorLimitProfile = offlineFloorLimitProfile;
		this.currencyApplicationProfile = currencyApplicationProfile;
		this.cdole1Profile = cdole1Profile;
		this.cdole2Profile = cdole2Profile;
		this.pdolProfile = pdolProfile;
		this.ddolProfile = ddolProfile;
		this.tdolProfile = tdolProfile;
		this.sdaTagListProfile = sdaTagListProfile;
		this.profileKeysEmv = profileKeysEmv;
		this.cardTvrActionCodeProfile = cardTvrActionCodeProfile;
		this.issuerActionCodeProfile = issuerActionCodeProfile;
		this.adaProfile = adaProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicationIDE() {
		return applicationIDE;
	}

	public void setApplicationIDE(String applicationIDE) {
		this.applicationIDE = applicationIDE;
	}

	public String getNamePrefered() {
		return namePrefered;
	}

	public void setNamePrefered(String namePrefered) {
		this.namePrefered = namePrefered;
	}

	public String getTypeSelection() {
		return typeSelection;
	}

	public void setTypeSelection(String typeSelection) {
		this.typeSelection = typeSelection;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getPriorityRank() {
		return priorityRank;
	}

	public void setPriorityRank(Integer priorityRank) {
		this.priorityRank = priorityRank;
	}

	public String getEnteringPin() {
		return enteringPin;
	}

	public void setEnteringPin(String enteringPin) {
		this.enteringPin = enteringPin;
	}

	public String getAipProfile() {
		return aipProfile;
	}

	public void setAipProfile(String aipProfile) {
		this.aipProfile = aipProfile;
	}

	public String getLangagePreferenceProfil() {
		return langagePreferenceProfil;
	}

	public void setLangagePreferenceProfil(String langagePreferenceProfil) {
		this.langagePreferenceProfil = langagePreferenceProfil;
	}

	public String getCvmListProfile() {
		return cvmListProfile;
	}

	public void setCvmListProfile(String cvmListProfile) {
		this.cvmListProfile = cvmListProfile;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getAflProfile() {
		return aflProfile;
	}

	public void setAflProfile(String aflProfile) {
		this.aflProfile = aflProfile;
	}

	public String getApplicationUsageControlProfile() {
		return applicationUsageControlProfile;
	}

	public void setApplicationUsageControlProfile(
			String applicationUsageControlProfile) {
		this.applicationUsageControlProfile = applicationUsageControlProfile;
	}

	public String getOfflineFloorLimitProfile() {
		return offlineFloorLimitProfile;
	}

	public void setOfflineFloorLimitProfile(String offlineFloorLimitProfile) {
		this.offlineFloorLimitProfile = offlineFloorLimitProfile;
	}

	public String getCurrencyApplicationProfile() {
		return currencyApplicationProfile;
	}

	public void setCurrencyApplicationProfile(String currencyApplicationProfile) {
		this.currencyApplicationProfile = currencyApplicationProfile;
	}

	public String getCdole1Profile() {
		return cdole1Profile;
	}

	public void setCdole1Profile(String cdole1Profile) {
		this.cdole1Profile = cdole1Profile;
	}

	public String getCdole2Profile() {
		return cdole2Profile;
	}

	public void setCdole2Profile(String cdole2Profile) {
		this.cdole2Profile = cdole2Profile;
	}

	public String getPdolProfile() {
		return pdolProfile;
	}

	public void setPdolProfile(String pdolProfile) {
		this.pdolProfile = pdolProfile;
	}

	public String getDdolProfile() {
		return ddolProfile;
	}

	public void setDdolProfile(String ddolProfile) {
		this.ddolProfile = ddolProfile;
	}

	public String getTdolProfile() {
		return tdolProfile;
	}

	public void setTdolProfile(String tdolProfile) {
		this.tdolProfile = tdolProfile;
	}

	public String getSdaTagListProfile() {
		return sdaTagListProfile;
	}

	public void setSdaTagListProfile(String sdaTagListProfile) {
		this.sdaTagListProfile = sdaTagListProfile;
	}

	public String getProfileKeysEmv() {
		return profileKeysEmv;
	}

	public void setProfileKeysEmv(String profileKeysEmv) {
		this.profileKeysEmv = profileKeysEmv;
	}

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCardTvrActionCodeProfile() {
		return cardTvrActionCodeProfile;
	}

	public void setCardTvrActionCodeProfile(String cardTvrActionCodeProfile) {
		this.cardTvrActionCodeProfile = cardTvrActionCodeProfile;
	}

	public String getIssuerActionCodeProfile() {
		return issuerActionCodeProfile;
	}

	public void setIssuerActionCodeProfile(String issuerActionCodeProfile) {
		this.issuerActionCodeProfile = issuerActionCodeProfile;
	}

	public String getAdaProfile() {
		return adaProfile;
	}

	public void setAdaProfile(String adaProfile) {
		this.adaProfile = adaProfile;
	}

}
