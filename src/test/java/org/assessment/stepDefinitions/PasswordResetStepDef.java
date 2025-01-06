package org.assessment.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.assessment.framewokFunctions.utility.WebDriverUtil;
import org.assessment.pages.PasswordResetPage;
import org.openqa.selenium.WebDriver;

public class PasswordResetStepDef {

    WebDriver driver = WebDriverUtil.getDriver();
    PasswordResetPage passwordResetPage;

    public PasswordResetStepDef() throws UserException {
        passwordResetPage = new PasswordResetPage(driver);
    }

    @Then("I should be redirected to password reset page")
    public void verifyResetPasswordPagePresent() throws UserException {
        passwordResetPage.verifyPageIsDisplayed();
    }

    @When("I click {string} button on password reset page")
    public void iClickButtonOnPasswordResetPage(String action) throws UserException {
        passwordResetPage.performAction(action);
    }
}
