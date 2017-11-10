package com.pack.common.packageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;

import junit.framework.TestCase;

public class TestRunner {
	List<Object> tcList = new ArrayList<Object>();
	ITestContext ngContext;
	
	public TestRunner(ITestContext ngContext){
		this.ngContext = ngContext;
	}

	@SuppressWarnings("resource")
	public void addTCFromXL() throws IOException {
		String skipTest = ngContext.getCurrentXmlTest().getParameter("SKIPTEST");
		if(skipTest!=null && skipTest.equalsIgnoreCase("true")) return;
		
		String filePath = System.getProperty("user.dir")+"\\src\\com\\pack";
		String FileName = ngContext.getCurrentXmlTest().getParameter("testData");
		if(FileName==null || FileName.isEmpty()) FileName = "/TestData.xlsx";
		File file =    new File(filePath+"\\"+FileName);
		String SheetName = ngContext.getCurrentXmlTest().getParameter("sheetName");
		if(SheetName==null || SheetName.isEmpty()) SheetName = "Way2AutomationFunctions";
		FileInputStream inputStream = new FileInputStream(file);
		Workbook MyWorkBook = null;
		String fileExtensionName = FileName.substring(FileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
		    //If it is xlsx file then create object of XSSFWorkbook class
		    	MyWorkBook = new XSSFWorkbook(inputStream);
		    }
		    //Check condition if the file is xls file
		    else if(fileExtensionName.equals(".xls")){
		        //If it is xls file then create object of XSSFWorkbook class
		    	MyWorkBook = new HSSFWorkbook(inputStream);
		    }
		MyWorkBook = new XSSFWorkbook(inputStream);
		Sheet MyWorkSheet = MyWorkBook.getSheet(SheetName);
		int countOfRows = MyWorkSheet.getLastRowNum() - MyWorkSheet.getFirstRowNum();
		for(int i=0;i<countOfRows;i++){
			Row row = MyWorkSheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				if(row.getCell(j).getStringCellValue().equalsIgnoreCase("yes")){
					j++;
					String tcName = row.getCell(j).getStringCellValue();
					j++;
					String Iteration = row.getCell(j).getStringCellValue();
					
					addTC(tcName,Iteration);
				}
				else
					System.out.println("######### No TestCase found with 'Yes' flag to run #######");
			}
		}
	}
	

	public void addTC(String tcName, String iteration) {
		TestCase tc = getTestCaseInstance(tcName,iteration);
		if(tc!=null){
			tcList.add(tc);
		}
	}
	
	public void addTC(String tcName, String iteration, boolean execution){
		if(execution){
			String skipTest = ngContext.getCurrentXmlTest().getParameter("SKIPTEST");
			if(skipTest!=null && skipTest.equalsIgnoreCase("true"))
				return;
			
			addTC(tcName,iteration);
		}
	}

	@SuppressWarnings("unchecked")
	private TestCase getTestCaseInstance(String tcName, String iteration) {
		try{
		Class<TestCase> tcClass = (Class<TestCase>) Class.forName(tcName);
		TestCaseElement tcInfo = new TestCaseElement(tcClass, iteration, ngContext);
		TestCase tcInstance = tcClass.getConstructor(TestCaseElement.class).newInstance(tcInfo);
		return tcInstance;
		}
		catch(Exception e){
			System.out.println("TestRunner: TestCase ["+ tcName +"] could not be initiated.");
			e.printStackTrace();
			return null;
		}
	}

	public Object[] getTCList() {
		Object[] tcArray = tcList.toArray().clone();
		tcList.clear();
		return tcArray;
	}

}
