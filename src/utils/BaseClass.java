package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	// BaseClass will have the SetUP() and the TearDown() methods

	public static WebDriver driver; // this variable is being declare as a class level because
	// we need to initialize from setUp();
	// and we need to close the variable from tearDown();

	public static void setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		// System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Browser not suported!! ");
			break;
		}

		driver.manage().window().maximize();
		String url = ConfigsReader.getProperty("url");
		driver.get(url);

	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
