package com.crm.SDET25A.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;
import com.crm.SDET25.GenericUtils.JavaUtility;
import com.crm.SDET25.GenericUtils.WebDriverUtility;

public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("=======Connect to database======");
	}

	@BeforeClass
	public void configBC() throws Throwable {
		
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String APPURL = fUtil.readDataFromPropertyFile("url");
		
	     if(BROWSER.equals("chrome")) {
	          driver = new ChromeDriver();
	     }else if(BROWSER.equals("firefox")){
	    	  driver = new FirefoxDriver();
	     }else if(BROWSER.equals("ie")){
	   	  driver = new InternetExplorerDriver();
	    }else {
	        driver = new ChromeDriver();
	    }	
	     
	    sdriver=driver;
	    driver.get(APPURL);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		LoginPage log = new LoginPage(driver);
		log.loginToApp(USERNAME , PASSWORD);
		
	}
	
	@AfterMethod
	public void configAM() {
		
		HomePage hp = new HomePage(driver);
		hp.signOut();
	}
	
	@AfterClass
	public void configAC() {
		
		driver.quit();
	}
	
	
}
