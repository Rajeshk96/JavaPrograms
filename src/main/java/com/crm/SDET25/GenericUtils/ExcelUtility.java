package com.crm.SDET25.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getStringData(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException {
		
		 FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		 Workbook workbook = WorkbookFactory.create(file);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	}

	public double getNumericExcelData(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException  {
		
		 FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		 Workbook workbook = WorkbookFactory.create(file);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getNumericCellValue(); 
	}
	
	public void writeDataToExcel(String sheetname, int rowno, int cellno, String valueToWrite) throws EncryptedDocumentException, IOException  {
		
		 FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		 Workbook workbook = WorkbookFactory.create(file);
		 workbook.createSheet(sheetname).createRow(rowno).createCell(cellno).setCellValue(valueToWrite);
		 
		 FileOutputStream file2 = new FileOutputStream("./testdata.xlsx");
		 workbook.write(file2);
	}
		 
	public Object[][] getMultipleData() throws Throwable {
		
		FileInputStream file = new FileInputStream("./data/testdata2.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowno = sheet.getLastRowNum();
		int cellno = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowno][cellno];
		for(int i=0;i<=rowno;i++) {
			for(int j=0;j<cellno; j++) {
				data[i][j]= sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
		 
		 
}
