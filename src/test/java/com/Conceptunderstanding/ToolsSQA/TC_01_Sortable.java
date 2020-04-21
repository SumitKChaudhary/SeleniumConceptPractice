/**
 * @author 			:	 Sumit chaudhary
 *	DATE       		:	 Apr 21, 2020
 *  FILE NAME  		: 	 TC_01_Sortable.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    8:28:19 PM
 */
package com.Conceptunderstanding.ToolsSQA;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_01_Sortable extends ToolsQABaseClass 
{
	@Test
	public void sortableTest()
	{
		driver.findElement(By.xpath(propertiesFile.getProperty("shortableClick"))).click();
		
		if(driver.getCurrentUrl().equals("https://demoqa.com/sortable/"))
		{
			System.out.println("Sortable window successfully open");
		}
		else
		{
			System.out.println("Please check the element");
		}
	}
}
