package com.chauhan.Saurabh.pages;

import java.util.Properties;

import org.testng.Assert;

import com.chauhan.Saurabh.helpers.WebUtility;

//in this class, validation of different functionality is validated of the homepage of yatra.com flight bookings

public class HomePage {

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 */
	public void isRedirectionCorrect(Properties validate) {

		String title = WebUtility.getTitle();
		Assert.assertEquals(title, validate.getProperty("homepage_Title"));
		System.out.println("Redirection is on the correct page");
	}

	/**
	 * In this method i'm validating the product is present or not after you hit the
	 * any search button
	 * 
	 * @param product name
	 */

	public void isProductAvailable(String expectedProductName, Properties locator) {
		String actualProductName = WebUtility
				.getText(locator.getProperty("loc.text.productName").replace("[dummytext]", expectedProductName));
		Assert.assertEquals(actualProductName, expectedProductName, "Product is not present");
		System.out.println("input functionality is correct");

	}

	/**
	 * In this method i'm validating the footer is displayed or not after you hit
	 * the any header button
	 * 
	 * @param errormsg
	 */

	public void isErrorMessageDisplayed(String errorMsg, Properties locator) {
		System.out.println("error msg=" + errorMsg);
		String actualMsg = WebUtility.getText(locator.getProperty("loc.errorMsg.product"));
		System.out.println("Actual msg" + actualMsg);
		Assert.assertTrue(actualMsg.contains(errorMsg), "msg is not displayed");
		System.out.println("Error message functionality is correct");

	}
}
