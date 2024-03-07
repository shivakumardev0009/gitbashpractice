package com.hms.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	/**
	 * read the data from excel sheet
	 * @author Dev
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int row, int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * to get the last row number
	 * @author Dev
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	/**
	 * write data into excel sheet
	 * @author Dev
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcelFile(String sheetName, int row,int cell, String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	/**
	 * store data from excel to hasmap and get the multiple data 
	 * @author Dev
	 * @param sheetName
	 * @param cell
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> readMultipleData(String sheetName, int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for ( int i=0; i<=rowCount; i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	
	public Object[][] genricExcelDP(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum()+1;
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][lastCellNum];
		for(int i=0; i<lastRowNum; i++)
		{
			for(int j=0; j<lastCellNum; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
