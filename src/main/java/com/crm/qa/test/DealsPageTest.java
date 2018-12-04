package com.crm.qa.test;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.FreeCRMBase;
import com.crm.qa.pages.FreeCRMDealsPage;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.FreeCRMLoginPage;
import com.crm.qa.util.FreeCRMTestUtil;

public class DealsPageTest extends FreeCRMBase {
	
	FreeCRMLoginPage loginPage;
	FreeCRMHomePage homePage;
	FreeCRMDealsPage dealsPage;
	FreeCRMTestUtil testUtil;
	
	public DealsPageTest() throws IOException {
		super();
	}
	
	@DataProvider
	public Iterator<Object[]>getCRMDealsData() throws IOException {
		testUtil=new FreeCRMTestUtil();
		return testUtil.getTestData().iterator();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initionalize();
		loginPage=new FreeCRMLoginPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage=homePage.clickOnNewDeals();
		
	}
	
	@Test(dataProvider="getCRMDealsData")
	public void createNewDealsTest(String title,String company,String amount,String quantity,String type) {
		dealsPage.createNewDeal(title, company, amount, quantity, type);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
