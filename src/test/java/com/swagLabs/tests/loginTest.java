package com.swagLabs.tests;

import com.swagLabs.pages.loginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest {
    //Variables
    WebDriver driver;


    //Tests
    //Test 1: Successful login
    @Test
    public void testSuccessfulLogin() {
        new loginPage(driver).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .successfulLogin();
    }


    //Configuration

    @BeforeTest
    public void setUp() {
        //Set up the test environment
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        new loginPage(driver).navigateToLoginPage();
    }


    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.quit();
    }

}
