package com.m2m.onousc.web.administration;

import com.m2m.onousc.web.administration.webbean.WinMenuWebBean;

public interface IWinMenuBusDelegate {
	
	boolean creerWinMenu(WinMenuWebBean webBean);

	boolean supprimerWinMenu(WinMenuWebBean webBean);

	boolean modifierWinMenu(WinMenuWebBean webBean);

}
