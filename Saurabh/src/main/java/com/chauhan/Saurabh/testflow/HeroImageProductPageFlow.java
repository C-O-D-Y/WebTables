package com.chauhan.Saurabh.testflow;

import java.util.Properties;

import com.chauhan.Saurabh.helpers.WebUtility;

/**
 * Class maintain the flow of the test to the second page by clicking on the
 * hero image
 */
public class HeroImageProductPageFlow {

	/**
	 * Method click on the hero image at the home page
	 */
	public static void clickHeroImage(Properties locator) {
		WebUtility.clickElement(locator.getProperty("loc.img.heroImage"));
		WebUtility.explicitWait(locator.getProperty("loc.text.heroImageProductName"));
	}

	/**
	 * Method click on the product specification bar
	 */
	public static void clickProductSpecification(Properties locator) {

		WebUtility.clickElement(locator.getProperty("loc.btn.specification"));
	}

	/**
	 * Method click on the Customer reviews bar
	 */
	public static void clickCustomerReviews(Properties locator) {

		WebUtility.clickElement(locator.getProperty("loc.btn.customerReviews"));
	}

	/**
	 * Method select the dropdown by index of the sorting options
	 */
	public static void selectSortingDropdown(int sortingOrder, Properties locator) {
		WebUtility.selectDropdownByIndex(locator.getProperty("loc.dpdn.sort"), sortingOrder);
		WebUtility.explicitWait(locator.getProperty("loc.text.heroImageProductName"));
	}

}
