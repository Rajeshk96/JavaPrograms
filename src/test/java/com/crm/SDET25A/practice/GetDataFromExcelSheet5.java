package com.crm.SDET25A.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet5 {
	
	@Test
	public void getData5() throws EncryptedDocumentException, IOException {
		
		//write the data into excel sheet
		FileInputStream file = new FileInputStream("./data/testdata.xlsx");
		 Workbook workbook = WorkbookFactory.create(file);
		 Sheet sheet = workbook.getSheet("Sheet1");
		 Row row = sheet.getRow(1);
		 Cell cell = row.createCell(7);
		 cell.setCellValue("TestYantra");
		 
		 FileOutputStream file2 = new FileOutputStream("./data/testdata.xlsx");
		 workbook.write(file2);
		 workbook.close();
	}

}
