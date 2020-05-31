/**
 * @author 			:	 Neelam-Sonu
 *	DATE       		:	 17-May-2020
 *  FILE NAME  		: 	 Capability.java
 *  PROJECT NAME 	:	 SeleniumInterviewPractice
 * 	Class Time		:    7:09:22 pm
 */
package com.Conceptunderstanding.ExcelFile;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capability {

	public static void main(String[] args) {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		
		capability.chrome().setCapability("web",    "");
	}
}
