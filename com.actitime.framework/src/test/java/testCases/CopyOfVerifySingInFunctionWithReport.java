package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class CopyOfVerifySingInFunctionWithReport {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		report = new ExtentReports(".\\Reports\\LoginTest.html", false);
		// logger = report.startTest("Verify login test");
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		// logger.log(LogStatus.PASS, "Browser launched successfully");
	}

	@Test
	public void testLogin() {
		try {
			logger = report.startTest("VerifySingInFunctionWithReport.java");
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			String homePageTitle = home.getApplicationTitle();
			System.out.println("Home page title is -- " + homePageTitle);
			Assert.assertTrue(homePageTitle.contains("Demo Store"));
			logger.log(LogStatus.PASS, "Login Page displayed successfully");
			home.clickOnSingInLink();
			LoginPage obj_loginPage = PageFactory.initElements(driver,
					LoginPage.class);
			obj_loginPage.loginPage(
					DataProviderFactory.getExcel().getData(0, 0, 0),
					DataProviderFactory.getExcel().getData(0, 0, 1));
			// obj_loginPage.loginPage("sangamesh19@gmail.com", "sam@123");
			boolean signInStatus = obj_loginPage.verifySignIn();
			// System.out.println("Sign out link found -> "+signInStatus);
			Assert.assertTrue(signInStatus);
			logger.log(LogStatus.PASS,
					"Application logged in successfully with given credentials");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FAIL,
					"Application failed to login successfully with given credentials");
		}

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
