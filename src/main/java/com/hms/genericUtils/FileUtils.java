package com.hms.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtils {
	/**
	 * read the data from the property file 
	 * @author Dev
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}
}
