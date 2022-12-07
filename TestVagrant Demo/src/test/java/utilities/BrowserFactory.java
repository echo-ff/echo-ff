package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	/*
	 * This Class contains methods for Setting up Webdriver and Closing Webdriver 
	 */
	
	//Opens the Browser
	public static WebDriver setUpDriver(WebDriver driver) {
		Reporter.log("Setting up WebDriver", true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Reporter.log("WebDriver Up and Running", true);
		return driver;
	}
	
	//Closes the Browser
	public static void CloseApplication(WebDriver driver) {
		Reporter.log("Closing Browser", true);
		driver.quit();


	}
}
