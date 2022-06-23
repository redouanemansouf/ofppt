package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.vo.ProfilOffLineDemoVO;
import com.m2m.onousc.web.referentiel.webbean.ProfilOffLineDemoWebBean;
import com.m2m.technicalservices.web.BaseMBean;

@ManagedBean
@ViewScoped
public class ProfilOffLineDemoMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3706335169252384983L;
	/** The web bean. */
	private ProfilOffLineDemoWebBean webBean;
	private boolean execSearch = true;
	private boolean createMode = true;

	public void init() {
		webBean = new ProfilOffLineDemoWebBean();
		webBean.setVos(new ArrayList<ProfilOffLineDemoVO>());
		initList();
	}

	public void initList() {
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<ProfilOffLineDemoVO> profilOffLineDemos = new ArrayList<ProfilOffLineDemoVO>();
		profilOffLineDemos.add(new ProfilOffLineDemoVO(1L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(2L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(3L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(4L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(5L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(6L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(7L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(8L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(9L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(10L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(11L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(12L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(13L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(14L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(15L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(16L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(17L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(18L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Dirham (MAD)", "AWB", "Type 01", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(19L, "Profil 01", "001", Double.valueOf(5200),
				Double.valueOf(3500), 15, "Euro", "BMCE", "Type 01", "Paiement TPE", null));
		
		profilOffLineDemos.add(new ProfilOffLineDemoVO(20L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(22L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(22L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(23L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(24L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(25L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Dirham (MAD)", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(26L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(27L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(28L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(29L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(3500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));
		
		
		profilOffLineDemos.add(new ProfilOffLineDemoVO(20L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(22L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(22L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(24L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(24L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(25L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Dirham (MAD)", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(26L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(27L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(28L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Dirham (MAD)", "AWB", "Type 02", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(29L, "Profil 02", "002", Double.valueOf(5200),
				Double.valueOf(4500), 25, "Euro", "BMCE", "Type 02", "Paiement TPE", null));
		
		profilOffLineDemos.add(new ProfilOffLineDemoVO(30L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Euro", "BMCE", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(33L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Dirham (MAD)", "AWB", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(33L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Euro", "BMCE", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(33L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Dirham (MAD)", "AWB", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(34L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Euro", "BMCE", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(35L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Dirham (MAD)", "BMCE", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(36L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Dirham (MAD)", "AWB", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(37L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Euro", "BMCE", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(38L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Dirham (MAD)", "AWB", "Type 03", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(39L, "Profil 03", "003", Double.valueOf(5300),
				Double.valueOf(3500), 35, "Euro", "BMCE", "Type 03", "Paiement TPE", null));
		
		
		
		profilOffLineDemos.add(new ProfilOffLineDemoVO(40L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Euro", "BMCE", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(44L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Dirham (MAD)", "AWB", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(44L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Euro", "BMCE", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(44L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Dirham (MAD)", "AWB", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(44L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Euro", "BMCE", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(45L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Dirham (MAD)", "BMCE", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(46L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Dirham (MAD)", "AWB", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(47L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Euro", "BMCE", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(48L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Dirham (MAD)", "AWB", "Type 04", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(49L, "Profil 04", "004", Double.valueOf(5400),
				Double.valueOf(4500), 45, "Euro", "BMCE", "Type 04", "Paiement TPE", null));
		
		
		
		profilOffLineDemos.add(new ProfilOffLineDemoVO(50L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Euro", "BMCE", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(55L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Dirham (MAD)", "AWB", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(55L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Euro", "BMCE", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(55L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Dirham (MAD)", "AWB", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(54L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Euro", "BMCE", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(55L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Dirham (MAD)", "BMCE", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(56L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Dirham (MAD)", "AWB", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(57L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Euro", "BMCE", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(58L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Dirham (MAD)", "AWB", "Type 05", "Paiement TPE", null));

		profilOffLineDemos.add(new ProfilOffLineDemoVO(59L, "Profil 05", "005", Double.valueOf(5500),
				Double.valueOf(5500), 55, "Euro", "BMCE", "Type 05", "Paiement TPE", null));

		webBean.setVos(profilOffLineDemos);
		execSearch = true;
	}

	public void resetVO() {
		getWebBean().setVo(new ProfilOffLineDemoVO());
	}

	public void addVO() {
		if (!getWebBean().getVos().isEmpty()) {
			getWebBean().getVo().setId(Long.valueOf(getWebBean().getVos().size()));
		}
		getWebBean().getVos().add(getWebBean().getVo());
		initList();
		resetVO();
	}

	public void removeVO() {
		getWebBean().getVos().remove(getWebBean().getVo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new ProfilOffLineDemoVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ProfilOffLineDemoVO>());
	}

	/**
	 * Gets the web bean.
	 * 
	 * @return the webBean
	 */
	public ProfilOffLineDemoWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean
	 *            the webBean to set
	 */
	public void setWebBean(ProfilOffLineDemoWebBean webBean) {
		this.webBean = webBean;
	}

	public boolean isExecSearch() {
		return execSearch;
	}

	public void setExecSearch(boolean execSearch) {
		this.execSearch = execSearch;
	}

	public boolean isCreateMode() {
		return createMode;
	}

	public void setCreateMode(boolean createMode) {
		this.createMode = createMode;
	}

}
