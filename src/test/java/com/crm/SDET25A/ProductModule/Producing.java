package com.crm.SDET25A.ProductModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.SDET25A.ObjectRepository.BaseClass;
import com.crm.SDET25A.ObjectRepository.ProductsPage;
import com.crm.SDET25A.ObjectRepository.ProductsSearchPage;

public class Producing extends BaseClass{
	
	@Test
	public void testngtest() throws Throwable {

			int random = jutil.getRanDomNumber();

			String ProductName = eutil.getStringData("Sheet1", 10, 0) + random;
			String VisibleText = eutil.getStringData("Sheet1", 15, 6);
			String qtyPerUnit = eutil.getStringData("Sheet1",15,5);
			
			ProductsPage pp = new ProductsPage(driver);
			pp.productPageInfo(ProductName);
			
			ProductsSearchPage ps = new ProductsSearchPage(driver);
			ps.productSearchInfo(VisibleText);
			
			WebElement searchFor = ps.getSearchForTxt();
			
		    wutil.executeJavaScript(driver, "arguments[0].value='"+qtyPerUnit+"';", searchFor);
		    
		    ps.getSearchNowBtn().click();
		
	}

}
