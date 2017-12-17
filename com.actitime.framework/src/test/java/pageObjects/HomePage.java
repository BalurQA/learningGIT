package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;

	}

	@FindBy(xpath = "//a[text()='Sign In']") WebElement homePage_signInLink;
	@FindBy(xpath = "//a[text()='Checkout']")WebElement homePage_CheckoutnLink;
	@FindBy(xpath = "//a[text()='My cart']")WebElement homePage_myCartLink;
	@FindBy(xpath = "//a[text()='My Account']")	WebElement homePage_myAccountLink;

	public void clickOnSingInLink() {
		homePage_signInLink.click();
	}

	public void clickOnCheckoutnLink() {
		homePage_CheckoutnLink.click();

	}

	public void clickOnmyCartLink() {
		homePage_myCartLink.click();

	}

	public void clickOnmyAccountLink() {
		homePage_myAccountLink.click();
	}
	public String getApplicationTitle(){
		return driver.getTitle();
	}
}
