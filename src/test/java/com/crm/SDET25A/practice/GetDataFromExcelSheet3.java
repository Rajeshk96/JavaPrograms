package com.crm.SDET25A.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet3 {
	
	@Test
	public void getColumnData() throws EncryptedDocumentException, IOException {
		
		//fetch only 1st and 2nd column data from all the rows
		FileInputStream file = new FileInputStream("./data/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int rowno = sheet.getLastRowNum();
		sheet.getPhysicalNumberOfRows();
		
		for(int i=0; i<=rowno; i++) {
			Row row = sheet.getRow(i);
			System.out.println(row.getCell(0).getStringCellValue());
			System.out.println(row.getCell(1).getStringCellValue());
		}
		
	}

}
