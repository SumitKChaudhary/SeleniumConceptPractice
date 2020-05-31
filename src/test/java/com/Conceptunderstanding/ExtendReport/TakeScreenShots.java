/**
 * @author 			:	 Sumit Kumar
 *	DATE       		:	 23-May-2020
 *  FILE NAME  		: 	 TakeScreenShots.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    12:24:58 AM
 */
package com.Conceptunderstanding.ExtendReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShots
{	
	 public static String captureScreen(ChromeDriver driver,String screenShotName) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"//"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	                     
	        return dest;
	    }

}
