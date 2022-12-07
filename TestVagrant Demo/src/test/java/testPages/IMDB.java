package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import baseClass.BaseClass;
import utilities.Helper;

public class IMDB extends BaseClass {
	WebDriver driver;
	
	//Below constructor is used to pass the driver.
	
	public IMDB(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	//Below are the Element Locators on IMDB Page
	
	//IMDB - Release Date Button (All Countries)
	@FindBy(xpath="//li[@data-testid='title-details-releasedate']//div//a[@role='button']")
	@CacheLookup
	public WebElement imdb_releasedate_button;
	
	@FindBy(xpath = "(//td[@class='release-date-item__date'])[6]")
	@CacheLookup
	public WebElement imdb_releasedate;
	
	//IMDB - Country
	@FindBy(xpath = "//li[@data-testid='title-details-origin']//a[@role='button']")
	@CacheLookup
	public WebElement imdb_country;
	
	/*
	 * Below are the methods to perform tasks on IMDB Page
	 */
	
	//This method would Open IMDB Page of Pusha
	public void openIMDBPage() {
		driver.manage().deleteAllCookies();
		
		/*
		 * I'm getting the url which I have stored in pageURLs.properties file
		 * using "getDataFromPropertyFile" method which is Declared in "DataProvider.java"
		 * class (inside utilities Package
		 */
		driver.get(Config.getDataFromPropertyFile("imdbURL"));
		
		/*
		 * Waiting for Page to load || "waitForPageLoadTime" method is declared in
		 * Helper.java class
		 */
		Helper.WaitForPageLoadTime(driver);
		
	}
	
	public String getimdbDate() {

		/*
		 * Waiting for Element to Visible || "waitTillElmentVisible" method is declared in
		 * Helper.java class
		 */
		Helper.waitTillElmentVisible(driver, imdb_releasedate);
		
		/*
		 * "getElementText" returns text of the element || Declared in Helper.java class
		 */
		return Helper.getElementText(imdb_releasedate);
	}
	
	public String getimdbCountry() {
		Helper.waitTillElmentVisible(driver, imdb_country);
		return Helper.getElementText(imdb_country);
	}

	

}
