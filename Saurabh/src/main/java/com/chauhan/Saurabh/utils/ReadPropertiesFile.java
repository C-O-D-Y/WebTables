package com.chauhan.Saurabh.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * The class loads the data of the property file and returns the value
 * associated with the key in the property file.
 * @author Saurabh Chauhan
 *
 */

public class ReadPropertiesFile {
	static Properties property;
	static File file;
	static FileReader reader;

	/**
	 * methods takes parameter as
	 * 
	 * @param filePath
	 * @return the propeties of the property file
	 * @throws IOException
	 */

	public static Properties loadProperty(String pathName)  {
		property = new Properties();
		file = new File(pathName);
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File path not found");
			e.printStackTrace();
		}
		try {
			property.load(reader);
		} catch (IOException e) {
			System.out.println("File not loaded successfully");
			e.printStackTrace();
		}
		return property;
	}
}
