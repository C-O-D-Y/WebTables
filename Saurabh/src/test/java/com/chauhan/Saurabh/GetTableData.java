package com.chauhan.Saurabh;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.logReports.LogReport;
import com.chauhan.Saurabh.pages.HomePage;
import com.chauhan.Saurabh.testBase.TestBase;
import com.chauhan.Saurabh.utils.ReadPropertiesFile;
import com.chauhan.Saurabh.utils.ReadWebTables;

public class GetTableData extends TestBase {
	Logger log;
	Properties locator, validate;
	ReadWebTables gdt;
	static HomePage home = new HomePage();

	@BeforeTest
	public void loadLocatorsFile() {
		log = Logger.getLogger(GetTableData.class);
		LogReport.getlogger();
		logger = extent.startTest("Table read");
		locator = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		validate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		gdt = new ReadWebTables(driver);
	}

	@Test(priority = 1)
	public void getDataByNumbers() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("get data table");
		log.info("Starting table validation");
		String ret = gdt.getCellDataByColumnAndRowNumber(locator.getProperty("loc.table"), 1, 1);
		System.out.println(ret);
	}

	@Test(priority = 2)
	public void getPosition() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("get position of data");
		log.info("Starting table validation");
		String ret = gdt.getPositionOfData(locator.getProperty("loc.table"), "Height");
		System.out.println("Position is " + ret);
	}

	@Test(priority = 3)
	public void getData() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("get table data");
		log.info("Starting table printing");
		gdt.printTableData(locator.getProperty("loc.table"));

	}

	@Test(priority = 4)
	public void getRowData() {
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		logger = extent.startTest("get row data");
		log.info("Starting table printing");
		String hd = gdt.getRowData(locator.getProperty("loc.table"), 2);
		System.out.println(hd);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
