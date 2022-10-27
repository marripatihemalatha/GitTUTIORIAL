package mavenexecution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.initilastion;
import objectRepository.HomePageModule;
import objectRepository.LoginpageModule;
import objectRepository.RegestrationPageModule;

public class RegistrationModuleTest extends initilastion {

	
@BeforeClass
public void BrowserInitilisation() throws IOException
	{	
		driver = BrowserInitialisation();
		String url = proper.getProperty("url");
		driver.get(url);
		
	}
@Test
	public void validateloginNameField() {
		HomePageModule hp =new HomePageModule(driver);
		hp.Eticketlogin().click();
		LoginpageModule lp = new LoginpageModule(driver);
		lp.SignUp().click();
		RegestrationPageModule rp = new RegestrationPageModule(driver);
		rp.loginName().sendKeys("hemalatha");
		rp.fullName().sendKeys("hemalathaa");
		rp.email().sendKeys("marripatihemalatha666@gmail.com");
		rp.SelectGender("FEMALE");
		rp.mobileNo().sendKeys("87878787878");
		rp.SaveBtn().click();
	}

}
