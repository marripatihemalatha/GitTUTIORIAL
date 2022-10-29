package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class initilastion {

	public WebDriver driver;
	
	public  Properties proper ;
	 
		public WebDriver BrowserInitialisation() throws IOException 
	{
       
		proper = new Properties();
		String properpath =System.getProperty("user.dir")+"\\Resources\\configures.properties";
		FileInputStream fis =  new FileInputStream(properpath);
		proper.load(fis);
		
		/*String browsername ="";
		
		browsername =System.getProperty("browser");
		
		if (browsername == "null")
		{
			browsername =proper.getProperty("browser");
			
		}         */
		
		String browsername =proper.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else 
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		
		
		return driver;
		
	}
	
	public String Getscreenshot(WebDriver driver ,String Tcname ) throws IOException
	{
	
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String screenshotpath =System.getProperty("user.dir")+"\\reports\\"+Tcname+".JPEG";
	FileUtils.copyFile(src, new File(screenshotpath));
	
	
	return screenshotpath;
   }
 
}
