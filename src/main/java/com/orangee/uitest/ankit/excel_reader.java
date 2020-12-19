package com.orangee.uitest.ankit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_reader {

	public String filepath;  // filepath location where the .xlsx file is kept
	public FileInputStream fis;  // read the content from the file (excel)
	public FileOutputStream fout;
	public XSSFWorkbook workbook; // workbook variable
	public XSSFSheet sheet;  // sheet variable
	public XSSFRow row;  // row variable
	public XSSFCell cell = null; // column/cell data variable
	int columncount=0; // initialization
	int rowcount = 0;
	String data = "";
	ArrayList<String> loginValues = new ArrayList<String>();
	
	public ArrayList<String> getCellData(String filepath,String excelName,String sheetName, int rowNumber) throws Exception {
		  
		/*
	      this.filepath = filepath;
	      String filepath1 = filepath+excelName;
          try {
			fis = new FileInputStream(filepath1);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			
			rowcount = sheet.getLastRowNum(); // 0 to 4 where 0 is having headers and 1-4 rows will have values/data
			
			System.out.println("Number of rows: " + rowcount); 
			
			
			row = sh  eet.getRow(rowNumber); // reaching out to the specific row in the sheet
			
			columncount = row.getLastCellNum(); // 1-2
			
			System.out.println("Number of columns: " + columncount);
			
			
			for(int i =0; i<columncount; i++) {
				
				 data = row.getCell(i).getStringCellValue(); // convert XSSFCell to String
				 loginValues.add(data); // List will always maintain the order of the inserted values (0- username, 1-password)
				
			}

		} 
    
          catch (Exception e) {
			e.printStackTrace();
		}
          
          finally {
        	  
        	workbook.close();
  			fis.close();  
          }
          
          return loginValues;   */
		
		
		//-----------------------------------------------------------//
		this.filepath  = filepath;
		String filepath1 = filepath + excelName;
		//System.getProperty("user.dir")+"\\Resources\\Data\\Book.xlsx\\"
		fis = new FileInputStream(filepath1);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		rowcount = sheet.getLastRowNum(); // 0 to 4 where 0 is having headers and 1-4 rows will have values/data
		
		System.out.println("Number of rows: " + rowcount); 
		
		
		row = sheet.getRow(rowNumber); // reaching out to the specific row in the sheet
		
		columncount = row.getLastCellNum(); // 1-2
		
		System.out.println("Number of columns: " + columncount);
		
		for(int i =0; i<columncount; i++) {
			
			 data = row.getCell(i).getStringCellValue();
			 loginValues.add(data); // List will always maintain the order of the inserted values (0- username, 1-password)
		}
		
		workbook.close();
		fis.close();
		return loginValues;
		
	}
	
	public void updateCellData(String filepath,String excelName,String sheetName, int rowNumber,String message )
	{
		  this.filepath = filepath;
	      String filepath1 = filepath+excelName;
          try
          {
			fis = new FileInputStream(filepath1);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			columncount = row.getLastCellNum();
			row = sheet.getRow(rowNumber);
			row.createCell(columncount - 1).setCellValue(message);
			
			fout = new FileOutputStream(filepath1);
			workbook.write(fout);
			
			workbook.close();
			fis.close();
			fout.close();
			
          }
		catch(Exception e)
          {
			System.out.println("exception:"+e.getMessage());
          }
		
	}
	
	
	void writeCellData() {
		
		
		
	}
	
	
	void createNewSheet(String filepath,String excelName,String sheetName) 
	{
		  this.filepath = filepath;
	      String filepath1 = filepath+excelName;
          try
          {
			fout = new FileOutputStream(filepath1);
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet(sheetName);
			
	     }
          
      	catch(Exception e)
          {
			System.out.println("exception:"+e.getMessage());
          }
		  

    }
}