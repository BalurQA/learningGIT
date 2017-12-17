package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out
					.println("Exception occured in ConfigDataProvider method "
							+ e.getMessage());
		}
	}

	public String getApplicationURL() {
		String appUrl = prop.getProperty("url");
		return appUrl;
	}
	public String getApplicationUactiTimeURL() {
		String appUrl = prop.getProperty("actiTimeurl");
		return appUrl;
	}

	public String getChromePath() {
		String chromeBroswer = prop.getProperty("chromePath");
		return chromeBroswer;
	}

	public String getIEPath() {
		String ieBroswer = prop.getProperty("IEPath");
		return ieBroswer;
	}

}
