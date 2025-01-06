package org.assessment.pages;

import org.assessment.framewokFunctions.BaseTest;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Page Object Model(POM) functionalities  related to the functionalities of Password Reset page
 */
public class PasswordResetPage implements BaseTest {
    WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Reset Password']")
    WebElement resetPasswordHead;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement resetPasswordButton;

    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPageIsDisplayed() throws UserException {
        Assert.assertTrue(resetPasswordHead.isDisplayed());
        screenShotUtil.captureScreenshot("ResetPassword");
    }

    public void performAction(String action) throws UserException {
        switch (action.toLowerCase().trim()) {
            case "cancel" :
                inputUtil.click(cancelButton);
                break;
            case "reset password" :
                inputUtil.click(resetPasswordButton);
                break;
            default:
                throw new UserException("Invalid action to perform in Reset Password page");
        }
    }
}
