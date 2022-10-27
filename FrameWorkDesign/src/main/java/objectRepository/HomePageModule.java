package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageModule {
//		driver.findElement(By.linkText("eTicket LOgin")).click();

	 WebDriver driver;
	 
	By eticketlgn = By.linkText("eTicket Login");
	By otplogin = By.linkText("ATB/OPR Login");
	
	
	public HomePageModule(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	public WebElement Eticketlogin()
	{
	return driver.findElement(eticketlgn);
	
	}

	
	public WebElement OTPlogin(){
		{
			return driver.findElement(otplogin);
		}
	}
}
