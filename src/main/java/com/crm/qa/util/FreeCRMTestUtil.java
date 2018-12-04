package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.FreeCRMBase;

public class FreeCRMTestUtil extends FreeCRMBase {
	
	Xls_Reader reader;
	String sheetName="Deals";
	

	public FreeCRMTestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_TIMEOUT=20;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public ArrayList<Object[]> getTestData(){
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		reader=new Xls_Reader("C:\\Users\\deshpanr\\eclipse-workspace\\FreeCRM\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Free_CRM_TestData.xlsx");
		int rowCount=reader.getRowCount(sheetName);
		for (int rowNo = 2; rowNo <= rowCount; rowNo++) {
			String title=reader.getCellData(sheetName, "title",rowNo);
			String company=reader.getCellData(sheetName, "company", rowNo);
			String amount=reader.getCellData(sheetName, "amount", rowNo);
			String quantity=reader.getCellData(sheetName, "quantity", rowNo);
			String typeName=reader.getCellData(sheetName, "type", rowNo);
			Object ob[]={title,company,amount,quantity,typeName};
			myData.add(ob);
		}
		
		return myData;
		
	
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
}
