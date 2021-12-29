package com.crm.SDET25A.BasicTestScripts;

import java.io.IOException;
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
import com.crm.SDET25.GenericUtils.IPathConstants;
import com.crm.SDET25.GenericUtils.WebDriverUtility;
import com.crm.SDET25A.ObjectRepository.LoginPage;

public class CreateOrganisation {
	
	@Test
	public void createOrg() throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		//read the common data from property file
		FileUtility flib = new FileUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String AppUrl = flib.readDataFromPropertyFile("url");
		String user = flib.readDataFromPropertyFile("username");
		String pass = flib.readDataFromPropertyFile("password");
		
		//read the data from excel
		ExcelUtility eutil = new ExcelUtility();
		String key1 = eutil.getStringData("Sheet1",4,0);
				
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
			System.out.println("invalid browser name");
		}
		
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.waitForPageToLoad(driver);
		driver.get(AppUrl);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(user, pass);

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(key1);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		
		WebElement signout = driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
		
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(admin).perform();
		
		signout.click();
		
	}


}
