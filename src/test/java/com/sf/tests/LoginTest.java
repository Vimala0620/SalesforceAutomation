package com.sf.tests;

import com.sf.base.BaseTest;
import com.sf.pages.LoginPage;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws Exception {
        LoginPage login = new LoginPage(driver);
        login.login();

        String expectedUrl = "https://cloudfulcrum";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl.contains(expectedUrl)
            : "Login failed! Expected: " + expectedUrl + ", but got: " + actualUrl;
    }
}
