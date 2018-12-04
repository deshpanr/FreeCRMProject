package com.crm.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.FreeCRMBase;
import com.crm.qa.pages.FreeCRMContactPage;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.FreeCRMLoginPage;

import org.testng.Assert;

public class contactPageTest extends FreeCRMBase {
	FreeCRMLoginPage loginPage;
	FreeCRMContactPage contactPage;
	FreeCRMHomePage homePage;

	public contactPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initionalize();
		loginPage=new FreeCRMLoginPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.clickContactsTab();
	}
	
	@Test(priority=1)
	public void getContactLabelTest() {
		String label=contactPage.getContactLabel();
		Assert.assertEquals("Contacts", label);
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		boolean selected=contactPage.selectConacts("Rohini Deshpande");
		Assert.assertTrue(selected);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
