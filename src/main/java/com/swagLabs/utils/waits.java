package com.swagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waits {
    private waits() {
        // Constructor is private to prevent instantiation
    }

    //wait until the element is present
    public static WebElement elementIsPresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator));
    }


    //wait until the element is visible
    public static WebElement elementIsVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                {
                    WebElement element = elementIsPresent(driver, locator);
                    if (element.isDisplayed()) {
                        return element;
                    } else {
                        return null;
                    }

                });
    }


    //wait until the element is clickable
    public static WebElement elementIsClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                {
                    WebElement element = elementIsVisible(driver, locator);
                    if (element.isEnabled()) {
                        return element;
                    } else {
                        return null;
                    }

                });


    }
}