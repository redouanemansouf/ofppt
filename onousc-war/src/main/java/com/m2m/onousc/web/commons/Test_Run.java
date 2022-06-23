package com.m2m.onousc.web.commons;

public class Test_Run {
	
	public static String ResBourse = "....\n";
	public static String Bourse="Non";	
	
	public static String padLeft(String s, int n) {
	    if (n <= 0)
	        return s;
	    int noOfSpaces = n;
	    StringBuilder output = new StringBuilder(s.length() + noOfSpaces);
	    while (noOfSpaces > 0) {
	        output.append("0");
	        noOfSpaces--;
	    }
	    output.append(s);
	    return output.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Bourse="Non";	
		
		
		
	//AppletWeb.lancerPersoElectrique(1);
	
		
		
		
		System.out.println(padLeft("01", 2));
		
		if (Bourse == "Oui")
		
		{ResBourse = "Oui";}
		  
		else if (Bourse == "Non")
		
		{ResBourse = "Non";}
		 
		
		System.out.println("ResBourse = "+ ResBourse);	
	//	AppletWeb.lancerLectureElectrique(1);
	//AppletWeb.lancerPersoGraphique(1);
		
	//	System.out.println(AppletWeb.resultat);
	}
	
}
