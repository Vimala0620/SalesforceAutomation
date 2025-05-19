package com.sf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchAppPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private By launchAppButton = By.xpath("//button[@title='App Launcher']");
	private By searchInput = By.xpath("//input[@placeholder='Search apps and items...']");
	private By salesOption = By.xpath("//span[text()='Sales']"); // Replace with actual locator if needed
	private By postRefresh = By.xpath("//b[text()='Post Refresh Automation']");
	public LaunchAppPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public PostRefreshAutomation selectSalesApp(String appName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Click on the App Launcher button
		WebElement appLauncher = 
				wait.until(ExpectedConditions.elementToBeClickable(launchAppButton));

		appLauncher.click();

		// Wait for dialog to load after clicking App Launcher
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));

		WebElement clicksearchInput = wait.until(ExpectedConditions.elementToBeClickable(searchInput));
		clicksearchInput.click();
		clicksearchInput.sendKeys(appName);

		WebElement salesOption = wait.until(ExpectedConditions.elementToBeClickable(postRefresh));
		salesOption.click();
		return new PostRefreshAutomation(driver);
	}

}	

