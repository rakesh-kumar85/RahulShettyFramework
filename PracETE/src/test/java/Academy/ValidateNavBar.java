package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBar extends Base{
	 
	//public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
   
	public void initialize() throws IOException
	{
		
		driver=initializedDriver();
		//driver.get(prop.getProperty("url"));
		driver.get(System.getProperty("url"));
		/*try {
			Properties prop=new Properties();
			FileInputStream fp = new FileInputStream(
					"C:\\Users\\rakeshkumar.brindlal\\PracETE\\src\\main\\java\\resources\\data.properties");
			prop.load(fp);
			String URL = prop.getProperty("url");
			driver.get(prop.getProperty("https://mail.rediff.com"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		}
	@Test
		
		public void validateAppNavBar() throws IOException
		{

			//one is inheritance
			// creating object to that class and invoke methods of it
			LandingPage l=new LandingPage(driver);
		
			//compare the text from the browser with actual text.- Error..
		   Assert.assertTrue(l.getNavigationBar().isDisplayed());
		 //   log.info("Navigation Bar is displayed");
			 System.out.println(" Test  Naviagte valaidate Landing page menubar completed");
		 //   Assert.assertFalse(false);
			
		
			
			}
		
		@AfterTest
		public void teardown()
		{
			
			driver.close();
			driver=null;
			
		}

		

}
