package com.chauhan.Saurabh.testBase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.extentReports.ExtentReport;
import com.chauhan.Saurabh.utils.ReadPropertiesFile;

/**
 * Class loads the web driver according to the config file
 */
public class TestBase extends ExtentReport {

	Properties baseClass;
	String url;
	String browser;
	int downloadFile;

	/**
	 * Method used to load the driver and redirect to the url present in the config
	 * file
	 * 
	 * @param configFilePath
	 */
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void intitailizeBrowser() throws IOException {
		BasicConfigurator.configure();
		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("URL");
		browser = baseClass.getProperty("browser");
		String[] brow = browser.split(",");

		for (String browserType : brow) {

			System.out.println("browser is " + browserType);

			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

				driver = new ChromeDriver();

			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.edge.driver", FilePath.IE_PATH);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			} else {
				System.out.println("Driver not found in the config file");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
	}
}