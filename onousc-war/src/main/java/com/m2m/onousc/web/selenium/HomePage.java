/*
* HomePage.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePage.
 *
 * @author aelhachimi
 */
public class HomePage {

	/** The driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new home page.
	 *
	 * @param webDriver the web driver
	 */
	public HomePage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.driver = webDriver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Check that we're on the right page.
		if (!"POC".equals(driver.getTitle())) {
			// Alternatively, we could do something else (navigate to other
			// page, ...)
			throw new IllegalStateException("This is not the home page");
		}
	}
}
