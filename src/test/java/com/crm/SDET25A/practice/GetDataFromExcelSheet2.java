package com.crm.SDET25A.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet2 {
	@Test
	public void getData() throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("./data/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		String url = workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String browser = workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String username = workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		
	}

}
