/*
* LoginIT.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginIT.
 *
 * @author msadik
 */
public class LoginIT {

	/** The driver. */
	private WebDriver driver;
	
	/** The base url. */
	private String baseUrl = "http://localhost:8088/onousc-war/";
//	private String baseUrl = System.getenv("SELENIUM_TEST_BASE_URL");
	/** The accept next alert. */
private boolean acceptNextAlert = true;
	
	/** The verification errors. */
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {

		// System.setProperty("webdriver.chrome.driver",
		// "F:/dev/tools/chromedriver.exe");

		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	/**
	 * Test loging page.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testLogingPage() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginAs("user1", "user1");
		Assert.assertNotNull(homePage);
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	/**
	 * Checks if is element present.
	 *
	 * @param by the by
	 * @return true, if is element present
	 */
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if is alert present.
	 *
	 * @return true, if is alert present
	 */
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * Close alert and get its text.
	 *
	 * @return the string
	 */
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
