package com.crm.SDET25A.BasicTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;

public class CreateVendor {
	
	@Test
	public void vendorCreation() throws Throwable {
		
		WebDriver driver = null;
		
		//read the common data from property file
		FileUtility flib = new FileUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String AppUrl = flib.readDataFromPropertyFile("url");
		String user = flib.readDataFromPropertyFile("username");
		String pass = flib.readDataFromPropertyFile("password");
		
		//read the data from excel
		ExcelUtility eutil = new ExcelUtility();
		String key9 = eutil.getStringData("Sheet1",7,1);
				
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("inavalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(AppUrl);
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement moreButton = driver.findElement(By.xpath("//a[text()='More']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(moreButton).perform();
		
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(key9);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement signout = driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
		
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(admin).perform();
		
		signout.click();
		
		
	}

}
