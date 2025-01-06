package org.assessment.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assessment.framewokFunctions.utility.WebDriverUtil;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.assessment.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Step definitions related to the functionalities of Login page
 */
public class LoginPageStepDef {

    private static final Logger log = LoggerFactory.getLogger(LoginPageStepDef.class);
    WebDriver driver;
    LoginPage loginPage;

    public LoginPageStepDef() throws UserException {
    }

    @Given("I am on the login page")
    public void navigateToLoginPage() throws UserException {
        driver= WebDriverUtil.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplayed();
    }

    @When("I enter valid {string} and {string}")
    public void enterValidCredentials(String username, String password) throws UserException {
        loginPage.loginWithCredentials(username, password);
    }

    @When("I enter invalid {string} and {string}")
    public void enterInValidCredentials(String username, String password) throws UserException {
        loginPage.loginWithCredentials(username, password);
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String errorMessage) throws UserException {
        loginPage.verifyErrorMessage(errorMessage);
    }

    @When("I click on the {string} link")
    public void performAction(String action) throws UserException {
        loginPage.performAction(action);
    }

    @And("close the browser")
    public void closeBrowser() {
        WebDriverUtil.closeDriver();
    }

    @Then("I should see error message for all mandatory fields")
    public void verifyMandatoryFields() {
        loginPage.verifyErrorForBothMandatoryFields();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() throws UserException {
        loginPage.verifyLoginPageDisplayed();
    }

    @Given("I navigate to the dashboard page without logging in")
    public void iNavigateToTheDashboardPageWithoutLoggingIn() throws UserException {
        driver= WebDriverUtil.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        loginPage = new LoginPage(driver);
    }
}
