package Factory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Factory.DataProviderFactory; 


public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.quit();

	}

}
