/**
 * @author 			:	 Sumit Kumar
 *	DATE       		:	 12-May-2020
 *  FILE NAME  		: 	 CommentONVideo.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    12:58:49 pm
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

public class CommentONVideo {
ChromeDriver driver;
	@BeforeMethod
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
     	System.setProperty("webdriver.chrome.driver", "F:\\Sumit_Project_Works\\Drivers&JarsforAutomation\\chromedriver.exe");
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
		email.sendKeys("dummyselenium1992@gmail.com");
		WebElement Next= driver.findElementByXPath("//span[text()='Next']");
		Next.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		WebElement pass= driver.findElementByXPath("//input[@name='password' and @jsname='YPqjbf']");
		pass.sendKeys("Selenium@2020");
		driver.findElementByXPath("//span[text()='Next']").click();
		WebElement Subscriptions = driver.findElementByXPath("//body/ytd-app/div[@id='content']/app-drawer[@id='guide']/div[@id='contentContainer']/div[@id='guide-wrapper']/div[@id='guide-content']/div[@id='guide-inner-content']/ytd-guide-renderer[@id='guide-renderer']/div[@id='sections']/ytd-guide-section-renderer[1]/div[1]/ytd-guide-entry-renderer[3]/a[1]");
		Subscriptions.click();
		System.out.println("Subscriptions");
		WebElement imageClk = driver.findElementByXPath("//button[@id='avatar-btn']");
		imageClk.click();
		System.out.println("image clicked");
		//System.out.println("image clbbicked");
		WebElement SignOut= driver.findElementByXPath("//yt-formatted-string[@id='label' and text()='Sign out']");
		wait.until(ExpectedConditions.elementToBeClickable(SignOut));
		SignOut.click();
		System.out.println("Sign out");
	}
}
