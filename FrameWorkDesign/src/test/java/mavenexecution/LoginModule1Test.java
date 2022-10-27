package mavenexecution;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.initilastion;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePageModule;
import objectRepository.LoginpageModule;


public class LoginModule1Test extends initilastion{
		
	String url;
	WebDriver driver;
	
	
	@BeforeClass
	public void initisations() throws IOException
	{
		driver=BrowserInitialisation();
	    url =proper.getProperty("url");
	    driver.get(url);
	}
	
	@Test(groups= "smoke")
		public void Succesfullogin () throws IOException {
		/*
	    WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.tsrtconline.in/oprs-web/");
		
		*/
	//	driver.findElement(By.linkText("eTicket Login")).click();
		
		
		
	     driver.get("https://www.tsrtconline.in/oprs-web/");
					
		 HomePageModule hp =new HomePageModule(driver);
		 hp.Eticketlogin().click();
		 
		 LoginpageModule lp = new LoginpageModule(driver);                  //third
		 lp.Login("hema345", "Lovely");
		
		 
	/*	 lp.username().sendKeys("hema");                                      //second
		 lp.password().sendKeys("lovely");
		 lp.submitBtn().click();
		 */
		 
		//driver.findElement(By.id("userName")).sendKeys("hema");
		//driver.findElement(By.i"d("password")).sendKeys("lovely");             //first
		//driver.findElement(By.id("submitBtn")).click();

		 //Taking Screenshot//
		//Getscreenshot(driver,"Succesfullogin");
		
		 String exptErrormsg ="Login incorrect. Please try again";
		
		 String actualerrormsg =lp.ErrorMsg().getText();
		 
		 Assert.assertEquals(actualerrormsg, exptErrormsg );
		
	}
	
	
		

	@Test
	public void forgetpassword() throws IOException
	{ 
   driver.get("https://www.tsrtconline.in/oprs-web/");

	HomePageModule hp =new HomePageModule(driver);
	 hp.Eticketlogin().click();
	 //taking screenshot//
	// Getscreenshot(driver ,"forgetpassword");
	 LoginpageModule lp = new LoginpageModule(driver);
	 lp.ForgotPassword().click();
	 driver.findElement(By.id("userName")).sendKeys("ghjklmnbv");
	 driver.findElement(By.id("submitBtn")).click();

	}
	
}
