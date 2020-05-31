/**
 * @author 			:	 Neelam-Sonu
 *	DATE       		:	 17-May-2020
 *  FILE NAME  		: 	 RuntestCapability.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    12:54:54 pm
 */
package com.Conceptunderstanding.ExcelFile;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Objects;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RuntestCapability {
	 
	Object obj[][];
//	@DataProvider
	public Object laodCreditialsData() throws BiffException, IOException {
		
		File getFile = new File("C:\\Users\\Neelam-Sonu\\Desktop\\Read.xls");
		
		Workbook creditialsFile = Workbook.getWorkbook(getFile);
		
		Sheet fileSheet = creditialsFile.getSheet(0);
		
		int row = fileSheet.getRows();
		int col = fileSheet.getColumns();
		
		obj = new Object[row][col];
		
		for(int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				Cell fileCells = fileSheet.getCell(j,i);
				
				obj[i][j]=fileCells.getContents();
			}
		}
		
		return obj;
	}
	
	@Test()
	public void read() 
	{
		 
	}
}
