package Academy;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	
	@BeforeTest
	public void initializedriverBrowser()
	{
		driver=initializedDriver();
		//driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		//String URL=prop.getProperty("url");
		//driver.get(prop.getProperty("url"));
		driver.get(System.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String uid, String pwd) {
		
		LandingPage ld=new LandingPage(driver);
		WebElement ele=ld.getLogin();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		LoginPage log=new LoginPage(driver);
		log.getUserid().sendKeys(uid);
		log.getPwd().sendKeys(pwd);
		WebElement signbutton=log.getSigniN();
		executor.executeScript("arguments[0].click();", signbutton);
		System.out.println(" Test  Naviagte Home Page completed");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="rakesh.kumar@rediff.com";
		data[0][1]="12345";
		return data;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}

}
