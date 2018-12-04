package com.crm.qa.test;

import java.io.IOException;

import org.testng.annotations.*;

import com.crm.qa.base.FreeCRMBase;
import com.crm.qa.pages.FreeCRMHomePage;
import com.crm.qa.pages.FreeCRMLoginPage;
import com.crm.qa.pages.FreeCRMSignUpPage;

import org.testng.Assert;

public class LoginPageTest extends FreeCRMBase {
	
	FreeCRMLoginPage loginPage;
	FreeCRMHomePage homePage=new FreeCRMHomePage();
	FreeCRMSignUpPage signUpPage=new FreeCRMSignUpPage();

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initionalize();
		loginPage=new FreeCRMLoginPage();
	}

	@Test
	public void logoTest() {
		boolean logoDisplay=loginPage.validateLogo();
		Assert.assertTrue(logoDisplay);
	}
	
	@Test
    public void loginTest() throws InterruptedException, IOException {
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(loginPage.freeCRMHomePage, homePage);
	}
	
	@Test
	public void titleTest() {
		String title=loginPage.validateLoginTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}
	
	@Test
	public void signUpLinkTest() throws InterruptedException {
		signUpPage=loginPage.validateSignUp();
		//Assert.assertEquals(loginPage.freeCRMSignUpPage, signUpPage);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
