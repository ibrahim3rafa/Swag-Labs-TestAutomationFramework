package com.swagLabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class broswerFactory {
    private broswerFactory() {
        // Constructor is private to prevent instantiation
    }


    //get the browser name
    public static WebDriver getBrowserName(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = getChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.valueOf("normal"));
                //options.addArguments("--headless");
                return new ChromeDriver(options);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--maximize-window");
                firefoxOptions.addArguments("--disable-infobars");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--disable-popup-blocking");
                firefoxOptions.addArguments("--disable-application-cache");
                firefoxOptions.addArguments("--disable-translate");
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.valueOf("normal"));
                firefoxOptions.setAcceptInsecureCerts(true);

                return new FirefoxDriver();

            default:
                EdgeOptions edgeOptions = getEdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.valueOf("normal"));
                // options.addArguments("--headless");
                return new EdgeDriver(edgeOptions);
        }
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        edgeOptions.addArguments("--maximize-window");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-popup-blocking");
        edgeOptions.addArguments("--disable-translate");
        edgeOptions.addArguments("--disable-notifications");
        Map<String, Object> edgePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "profile.default_content_setting_values.popups", 0,
                "credential_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.enable_show_autofill_sign", false
        );
        edgeOptions.setExperimentalOption(" prefs", edgePrefs);
        return edgeOptions;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = getOptions();
        Map<String, Object> prefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "profile.default_content_setting_values.popups", 0,
                "credential_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.enable_show_autofill_sign", false
        );
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--maximize-window");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-application-cache");
        options.addArguments("--disable-translate");
        options.addArguments("--disable-notifications");
        return options;
    }
}
