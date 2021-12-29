package com.crm.SDET25.GenericUtils;

import java.util.Date;
import java.util.Random;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class JavaUtility {
	
	/**
	 * its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return
	 */
	
	public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
		
	}
	
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	
	public String getSystemDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	
	public String getSystemDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];   
        int MM = date.getMonth()+1;
        
        String finalFormat = YYYY+"-"+MM+"-"+DD;
		return finalFormat;	  
	}

	
	 public void pressVirtualEnterKey() throws Throwable {
	    	
	    	Robot robo = new Robot();
	    	robo.keyPress(KeyEvent.VK_ENTER);
	    	robo.keyRelease(KeyEvent.VK_ENTER);
	    }

	 public String getDateAndTime() {
		   Date dateObj = new Date();  
		   String dateFormat = dateObj.toString().replace(":","_").replace(" ", "_");
		   return dateFormat;
	   }

	 
	 
}
