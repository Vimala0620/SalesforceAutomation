package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostRefreshAutomation {
	
	
	WebDriver driver;
	private By more = By.xpath("//span[text()='More']");
	private By postRefresh = By.xpath("//span[text()='Post Refresh Automation']");
	
	
	public PostRefreshAutomation(WebDriver driver) {
        this.driver = driver;
    }
	public void clickPostRefresh() {
		System.out.println("Post Refresh Automation");
		//driver.findElement(more).click();
		//driver.findElement(postRefresh).click();
		
	}
}
