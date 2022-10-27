package mavenexecution;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reportingclas {
	
	public static ExtentReports extent;
	public static ExtentReports GenerateReport() {

			
		//ExtentReports extent = new ExtentReports ();
		//C:\Users\marri\OneDrive\Desktop\AUTOMATION_TESTING\FrameWorkDesign\reports
		
		String reportpath =System.getProperty("user.dir")+"\\reports\\extentreports.html";
		
		String reportconfig =System.getProperty("user.dir")+"\\Resources\\extentf-config.json";

		//C:\Users\marri\OneDrive\Desktop\AUTOMATION_TESTING\FrameWorkDesign\Resources\extentf-config.json	
		
		ExtentSparkReporter sparkreporter =new ExtentSparkReporter (reportpath);
	 
		/*
		//updating the default configuration of the report
		sparkreporter.config().setDocumentTitle("QA test Results");
		sparkreporter.config().setDocumentTitle("sample extent extent Report");
		sparkreporter.config().setCss(".badge-success{background-color:#19af24;}");    
		
		*/
		try {
		
		sparkreporter.loadJSONConfig(new File(reportconfig));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		extent =new ExtentReports();
		
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("TeamName", "Quanton");
		extent.setSystemInfo("TeamLead", "hema");

		return extent;
		
		
	/*	ExtentTest test = test =extent.createTest("Test case1");
		test.pass("test case exxecuted successfully");
		
		test = extent.createTest("test case2");
		test.fail("test case failed");
		*/
		
		
		//extent.flush();
	}
	
	
}
