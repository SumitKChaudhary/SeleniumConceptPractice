/**
 * @author 			:	 Neelam-Sonu
 *	DATE       		:	 19-May-2020
 *  FILE NAME  		: 	 Login.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    10:49:19 am
 */
package com.Conceptunderstanding.youtube;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login 
{
	ChromeDriver driver;
	@BeforeMethod
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
     	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neelam-Sonu\\Desktop\\chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
	}
	@Test
	public void Login() throws InterruptedException
	{
		WebElement login= driver.findElementByXPath("//yt-formatted-string[text()='Sign in']");
		login.click();
		WebElement email=driver.findElementByXPath("//input[@id='identifierId']");
		email.sendKeys("docquitytestdevice@gmail.com");
		WebElement Next= driver.findElementByXPath("//span[text()='Next']");
		Next.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		WebElement pass= driver.findElementByXPath("//input[@name='password' and @jsname='YPqjbf']");
		pass.sendKeys("Let'sDoAutomate#2020");
		driver.findElementByXPath("//div[@id='passwordNext']").click();
		
	}
}
