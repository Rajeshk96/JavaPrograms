package com.crm.SDET25A.ProductModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;
import com.crm.SDET25.GenericUtils.WebDriverUtility;

public class SearchProductByQtyPerUnit {

	public static void main(String[] args) throws Throwable {
		
		/* read common data from Properties File*/
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String APPURL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		 
		 /* read test data from Excel File*/
		ExcelUtility eutil = new ExcelUtility();
		String ProductName5 = eutil.getStringData("Sheet1",15,0);
		String qtyPerUnit = eutil.getStringData("Sheet1",15,5);
		 
	     
	     /* launch the Browser */ 
	     WebDriver driver = null;
	     if(BROWSER.equals("chrome")) {
	          driver = new ChromeDriver();
	     }else if(BROWSER.equals("firefox")){
	    	  driver = new FirefoxDriver();
	     }else if(BROWSER.equals("ie")){
	   	  driver = new InternetExplorerDriver();
	    }else {
	        driver = new ChromeDriver();
	    }
	          
	          
	     driver.manage().window().maximize();
	     
	     WebDriverUtility wutil = new WebDriverUtility();
	     wutil.waitForPageToLoad(driver);
	     driver.get(APPURL);
	     
	     /* step 1 : login to APP */ 
	     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	     driver.findElement(By.id("submitButton")).click();
	     
	     driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	     driver.findElement(By.name("productname")).sendKeys(ProductName5);
	     driver.findElement(By.id("qty_per_unit")).sendKeys(qtyPerUnit);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	     driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
	     
	     WebElement productList = driver.findElement(By.xpath("(//select[@name='search_field' and @id='bas_searchfield'])[1]"));
	     
	     Select sel = new Select(productList);
	     sel.selectByVisibleText("Qty/Unit");
	     
	     WebElement searchFor = driver.findElement(By.xpath("//input[@name='search_text']"));
	     
	     JavascriptExecutor jse = (JavascriptExecutor) driver;
	     jse.executeScript("arguments[0].value='"+qtyPerUnit+"';", searchFor);
	     
	     driver.findElement(By.name("submit")).click();


	}

}
