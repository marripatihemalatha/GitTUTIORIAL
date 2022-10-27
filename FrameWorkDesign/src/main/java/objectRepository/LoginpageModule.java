package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageModule {

	
	public WebDriver driver;
	
	
	//by eticketlgn = by,linkText("eticketlogin");
	//driver.findelement(eticketlgn);
	
	
	
	@FindBy(id="userName")
	WebElement txtusrnameobj;
	
	
	@FindBy(id="password")
	WebElement txtpasswrdobj;
	
	@FindBy(id="submitBtn")
	WebElement btnloginobj;
	
	@FindBy(linkText="SignUp")
	WebElement linksinupobj;
	
	@FindBy(linkText="Forgot Password")
	WebElement frgtpwdobj;
	
	
	@FindBy(id="errorMsg")
	WebElement errormsgobj;
	
	
	public LoginpageModule(WebDriver driver) 
	{
	this.driver =driver;
	
	PageFactory.initElements(driver, this);
	}
	public WebElement username()
	{
		return txtusrnameobj;
	}
	public WebElement password()
	{
		return txtpasswrdobj;
	}
	
	public WebElement submitBtn()
	{
		return btnloginobj;
	}
	
	public WebElement SignUp()
	{
		return linksinupobj;
	}
	
	public WebElement ForgotPassword()
	{
		return frgtpwdobj;
	}
	
	public WebElement ErrorMsg()
	{
		return errormsgobj;
	}
	
		public void Login (String usrname,String pwd)

		{
			
			txtusrnameobj .sendKeys(usrname);
			txtpasswrdobj .sendKeys(pwd);
			btnloginobj.click();
		
		}
	
	
	
	
	
}
