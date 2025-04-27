package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementActions {

    private elementActions() {
        // Constructor is private to prevent instantiation
    }


    //find element
    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }


    //send keys
    public static void sendData(WebDriver driver, By locator, String text) {
        waits.elementIsVisible(driver, locator);
        scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).sendKeys(text);
    }


    //click
    public static void clickElement(WebDriver driver, By locator) {
        waits.elementIsClickable(driver, locator);
        scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).click();
    }

    public static String getText(WebDriver driver, By locator) {
        waits.elementIsVisible(driver, locator);
        scrolling.scrollToElement(driver, locator);
        return findElement(driver,locator).getText();
    }

}
