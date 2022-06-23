package com.m2m.technicalservices.tools;

public class StringUtils {

	private StringUtils() {
	}

	public static boolean isEmpty(String in) {
		if (in == null || "".equals(in)) {
			return true;
		}
		return false;
	}
	
	public static String padLeft(String s, int n) {
	    if (n <= 0)
	        return s;
	    int noOfSpaces = n * 2;
	    StringBuilder output = new StringBuilder(s.length() + noOfSpaces);
	    while (noOfSpaces > 0) {
	        output.append("0");
	        noOfSpaces--;
	    }
	    output.append(s);
	    return output.toString();
	}
}
