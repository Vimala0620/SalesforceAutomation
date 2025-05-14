package com.CF.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.CF.pages.HomePage;
import com.CF.pages.LoginPage;
import com.CF.base.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
    public void verifyAccountNavigation() throws IOException, InterruptedException {
		
		 LoginPage login = new LoginPage(driver);
		 HomePage home = login.Login();
		 home.home();
		 //LaunchAppPage appLauncher = home.selectSalesApp("Post Refresh Automation");
	     //AccountsPage accounts = appLauncher.goToAccounts();
	}
	
}
