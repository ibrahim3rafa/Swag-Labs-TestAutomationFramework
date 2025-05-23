package com.swagLabs.pages;

import com.swagLabs.utils.browserActions;
import com.swagLabs.utils.customSoftAssertions;
import com.swagLabs.utils.elementActions;
import com.swagLabs.utils.validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.swagLabs.utils.browserActions.*;
import static com.swagLabs.utils.customSoftAssertions.softAssertions;

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


    public loginPage softAssertLoginURL() {
        customSoftAssertions.softAssertions.assertEquals(browserActions.getCurrentUrl(driver), ("https://www.saucedemo.com/inventory.html"), "Login failed URL not matched");
        return this;
    }


    //soft assert title
    public loginPage softAssertLoginTitle() {
        customSoftAssertions.softAssertions.assertEquals(browserActions.getTitle(driver), ("Swag Labs"), "Login failed title not matched");
        return this;
    }

    //soft assert successful login
    public loginPage softAssertSuccessfulLogin() {
        softAssertLoginURL().softAssertLoginTitle();
        return this;
    }

    //Validation
    public loginPage successfulLogin() {
        //Add validation for successful login
        //This can be done by checking the URL or checking for the presence of a specific element on the page
        //For example, checking if the URL contains "inventory.html"
        validations.validateEquals(browserActions.getCurrentUrl(driver), ("https://www.saucedemo.com/inventory.htmlk"), "Login failed");
        return this;
    }


    public loginPage unsuccessfulLogin() {
        //Add validation for unsuccessful login
        //This can be done by checking the URL or checking for the presence of a specific element on the page
        //For example, checking if the URL contains "inventory.html"
        validations.validateEquals(elementActions.getText(driver, errorMessage), "Epic sadface: Username and password do not match any user in this service", "Login failed");
        return this;
    }
}
