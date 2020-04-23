package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a.signin");
	By menubar=By.cssSelector("div[class='logobar']");
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}

	public WebElement getNavigationBar() {
		// TODO Auto-generated method stub
		return driver.findElement(menubar);
	}

}
