package com.crm.qa.pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.FreeCRMBase;

public class FreeCRMLoginPage extends FreeCRMBase {
	
	public FreeCRMHomePage freeCRMHomePage;
	public FreeCRMSignUpPage freeCRMSignUpPage;
	
	//page objects
	
	@FindBy(name="username")
	WebElement user;
	@FindBy(name="password")
	WebElement pwd;
    @FindBy(xpath="//input[@type='submit']")
    WebElement login;
    @FindBy(linkText="Sign Up")
    WebElement signUp;
    @FindBy(xpath="//img[contains(@alt,'free crm logo')]")
    WebElement logo;
    

	public FreeCRMLoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	public FreeCRMHomePage validateLogin(String un,String pw) throws InterruptedException, IOException {
		Thread.sleep(2000);
		user.sendKeys(un);
		pwd.sendKeys(pw);
		login.click();
		return new FreeCRMHomePage();
	}
	
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	
	public FreeCRMSignUpPage validateSignUp() throws InterruptedException {
		Thread.sleep(2000);
		signUp.click();
		return new FreeCRMSignUpPage();
	}
}
