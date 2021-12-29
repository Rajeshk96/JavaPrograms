package com.crm.SDET25A.practice;

import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.JsonUtility;

public class GetDataFromJsonFile {
	
	@Test
	public void getJsonData() throws Throwable {
		
		JsonUtility jutil = new JsonUtility();
		String URL = jutil.readDataFromJson("url");
		
		System.out.println(URL);
		
	}

}
