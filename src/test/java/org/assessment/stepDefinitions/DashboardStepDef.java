package org.assessment.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assessment.framewokFunctions.utility.WebDriverUtil;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.assessment.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardStepDef {

    WebDriver driver = WebDriverUtil.getDriver();
    DashboardPage dashboardPage;

    public DashboardStepDef() throws UserException {
        dashboardPage = new DashboardPage(driver);
    }

    @Then("I should be redirected to the dashboard")
    public void verifyDashboard() throws UserException {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyRedirectedToDashboard();
    }

    @And("I should see following widgets in dashboard")
    public void iShouldSeeFollowingWidgetsInDashboard(String widgets) throws UserException {
        dashboardPage.verifyWidgetsOfDashboardPage(widgets);
    }

}
