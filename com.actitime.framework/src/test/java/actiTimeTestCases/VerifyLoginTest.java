package actiTimeTestCases;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ConfigDataProvider;
import pageObjects.ActiTimeLoginPage;
import utility.Helper;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginTest {
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
	public void loginTest() throws Exception {
		logger = report.startTest("loginTest");

		ActiTimeLoginPage actiTime = PageFactory.initElements(driver,
				ActiTimeLoginPage.class);
		// String title_HomePage = actiTime.getApplicationTitle();
		// System.out.println("Home Page title " + title_HomePage);
		// if (title_HomePage.contains("actiTIME - Login")) {
		// logger.log(LogStatus.INFO, title_HomePage + " contain "
		// + "actiTIME - Login");
		// } else {
		// logger.log(LogStatus.FAIL, title_HomePage + " doesn't contain "
		// + "actiTIME - Login");
		// }
		// Assert.assertEquals("actiTIME - Login", title_HomePage);

		// actiTime.loginTest("admin", "manager");
		actiTime.loginTest(
				DataProviderFactory.getExcel().getData("actiTimeLogin", 0, 0),
				DataProviderFactory.getExcel().getData("actiTimeLogin", 0, 1));
		// boolean signStatus = actiTime.verifyLogin();
		// System.out.println("SignStatus value is ->"+signStatus);
		Thread.sleep(3000);
		 WebElement signStatus = driver.findElement(By.id("logoutLink"));
		 if (signStatus.isDisplayed()) {
		 logger.log(LogStatus.PASS,
		 "Logout link displayed, actiTime login is successful");
		 } else {
		 logger.log(LogStatus.FAIL,
		 "Logout link not displayed, actiTime login is not successful");
		 }
		 String adminLogin = actiTime.getApplicationTitle();
		// System.out.println("Page Title after login ->" + adminLogin);
		// if (adminLogin.contains("actiTIME - Enter Time-Track")) {
		// logger.log(LogStatus.PASS, adminLogin + " contain "
		// + "actiTIME - Enter Time-Track");
		// } else {
		// logger.log(LogStatus.FAIL, adminLogin + " doesn't contain "
		// + "actiTIME - Enter Time-Track");
		// }
		Assert.assertEquals("actiTIME - Enter Time-Track", adminLogin);
	}

	@AfterMethod
	public void tearDown() {
		report.endTest(logger);
		report.flush();
		report.close();
		BrowserFactory.closeBrowser(driver);
	}
}
