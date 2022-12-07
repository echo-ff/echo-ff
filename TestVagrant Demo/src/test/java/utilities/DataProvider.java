package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataProvider {
	
	// creating Object
	
	Properties pro;                 
	File src;
	
	/*
	 * Purpose : To fetch data from properties file i.e. the URLs
	 */
	
	public DataProvider(String propertyFilePath) { 
		
		// Constructor

		src = new File(propertyFilePath);
		try {
			FileInputStream fis = new FileInputStream(src);

			pro=new Properties();
			pro.load(fis);
			fis.close();
		}

		catch (Exception e) {

			System.out.println("Not able to load Property File >> " + e.getMessage());
		}
	}
	
	// This method will return value corresponding to the key
	
	public String getDataFromPropertyFile(String keyToSearch) {      

		return pro.getProperty(keyToSearch);
	}


}
