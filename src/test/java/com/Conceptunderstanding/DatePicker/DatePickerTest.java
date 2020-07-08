/**
 * @author 			:	 Neelam-Sonu
 *	DATE       		:	 08-Jul-2020
 *  FILE NAME  		: 	 DatePickerTest.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    4:57:56 pm
 */
package com.Conceptunderstanding.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerTest 
{
	public static void main(String[] args) throws ParseException {
		
		WebDriver driver; 
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.navigate().to("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		driver.findElement(By.xpath("//input[@id='datepicker'][1]")).click();
		
		String setDateStr= "17/06/1990";
		
		String currDateStr = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText(); //MMMM YYYY
		
		Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
		
		Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);
		
		//fetch the different between current month and desire month
		int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
				
		boolean isFuture = true; 
		
		//if month is 0 then convert in to positive for run loop
		if(monthDiff<0)
		{
			isFuture=false;
				monthDiff = -1 * monthDiff;
		}
		
		for(int i=0; i<monthDiff; i++)
		{
			if(isFuture)
			{
				//click on next bar
				driver.findElement(By.xpath("//a[@title='Next'][1]")).click();
			}
			else
			{
				//click on previous bar
				driver.findElement(By.xpath("//a[@title='Prev'][1]")).click();
				
			}
			
		}
		
		String day = new SimpleDateFormat("dd").format(setDate);
		driver.findElement(By.xpath("//a[text()='"+Integer.parseInt(day)+"']")).click();
	}

}
