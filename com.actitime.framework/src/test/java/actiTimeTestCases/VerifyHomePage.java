package actiTimeTestCases;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import pageObjects.ActiTimeLoginPage;
import utility.Helper;

public class VerifyHomePage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		report = Helper.Instance();
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUactiTimeURL());
	}

	@Test
	public void HomePageVerification() {
		logger = report.startTest("Home_Page_Verification");
		ActiTimeLoginPage actiTime = PageFactory.initElements(driver,
				ActiTimeLoginPage.class);
		String title_HomePage = actiTime.getApplicationTitle();
		System.out.println("Home Page title "+title_HomePage);
		if (title_HomePage.contains("actiTIME - Login")) {
			logger.log(LogStatus.PASS, title_HomePage + " contain "
					+ "actiTIME - Login");
		} else {
			logger.log(LogStatus.FAIL, title_HomePage + " doesn't contain "
					+ "actiTIME - Login");
		}
		Assert.assertEquals("actiTIME - Login", title_HomePage);
	}

	@AfterMethod
	public void tearDown() {
		report.endTest(logger);
		report.flush();
		report.close();
		BrowserFactory.closeBrowser(driver);
	}
}
