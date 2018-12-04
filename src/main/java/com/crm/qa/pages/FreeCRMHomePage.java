package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.FreeCRMBase;
import com.crm.qa.util.FreeCRMTestUtil;

public class FreeCRMHomePage extends FreeCRMBase {
	FreeCRMContactPage contactPage;
	FreeCRMTestUtil testUtil;
	
	
	@FindBy(xpath="//td[contains(text(),'User: Ravindra Deshpande')]")
	WebElement username;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactTab;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsTab;
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDeals;
	
	
	public FreeCRMHomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfHomePage() {
		return driver.getTitle();
	}
	
	public String getUsername() throws IOException {
		testUtil=new FreeCRMTestUtil();
		testUtil.switchToFrame();
		return username.getText();
	}
	
    public FreeCRMContactPage clickContactsTab() throws IOException {
    testUtil=new FreeCRMTestUtil();
	testUtil.switchToFrame();
	contactTab.click();
	return new FreeCRMContactPage();
}
    
    public FreeCRMDealsPage clickOnNewDeals() throws IOException, InterruptedException {
    	testUtil=new FreeCRMTestUtil();
    	testUtil.switchToFrame();
    	Actions action=new Actions(driver);
    	action.moveToElement(dealsTab).build().perform();
    	Thread.sleep(2000);
    	newDeals.click();
    	return new FreeCRMDealsPage();
    	
    }
}
