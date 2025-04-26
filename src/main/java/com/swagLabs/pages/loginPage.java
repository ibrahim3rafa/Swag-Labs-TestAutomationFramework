package com.swagLabs.pages;

import com.swagLabs.utils.browserActions;
import com.swagLabs.utils.elementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.swagLabs.utils.browserActions.*;

public class loginPage {

    //Variables
    private final WebDriver driver;
    //Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    //Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }


    //Navigation
    public void navigateToLoginPage() {
        openBrowser(driver, "https://www.saucedemo.com/");
    }

    //Actions
    //Methods -> wait -> scroll -> sendKeys ->

    public loginPage enterUsername(String user) {
        elementActions.sendData(driver, username, user);
        return this;
    }

    public loginPage enterPassword(String pass) {
        elementActions.sendData(driver, password, pass);
        return this;
    }

    public loginPage clickLoginButton() {
        elementActions.clickElement(driver, loginButton);
        return this;
    }


    //Validation
    public void successfulLogin() {
        //Add validation for successful login
        //This can be done by checking the URL or checking for the presence of a specific element on the page
        //For example, checking if the URL contains "inventory.html"
        Assert.assertEquals(browserActions.getCurrentUrl(driver), ("https://www.saucedemo.com/inventory.html"));
    }


    public void unsuccessfulLogin() {
        //Add validation for unsuccessful login
        //This can be done by checking the URL or checking for the presence of a specific element on the page
        //For example, checking if the URL contains "inventory.html"
        Assert.assertEquals(elementActions.getText(driver, errorMessage), "Epic sadface: Username and password do not match any user in this service");
    }


}
