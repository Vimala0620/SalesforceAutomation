package com.sf.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sf.base.BaseTest;
import com.sf.pages.AccountsPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;

public class AccountsTest extends BaseTest {
	
	// Test method to verify account creation
	@Test
    public void verifyAccountCreation() throws IOException, InterruptedException {
		
		
		// Step 1: Log in to the application
		 LoginPage login = new LoginPage(driver);
		 login.login();
		 HomePage home = new HomePage(driver);
		 home.navigateToObject("Accounts");
		 AccountsPage accountsPage = new AccountsPage(driver);
		 accountsPage.createNewAccount("Automating Test Account");
	}
}
