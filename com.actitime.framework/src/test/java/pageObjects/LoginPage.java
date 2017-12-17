package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(id="account_sign_in_form_email_id") WebElement userEmailID;
	@FindBy(id="account_sign_in_form_passwd_id") WebElement userPassword;
	@FindBy(xpath="//input[@value='Sign In']") WebElement buttonSignIn;
//	@FindBy(xpath="//div[@class='pre-header']//a[text()='Sign Out']")WebElement signOutLink;
	By signOutLink = By.xpath("//div[@class='pre-header']//a[text()='Sign Out']");
	
	public void loginPage(String userName,String userPwd){
		userEmailID.sendKeys(userName);
		userPassword.sendKeys(userPwd);
		buttonSignIn.click();
		
	}
	
	public boolean verifySignIn(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated((signOutLink)));
		//String signOutText = ele.getText();
		//Assert.assertEquals(signOutText, "Sign Out");
		 boolean signStatus = ((WebElement) signOutLink).isDisplayed();
		 return signStatus;
	}

}
