package utility;

import java.io.File;
//import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class Helper {

	public static String captureScreenShot(WebDriver driver,
			String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = ".\\Screenshots" + System.currentTimeMillis()
				+ ".png";

		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture screeenshot "
					+ e.getMessage());
		}
		return destination;
	}

	public static ExtentReports Instance() {
		ExtentReports extent;
		String Path = "./Reports/ExtentReport.html";
		System.out.println(Path);
		extent = new ExtentReports(Path, false);
		extent.config().documentTitle("Automation Report").reportName("Regression");
		extent.config().documentTitle("Automation Report")
				.reportName("Regression");

		return extent;
	}
}
