package com.crm.SDET25A.practice;

import org.testng.annotations.Test;

public class GetDataFromCommandLineTest {
	
	@Test
	public void getCmdData() {
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
