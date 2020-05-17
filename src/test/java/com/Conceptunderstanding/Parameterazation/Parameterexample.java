package com.Conceptunderstanding.Parameterazation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterexample
{
	//@Parameters({"browserType","userNmae", "passWord"})
	
	
	@Test
	public void testParameterFromTestNGFile(String browserName, String userN, String pass)
	{
		System.out.println("TestNG File have browser name is: "+browserName);
		System.out.println("TestNG File have user name is: "+userN);
		System.out.println("TestNG File have password is: "+pass);
	}
	@Test(invocationCount = 3)
	public void multipleTimesRun()
	{
		System.out.println("run");
	}
	
	

}
