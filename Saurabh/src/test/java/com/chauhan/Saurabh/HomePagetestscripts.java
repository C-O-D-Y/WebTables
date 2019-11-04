package com.chauhan.Saurabh;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.TestNGException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.dataProvider.TestDataProvider;
import com.chauhan.Saurabh.logReports.LogReport;
import com.chauhan.Saurabh.pages.HomePage;
import com.chauhan.Saurabh.testBase.TestBase;
import com.chauhan.Saurabh.testflow.HomePageFlow;
import com.chauhan.Saurabh.utils.ReadPropertiesFile;

/*
*Class validates the functionality of homepage header buttons functionality
*/
public class HomePagetestscripts extends TestBase {
	Logger log;
	Properties locator, validate;
	static HomePage home = new HomePage();

	/*
	 * Test loads the properties file to get the locators and the validation data
	 * from the file
	 */
	@BeforeTest
	public void loadLocatorsFile() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		locator = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
	}

	/*
	 * Test validates the homepage redirection of the konakart.com
	 */
	@Test(priority = 1)
	public void homePageRedirection() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect(validate);
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	// method validate the availability of the product
	@Test(priority = 2, dataProvider = "rightCategory", dataProviderClass = TestDataProvider.class)
	public void validateProductAvailability(String category, String product, String expectedProductName)
			throws InterruptedException {
		logger = extent.startTest("Validating input functionality");
		try {
			HomePageFlow.clickCategory(category, locator);
			HomePageFlow.selectProduct(product, locator);
			log = Logger.getLogger(HomePagetestscripts.class);
			// WebUtility.explicitWait(Locators.getLocators("loc.btn.services"));
			home.isProductAvailable(expectedProductName, locator);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

	/*
	 * Test validates the error msg is displayed when giving wrong input
	 */
	@Test(priority = 3, dataProvider = "wrongCategory", dataProviderClass = TestDataProvider.class)
	public void validateErrorMessage(String category, String product, String errorMsg) throws InterruptedException {
		try {
			HomePageFlow.clickCategory(category, locator);
			HomePageFlow.selectProduct(product, locator);
			logger = extent.startTest("Validating error message functionality");
			log = Logger.getLogger(HomePagetestscripts.class);
			// WebUtility.explicitWait(Locators.getLocators("loc.btn.services"));
			home.isErrorMessageDisplayed(errorMsg, locator);
			log.info("Validation done");
		} catch (TestNGException exception) {
			log.info("Input Functionality is not correct");
			exception.printStackTrace();
		}
	}

}
