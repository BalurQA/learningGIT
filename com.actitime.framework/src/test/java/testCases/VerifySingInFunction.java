package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifySingInFunction {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
	}

	@Test
	public void testLogin() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String homePageTitle = home.getApplicationTitle();
		System.out.println("Home page title is -- " + homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Demo Store"));
		home.clickOnSingInLink();
		
		LoginPage obj_loginPage = PageFactory.initElements(driver,
				LoginPage.class);
		
		obj_loginPage.loginPage(DataProviderFactory.getExcel().getData(0, 0,0), DataProviderFactory.getExcel().getData(0, 0, 1));
//		obj_loginPage.loginPage("sangamesh19@gmail.com", "sam@123");
//		boolean signInStatus =  obj_loginPage.verifySignIn();
//		System.out.println("Sign out link found -> "+signInStatus);
//		Assert.assertTrue(signInStatus);

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser(driver);
	}
}
