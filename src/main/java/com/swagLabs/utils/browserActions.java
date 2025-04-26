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

}
