package com.crm.SDET25A.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet {
	
	@Test
	public void getExcelData() throws EncryptedDocumentException, IOException{
		
		 FileInputStream file = new FileInputStream("./data/testdata.xlsx");
		 Workbook workbook = WorkbookFactory.create(file);
		 Sheet sheet = workbook.getSheet("Sheet1");
		 Row row = sheet.getRow(1);
		 Cell cell = row.getCell(0);
		 String url = cell.getStringCellValue();
		 
		 System.out.println(url);
		
	}

}
