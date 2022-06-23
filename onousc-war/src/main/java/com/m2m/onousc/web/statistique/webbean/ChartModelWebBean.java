package com.m2m.onousc.web.statistique.webbean;

import java.util.List;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ChartModelWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473463207047473864L;
	private LineChartModel dateModel;
	private LineChartModel dateModel2;

	public ChartModelWebBean() {
		super();
		dateModel = new LineChartModel();
	}

	public void createDateModel(List<StatistiqueJourVO> st, Integer type,
			String date_max) {
		System.out.println("size " + st.size());
		dateModel = new LineChartModel();
		if (type == 0)
			initJourModel(st, date_max);
		else if (type == 2)
			initMoisModel(st, date_max);
		else if (type == 3)
			initAnneeModel(st, date_max);
		else
			initSemaineModel(st, date_max);
	}

	private void initJourModel(List<StatistiqueJourVO> st, String date_max) {
		dateModel = new LineChartModel();
		dateModel2 = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		ChartSeries series3 = new ChartSeries();
		series1.setLabel("Evolution de réservation");
		series2.setLabel("Evolution de consommation des repas");
		series3.setLabel("Evolution des montants des repas consommé");
		for (StatistiqueJourVO jr : st) {
			series1.set(jr.getDateOperation().toString(),
					jr.getNbreReservation());
			series2.set(jr.getDateOperation().toString(),
					jr.getNbreRepasConsomme());
			series3.set(jr.getDateOperation().toString(),
					jr.getMontantRepasConsomme());
		}

		dateModel.addSeries(series1);
		dateModel.addSeries(series2);
		dateModel2.addSeries(series3);
		dateModel.setLegendPosition("e");
		dateModel.getAxis(AxisType.Y).setLabel("Valeur");
		dateModel2.setLegendPosition("e");
		dateModel2.getAxis(AxisType.Y).setLabel("Valeur");
		DateAxis axis = new DateAxis(
				"Evolution de consommation de repas par jour");
		axis.setTickAngle(-50);
		axis.setMax(date_max);
		axis.setTickFormat("%#d %b, %y");

		DateAxis axis2 = new DateAxis("Evolution des montants par jour");
		axis2.setTickAngle(-50);
		axis2.setMax(date_max);
		axis2.setTickFormat("%#d %b, %y");

		dateModel.getAxes().put(AxisType.X, axis);
		dateModel2.getAxes().put(AxisType.X, axis2);
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}

	public LineChartModel getDateModel2() {
		return dateModel2;
	}

	public void setDateModel2(LineChartModel dateModel2) {
		this.dateModel2 = dateModel2;
	}

	private void initMoisModel(List<StatistiqueJourVO> st, String date_max) {
		dateModel = new LineChartModel();
		dateModel2 = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		series1.setLabel("Evolution de consommation des repas");
		series2.setLabel("Evolution des montants des repas consommé");
		for (StatistiqueJourVO jr : st) {
			series1.set(jr.getDateOperation().toString(),
					jr.getNbreRepasConsomme());
			series2.set(jr.getDateOperation().toString(),
					jr.getMontantRepasConsomme());
		}
		dateModel.addSeries(series1);
		dateModel2.addSeries(series2);
		dateModel.setLegendPosition("e");
		dateModel2.setLegendPosition("e");
		dateModel.getAxis(AxisType.Y).setLabel("Valeur");
		dateModel2.getAxis(AxisType.Y).setLabel("Valeur");
		DateAxis axis = new DateAxis(
				"Evolution de consommation de repas par mois");
		DateAxis axis2 = new DateAxis("Evolution des montants par mois");
		axis.setTickAngle(-50);
		axis.setMax(date_max);
		axis.setTickFormat("%#d %b, %y");

		axis2.setTickAngle(-50);
		axis2.setMax(date_max);
		axis.setTickFormat("%#d %b, %y");

		dateModel.getAxes().put(AxisType.X, axis);
		dateModel2.getAxes().put(AxisType.X, axis2);

	}

	private void initAnneeModel(List<StatistiqueJourVO> st, String date_max) {
		dateModel = new LineChartModel();
		dateModel2 = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		series1.setLabel("Evolution de consommation des repas");
		series2.setLabel("Evolution des montants des repas consommé");
		for (StatistiqueJourVO jr : st) {
			series1.set(jr.getDateOperation().toString(),
					jr.getNbreRepasConsomme());
			series2.set(jr.getDateOperation().toString(),
					jr.getMontantRepasConsomme());
		}
		dateModel.addSeries(series1);
		dateModel2.addSeries(series2);
		dateModel.setLegendPosition("e");
		dateModel2.setLegendPosition("e");
		dateModel.getAxis(AxisType.Y).setLabel("Valeur");
		dateModel2.getAxis(AxisType.Y).setLabel("Valeur");
		DateAxis axis = new DateAxis(
				"Evolution de consommation de repas par année");
		DateAxis axis2 = new DateAxis(
				"Evolution de consommation de repas par année");
		axis.setTickAngle(-50);
		axis.setMax(date_max);
		axis.setTickFormat("%#d %b, %y");

		axis2.setTickAngle(-50);
		axis2.setMax(date_max);
		axis2.setTickFormat("%#d %b, %y");

		dateModel.getAxes().put(AxisType.X, axis);
		dateModel2.getAxes().put(AxisType.X, axis2);

	}

	private void initSemaineModel(List<StatistiqueJourVO> st, String date_max) {
		dateModel = new LineChartModel();
		dateModel2 = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		series1.setLabel("Evolution de consommation des repas");
		series2.setLabel("Evolution des montants des repas consommé");
		for (StatistiqueJourVO jr : st) {
			series1.set(jr.getDateOperation().toString(),
					jr.getNbreRepasConsomme());
			series2.set(jr.getDateOperation().toString(),
					jr.getMontantRepasConsomme());
		}
		dateModel.addSeries(series1);
		dateModel2.addSeries(series2);
		dateModel.setLegendPosition("e");
		dateModel2.setLegendPosition("e");
		dateModel.getAxis(AxisType.Y).setLabel("Valeur");
		dateModel2.getAxis(AxisType.Y).setLabel("Valeur");
		DateAxis axis = new DateAxis(
				"Evolution de consommation de repas par semaine");
		DateAxis axis2 = new DateAxis("Evolution des montants par semaine");
		axis.setTickAngle(-50);
		axis.setMax(date_max);
		axis.setTickFormat("%#d %b, %y");

		axis2.setTickAngle(-50);
		axis2.setMax(date_max);
		axis2.setTickFormat("%#d %b, %y");

		dateModel.getAxes().put(AxisType.X, axis);
		dateModel2.getAxes().put(AxisType.X, axis2);

	}
}
