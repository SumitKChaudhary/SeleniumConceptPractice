/**
 * @author 			:	 Sumit chaudhary
 *	DATE       		:	 Apr 16, 2020
 *  FILE NAME  		: 	 ScrllPage.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    1:01:03 PM
 */
package com.Conceptunderstanding.seleniumInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrllPage {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.findElement(By.id("inputBox")).sendKeys("desire text");
		
		driver.findElement(By.id("inputBox")).clear();
		
		driver.manage().deleteAllCookies();
		
		//or 
		
		WebElement typeInputBox = driver.findElement(By.id("inputBox"));
		
		typeInputBox.sendKeys("desire Text");
	}

}
