package com.crm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.FreeCRMBase;
import com.crm.qa.pages.FreeCRMContactPage;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.FreeCRMLoginPage;

public class HomePageTest extends FreeCRMBase {
	FreeCRMLoginPage loginPage;
	FreeCRMHomePage homePage;
	FreeCRMContactPage freeCRMContactPage;

	public HomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initionalize();
		loginPage=new FreeCRMLoginPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=2)
	public void homePageTitleTest() {
		String title=homePage.getTitleOfHomePage();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=1)
	public void usernameTest() throws IOException {
		String username=homePage.getUsername();
		Assert.assertEquals(username, "  User: Ravindra Deshpande");
	}
	
	@Test(priority=3)
	public void clickContactTabTest() throws IOException {
		freeCRMContactPage=homePage.clickContactsTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
