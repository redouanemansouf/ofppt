package com.m2m.onousc.web.administration;

import com.m2m.onousc.web.administration.webbean.GroupUserWebBean;

public interface IGroupUserBusDelegate {

	boolean creerGroupUser(GroupUserWebBean webBean);

	boolean supprimerGroupUser(GroupUserWebBean webBean);

	boolean modifierGroupUser(GroupUserWebBean webBean);

}
