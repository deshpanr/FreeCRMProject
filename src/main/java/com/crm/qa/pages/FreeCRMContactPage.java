package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.FreeCRMBase;

public class FreeCRMContactPage extends FreeCRMBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;

	public FreeCRMContactPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String getContactLabel() {
		return contactLabel.getText();
	}
	
	public boolean selectConacts(String contactName) {
		 WebElement checkBox=driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']"));
		 checkBox.click();
		 return checkBox.isSelected();
	}
}
