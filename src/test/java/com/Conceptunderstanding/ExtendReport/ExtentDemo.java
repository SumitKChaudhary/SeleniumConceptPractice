	/**
	 * @author 			:	 Sumit Kumar
	 *	DATE       		:	 23-May-2020
	 *  FILE NAME  		: 	 ExtentDemo.java
	 *  PROJECT NAME 	:	 SeleniumInterviewPractice
	 * 	Class Time		:    12:26:58 AM
	 */
	package com.Conceptunderstanding.ExtendReport;
	
	import java.io.IOException;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	
	public class ExtentDemo {
	
		ExtentHtmlReporter htmlReporter;
	    ExtentReports extent;
	    ExtentTest test;
	    ChromeDriver driver;
	     
	    @BeforeTest
	    public void config()
	    {
	    	//Give the path where we want to export our extent report 
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }
	     
	    @Test
	    public void captureScreenshot()
	    {
	        test = extent.createTest("captureScreenshot");
	        System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("http://www.google.in");
	        String title = driver.getTitle();
	        Assert.assertEquals("Google", title);
	        }
	     
	    @AfterMethod
	    public void getResult(ITestResult result) throws IOException
	    {
	        if (result.getStatus() == ITestResult.FAILURE)
	        {
	   
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	        	String path=TakeScreenShots.captureScreen(driver, "PassAttached");
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	            test.pass("Snapshot below: " + test.addScreenCaptureFromPath(path));
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	        extent.flush();
	    }
	     
	    @AfterTest
	    public void endReport()
	    {
	        driver.quit();
	    }
	}
