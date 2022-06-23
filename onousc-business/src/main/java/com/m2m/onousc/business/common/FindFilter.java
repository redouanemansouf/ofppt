package com.m2m.onousc.business.common;
 
import java.io.File;
import java.io.FilenameFilter;


// FileNameFilter implementation
public class FindFilter implements FilenameFilter {

	private String extension;

	public FindFilter(String extension) {
		this.extension = extension.toLowerCase();
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.replace(" ", "").toLowerCase().startsWith(extension);
	}

}