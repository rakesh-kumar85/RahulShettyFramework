package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public String browserName;

	public WebDriver initializedDriver() {

		if (!(System.getProperty("propertyName").isEmpty())) {
			browserName = System.getProperty("propertyName");
			System.out.println("Using Browser" + browserName);
		}
		else {

			try {
				prop = new Properties();
				FileInputStream fp = new FileInputStream(
						"C:\\Users\\rakeshkumar.brindlal\\PracETE\\src\\main\\java\\resources\\data.properties");
				prop.load(fp);
				browserName = prop.getProperty("browser");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./Drivers\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			return driver;
		}
		
	}

