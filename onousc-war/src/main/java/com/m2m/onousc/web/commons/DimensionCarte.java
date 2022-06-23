package com.m2m.onousc.web.commons;

public class DimensionCarte {
	
	private int X_Name;
	private int Y_Name;
	
	private int H_photo;
	private int W_photo;
	
	private int X_photo;
	private int Y_photo;
	
	private int X_Imat;
	private int Y_Imat;
	
	private int X_date;
	private int Y_date;
	
	private int X_Expdate;
	private int Y_Expdate;
	
	public int getX_Name() {
		return X_Name;
	}
	public void setXYName(String x_Name) {
		try
		{
			X_Name =  Integer.parseInt(x_Name.split(",")[0]);
			Y_Name =  Integer.parseInt(x_Name.split(",")[1]);
			
		}catch (Exception e) {
			X_Name = 0;
			Y_Name = 0;
		}
		
	}
	public int getY_Name() {
		return Y_Name;
	}
	 
	public int getH_photo() {
		return H_photo;
	}
	public void setHWphoto(String h_photo) {
	
		try
		{
			H_photo =  Integer.parseInt(h_photo.split(",")[0]);
			W_photo =  Integer.parseInt(h_photo.split(",")[1]);
			
		}catch (Exception e) {
			H_photo = 0;
			W_photo = 0;
		} 
	}
	public int getW_photo() {
		return W_photo;
	}
	public void setW_photo(int w_photo) {
		W_photo = w_photo;
	}
	public int getX_photo() {
		return X_photo;
	}
	public void setXYphoto(String XYphoto) {
		try
		{
			X_photo =  Integer.parseInt(XYphoto.split(",")[0]);
			Y_photo =  Integer.parseInt(XYphoto.split(",")[1]);
			
		}catch (Exception e) {
			X_photo = 0;
			Y_photo = 0;
		} 
	}
	public int getY_photo() {
		return Y_photo;
	}
	public void setY_photo(int y_photo) {
		Y_photo = y_photo;
	}
	public int getX_Imat() {
		return X_Imat;
	}
	public void setXYImat(String x_Imat) {
		try
		{
			X_Imat =  Integer.parseInt(x_Imat.split(",")[0]);
			Y_Imat =  Integer.parseInt(x_Imat.split(",")[1]);
			
		}catch (Exception e) {
			X_Imat = 0;
			Y_Imat = 0;
		} 
	}
	public int getY_Imat() {
		return Y_Imat;
	}
	public void setY_Imat(int y_Imat) {
		Y_Imat = y_Imat;
	}
	public int getX_date() {
		return X_date;
	}
	public void setXYdate(String x_date) {
		try
		{
			X_date =  Integer.parseInt(x_date.split(",")[0]);
			Y_date =  Integer.parseInt(x_date.split(",")[1]);
			
		}catch (Exception e) {
			X_date = 0;
			Y_date = 0;
		}  
	}
	public int getY_date() {
		return Y_date;
	}
	public void setY_date(int y_date) {
		Y_date = y_date;
	}
	 
	public int getX_Expdate() {
		return X_Expdate;
	}
	public void setXYExpdate(String x_Expdate) {
		try
		{
			X_Expdate =  Integer.parseInt(x_Expdate.split(",")[0]);
			Y_Expdate =  Integer.parseInt(x_Expdate.split(",")[1]);
			
		}catch (Exception e) {
			X_Expdate = 0;
			Y_Expdate = 0;
		}  
	}
	public int getY_Expdate() {
		return Y_Expdate;
	}
	
	
	
}
