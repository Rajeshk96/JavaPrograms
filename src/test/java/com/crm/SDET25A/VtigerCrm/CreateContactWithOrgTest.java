package com.crm.SDET25A.VtigerCrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.SDET25.GenericUtils.IPathConstants;


public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		
		/* get ramDomData */
	 	Random ran = new Random();
	     int ranDomNun = ran.nextInt(10000);
	/* read common data from Properties File*/
	FileInputStream fis= new FileInputStream(IPathConstants.PROPERTY_PATH);
	Properties pObj = new Properties();
	 pObj.load(fis);
	 String BROWER = pObj.getProperty("browser");
	 String URL = pObj.getProperty("url");
	 String USERNAME = pObj.getProperty("username");
	 String PASSWORD = pObj.getProperty("password");
	 
	 /* read test data from Excel File*/
		FileInputStream efis= new FileInputStream(IPathConstants.EXCEL_PATH);
	    Workbook wb =  WorkbookFactory.create(efis);
        Sheet sh =  wb.getSheet("Sheet1");
	    Row row = sh.getRow(10);
	    String orgName = row.getCell(0).getStringCellValue() + ranDomNun;
	    String conactName = row.getCell(1).getStringCellValue() + ranDomNun;
	    wb.close();
	   
	 
     
     /* launch the Browser */ 
     WebDriver driver = null;
     if(BROWER.equals("chrome")) {
          driver = new ChromeDriver();
     }else if(BROWER.equals("firefox")){
    	  driver = new FirefoxDriver();
     }else if(BROWER.equals("ie")){
   	  driver = new InternetExplorerDriver();
    }else {
        driver = new ChromeDriver();
    }

               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.get(URL);
     /* step 1 : login to APP */ 
     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
     driver.findElement(By.id("submitButton")).click();
     /* step 1 : navigate to Org Page */ 
     driver.findElement(By.linkText("Organizations")).click();

     /* step 2 :  navigate to CREATE  Org Page*/ 
     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
     /* step 3 : create a new Org */
     driver.findElement(By.name("accountname")).sendKeys(orgName);
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

     WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
     WebDriverWait wait = new WebDriverWait(driver, 20);
     wait.until(ExpectedConditions.elementToBeClickable(headerWb));
     
     
     /* step 4 : navigate to Contact Page */ 
     driver.findElement(By.linkText("Contacts")).click();
    
     /* step 5 :  navigate to CREATE  Coantct Page*/ 
     driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    
     
     /* step 6 : create a new contact With org Name */
     driver.findElement(By.name("lastname")).sendKeys(conactName);
     driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
     Set<String> set = driver.getWindowHandles();
     Iterator<String> it = set.iterator();

      while (it.hasNext()) {
	          String wID = it.next();
	          driver.switchTo().window(wID);
	          String currentWindowTitle = driver.getTitle();
	          if(currentWindowTitle.contains("Accounts")) {
	        	  break;
	          }
    	}
     

     driver.findElement(By.name("search_text")).sendKeys(orgName);
     driver.findElement(By.name("search")).click();
     driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
     
     Set<String> set1 = driver.getWindowHandles();
     Iterator<String> it1 = set1.iterator();
     while (it1.hasNext()) {
          String wID = it1.next();
          driver.switchTo().window(wID);
          String currentWindowTitle = driver.getTitle();
          if(currentWindowTitle.contains("Contacts")) {
        	  break;
          }
	}
     
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     
     
/**   
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
    driver.findElement(By.linkText("Sign Out")).click();
    driver.close();
    
    */


	}

}
