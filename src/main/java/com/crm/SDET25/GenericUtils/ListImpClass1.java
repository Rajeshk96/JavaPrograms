package com.crm.SDET25.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.SDET25A.ObjectRepository.BaseClass;

public class ListImpClass1 implements ITestListener{
	
	JavaUtility jutil = new JavaUtility();
	
	public void onTestFailure(ITestResult result) {
			
			String testName = result.getMethod().getMethodName();
			String date = jutil.getDateAndTime();
			
			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File("./screenShot/"+testName+"_"+date+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				
			}
			
		}
		
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
		}

		
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
		}
		
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
		}

		
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
		}

		
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
		}

}
