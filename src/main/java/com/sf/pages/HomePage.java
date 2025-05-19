
package com.sf.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to verify the home page title
    public boolean isHomePageDisplayed(String expectedTitle) {
        String actualTitle = driver.getTitle();
        return actualTitle.contains(expectedTitle);
    }

    // Method to navigate to an app
    public void navigateToObject(String objectName) {
        try {
            WebElement appLauncher = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-r6']")));
            appLauncher.click();

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable
            		(By.xpath("//input[@placeholder='Search apps and items...']")));
            searchInput.click();
            searchInput.sendKeys(objectName);

            WebElement objectOption = 
            		wait.until(ExpectedConditions.elementToBeClickable
            				(By.xpath("//a[@data-label='"+objectName+"']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", objectOption);
            
        } catch (Exception e) {
            System.err.println("Failed to navigate to app: " + objectName);
            e.printStackTrace();
        }
    }

    // Method to navigate to a specific tab
    public void navigateToTab(String tabName) {
        try {
            WebElement tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='" + tabName + "']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabElement);
        } catch (Exception e) {
            System.err.println("Failed to navigate to tab: " + tabName);
            e.printStackTrace();
        }
    }
}
