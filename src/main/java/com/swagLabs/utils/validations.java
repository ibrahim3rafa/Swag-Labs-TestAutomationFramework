package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class validations {
    private validations() {
        // Constructor is private to prevent instantiation
    }

    //validate true
    public static void validateTrue(boolean condition ,String message) {
        Assert.assertTrue(condition, message);
    }

    //validate false
    public static void validateFalse(boolean condition ,String message) {
        Assert.assertFalse(condition, message);
    }

    //validate equals
    public static void validateEquals(Object expected, Object actual ,String message) {
        Assert.assertEquals(actual, expected , message);
    }

    //validate not equals
    public static void validateNotEquals(Object expected, Object actual) {
        Assert.assertNotEquals(actual, expected);
    }

    //validate contains
    public static void validateContains(String expected, String actual) {
        Assert.assertTrue(actual.contains(expected));
    }


    //validate the page URL
    public static void validatePageUrl(WebDriver driver , String expected) {
        Assert.assertEquals(browserActions.getCurrentUrl(driver), expected);
    }

    //validate the page title
    public static void validatePageTitle(WebDriver driver , String expected) {
        Assert.assertEquals(browserActions.getTitle(driver), expected);
    }





}
