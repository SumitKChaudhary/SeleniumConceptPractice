/**
 * @author 			:	 Sumit chaudhary
 *	DATE       		:	 Apr 22, 2020
 *  FILE NAME  		: 	 Playspecificvideo.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    6:59:33 PM
 */
package com.Conceptunderstanding.youtube;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Playspecificvideo 
{
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
     	System.setProperty("webdriver.chrome.driver", "F:\\Sumit_Project_Works\\Drivers&JarsforAutomation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.youtube.com");//open the youtube
		WebElement login= driver.findElement(By.xpath("//yt-formatted-string[text()='Sign in']"));
		login.click();
		WebDriverWait wait = new WebDriverWait(driver, 300);
		WebElement email=driver.findElement(By.xpath("//input[@id='identifierId']"));
		email.sendKeys("dummyselenium1992@gmail.com");
		
		WebElement Next= driver.findElement(By.xpath("//span[text()='Next']"));
		wait.until(ExpectedConditions.elementToBeClickable(Next));
		Next.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@name='password']]")).sendKeys("Selenium@2020");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));// click on youtube search bar
		
		searchBar.click();//click on search bar
		searchBar.sendKeys("Duji Vaar Pyar");//search the song by query 
		
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();//click the search icon after enter the query
		
		List<WebElement> videoLinks = driver.findElements(By.xpath("//a[@id='video-title'][1]"));//store all videos elements in the list
		
		for(WebElement getOneVideo : videoLinks)// get the element one by one from the videos list 
		{
			// Comparing the video tile as per the title 
              if(getOneVideo.getText().contains("Duji Vaar Pyar | Sunanda Sharma | Sukh-E | Jaani | Arvindr K | Official Video | Mad 4 Music"))
              {
            	  // if my comparing success then click on that video 
            	  getOneVideo.click();
            	  System.out.println("Play from comparing");
            	  driver.findElement(By.xpath("//div[@id='contenteditable-root']")).sendKeys("Comment ");
            	  break;
              }
              else
              {
            	  //if not comparing success then play first video from the list. 
            	  getOneVideo.click();
            	  System.out.println("Play first video from index ");
              }
		}
		
	}

}
