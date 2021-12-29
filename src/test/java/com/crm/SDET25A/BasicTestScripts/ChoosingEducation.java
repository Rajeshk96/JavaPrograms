package com.crm.SDET25A.BasicTestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;

public class ChoosingEducation {
	
	@Test
	public void createIndustry() throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		//read the common data from property file
		FileUtility flib = new FileUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String AppUrl = flib.readDataFromPropertyFile("url");
		String user = flib.readDataFromPropertyFile("username");
		String pass = flib.readDataFromPropertyFile("password");
		
		//read the data from Excel
		ExcelUtility eutil = new ExcelUtility();
		String key2 = eutil.getStringData("Sheet1",4,1);
		String key3 = eutil.getStringData("Sheet1",4,2);
		
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
		
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(key3);
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select s = new Select(industry);
		s.selectByVisibleText(key2);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Thread.sleep(5000);
		
		WebElement signout = driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
		
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(admin).perform();
		
		signout.click();
		
	}


}
