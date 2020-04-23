package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	By uid=By.cssSelector("input[name='login']");
	By pwd=By.cssSelector("input[name='passwd']");
	By signinbutton=By.cssSelector("input.signinbtn");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getUserid()
	{
		return driver.findElement(uid);
	}
	
	public WebElement getPwd()
	{
		return driver.findElement(pwd);
	}

	public WebElement getSigniN()
	{
		return driver.findElement(signinbutton);
	}
}
