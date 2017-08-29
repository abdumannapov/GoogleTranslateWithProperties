package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver getDriver(){
		WebDriver driver=null;
		if(driver==null){
		switch(Config.getProperty("browser")){
		case "chrome":
			System.setProperty(Config.getProperty("drivertype"),
					Config.getProperty("driverpath"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/jabdu/OneDrive/Documents/Libraries/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver",
					"C:/Users/jabdu/OneDrive/Documents/Libraries/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		}
		return driver;
	}
	
}
