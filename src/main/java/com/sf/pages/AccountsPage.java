package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.utils.PicklistPage;

public class AccountsPage{
	
	WebDriver driver;
	PicklistPage picklistPage;
	@FindBy(xpath="//div[@title='New']")
	WebElement newAccButton;
	
	@FindBy(xpath="//input[@name='Name']")
	WebElement accountNameInput;
	
	@FindBy(xpath="//button[@aria-label=\"Sales Owner\"]")
	WebElement salesOwnerDropdown;
	
	@FindBy(xpath="//button[@name='SaveEdit']")
	WebElement saveButton;
	
	By salesOwnerBylocator = By.xpath("//button[@aria-label='Sales Owner']");
	
	private String visibleText = "Anil Reddy";
	public WebElement getSalesOwnerOption() {
	    return driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + visibleText + "']"));
	}
	public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void createNewAccount(String accountName) {
		newAccButton.click();
		accountNameInput.sendKeys(accountName);
		salesOwnerDropdown.click();
		WebElement salesOwnerOption = getSalesOwnerOption();
		salesOwnerOption.click();
		
		//PicklistPage.selectByVisibleText(driver, salesOwnerBylocator, visibleText);
		saveButton.click();
		
	}
}
