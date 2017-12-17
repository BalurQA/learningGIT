package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActiTimeLoginPage {
	WebDriver driver;

	public ActiTimeLoginPage(WebDriver ldriver) {
		this.driver = ldriver;

	}

	@FindBy(name = "username")
	WebElement loginUserName;
	@FindBy(name = "pwd")
	WebElement loginPassword;
	@FindBy(id = "loginButton")
	WebElement buttonLogin;
	@FindBy(id = "logoutLink")
	WebElement buttonLogOut;
//	By buttonLogOut = By.xpath("//a[@id='logoutLink']");
//	WebElement  buttonLogOut = (WebElement) By.xpath("//a[@id='logoutLink']");

	public void loginTest(String userName, String Password) {
		loginUserName.sendKeys(userName);
		loginPassword.sendKeys(Password);
		buttonLogin.click();
	}

	public boolean verifyLogin() {

		WebElement ele = (new WebDriverWait(driver, 30))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));
		String LogOutText = ele.getText();
//		Assert.assertEquals(LogOutText, "Logout");
		boolean signStatus = ((WebElement) buttonLogOut).isDisplayed();
		System.out.println("Logout link status >"+signStatus);
		return signStatus;

	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}
}
