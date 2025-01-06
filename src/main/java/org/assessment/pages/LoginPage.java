package org.assessment.pages;

import org.assessment.framewokFunctions.BaseTest;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Page Object Model(POM) functionalities  related to the functionalities of Login page
 */
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

    /**
     * Verifies if user had landed on login page
     * @throws UserException for any failures
     */
    public void verifyLoginPageDisplayed() throws UserException {
        screenShotUtil.captureScreenshot("LoginPage");
        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(loginButton.isDisplayed());
    }

    /**
     * This generic function helps to enter values in the fields of login page
     * @param field label of field
     * @param value value to be entered
     * @throws UserException
     */
    public void enterDetails(String field, String value) throws UserException {
        switch (field.toLowerCase().trim()) {
            case "username" :
                inputUtil.enterText(usernameField, value);
                break;
            case "password" :
                inputUtil.enterText(passwordField, value);
                break;
            default:
                throw new UserException("Invalid field to enter data in Login page, field=" + field);
        }
    }

    /**
     * Performs user required action on login page
     * @param action to be performed like clicking login or forgot password button
     * @throws UserException
     */
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

    /**
     * enters credentials and performs login action
     * @param username username
     * @param password password
     */
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
