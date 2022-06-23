package com.m2m.onousc.business.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

public class FieldsControler {
	
	private static final ILogger LOGGER = SL4JLogger
			.getInstance(FieldsControler.class);
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isNumeric(String value, int length) {
		 return   StringUtils.isNotBlank(value) && value.length() == length && StringUtils.isNumeric(value);
	}
	
	public static boolean isNumeric(String value) {	
		return   StringUtils.isNotBlank(value) && StringUtils.isNumeric(value);
	}
	
	public static boolean isAlpha(String value){
		return !isBlank(value) && StringUtils.isAlphaSpace(value); 
	}
	
	public static boolean isAlphaNumeric(String value){
		return !isBlank(value) && StringUtils.isAlphanumericSpace(value); 
	}
	
	public static boolean isBlank(String value){
		return StringUtils.isBlank(value);
	}
	
	public static boolean verifyLength(String value,int length){
		if(value.isEmpty()) return false;
		return value.length() == length;
	}
	
	public static Date extractDateFromString(String value, String pattern){

		if(StringUtils.isBlank(value)) return null;

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		// J.RHANIM - 25-06-2018
		formatter.setLenient(false);
		try {
			return formatter.parse(value);
		} catch (ParseException e) {
			LOGGER.error("ParseException: error parsing date", e);
			return null;
		}
	
	}
	
	public static boolean isValideAge(Date dateNaissance, int minAge, int maxAge){

        Calendar calDateNaissance = Calendar.getInstance() ;
        Calendar calCurrent =  Calendar.getInstance();
        
        calDateNaissance.setTime(dateNaissance);
        calCurrent.setTime(new Date());
        
        int age = calCurrent.get(Calendar.YEAR) 
                - calDateNaissance.get(Calendar.YEAR);
        
        int moisCourant = calCurrent.get(Calendar.MONTH);
        int moisNaissance = calDateNaissance.get(Calendar.MONTH);
        
        if (moisNaissance > moisCourant) {
            age--;

        } else if (moisNaissance == moisCourant) { 
            int jourCourant = calCurrent.get(Calendar.DAY_OF_MONTH);
            int jourNaissance = calDateNaissance.get(Calendar.DAY_OF_MONTH);
            if (jourNaissance > jourCourant) { 
                age--;
            }

        }
        
        if(age < minAge && age > maxAge ){
        	return false;
        } else {
        	return true;
        }
	
	}
	
	public static float extractFloat(String value) {
		if(StringUtils.isBlank(value)) return 0;
		try {
			return Float.parseFloat(value);
		} catch (Exception e) {
			return -1;
		}

	}
	
	public static boolean isMailValide(String value){
		return  StringUtils.isNotBlank(value) && value.matches(EMAIL_PATTERN);
	}
	
	
}
