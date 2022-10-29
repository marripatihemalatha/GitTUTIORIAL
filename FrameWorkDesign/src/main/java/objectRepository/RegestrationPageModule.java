package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegestrationPageModule {
	//page factory
	@FindBy(id="loginName")
	WebElement txtLoginNameobj;
	
	@FindBy(id="fullName")
	WebElement txtfullNameobj;
	
	@FindBy(id="email")
	WebElement txtemailobj;

	@FindBy(name="SaveBtn")
	WebElement txtsavebtnobj;
	
	@FindBy(name="mobileNo")
	WebElement txtmobilenoobj;

	@FindBy(id="genderId")
	WebElement firstgenderobj;
	//date  objects
	
	@FindBy(id="txtDob")
	WebElement txtDateObj;
	
	@FindBy(className = "ui-datepicker-year")
	WebElement lstyearobj;
	
	@FindBy(className="ui-datepicker-month")
	WebElement lstmonthobj;
	
	
	 //td[@data-handler ='selectDay']/a
	
	@FindBy(xpath ="//td[@data-handler ='selectDay']/a")
	List<WebElement> daysobj;
	
	

	public WebDriver driver;

	public RegestrationPageModule(WebDriver driver) 
	{
	this.driver = driver;
	
	PageFactory.initElements(driver, this);
	}
	
	public WebElement loginName()
	{
	return txtLoginNameobj;
	}
		
	public WebElement fullName()
	{
	return txtfullNameobj;
	}
	
	public WebElement email()
	{
	return txtemailobj;
	}
	
	public WebElement mobileNo()
	{
	return txtmobilenoobj;
	}
	
	public WebElement genderId()
	{
	return firstgenderobj;
	}
	
	public WebElement SaveBtn()
	{
	return txtsavebtnobj;
	}
	
	
	public void SelectGender(String gender)
	{
		Select gendselect = new Select (firstgenderobj);
		
		gendselect.selectByVisibleText(gender);
	}
	
	
		public void SelectData(String strdate) 
	{
		String [] dateArr = strdate.split("-")	;
		txtDateObj.click();
		
		//24/Jun/1988
		Select selectYear =new Select (lstyearobj);
		selectYear.selectByVisibleText(dateArr[2]);
		
		Select selectMonth = new Select(lstmonthobj);
		selectMonth.selectByVisibleText(dateArr[1]);
		
		for(WebElement day : daysobj)
		{ 
			String actday =day.getText();
			
			if (actday.equalsIgnoreCase(dateArr[0]))
			{
			day.click();
				break;
			}
		}
	
		
	}
	
	}
