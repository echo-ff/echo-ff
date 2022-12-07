package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import baseClass.BaseClass;

public class Helper extends BaseClass {
	
	/*
	 * This class contains some functions like waiting till element is Displayed,
	 * getting the text of the Web Element etc.
	 */
	
	// Wait Till Element is Visible
	public static void waitTillElmentVisible(WebDriver driver, WebElement element) {
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	//Wait till Page is loaded
	public static void WaitForPageLoadTime(WebDriver driver) {                     

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS); 
	}	
	
	
	
	// Returns the Element Text
	public static String getElementText(WebElement element) {
		return element.getText();
	}
	
	/*
	 * NOT USED IN DEMO : Could Have been Used if We wanted to Convert the Dates
	 * into Timestamp and then Compare
	 */
	
	//This method Converts String Date to TimeStamp
	public static Timestamp convertStringToTimestamp(String strDate, String formmate) {
	    try {
	      DateFormat formatter = new SimpleDateFormat(formmate);
	       // you can change format of date
	      Date date = formatter.parse(strDate);
	      Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Exception :" + e);
	      return null;
	    }
	  }
	
	

}
