package org.assessment.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assessment.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username and password")
    public void enterValidCredentials() {
        loginPage.login("Admin", "admin123");
    }

    @Then("I should be redirected to the dashboard")
    public void verifyDashboard() {
        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
