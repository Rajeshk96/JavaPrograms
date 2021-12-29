package com.crm.SDET25A.VtigerCrm;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateOrganizationTest {
	
	public static void main(String[] args) throws Throwable {
		
		/* get ramDomData */
	 	Random ran = new Random();
	     int ranDomNun = ran.nextInt(10000);
	/* read common data from Properties File*/
	FileInputStream fis= new FileInputStream("./data/commonData.properties");
	Properties pObj = new Properties();
	 pObj.load(fis);
	 String BROWER = pObj.getProperty("browser");
	 String URL = pObj.getProperty("url");
	 String USERNAME = pObj.getProperty("username");
	 String PASSWORD = pObj.getProperty("password");
	 
	 /* read test data from Excel File*/
		FileInputStream efis= new FileInputStream("./data/testdata.xlsx");
	    Workbook wb =  WorkbookFactory.create(efis);
        Sheet sh =  wb.getSheet("org");
	    Row row = sh.getRow(1);
	    String orgName = row.getCell(2).getStringCellValue() + ranDomNun;
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

     /* step 4 : verify */ 
    String actOrgName =  driver.findElement(By.className("dvHeaderText")).getText();
    if (actOrgName.contains(orgName)) {
		System.out.println(orgName + "org is created==PASs");
	}else{
		System.out.println(orgName + "org is not created==FAIL");

	}
     /* step 5 : logout */ 
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
    driver.findElement(By.linkText("Sign Out")).click();
    driver.close();

		
		
	}

}
