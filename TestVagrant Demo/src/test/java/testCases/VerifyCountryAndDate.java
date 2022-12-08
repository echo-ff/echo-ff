package testCases;

import static org.testng.Assert.assertThrows;

import java.security.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseClass.BaseClass;
import testPages.IMDB;
import testPages.Wiki;


public class VerifyCountryAndDate extends BaseClass{
	
	/*
	 * Declaring Extent Report
	 * To Access: After Running The Test Suite, Open the "Test_Report.html" 
	 * inside Reports Folder
	 */
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/Reports.html");
	
	/*
	 * Setting Up Test Report
	 */
	@BeforeTest
	public void setupTest() {
		extent.attachReporter(spark);
	}
	
	/*
	 * Test 1: To Verify The Date of Release
	 */
	@Test (priority = 1)
	public void VerifyDateOfRelease() {
		Reporter.log("Test 01 Started", true);

		/*
		 * This Test Verifies if the Date present on both Sites is same
		 * Pass Criteria: Date should be same on both Sites
		 * Fail Criteria : If Dates are not Matching
		 */
		
		ExtentTest Test_01 = extent.createTest("Test 1: To Verify Release Date");
		Test_01.assignCategory("Date");
		Test_01.info("This test is to compare the Release date of Movie on Wiki and IMDB Page");
		
		String wikiDate = "";
		String imdbDate = "";
		Wiki wikipage = PageFactory.initElements(driver, Wiki.class);
		IMDB imdbpage = PageFactory.initElements(driver, IMDB.class);
		Assertion Assert = new Assertion();
		
		//Step 1: Open Wikipedia Page
		wikipage.openWikiPage();
		
		//Assert if Correct Page is Opened i.e. Wiki Page of Pushpa
		if(driver.getTitle().contains("Pushpa")) {
			Assert.assertTrue(true, "Opened Expected Page" );
			Test_01.pass("Expected Page Opened || URL : " + driver.getCurrentUrl());
			
		}
		else {
			Assert.assertTrue(false, "Expected Page Not Opened");
			Test_01.fail("Expected Page Not Opened. || URL : " + driver.getCurrentUrl());
		}
		
		//Get Date from Wiki and Assert
		wikiDate = wikipage.getwikiDate().replaceAll("[^\\p{ASCII}]|&nbsp;| ", " ");
		if (wikiDate.isEmpty() == false) {
			Test_01.pass("Fetched Date from Wikipedia Page "+ wikiDate);
		}
		else {
			Assert.assertTrue(false, "Date Not Found");
			Test_01.fail("Expected Date Not Found on Wiki");
		}
		
		
		//Step 2: Open IMDB Page
		imdbpage.openIMDBPage();
		
		Helper.waitTillElmentVisible(driver, imdbpage.imdb_releasedate_button);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", imdbpage.imdb_releasedate_button );
		
		//Assert if Correct Page is Opened i.e. IMDB of Pushpa
		if(driver.getTitle().contains("Pushpa")) {
			Assert.assertTrue(true, "Opened Expected Page" );
			Test_01.pass("Expected Page Opened || URL : " + driver.getCurrentUrl());
		}
		else {
			Assert.assertTrue(false, "Expected Page Not Opened");
			Test_01.fail("Expected Page Not Opened. || URL : " + driver.getCurrentUrl());
		}
		
		//Get Date
		imdbDate = imdbpage.getimdbDate().replaceAll("[^\\p{ASCII}]|&nbsp;| ", " ");
		if (imdbDate.isEmpty() == false) {
			Test_01.pass("Fetched Date from IMDB Page "+ imdbDate);
		}
		else {
			Assert.assertTrue(false, "Date Not Found");
			Test_01.fail("Expected Date Not Found on IMDB Page");
		}
		
		//Compare Both Dates
		
		if(wikiDate.contentEquals(imdbDate)) {
			Test_01.pass("Release Date on Both Pages is same");
		}
		else {
			Test_01.fail("Release Date is not Matching");
		}
		Reporter.log("Test 01 Ended", true);
		
	}
	
	@Test (priority = 2)
	public void VerifyCountryOfRelease() {
		Reporter.log("Test 02 Started", true);

		/*
		 * This Test Verifies if Country present on both Sites is same
		 * Pass Criteria: Country should be same on both Sites
		 * Fail Criteria : If Country is not Matching
		 */
		
		ExtentTest Test_02 = extent.createTest("Test 2: To Verify Country of Release");
		Test_02.assignCategory("Country");
		Test_02.info("This test is to compare Country of Release of Movie on Wiki and IMDB Page");
	
		String wikiCountry = "";
		String imdbCountry = "";
		Wiki wikipage = PageFactory.initElements(driver, Wiki.class);
		IMDB imdbpage = PageFactory.initElements(driver, IMDB.class);
		Assertion Assert = new Assertion();
		
		//Step 1: Open Wikipedia Page
		wikipage.openWikiPage();
		
		//Assert if Correct Page is Opened i.e. Wiki Page of Pushpa
		if(driver.getTitle().contains("Pushpa")) {
			Assert.assertTrue(true, "Opened Expected Page" );
			Test_02.pass("Expected Page Opened || URL : " + driver.getCurrentUrl());
			
		}
		else {
			Assert.assertTrue(false, "Expected Page Not Opened");
			Test_02.fail("Expected Page Not Opened. || URL : " + driver.getCurrentUrl());
		}
		
		//Get Country from Wiki and Assert
		wikiCountry = wikipage.getWikiCountry();
		if (wikiCountry.isEmpty() == false) {
			Test_02.pass("Fetched Country from Wikipedia Page : "+ wikiCountry);
		}
		else {
			Assert.assertTrue(false, "Country Not Found");
			Test_02.fail("Expected Country Not Found on Wiki");
		}
		
		
		//Step 2: Open IMDB Page
		imdbpage.openIMDBPage();
		
		//Assert if Correct Page is Opened i.e. IMDB of Pushpa
		if(driver.getTitle().contains("Pushpa")) {
			Assert.assertTrue(true, "Opened Expected Page" );
			Test_02.pass("Expected Page Opened || URL : " + driver.getCurrentUrl());
		}
		else {
			Assert.assertTrue(false, "Expected Page Not Opened");
			Test_02.fail("Expected Page Not Opened. || Current URL : " + driver.getCurrentUrl());
		}
		
		//Get Country From IMDB Page
		imdbCountry = imdbpage.getimdbCountry();
		if (imdbCountry.isEmpty() == false) {
			Test_02.pass("Fetched Country from IMDB Page is : "+ imdbCountry);
		}
		else {
			Assert.assertTrue(false, "Date Not Found");
			Test_02.fail("Expected Country Not Found on IMDB Page");
		}
		
		//Compare Both Countries
		
		if(wikiCountry.contentEquals(imdbCountry)) {
			Test_02.pass("Countries on Both Pages is same");
		}
		else {
			Test_02.fail("Countries on both pages is not Matching");
		}
		Reporter.log("Test 02 Ended", true);	
		
	}
	

	
	@AfterTest
	public void tearDownTest() {
		extent.flush();
	}

}
