package com.crm.SDET25A.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet4 {
	
	@Test
	public void getData4() throws EncryptedDocumentException, IOException{
		
		//check the cell has value or not, if it is there fetch next cell value
		FileInputStream file = new FileInputStream("./data/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String expectedData = "admin";
		String actualData = sheet.getRow(1).getCell(2).toString();
		if(actualData.equals(expectedData)) 
		{
			System.out.println(sheet.getRow(1).getCell(3).toString());
		}
		
	}
	
	
}
