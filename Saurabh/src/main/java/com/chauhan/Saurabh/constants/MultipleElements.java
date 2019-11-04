package com.chauhan.Saurabh.constants;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.chauhan.Saurabh.helpers.WebUtility;
import com.chauhan.Saurabh.testBase.TestBase;

/*
 * Class used to get the multiple elements to check the elements structure and the text
 * */

public class MultipleElements extends TestBase {
	List<WebElement> webElements = new ArrayList<WebElement>();

	@Test
	public void getElements() throws FileNotFoundException {

		webElements = WebUtility.getElementsList("//p[@class='custom-autoTxt']");
		try {
			for (int initial = 0; initial < webElements.size(); initial++) {
				String elements = webElements.get(initial).getText();
				// String links = webElements.get(initial).getAttribute("class");
				System.out.println(elements);
			}
		} catch (NullPointerException e) {
			System.out.println("File contains no data");
		}
	}
}
