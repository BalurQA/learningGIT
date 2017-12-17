package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyHomePageWithReports {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
		
	@BeforeMethod
	public void setUp(){
		report = new ExtentReports(".\\Reports\\HomePageReport.html",false);
		//logger = new ExtentTest("Home page verification", "Verification of home an element in home page");
		driver = BrowserFactory.getBrowser("ie");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		//logger.log(LogStatus.INFO, "Launching Application");
	}

	@Test
	public void testHomePage() {
		logger = report.startTest("Verify Home Page Test - Method");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String homePageTitle = home.getApplicationTitle();
		System.out.println("Home page title is -- " + homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Demo Store"));
		logger.log(LogStatus.PASS, "Home page displayed successfully");
		//Assert.assertEquals("Avactis Demo Store", homePageTitle);
	
	}
	@Test
	public void testHomePage1() {
		logger = report.startTest("Verify Home Page Test 2");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String homePageTitle = home.getApplicationTitle();
		System.out.println("Home page title is -- " + homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Demo Store"));
		logger.log(LogStatus.PASS, "Home page displayed successfully");
		//Assert.assertEquals("Avactis Demo Store", homePageTitle);
	
	}
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
