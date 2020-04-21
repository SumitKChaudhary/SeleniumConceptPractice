package com.Conceptunderstanding.TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsSequence 
{
	@BeforeMethod//4.
	public void beforeMethod()
	{
		System.out.println("@BeforeMethod");
	}
	@BeforeClass//3.
	public void beforeClass()
	{
		System.out.println("@BeforeClass");
	}
	@BeforeGroups
	public void beforeGroup()
	{
		System.out.println("@BeforeGroups");
	}
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("@BeforeSuite");//1. 
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("@BeforeTest");//2.
	}
	@AfterClass//7.
	public void afterClass()
	{
		System.out.println("@AfterClass");
	}
	@AfterGroups
	public void afterGroup() {
		System.out.println("@AfterGroups");
	}
	@AfterMethod//6.
	public void afterMethod()
	{
		System.out.println("@AfterMethod");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("@AfterSuite");
	}
	@AfterTest//8. 
	public void afterTest()
	{
		System.out.println("@AfterTest");
	}
	@Test//5.
	public void Test()
	{
		System.out.println("@Test");
	}


}
