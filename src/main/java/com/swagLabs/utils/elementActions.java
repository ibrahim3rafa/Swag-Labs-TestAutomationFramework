package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class elementActions {

    private elementActions() {
        // Constructor is private to prevent instantiation
    }

    //send keys
    public static void sendData(WebDriver driver, By locator, String text) {
        waits.elementIsVisible(driver, locator);
        scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).sendKeys(text);
    }


    //click
    public static void clickElement(WebDriver driver, By locator) {
        waits.elementIsClickable(driver, locator);
        scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).click();
    }

    public static String getText(WebDriver driver, By locator) {
        waits.elementIsVisible(driver, locator);
        scrolling.scrollToElement(driver, locator);
        return driver.findElement(locator).getText();
    }

}
