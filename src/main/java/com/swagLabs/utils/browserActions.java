package com.swagLabs.utils;

import org.openqa.selenium.WebDriver;

public class browserActions {
    private browserActions() {
        // Constructor is private to prevent instantiation
    }

    //open the browser
    public static void openBrowser(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }


    //get the title of the page
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }



    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }

    //maximize the browser
    public static void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    //minimize the browser
    public static void minimizeBrowser(WebDriver driver) {
        driver.manage().window().minimize();
    }

    //refresh the browser
    public static void refreshBrowser(WebDriver driver) {
        driver.navigate().refresh();
    }

    //

}
