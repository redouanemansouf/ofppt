/*
 * DateUtil.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.technicalservices.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.m2m.technicalservices.exception.TechnicalException;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

public class DateUtil {

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(DateUtil.class);

	public static final String FORMAT_DEFAUT = "yyyy-MM-dd";

	public static final String FRENCH_DEFAUT = "dd/MM/yy";

	public static final String FORMAT_DDMMYY = "dd-MM-yy";

	public static final String DF_DD_MM_YYYY_HH_MM = "dd/MM/yy HH:mm";

	public static final String DF_DD_MM_YYYY_A_HH_MM_SS = "dd/MM/yy à HH:mm:ss";

	public static final String[] MOIS = { "janvier", "février", "mars",
			"avril", "mai", "juin", "juillet", "août", "septembre", "octobre",
			"novembre", "décembre" };

	public static final Map<String, Integer> MOIS_BY_NUM_LIST = new HashMap<String, Integer>();

	public static final long MS_PAR_JOUR = 1000 * 60 * 60 * 24;

	public static final String DATE_SEPARATOR = "/";
	/**
	 * @author pour le calcule des jours entre 2 dates
	 */
	public static final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

	private DateUtil() {
	}

	/**
	 * Méthode permettant de récupérer la date courante
	 * 
	 * @return Date
	 */
	public static Date currentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(new Date());
		return ConvertUtil.stringToDate(strDate);
	}

	/**
	 * Méthode permettant de récupérer l'année courant
	 * 
	 * @return int
	 */

	public static int currentYear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return Integer.parseInt(formatter.format(currentDate()));
	}

	public static Date lastDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, currentYear());
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return cal.getTime();
	}

	/**
	 * Current year string.
	 *
	 * @return the string
	 */
	public static String currentYearString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(currentDate());
	}

	/**
	 * Méthode permettant de retourner une date du type "dd/mm/yyyy" avec comme
	 * paramètre le jour, le mois et l'année
	 * 
	 * @return Date
	 * @throws ParseException
	 */
	public static Date format(String day, String month, String year)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		return formatter.parse(day + "/" + month + "/" + year);
	}

	/**
	 * Méthode permettant de retourner une date du type "dd/mm/yyyy" avec comme
	 * paramètre la date sous forme de String, et le pattern
	 * 
	 * @return Date
	 * @throws ParseException
	 */
	public static Date format(String date, String pattern)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(date);
	}

	/**
	 * Méthode retourne vrai si les deux dates correspondent au même jour<br>
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		String jour1 = ConvertUtil.dateToString(date1, "ddMMyyyy");
		String jour2 = ConvertUtil.dateToString(date2, "ddMMyyyy");
		return jour1.equals(jour2);
	}

	/**
	 * Méthode retourne vrai si la premiere date est un jour avant le date
	 * suivante <br>
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean isNextDay(Date date1, Date date2) {
		if (isSameDay(date1, date2)) {
			return false;
		}
		return date1.before(date2);
	}

	/**
	 * Méthode verifie si la date dateATester appartient à l'intervalle
	 * [dateLimite-jourInf j ,dateLimite+jourSup j]
	 * 
	 * @param dateATester
	 * @param dateLimite
	 * @param jourInf
	 * @param jourSup
	 * @return boolean
	 */
	public static boolean isBetween(Date dateATester, Date dateLimite,
			int jourInf, int jourSup) {
		long timeATester = dateATester.getTime();
		long timeReference = dateLimite.getTime();

		// dateATester + jourInf * jours => dateLimite
		// et dateATester - jourSup * jours - dateLimite < 24 heures
		return (timeATester - timeReference + (jourInf + 1) * MS_PAR_JOUR) > 0
				&& (timeATester - (jourSup + 1) * MS_PAR_JOUR - timeReference) < 0;

	}

	/**
	 * Méthode vérifiant si une date est compris entre des deux dates<br>
	 * 
	 * @param dateATester
	 * @param dateInf
	 * @param dateSup
	 * @return
	 */
	public static boolean isBetween(Date dateATester, Date dateInf, Date dateSup) {
		if (DateUtil.isSameDay(dateATester, dateInf)
				|| DateUtil.isSameDay(dateATester, dateSup)) {
			return true;
		} else {
			if (dateATester.before(dateSup) && dateATester.after(dateInf)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBetweenTimeStomps(Date dateATester, Date dateInf,
			Date dateSup) {
		if (dateATester.equals(dateInf) || dateATester.equals(dateSup)) {
			return true;
		} else {
			if (dateATester.before(dateSup) && dateATester.after(dateInf)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInTimeInterval(Date data, Date debut, Date fin) {
		Date heureDebut = timeOnly(debut);
		Date heureFin = timeOnly(fin);
		Date heure = timeOnly(data);

		if (heure.equals(heureDebut) || heure.equals(heureFin)) {
			return true;
		} else if (heure.before(heureFin) && heure.after(heureDebut)) {
			return true;
		}
		return false;
	}

	/**
	 * Méthode permettant comparer une date par rapport à la date du jour
	 * 
	 * @param date
	 * @return boolean
	 */
	public static boolean isCurrentDay(Date date) {
		return isSameDay(date, new Date());
	}

	/**
	 * Méthode permettant de vérifier si un champ de type String est une date
	 * 
	 * @param data
	 * @param pattern
	 * @return boolean
	 */
	public static boolean isDate(String data, String pattern) {

		if (data == null || "".equals(data)) {
			return false;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = formatter.parse(data);
		} catch (ParseException e) {
			LOGGER.error("ParseException: error parsing date", e);
			return false;
		}

		String dateReverse = formatter.format(date);

		return data.equals(dateReverse);
	}

	/**
	 * Méthode permettant convertir une java.util.Date en java.sql.Date
	 * 
	 * @param date
	 * @return java.sql.Date
	 */
	public static java.sql.Date toSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * Méthode permettant d'ajouter un nombre de jours à une date
	 * 
	 * @param date
	 *            de départ
	 * @param nbJours
	 *            nombre de jours à ajouter
	 * @return date de départ + nbJours
	 */
	public static java.util.Date addJours(Date date, int nbJours) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_YEAR, nbJours);
		return now.getTime();
	}

	/**
	 * Méthode permettant d'ajouter un nombre de mois à une date
	 * 
	 * @param date
	 *            de départ
	 * @param nbMois
	 *            nombre de mois à ajouter
	 * @return date de départ + nbMois
	 */
	public static java.util.Date addMois(Date date, int nbMois) {
		Calendar now = Calendar.getInstance();

		now.setTime(date);
		now.add(Calendar.MONTH, nbMois);
		return now.getTime();
	}

	/**
	 * Méthode permettant d'obtenir le jour d'une date
	 * 
	 * @param date
	 *            de départ
	 * @return jour
	 */
	public static int getDay(Date date) {
		Calendar calendar;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Méthode permettant d'obtenir le mois d'une date (janvier = 1, ...)
	 * 
	 * @param date
	 *            de départ
	 * @return mois
	 */
	public static int getMonth(Date date) {
		Calendar calendar;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * Méthode permettant d'obtenir l'annee d'une date
	 * 
	 * @param date
	 *            de départ
	 * @return annee
	 */
	public static int getYear(Date date) {
		Calendar calendar;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static int getHour(Date date) {
		Calendar calendar;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMin(Date date) {
		Calendar calendar;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * Méthode de test pour une date en chaîne de caractère avec le format par
	 * défaut
	 * 
	 * @param DateUtil
	 * @return boolean
	 */
	public static boolean isDate(String sdt) {
		return DateUtil.isDate(sdt, FORMAT_DEFAUT);
	}

	public static Calendar dateCalendarCouranteDDMMYYYY() {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault(),
				Locale.getDefault());
		final String date = formatCalendar("dd/MM/yyyy", cal);
		cal = getCalendar("dd/MM/yyyy", date);
		return cal;
	}

	public static String formatCalendar(String format, Calendar fDate) {

		if (fDate == null) {
			return "";
		}

		final SimpleDateFormat sdf = new SimpleDateFormat(format);
		final String lDate = sdf.format(fDate.getTime());
		return lDate;
	}

	public static Calendar getCalendar(String fDate) {
		if (StringUtils.isEmpty(fDate)) {
			return null;
		}
		String format = null;
		final int lengthDate = fDate.length();
		fDate = fDate.replace("-", "/");
		if (lengthDate == 10) {
			format = "dd/MM/yyyy";
		} else if (lengthDate == 13) {
			format = "dd/MM/yyyy HH";
		} else if (lengthDate == 16) {
			format = "dd/MM/yyyy HH:mm";
		} else if (lengthDate == 19) {
			format = "dd/MM/yyyy HH:mm:ss";
		}
		return getCalendar(format, fDate);
	}

	public static Calendar getCalendar(String format, String fDate) {

		final Calendar calendar = Calendar.getInstance(TimeZone.getDefault(),
				Locale.getDefault());
		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		final ParsePosition pos = new ParsePosition(0);
		final Date lDate = formatter.parse(fDate, pos);
		if (lDate == null) {
			throw new TechnicalException(
					"Problem [DateUtils]-->getCalendar format:(" + format
							+ ") fDate:(" + fDate + ")");
		}
		final Date dateHeure = new Date(lDate.getTime());
		calendar.setTime(dateHeure);
		return calendar;
	}

	public static String formatCalendarDDMMYYHHMMSSConcat(Calendar fDate) {
		return formatCalendar("ddMMyyyyHHmmss", fDate);
	}

	public static String formatDateLong(Date date) {
		DateFormat dateFormatLong = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormatLong.format(date);
	}

	/**
	 * recupere le nombre de jour entre deux date
	 * 
	 * @author amtarji
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	public static int getNumberOfDays(Date dateDebut, Date dateFin) {
		return (int) ((ConvertUtil.roundDateToLower(dateFin).getTime() - ConvertUtil
				.roundDateToLower(dateDebut).getTime()) / DAY_IN_MILLIS);
	}

	public static Date getDate1970() {
		return ConvertUtil.stringToDate("01/01/1970", "dd/MM/yy");
	}

	public static Date timeOnly(Date date) {
		return ConvertUtil.stringToTime(ConvertUtil.dateToString(date,
				ConvertUtil.TIME_ONLY));
	}
}
