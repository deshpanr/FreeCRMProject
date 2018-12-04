package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.FreeCRMBase;

public class FreeCRMDealsPage extends FreeCRMBase {

	
	@FindBy(id="title")
	WebElement title;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(id="amount")
	WebElement amount;
	@FindBy(id="quantity")
	WebElement qty;
	@FindBy(xpath="//input[@class='button' and @value='Save']")
	WebElement savebtn;
	
	public FreeCRMDealsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeal(String titlename,String companyname,String amt,String quantity,String typeName) {
		title.sendKeys(titlename);
		company.sendKeys(companyname);
		amount.sendKeys(amt);
		qty.sendKeys(quantity);
		Select select=new Select(driver.findElement(By.name("type")));
		select.selectByVisibleText(typeName);
		savebtn.click();
		
	}
}
