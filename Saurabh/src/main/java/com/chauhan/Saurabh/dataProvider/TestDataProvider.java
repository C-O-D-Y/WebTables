package com.chauhan.Saurabh.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.constants.FilePath;
import com.chauhan.Saurabh.utils.ProvideExcelData;

/**
 * In this class, data is given from the dataprovider
 */
public class TestDataProvider {

	

	/**
	 * In this method, getting the data of the category, product and name of the
	 * product into object array and returning to the calling method
	 */

	@DataProvider(name = "rightCategory")
	public Object[][] getHeader() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the data inside the header(SERVICES) into object
	 * array and returning to the calling method
	 */
	@DataProvider(name = "wrongCategory")
	public Object[][] getOption1() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the data inside the header(SERVICES) into object
	 * array and returning to the calling method
	 */
	@DataProvider(name = "wrongProduct")
	public Object[][] getProduct() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the data inside the header(SERVICES) into object
	 * array and returning to the calling method
	 */
	@DataProvider(name = "rightProduct")
	public Object[][] getProduct1() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 3);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, getting the pricing for sorting the products and saving it
	 * into array and returning to the calling method
	 */
	@DataProvider(name = "pricing")
	public Object[][] getPricing() {
		ProvideExcelData provideData = new ProvideExcelData(FilePath.TESTDATA_FILE, 4);
		Object[][] getData = provideData.provideExcelData();
		return getData;
	}

	/**
	 * In this method, calling the method to check the data
	 */
	@Test(priority = 2, dataProvider = "category", dataProviderClass = TestDataProvider.class)
	public void validatefooter(String footer, String footer1, String dh) {
		System.out.println(footer);
		System.out.println(footer1);
		System.out.println(dh);
	}
}