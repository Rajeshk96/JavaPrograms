package com.crm.SDET25A.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class GetDataFromXmlFile {
	
	@Test
	public void getXmlData(XmlTest xml) {
		String browser = xml.getParameter("browser");
		System.out.println(browser);
		
		String username = xml.getParameter("username");
		System.out.println(username);
		
		String password = xml.getParameter("password");
		System.out.println(password);
	}

}
