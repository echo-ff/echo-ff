package baseClass;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.BrowserFactory;
import utilities.DataProvider;

public class BaseClass {
	public static DataProvider Config;
	public static WebDriver driver;
	
	
	
	//Read Data From Property File i.e. the URLs of the Page
	@BeforeSuite (alwaysRun = true)
	public void setupdatafiles() throws Exception {
		Config = new DataProvider("./DataProvider/pageURLs.properties");
		
		driver = BrowserFactory.setUpDriver(driver);
	}
	
	//Closes the Browser
	@AfterSuite (alwaysRun = true)
	public void teardown() throws Exception{
		BrowserFactory.CloseApplication(driver);
	}
	


}
