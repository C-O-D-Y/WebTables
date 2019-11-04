package com.chauhan.Saurabh;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.logReports.LogReport;
import com.chauhan.Saurabh.pages.HeroImageProductValidation;
import com.chauhan.Saurabh.pages.HomePage;
import com.chauhan.Saurabh.testBase.TestBase;
import com.chauhan.Saurabh.testflow.HeroImageProductPageFlow;
import com.chauhan.Saurabh.utils.ReadPropertiesFile;

/*
*Class validates the functionality of heroImageTestScripts page
*/
public class HeroImageProducttestscripts extends TestBase {
	Logger log;
	Properties locator, validate;
	HomePage home = new HomePage();

	HeroImageProductValidation heroImg = new HeroImageProductValidation();

	/*
	 * Test loads the properties file to get the locators and the validation data
	 * from the file
	 */
	@BeforeTest
	public void loadLocatorsFile() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		locator = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		log.info("Files has been loaded");
	}
	/*
	 * Test validates the homepage redirection of the konakart.com
	 */

	@Test(priority = 4)
	public void homePageRedirection() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("HomepageRedirection");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect(validate);
		log.info("Redirection is on the correct page");
		log.info("Starting the Hero Image Product Validation testing");

	}

	/*
	 * Test validates the content of the product description and specification
	 */
	@Test(priority = 5)
	public void validateContents() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the content of the product");
		HeroImageProductPageFlow.clickHeroImage(locator);
		heroImg.validateDescriptionContent(locator, validate);
		;
		log.info("Content validation is correct");
		HeroImageProductPageFlow.clickProductSpecification(locator);
		heroImg.validateSpecificationContent(locator, validate);
		log.info("Content is present");
		log.info("Starting Sorting functionality testing");
	}

	/*
	 * Test maintain the flow to the second page by clicking customer reviews.
	 */
	@Test(priority = 6)
	public void validateSortingFunctionality() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.clickCustomerReviews(locator);
		log.info("Content is present");
		log.info("Starting Sorting functionality testing");
	}
	/*
	 * Test validates the sorting functionality of the date selection type
	 */

	@Test(priority = 7)
	public void validateSortingByDate() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.selectSortingDropdown(0, locator);
		heroImg.validateDate(1, locator, validate);
		HeroImageProductPageFlow.selectSortingDropdown(1, locator);
		heroImg.validateDate(2, locator, validate);
		log.info("sorting is correct");
	}

	/*
	 * Test validates the sorting functionality of the rating selection type
	 */
	@Test(priority = 8)
	public void validateSortingByRating() {
		log = Logger.getLogger(HeroImageProducttestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("Validating the Sorting functionality");
		HeroImageProductPageFlow.selectSortingDropdown(2, locator);
		heroImg.validateStarRating(3, locator, validate);
		HeroImageProductPageFlow.selectSortingDropdown(3, locator);
		heroImg.validateStarRating(4, locator, validate);
		log.info("sorting is correct");
	}
}
