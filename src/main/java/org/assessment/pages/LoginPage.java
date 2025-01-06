package org.assessment.pages;

import org.assessment.framewokFunctions.BaseTest;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage implements BaseTest {

    WebDriver driver;
    @FindBy(name = "username")
    WebElement usernameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//p[normalize-space()='Forgot your password?']")
    WebElement forgetPasswordButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement invalidError;
    @FindBy(xpath = "//label[text()='Username']/../..//span[text()='Required']")
    WebElement userNameRequiredError;
    @FindBy(xpath = "//label[text()='Password']/../..//span[text()='Required']")
    WebElement passwordRequiredError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageDisplayed() throws UserException {
        screenShotUtil.captureScreenshot("LoginPage");
        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(loginButton.isDisplayed());
    }

    public void enterDetails(String field, String value) throws UserException {
        switch (field.toLowerCase().trim()) {
            case "username" :
                inputUtil.enterText(usernameField, value);
                break;
            case "password" :
                inputUtil.enterText(passwordField, value);
                break;
            default:
                throw new UserException("Invalid field to enter data in Login page");
        }
    }

    public void performAction(String action) throws UserException {
        switch (action.toLowerCase().trim()) {
            case "login" :
                inputUtil.click(loginButton);
                break;
            case "forgot your password?" :
                inputUtil.click(forgetPasswordButton);
                break;
            default:
                throw new UserException("Invalid action to perform in Login page");
        }
    }

    public void loginWithCredentials(String username, String password) throws UserException {
        enterDetails("username", username);
        enterDetails("password", password);

        screenShotUtil.captureScreenshot("LoginPage");

        performAction("login");
    }

    public void verifyErrorMessage(String errorMessage) throws UserException {
        assertTrue(invalidError.isDisplayed());
        assertEquals(invalidError.getText(), errorMessage);
        screenShotUtil.captureScreenshot("LoginError");
    }

    public void verifyErrorForBothMandatoryFields() {
        assertTrue(userNameRequiredError.isDisplayed());
        assertTrue(passwordRequiredError.isDisplayed());
    }




}
