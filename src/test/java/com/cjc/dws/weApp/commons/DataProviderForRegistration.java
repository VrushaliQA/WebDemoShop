package com.cjc.dws.weApp.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderForRegistration {
	
	@DataProvider(name="RegistrationData")
	public Iterator<Row> dataProviderForRegistrationMethod() {
		 FileInputStream fip;
		  XSSFWorkbook workbook = null;
		  
		  try {
			fip=new FileInputStream("G:\\CJCSelenium\\MavenTasks\\02_11_2022_Project\\src\\test\\resources\\TestData\\dataForRegistration.xlsx");
			workbook=new XSSFWorkbook(fip);
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  XSSFSheet sheet=workbook.getSheet("sheet1");
		
		 Iterator<Row> rows= sheet.rowIterator();
		 return rows;
			
	}

}
