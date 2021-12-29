package com.crm.SDET25A.BasicTestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
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

public class CreateContact {
	
	@Test
	public void createCont() throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		//read the common data from property file
		FileUtility flib = new FileUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String AppUrl = flib.readDataFromPropertyFile("url");
		String user = flib.readDataFromPropertyFile("username");
		String pass = flib.readDataFromPropertyFile("password");
		
		//read the data from excel
		ExcelUtility eutil = new ExcelUtility();
		String key4 = eutil.getStringData("Sheet1",4,3);
		
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
				
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(key4);
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();
		
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> tab = new ArrayList<String>(handles);
		driver.switchTo().window(tab.get(1));
		
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		driver.switchTo().window(tab.get(0)); 
		
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
		
		save.click();
		
		WebElement signout = driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
		
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(admin).perform();
		
		signout.click();
	}
	

}
