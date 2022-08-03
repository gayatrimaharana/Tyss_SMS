package org.tyss.sms.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class SmsExcelUtility {
	private Workbook workbook;
	public void initializeExcelFile(String excelPath)
	{
		FileInputStream fisExcel=null;
		try {
			 fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 try {
			 workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getLastCellDataFromExcel(String sheetName,int rowNum) {
		   int data = workbook.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		  return data;
		
	}
	
	public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{
		Sheet sheet = workbook.getSheet(sheetName);
	return	new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
	
	public void setDataIntoExcel(String sheetName,int rowNumber,int cellNumber,String value)
	{
	Sheet sheet = workbook.getSheet(sheetName);
	sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
	System.out.println("Data entered");	
	}
	public void SaveDataInExcel(String filePath)
	{
		FileOutputStream fos=null;
		try {
			 fos=new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeExcel()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
