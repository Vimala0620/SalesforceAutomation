package com.CF.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.CF.pages.LaunchAppPage;
import com.CF.pages.PostRefreshAutomation;
import com.CF.base.BaseTest;

public class LoginPage extends BaseTest{
	
	WebDriver driver;
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="Login")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public HomePage Login() throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		prop.load(fis);
		String url = prop.getProperty("srurl");
		String loginusername = prop.getProperty("srusername");
		String loginpassword = prop.getProperty("srpassword");
		
		driver.get(url);
		
		usernameField.sendKeys(loginusername);
		passwordField.sendKeys(loginpassword);
		loginButton.click();
		
		return new HomePage(driver);
       
	}
	
}
