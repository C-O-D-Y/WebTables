package com.chauhan.Saurabh.testflow;

import java.util.Properties;

import org.apache.log4j.BasicConfigurator;

import com.chauhan.Saurabh.helpers.WebUtility;

/**
 * class used to maintain the flow of the homepage of the Konakart.com
 */
public class HomePageFlow {

	
	/**
	 * Method used to click to the category.
	 */
	public static void clickCategory(String category, Properties locator) throws InterruptedException {
		BasicConfigurator.configure();
		System.out.println(locator.getProperty("loc.dpdn.search"));
		WebUtility.selectDropdown(locator.getProperty("loc.dpdn.search"), category);
	}

	/**
	 * Method used to send the product text to select the product.
	 */
	public static void selectProduct(String product, Properties locator) {
		WebUtility.clickAndSendText(locator.getProperty("loc.textinput.search"), product);
		WebUtility.clickElement(locator.getProperty("loc.btn.search"));
	
	}

	/**
	 * Method used to select the product from the dropdown
	 */
	public static void selectProductByDropdown(String product, Properties locator) {
		WebUtility.clickAndSendText(locator.getProperty("loc.textinput.search"), product);
		WebUtility
				.explicitWait(locator.getProperty("loc.inputText.insertGraphicsCards").replace("dummytext", product));
		WebUtility
				.clickElement(locator.getProperty("loc.inputText.insertGraphicsCards").replace("dummytext", product));
	}
}
