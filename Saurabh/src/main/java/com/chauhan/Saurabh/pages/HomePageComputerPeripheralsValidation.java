package com.chauhan.Saurabh.pages;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.chauhan.Saurabh.helpers.WebUtility;

/**
 * Class validates the pricing of the products displayed
 */
public class HomePageComputerPeripheralsValidation {

	/**
	 * Method is used to validate the scenario of pricing validation and compare it
	 * is in the range of the price slider range
	 */
	public void validatePrice(Properties locator) {
		ArrayList<WebElement> prices = (ArrayList<WebElement>) WebUtility
				.getElementsList(locator.getProperty("loc.getPrices.products"));
		int values = prices.size();

		System.out.println("Values=" + values);
		String priceRange = WebUtility.getText(locator.getProperty("loc.slider.priceRange"));
		System.out.println("Price range=" + priceRange);
		String[] priceValues = priceRange.split("-");
		System.out.println("priceValues are" + priceValues[0] + "  " + priceValues[1]);
		String minimumPrice = priceValues[0].replace("$", "");
		System.out.println("minimum price " + minimumPrice);
		String maximumPrice = priceValues[1].replace("$", "");
		System.out.println("Maximum price " + maximumPrice);

		for (WebElement prices1 : prices) {
			System.out.println(prices1.getText());
			String productPrice = prices1.getText();
			System.out.println("product price=" + productPrice);
			String productPriceValidate = productPrice.replace("$", "");
			System.out.println("Product price validate" + productPriceValidate);
			System.out.println(Float.parseFloat(minimumPrice));
			System.out.println(Float.parseFloat(productPriceValidate));
			System.out.println(Float.parseFloat(maximumPrice));

			Assert.assertTrue(
					Float.parseFloat(minimumPrice) <= Float.parseFloat(productPriceValidate)
							&& Float.parseFloat(productPriceValidate) <= Float.parseFloat(maximumPrice),
					"Price range slider sorting is not correct");
		}
	}
}
