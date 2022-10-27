package mavenexecution;
	

	import java.io.IOException;
	import java.util.ArrayList;

	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import base.initilastion;
	import objectRepository.HomePageModule;
	import objectRepository.LoginpageModule;
	import objectRepository.RegestrationPageModule;

	public class REGESTRATIONMODULETEST extends initilastion{
		
		
				
				String url = new String("https://www.tsrtconline.in/");
				//CommonMethods cm = new CommonMethods();
				
				@BeforeTest
				public void BrowserInitisations() throws IOException
				{
					driver=BrowserInitialisation();
				    url =proper.getProperty("url");
				    driver.get(url);
				}
				
				@Test
				public void ValidateLoginNameField1() throws IOException
				{
			     ArrayList<String> Tcdata = new ArrayList();
				
				Tcdata =CommonMethods.GetExcelData("fullname");
				
				HomePageModule hp =new HomePageModule(driver);
				hp.Eticketlogin().click();
				LoginpageModule lp = new LoginpageModule(driver);       
				lp.SignUp().click();
				RegestrationPageModule rp = new RegestrationPageModule(driver);
				rp.loginName().sendKeys(Tcdata.get(1));
				rp.fullName().sendKeys(Tcdata.get(2));
				rp.email().sendKeys(Tcdata.get(4));
				
				rp.SelectGender("FEMALE");
				rp.SelectData("22-Jul-1990");
				rp.mobileNo().sendKeys(Tcdata.get(3));
				rp.SaveBtn().click();
				
				}

				@Test
				public void ValidateLoginNameField2() throws IOException
				{
				ArrayList<String> Tcdata = new ArrayList();
				
				Tcdata =CommonMethods.GetExcelData("SuccessfullyReg");
				
				HomePageModule hp =new HomePageModule(driver);
				hp.Eticketlogin().click();
				LoginpageModule lp = new LoginpageModule(driver);       
				lp.SignUp().click();
				RegestrationPageModule rp = new RegestrationPageModule(driver);
				rp.loginName().sendKeys(Tcdata.get(1));
				rp.fullName().sendKeys(Tcdata.get(2));
				rp.email().sendKeys(Tcdata.get(4));
				
				rp.SelectGender("FEMALE");
				rp.SelectData("25-Dec-2005");
				
				
				rp.mobileNo().sendKeys(Tcdata.get(3));
				rp.SaveBtn().click();
				
				}
		      @Test
				public void ValidateLoginNameField3() throws IOException
				{
				ArrayList<String> Tcdata = new ArrayList();
				
				Tcdata =CommonMethods.GetExcelData("LoginNameValid");
				
				HomePageModule hp =new HomePageModule(driver);
				hp.Eticketlogin().click();
				LoginpageModule lp = new LoginpageModule(driver);       
				lp.SignUp().click();
				RegestrationPageModule rp = new RegestrationPageModule(driver);
				rp.loginName().sendKeys(Tcdata.get(1));
				rp.fullName().sendKeys(Tcdata.get(2));
				rp.email().sendKeys(Tcdata.get(4));

				rp.SelectGender("FEMALE");
				rp.SelectData("22-Aug-1998");
				rp.mobileNo().sendKeys(Tcdata.get(3));
				rp.SaveBtn().click();
				
		   }

		        @Test
				public void ValidateLoginNameField4() throws IOException
				{
				ArrayList<String> Tcdata = new ArrayList();
				
				Tcdata =CommonMethods.GetExcelData("FieldValidation");
				
				HomePageModule hp =new HomePageModule(driver);
				hp.Eticketlogin().click();
				LoginpageModule lp = new LoginpageModule(driver);       
				lp.SignUp().click();
				RegestrationPageModule rp = new RegestrationPageModule(driver);
				rp.loginName().sendKeys(Tcdata.get(1));
				rp.fullName().sendKeys(Tcdata.get(2));
				rp.email().sendKeys(Tcdata.get(4));

				rp.SelectGender("FEMALE");
				rp.SelectData("22-Jun-1992");
				rp.mobileNo().sendKeys(Tcdata.get(3));
				rp.SaveBtn().click();
				
		   }

		        public void Closeobjects ()
		        {
		        	driver.close();
		        }
		  }	
				




