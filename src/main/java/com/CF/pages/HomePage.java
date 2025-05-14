package com.CF.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
		
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
		public void home() throws InterruptedException { 
		   LaunchAppPage launchAppPage = new LaunchAppPage(driver);
	       launchAppPage.selectSalesApp("post Refresh Automation");
		}
}
