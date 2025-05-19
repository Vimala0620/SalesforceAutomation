package com.sf.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PicklistPage {
	public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
		System.out.println("locator " + locator);
		WebElement dropdown = driver.findElement(locator);
        System.out.println("locator " + locator);

        System.out.println("Dropdown element: " + dropdown);
        Select select = new Select(dropdown);
        System.out.println("visibleText: " + visibleText);
        select.selectByVisibleText(visibleText);
    }

    // Method to select a value from a picklist by index
    public static void selectByIndex(WebDriver driver, By locator, int index) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // Method to select a value from a picklist by value attribute
    public static void selectByValue(WebDriver driver, By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
}
