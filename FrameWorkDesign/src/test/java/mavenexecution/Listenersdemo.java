package mavenexecution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.initilastion;

public class Listenersdemo extends initilastion implements ITestListener {
 
	ExtentReports extent = Reportingclas.GenerateReport();
	 
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.pass("Test case executed sucessfully");
	}

	@Override // very important for screenshot 
	
	public void onTestFailure(ITestResult result) {
		
		String screenpath ="";
		WebDriver driver = null ;
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		test.fail(result.getThrowable());
		
		try {
			screenpath = Getscreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenpath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}
	
}
	
	