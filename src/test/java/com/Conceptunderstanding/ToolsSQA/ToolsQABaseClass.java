/**
 * @author 			:	 Sumit chaudhary
 *	DATE       		:	 Apr 21, 2020
 *  FILE NAME  		: 	 BaseClass.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    8:17:22 PM
 */
package com.Conceptunderstanding.ToolsSQA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class ToolsQABaseClass
{
	static WebDriver driver;
	static Properties propertiesFile;
	
	
	@BeforeMethod
	public void toolsSQALaunch() throws IOException
	{
		//Get File inputstream to get content from the file 
		FileInputStream getFile = new FileInputStream("E:\\Sumit_Works\\SeleniumInterviewPractice\\src\\test\\java\\com\\Conceptunderstanding\\ToolsSQA\\ToolsSQLelementpropertiesFile.properties");
		propertiesFile = new Properties();//Initialize the properties object. 
		propertiesFile.load(getFile);// Take fileinput object for get the value according to key. 
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers&JarsforAutomation\\ChromeDriverfor80\\chromedriver.exe");
		
		driver = new ChromeDriver();//initialize / call the chrome driver 
		
		driver.navigate().to("https://demoqa.com/");//navigate the dummy site. 
		driver.manage().window().maximize();//Miximize the browser
	}

}
