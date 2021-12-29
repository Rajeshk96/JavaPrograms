package com.crm.SDET25A.ProductModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;
import com.crm.SDET25.GenericUtils.JavaUtility;
import com.crm.SDET25.GenericUtils.WebDriverUtility;
import com.crm.SDET25A.ObjectRepository.BaseClass;
import com.crm.SDET25A.ObjectRepository.LoginPage;
import com.crm.SDET25A.ObjectRepository.ProductsPage;
import com.crm.SDET25A.ObjectRepository.ProductsSearchPage;

public class SearchProductByProductName extends BaseClass {

	@Test
	public void SearchProductByProductNameTesting() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		//ps.productSearchInfo();

		WebElement searchFor = driver.findElement(By.xpath("//input[@name='search_text']"));
		wutil.executeJavaScript(driver, "arguments[0].value='" + ProductName + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

}
