package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import baseClass.BaseClass;
import utilities.Helper;

public class Wiki extends BaseClass{
	
	WebDriver driver;
	
	//Below constructor is used to pass the driver.
	
	public Wiki(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	//Below are the Element Locators on Wikipedia Page
	
	//Wikipedia - Release Date Locator
	@FindBy(xpath="//table[@class='infobox vevent']//tr[12]//td")
	@CacheLookup
	public WebElement wiki_releasedate;
	
	//Wikipedia - Country Locator
	@FindBy(xpath = "//table[@class='infobox vevent']//tr[14]//td")
	@CacheLookup
	public WebElement wiki_country;
	
	/*
	 * Below are the methods to perform tasks on Wikipedia Page
	 */
	
	//This method would Open Wikipedia Page of Pusha
	public void openWikiPage() {
		driver.manage().deleteAllCookies();
		/*
		 * I'm getting the url which I have stored in pageURLs.properties file
		 * using "getDataFromPropertyFile" method which is Declared in "DataProvider.java"
		 * class (inside utilities Package
		 */
		driver.get(Config.getDataFromPropertyFile("wikiURL"));
		
		/*
		 * Waiting for Page to load || "waitForPageLoadTime" method is declared in
		 * Helper.java class
		 */
		Helper.WaitForPageLoadTime(driver);
	}
	
	public String getwikiDate() {

		/*
		 * Waiting for Element to Visible || "waitTillElmentVisible" method is declared in
		 * Helper.java class
		 */
		Helper.waitTillElmentVisible(driver, wiki_releasedate);
		
		/*
		 * "getElementText" returns text of the element || Declared in Helper.java class
		 */
		return Helper.getElementText(wiki_releasedate);
	}
	
	public String getWikiCountry() {
		Helper.waitTillElmentVisible(driver, wiki_country);
		return Helper.getElementText(wiki_country);
	}
}
