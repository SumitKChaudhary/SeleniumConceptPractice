/**
 * Project Copyright:  Payworld
 * @author 			:	 Sumit Kumar
 *	DATE       		:	 14-Jul-2020
 *  FILE NAME  		: 	 PayworldFetchedDataSaver.java
 *  PROJECT NAME 	:	 PayworldRPOS
 * 	Time			:    2:17:05 am
 */
package com.Conceptunderstanding.seleniumInterview;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Conceptunderstanding.ExcelFile.ExcelReaderController;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaveTableDataintoExcel 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> tableList= driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		int sizeOftable= tableList.size();
		
		String companyBeforeXpath= "//*[@id='customers']/tbody/tr[";
		String companyAfterXpath = "]/td[1]";
		String contactBeforeXpath= "//*[@id='customers']/tbody/tr[";
		String contactAfterXpath = "]/td[2]";
		String countryBeforeXpath= "//*[@id='customers']/tbody/tr[";
		String countryAfterXpath = "]/td[3]";
		
		ExcelReaderController excelFileReader = new ExcelReaderController(System.getProperty("user.dir")+File.separator+"DataFileContainer"+File.separator+"HTMLTableData.xlsx");
		
		if(!excelFileReader.isSheetExist("TableData"))
		{
			excelFileReader.addSheet("TableData");
			excelFileReader.addColumn("TableData", "CompanyName");
			excelFileReader.addColumn("TableData", "ContactList");
			excelFileReader.addColumn("TableData", "CountryName");
		}
		
		for(int i=2; i<=sizeOftable; i++)
		{
			String companyAbluteXpath = companyBeforeXpath+i+companyAfterXpath;
			String companyName= driver.findElement(By.xpath(companyAbluteXpath)).getText();
			excelFileReader.setCellData("TableData", "CompanyName", i, companyName);
			
			String contactAbluteXpath = contactBeforeXpath+i+contactAfterXpath;
			String contactList= driver.findElement(By.xpath(contactAbluteXpath)).getText();
			excelFileReader.setCellData("TableData", "ContactList", i, contactList);
			
			String countryAbluteXpath = countryBeforeXpath+i+countryAfterXpath;
			String countryName= driver.findElement(By.xpath(countryAbluteXpath)).getText();
			excelFileReader.setCellData("TableData", "CountryName", i, countryName);
		}
	}

}
