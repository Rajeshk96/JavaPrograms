package com.crm.SDET25A.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;

public class FetchMultipleData {
	
	@DataProvider
	public Object[][] data() throws Throwable{
		ExcelUtility eutil = new ExcelUtility();
		return eutil.getMultipleData();
	}
	
	@Test(dataProvider = "data")
	public void getDatas(String username, String password) {
		
		System.out.println(username+" "+password);
	}

}
