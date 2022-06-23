/*
* LoginPage.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPage.
 *
 * @author aelhachimi
 */
public class LoginPage {

	/** The driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new login page.
	 *
	 * @param webDriver the web driver
	 */
	public LoginPage(WebDriver webDriver) {
		super();
		this.driver = webDriver;
		// Check that we're on the right page.
		// if (!"Login".equals(driver.getTitle())) {
		// // Alternatively, we could navigate to the login page, perhaps
		// // logging out first
		// throw new IllegalStateException("This is not the login page");
		// }
	}

	// The login page contains several HTML elements that will be represented as
	// WebElements.
	// The locators for these elements should only be defined once.
	/** The username locator. */
	private By usernameLocator = By.id("Authentification:j_username");
	
	/** The password locator. */
	private By passwordLocator = By.id("Authentification:j_password");
	
	/** The login button locator. */
	private By loginButtonLocator = By.id("Authentification:login");

	// The login page allows the user to type their username into the username
	// field
	/**
	 * Type username.
	 *
	 * @param username the username
	 * @return the login page
	 */
	public LoginPage typeUsername(String username) {
		// This is the only place that "knows" how to enter a username
		driver.findElement(usernameLocator).sendKeys(username);

		// Return the current page object as this action doesn't navigate to a
		// page represented by another PageObject
		return this;
	}

	// The login page allows the user to type their password into the password
	// field
	/**
	 * Type password.
	 *
	 * @param password the password
	 * @return the login page
	 */
	public LoginPage typePassword(String password) {
		// This is the only place that "knows" how to enter a password
		driver.findElement(passwordLocator).sendKeys(password);

		// Return the current page object as this action doesn't navigate to a
		// page represented by another PageObject
		return this;
	}

	// The login page allows the user to submit the login form
	/**
	 * Submit login.
	 *
	 * @return the home page
	 */
	public HomePage submitLogin() {
		// This is the only place that submits the login form and expects the
		// destination to be the home page.
		// A seperate method should be created for the instance of clicking
		// login whilst expecting a login failure.
		driver.findElement(loginButtonLocator).click();

		// Return a new page object representing the destination. Should the
		// login page ever
		// go somewhere else (for example, a legal disclaimer) then changing the
		// method signature
		// for this method will mean that all tests that rely on this behaviour
		// won't compile.

		// // We can wait for a condition before proceeding
		// (new WebDriverWait(driver, 10)).until(new
		// ExpectedCondition<Boolean>() {
		// public Boolean apply(WebDriver d) {
		// return !d.getTitle().equalsIgnoreCase("login");
		// }
		// });
		return new HomePage(driver);
	}

	// The login page allows the user to submit the login form knowing that an
	// invalid username and / or password were entered
	/**
	 * Submit login expecting failure.
	 *
	 * @return the login page
	 */
	public LoginPage submitLoginExpectingFailure() {
		// This is the only place that submits the login form and expects the
		// destination to be the login page due to login failure.
		driver.findElement(loginButtonLocator).submit();

		// Return a new page object representing the destination. Should the
		// user ever be navigated to the home page after submiting a login with
		// credentials
		// expected to fail login, the script will fail when it attempts to
		// instantiate the LoginPage PageObject.
		return new LoginPage(driver);
	}

	// Conceptually, the login page offers the user the service of being able to
	// "log into"
	// the application using a user name and password.
	/**
	 * Login as.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the home page
	 */
	public HomePage loginAs(String username, String password) {
		// The PageObject methods that enter username, password & submit login
		// have already defined and should not be repeated here.
		typeUsername(username);
		typePassword(password);
		return submitLogin();
	}
}
