package com.m2m.onousc.web.administration;

import com.m2m.onousc.web.administration.webbean.MenuWebBean;

public interface IMenuBusDelegate {

	boolean creerMenu(MenuWebBean webBean);

	boolean supprimerMenu(MenuWebBean webBean);

	boolean modifierMenu(MenuWebBean webBean);

}
