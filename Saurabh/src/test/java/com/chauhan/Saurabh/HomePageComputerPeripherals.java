package com.chauhan.Saurabh;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.TestNGException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.dataProvider.TestDataProvider;
import com.chauhan.Saurabh.logReports.LogReport;
import com.chauhan.Saurabh.pages.HomePage;
import com.chauhan.Saurabh.pages.HomePageComputerPeripheralsValidation;
import com.chauhan.Saurabh.testBase.TestBase;
import com.chauhan.Saurabh.testflow.HomePageComputerPeripheralsFlow;
import com.chauhan.Saurabh.testflow.HomePageFlow;
import com.chauhan.Saurabh.utils.ReadPropertiesFile;

/*
*Class validates the functionality of Computer peripherals page
*/
public class HomePageComputerPeripherals extends TestBase {
	Logger log;
	Properties locator, validate;
	static HomePage home = new HomePage();

	HomePageComputerPeripheralsFlow peripheralsFlow = new HomePageComputerPeripheralsFlow();
	HomePageComputerPeripheralsValidation peripheralsValidation = new HomePageComputerPeripheralsValidation();

	/*
	 * Test loads the properties file to get the locators and the validation data
	 * from the file
	 */
	@BeforeTest
	public void loadLocatorsFile() {
		log = Logger.getLogger(HomePageComputerPeripherals.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageProductValidation");
		locator = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		log.info("Files loaded");
	}

	/*
	 * Test validates the error msg is displayed when giving graphics cards input
	 * and clicking on search button
	 */

	@Test(priority = 9, dataProvider = "wrongProduct", dataProviderClass = TestDataProvider.class)
	public void validateMessage(String category, String product, String errorMsg) throws InterruptedException {
		logger = extent.startTest("Validating error message functionality");

		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			LogReport.getlogger();
			HomePageFlow.clickCategory(category, locator);
			HomePageFlow.selectProduct(product, locator);

			home.isErrorMessageDisplayed(errorMsg, locator);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	// method validate the availability of the product graphics cards when selected
	// from the dropdown

	@Test(priority = 10, dataProvider = "rightProduct", dataProviderClass = TestDataProvider.class)
	public void validateProductAvilability(String category, String product, String expectedProductName)
			throws InterruptedException {
		logger = extent.startTest("Validating input functionality");
		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			HomePageFlow.clickCategory(category, locator);
			HomePageFlow.selectProductByDropdown(product, locator);

			home.isProductAvailable(expectedProductName, locator);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	@Test(priority = 11, dataProvider = "pricing", dataProviderClass = TestDataProvider.class)
	public void validatePricingSortingFunctionality(String xoffset) throws InterruptedException {
		logger = extent.startTest("Validating pricing (sorting) functionality");
		try {
			log = Logger.getLogger(HomePageComputerPeripherals.class);
			peripheralsFlow.clickComputerPeripherals(locator);
			System.out.println(xoffset);
			peripheralsFlow.selectPricing(Integer.parseInt(xoffset), locator);
			peripheralsValidation.validatePrice(locator);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}
}
