package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class scrolling {

    private scrolling() {
        // Constructor is private to prevent instantiation
    }

    //scroll to the element
    public static void scrollToElement(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementActions.findElement(driver,locator));
    }


}
