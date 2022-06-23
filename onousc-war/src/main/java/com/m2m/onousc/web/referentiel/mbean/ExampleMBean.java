package com.m2m.onousc.web.referentiel.mbean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.ExampleVO;
import com.m2m.onousc.web.referentiel.webbean.ExampleWebBean;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class ExampleMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 441323546745993632L;
	/** The web bean. */
	private ExampleWebBean webBean;
	private String currentTheme = "style.css";

	private PieChartModel pieModel;
	private LineChartModel areaModel;
	private String transactionfiledchoice;
	private List<SelectItem> selecteditemvos;

	private List<SelectItem> testSelection;

	private boolean mode = true;

	private String defaultSelection = "0";

	private DonutChartModel donutModel;

	private PieChartModel ventePie;
	
	private HorizontalBarChartModel etatStock;

	private void initCharteModels() {
		ventePie = new PieChartModel();

		ventePie.set("Carte prépayée", 25);
		ventePie.set("Carte instantanée", 5);
		ventePie.set("Token", 3);
		ventePie.set("TPE", 4);
		ventePie.setLegendPosition("e");
		ventePie.setShowDataLabels(true);
		ventePie.setDiameter(200);
		ventePie.setSeriesColors("3498db,e67e22,2ecc71,e74c3c");
		ventePie.setExtender("pfChartExtender");
		ventePie.setSliceMargin(5);

	}
	public List<SelectItem> getTestSelection() {
		return testSelection;
	}

	public void setTestSelection(List<SelectItem> testSelection) {
		this.testSelection = testSelection;
	}

	public List<SelectItem> getSelecteditemvos() {
		return selecteditemvos;
	}

	public String getTransactionfiledchoice() {
		return transactionfiledchoice;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public void setAreaModel(LineChartModel areaModel) {
		this.areaModel = areaModel;
	}

	public void setSelecteditemvos(List<SelectItem> selecteditemvos) {
		this.selecteditemvos = selecteditemvos;
	}

	public void setTransactionfiledchoice(String transactionfiledchoice) {
		this.transactionfiledchoice = transactionfiledchoice;

	}

	public void getMenuByChoice() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub

		init();

		System.out.println("ajax called :" + getTransactionfiledchoice());

		Field f = ExampleVO.class.getDeclaredField(getTransactionfiledchoice());
		f.setAccessible(true);
		for (Object o : webBean.getVos()) {

			selecteditemvos.add(new SelectItem(o, "" + f.get(o), ""
					+ getTransactionfiledchoice() + " de transaction"));
		}

	}

	public void init() {
		webBean = new ExampleWebBean();
		testSelection = new ArrayList<SelectItem>();
		selecteditemvos = new ArrayList<SelectItem>();
		List<ExampleVO> examples = new ArrayList<ExampleVO>();
		examples.add(new ExampleVO(1L, "Tos", "", Double.valueOf(25.35), 2896,
				"Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(2L, "Ex 02", "1", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(3L, "Ldom", "2", Double.valueOf(25.35),
				2896, "Décharge", EntityStatus.ENABLED, "unload_mini"));
		examples.add(new ExampleVO(4L, "Ipsum", "3", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(5L, "Ehor", "2", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(6L, "Renne", "", Double.valueOf(25.35),
				2896, "Décharge", EntityStatus.ENABLED, "unload_mini"));
		examples.add(new ExampleVO(7L, "Glaive", "1", Double.valueOf(25.35),
				2896, "Transfert carte à carte", EntityStatus.DISABLED,
				"transfert-card2card_mini"));
		examples.add(new ExampleVO(8L, "Nikana", "2", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(9L, "Tonkor", "", Double.valueOf(25.35),
				2896, "Transfert carte à carte", EntityStatus.DISABLED,
				"transfert-card2card_mini"));
		examples.add(new ExampleVO(10L, "Zorn", "3", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		examples.add(new ExampleVO(12L, "Hades", "1", Double.valueOf(25.35),
				2896, "Décharge", EntityStatus.DISABLED, "unload_mini"));
		examples.add(new ExampleVO(13L, "Harpy", "", Double.valueOf(25.35),
				2896, "Transfert carte à carte", EntityStatus.ENABLED,
				"transfert-card2card_mini"));
		examples.add(new ExampleVO(14L, "Artemis", "2", Double.valueOf(25.35),
				2896, "Recharge", EntityStatus.ENABLED, "load_mini"));
		webBean.setVos(examples);
		testSelection.add(new SelectItem("0", "test1"));
		testSelection.add(new SelectItem("1", "test2"));
		createAreaModel();
		createPieModels();

		// example compte
		webBean.setVoComtpes(new ArrayList<ExampleVO>());
		initCharteModels();
	}

	public void addAccountDemo() {
		webBean.getVoComtpes().add(
				new ExampleVO(1L, "c1", "2354689123485", Double.valueOf(25.35),
						2896, "Recharge", EntityStatus.ENABLED, ""));

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Compte ajouter avec Succès!", null));
	}

	public void addCarteDemo() {
		webBean.getVoCartes().add(
				new ExampleVO(1L, "visagold", "1532684456300", Double
						.valueOf(25.35), 2896, "Recharge",
						EntityStatus.ENABLED, ""));

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Carte ajouter avec Succès!", null));
	}

	public void addAssociationDemo() {
		webBean.getVoAssociation().add(
				new ExampleVO(1L, "c1", "2354689123485", Double.valueOf(25.35),
						2896, "Recharge", EntityStatus.ENABLED, ""));

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Association carte/compte ajouter avec Succès!", null));
	}

	public void clientPrepayee() {

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Client affecter avec succès!", null));

		setMode(false);
	}

	public void chargePrepayed() {

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Recharge effectuer avec succès!", null));
	}

	public void transferPrepayed() {

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Transfert effectuer avec succès!", null));
	}

	public void switchMode() {
		mode = false;
	}

	public void resetVO() {
		this.webBean.setCarte(new ExampleVO());
	}

	public void resetVOCompte() {
		this.webBean.setCompte(new ExampleVO());
	}

	public void resetAssociationVO() {
		this.webBean.setAssociationCompte(new ExampleVO());
	}

	public void createPieModels() {
		// TODO Auto-generated method stub

		pieModel = new PieChartModel();

		pieModel.set("Paiement Tpe", 840);
		pieModel.set("Retrait GAB", 725);
		pieModel.set("E-Commerce", 602);
		pieModel.set("Recharge", 421);
		pieModel.set("Transfert", 421);
		pieModel.set("Paiement de Facture", 421);
		pieModel.set("Autres", 421);
		pieModel.setShowDataLabels(true);
		pieModel.setTitle("HISTORIQUE DE TRANSACTIONS");
		pieModel.setLegendPosition("w");

	}
	private void createetatStock() {
        etatStock = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Carte prépayée");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Token");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        etatStock.addSeries(boys);
        etatStock.addSeries(girls);
         
        etatStock.setStacked(true);
         
        Axis xAxis = etatStock.getAxis(AxisType.X);
        xAxis.setLabel("En stock");
         
        Axis yAxis = etatStock.getAxis(AxisType.Y);
        yAxis.setLabel("Produits");        
    }
	public PieChartModel getPieModel() {
		return pieModel;
	}

	/**
	 * Reset web bean vo.
	 */

	public LineChartModel getAreaModel() {
		return areaModel;
	}

	private Date date = Calendar.getInstance().getTime();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private void createAreaModel() {
		areaModel = new LineChartModel();

		LineChartSeries transactions = new LineChartSeries();
		transactions.setFill(true);
		transactions.setLabel("Transaction");
		transactions.set("Fevrier", 120);
		transactions.set("Avril", 100);
		transactions.set("Juin", 44);
		transactions.set("Aout", 150);
		transactions.set("Nov", 25);

		LineChartSeries slode = new LineChartSeries();
		slode.setFill(true);
		slode.setLabel("Solde");
		slode.set("Fevrier", 52);
		slode.set("Avril", 60);
		slode.set("Juin", 110);
		slode.set("Aout", 90);
		slode.set("Nov", 120);

		areaModel.addSeries(transactions);
		areaModel.addSeries(slode);

		areaModel.setTitle("2015");
		areaModel.setLegendPosition("ne");
		areaModel.setStacked(true);
		areaModel.setShowPointLabels(true);

		Axis xAxis = new CategoryAxis("Mois");
		areaModel.getAxes().put(AxisType.X, xAxis);
		Axis yAxis = areaModel.getAxis(AxisType.Y);
		yAxis.setLabel("");
		yAxis.setMin(0);
		yAxis.setMax(300);
	}

	public void pieModel() {

	}

	public void resetWebBeanVO() {
		webBean.setVo(new ExampleVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<ExampleVO>());
	}

	/**
	 * Gets the web bean.
	 * 
	 * @return the webBean
	 */
	public ExampleWebBean getWebBean() {
		return webBean;
	}

	/**
	 * Sets the web bean.
	 * 
	 * @param webBean
	 *            the webBean to set
	 */

	public void removeVo() {
		// TODO Auto-generated method stub
		getWebBean().getVos().remove(webBean.getVo());

	}

	public void setWebBean(ExampleWebBean webBean) {
		this.webBean = webBean;
	}

	public String getCurrentTheme() {
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
	}

	public boolean isMode() {
		return mode;
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public String getDefaultSelection() {
		return defaultSelection;
	}

	public void setDefaultSelection(String defaultSelection) {
		this.defaultSelection = defaultSelection;
	}

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}

	public PieChartModel getVentePie() {
		return ventePie;
	}

	public void setVentePie(PieChartModel ventePie) {
		this.ventePie = ventePie;
	}
	public HorizontalBarChartModel getEtatStock() {
		return etatStock;
	}
	public void setEtatStock(HorizontalBarChartModel etatStock) {
		this.etatStock = etatStock;
	}

}
