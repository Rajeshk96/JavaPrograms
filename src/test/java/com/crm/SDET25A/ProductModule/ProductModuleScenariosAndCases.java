package com.crm.SDET25A.ProductModule;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SDET25A.ObjectRepository.BaseClass;
import com.crm.SDET25A.ObjectRepository.ProductInformationPage;
import com.crm.SDET25A.ObjectRepository.ProductsPage;
import com.crm.SDET25A.ObjectRepository.ProductsSearchPage;

@Listeners(com.crm.SDET25.GenericUtils.ListImpClass1.class)
public class ProductModuleScenariosAndCases extends BaseClass {

	@Test //(retryAnalyzer = com.crm.SDET25.GenericUtils.RetryAnalyzer.class)
	public void SearchProductByProductNameTesting() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String VisibleText = eutil.getStringData("Sheet1", 10, 6);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductInformationPage pi = new ProductInformationPage(driver);
		String expectedProductName = pi.getEditProductNameTxtBox().getText();
		Assert.assertEquals(expectedProductName, ProductName);

		//Assert.fail();

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + ProductName + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

	@Test(groups = "smokeTest")
	public void SearchProductByProductNo() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String ProductNo = eutil.getStringData("Sheet1", 11, 1);
		String VisibleText = eutil.getStringData("Sheet1", 11, 6);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + ProductNo + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

	@Test(groups = "smokeTest")
	public void SearchProductByPartNumber() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String VisibleText = eutil.getStringData("Sheet1", 12, 6);
		String PartNumber = eutil.getStringData("Sheet1", 12, 2);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + PartNumber + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

	@Test(groups = "smokeTest")
	public void SearchProductByCommissionRate() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String VisibleText = eutil.getStringData("Sheet1", 13, 6);
		String CommissionRate = eutil.getStringData("Sheet1", 13, 3);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + CommissionRate + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

	@Test(groups = "regressionTest")
	public void SearchProductByQtyInStock() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String VisibleText = eutil.getStringData("Sheet1", 14, 6);
		String inStock = eutil.getStringData("Sheet1", 14, 4);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + inStock + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

	@Test(groups = "regressionTest")
	public void SearchProductByQtyPerUnit() throws Throwable {

		int random = jutil.getRanDomNumber();

		String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
		String VisibleText = eutil.getStringData("Sheet1", 15, 6);
		String qtyPerUnit = eutil.getStringData("Sheet1", 15, 5);

		ProductsPage pp = new ProductsPage(driver);
		pp.productPageInfo(ProductName);

		ProductsSearchPage ps = new ProductsSearchPage(driver);
		ps.productSearchInfo(VisibleText);

		WebElement searchFor = ps.getSearchForTxt();

		wutil.executeJavaScript(driver, "arguments[0].value='" + qtyPerUnit + "';", searchFor);

		ps.getSearchNowBtn().click();

	}

}
