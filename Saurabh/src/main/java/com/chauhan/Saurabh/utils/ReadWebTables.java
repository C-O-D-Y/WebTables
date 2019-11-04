package com.chauhan.Saurabh.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chauhan.Saurabh.helpers.WebUtility;

/**
 * Class reads the web tables according to various parameters
 */

public class ReadWebTables {
	WebDriver driver;
	WebUtility utils = new WebUtility();
	List<WebElement> tableRow;
	List<WebElement> tableColumn;
	List<Integer> colnum;
	String cellData = null;

	public ReadWebTables(WebDriver driver) {
		this.driver = driver;
	}

	// getting row count of the web table
	/**
	 * returns row count of the web table
	 * 
	 * @param web table locator
	 * @return row count
	 */
	public int getRowCount(String tableLocator) {

		tableRow = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		return tableRow.size();
	}

	/**
	 * returns column count of the web table respective of row number
	 * 
	 * @param web table locator,row number
	 * @return column count
	 */

	public int getColumnCount(String tableLocator, int rowNum) {
		int rowCount = getRowCount(tableLocator);
		System.out.println(rowCount);
		if (rowCount < rowNum)
			return 0;
		else {
			tableColumn = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody"))
					.findElements(By.tagName("tr")).get(rowNum).findElements(By.tagName("td"));

			return tableColumn.size();
		}
	}

	/**
	 * returns cell data of the web table respective of given column and row number
	 * 
	 * @param web table locator,row number, column number
	 * @return cell data
	 */

	public String getCellDataByColumnAndRowNumber(String tableLocator, int rowNumber, int columnnumber) {

		for (int index = 0; index < getRowCount(tableLocator); index++) {
			cellData = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody"))
					.findElements(By.tagName("tr")).get(rowNumber - 1).findElements(By.tagName("td"))
					.get(columnnumber - 1).getText();
		}
		return cellData;
	}

	/**
	 * returns position of the cell data in form of column and row number
	 * 
	 * @param web table locator,cell data
	 * @return column number and row number of the given data
	 */

	public String getPositionOfData(String tableLocator, String cellData) {

		int rowIndex = getRowCount(tableLocator);
		for (int index = 0; index < rowIndex; index++) {
			int columnIndex = getColumnCount(tableLocator, index);
			for (int colIndex = 0; colIndex < columnIndex; colIndex++) {
				String ActualcellData = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr")).get(index).findElements(By.tagName("td")).get(colIndex)
						.getText();
				if (cellData.equals(ActualcellData)) {
					return "column Number is " + (colIndex + 1) + " and Row number is " + (index + 1);
				}
			}
		}
		return "No data found";
	}

	/**
	 * prints all the data of the web table
	 * 
	 * @param web table locator
	 */

	public void printTableData(String tableLocator) {

		int rowIndex = getRowCount(tableLocator);
		for (int index = 0; index < rowIndex; index++) {
			int columnIndex = getColumnCount(tableLocator, index);
			for (int colIndex = 0; colIndex < columnIndex; colIndex++) {
				cellData = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr")).get(index).findElements(By.tagName("td")).get(colIndex)
						.getText();
				System.out.print(cellData + "	 ");
			}
			System.out.println("");
		}
	}

	/**
	 * returns row data of the given respective row number
	 * 
	 * @param web table locator,row number
	 * @return row data
	 */

	public String getRowData(String tableLocator, int rowNumber) {
		try {
			int columnIndex = getColumnCount(tableLocator, rowNumber - 1);
			for (int colIndex = 0; colIndex < columnIndex; colIndex++) {
				cellData = WebUtility.getElement(tableLocator).findElement(By.tagName("tbody"))
						.findElements(By.tagName("tr")).get(rowNumber - 1).findElements(By.tagName("td")).get(colIndex)
						.getText();

			}

		} catch (NullPointerException npl) {
			System.out.println("No data found ");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("row number is out of range  ");
		}
		return cellData;
	}
}
