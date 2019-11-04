package com.chauhan.Saurabh.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.chauhan.Saurabh.helpers.WebUtility;



public class HeroImageProductValidation {
	
	static int index = 1;

	/**
	 * Method use to get the content of the product description by conditional
	 * description of the hero image
	 */
	public void validateDescriptionContent(Properties locator, Properties validate) {
		String productName1 = WebUtility.getText(locator.getProperty("loc.text.heroImageProductName"));
		if (productName1.equalsIgnoreCase(validate.getProperty("productName1"))) {
			String content = WebUtility.getText(locator.getProperty("loc.text.productDescription"));
			Assert.assertTrue(content.contains(validate.getProperty("product_description1")),
					"Product description is wrong");
			System.out.println("Product description is right");
		}
		String productName2 = WebUtility.getText(locator.getProperty("loc.text.heroImageProductName"));
		if (productName2.equalsIgnoreCase(validate.getProperty("productName2"))) {
			String content = WebUtility.getText(locator.getProperty("loc.text.productDescription"));
			Assert.assertTrue(content.contains(validate.getProperty("product_description2")),
					"Product description is wrong");
			System.out.println("Product description is right");
		}
	}

	/**
	 * Method use to get the content of the product specification
	 */
	public void validateSpecificationContent(Properties locator, Properties validate) {
		String content = WebUtility.getText(locator.getProperty("loc.text.productSpecification"));
		Assert.assertTrue(content.contains(validate.getProperty("product_specification")),
				"Product specification is wrong");
		System.out.println("Product specification is right");
	}

	/**
	 * Method use to get the date of the reviews to validate the sorting
	 * functionality with date
	 */

	public void validateDate(int select,Properties locator, Properties validate) {
		List<WebElement> elements = WebUtility.getElementsList(locator.getProperty("loc.reviews.details.count"));
		// getting blog date from the web

		int loopCount = elements.size();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		while (index < loopCount) {
			String string = WebUtility.getText(locator.getProperty("loc.date.sort").replace("index", index + ""));
			String split[] = string.split(" ", 2);
			System.out.println("split 1" + split[1].substring(1, 2));
			if (split[1].substring(1, 2).equals(" ")) {
				split[1] = "0" + split[1];
			}
			LocalDate localDate = LocalDate.parse(split[1], formatter);

			String string1 = WebUtility
					.getText(locator.getProperty("loc.date.sort").replace("index", (index + 1) + ""));
			String split1[] = string1.split(" ", 2);
			System.out.println(split1[1]);

			System.out.println("split 1" + split1[1].substring(1, 2));
			if (split1[1].substring(1, 2).equals(" ")) {
				split1[1] = "0" + split1[1];
			}
			System.out.println(split1[1]);

			LocalDate localDate1 = LocalDate.parse(split1[1], formatter);
			int difference = localDate.compareTo(localDate1);
			if (select == 1) {
				Assert.assertTrue(difference >= 0);
			}
			if (select == 2) {
				Assert.assertTrue(difference <= 0);
			}
			index++;
		}
	}

	/**
	 * Method use to validate the star rating sorting functionality
	 */
	public void validateStarRating(int sortOrder,Properties locator, Properties validate) {
		List<WebElement> elements = WebUtility.getElementsList(locator.getProperty("loc.reviews.details.count"));
		int loopCount = elements.size();
		while (index < loopCount) {
			int count1 = WebUtility
					.getElementsList(locator.getProperty("loc.starrating.sort").replace("index", index + "")).size();
			int count2 = WebUtility
					.getElementsList(locator.getProperty("loc.starrating.sort").replace("index", (index + 1) + ""))
					.size();
			int difference = count1 - count2;

			if (sortOrder == 3) {
				Assert.assertTrue(difference >= 0);
			}
			if (sortOrder == 4) {
				Assert.assertTrue(difference <= 0);
			}
		}
	}
}
