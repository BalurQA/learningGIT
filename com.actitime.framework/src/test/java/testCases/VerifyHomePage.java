package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("ie");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
	}

	@Test
	public void testHomePage() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String homePageTitle = home.getApplicationTitle();
		System.out.println("Home page title is -- " + homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Demo Store"));
		//Assert.assertEquals("Avactis Demo Store", homePageTitle);
	
	}
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
