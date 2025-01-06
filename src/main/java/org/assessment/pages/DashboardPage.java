package org.assessment.pages;

import org.assessment.framewokFunctions.BaseTest;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class DashboardPage implements BaseTest {

    WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardLabel;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyRedirectedToDashboard() {
        Assert.assertTrue(dashboardLabel.isDisplayed());
    }

    public void verifyWidgetsOfDashboardPage(String widgets) throws UserException {
        List<String> widgetHeaders = Arrays.asList(widgets.split(","));

        for (String widget : widgetHeaders) {
            String xpath = "//div[contains(@class,'orangehrm-dashboard-grid')]//p[normalize-space()='" + widget.trim() + "']";

            WebElement widgetElement = driver.findElement(By.xpath(xpath));
            Assert.assertTrue(widgetElement.isDisplayed());
        }
        screenShotUtil.captureScreenshot("DashboardPage");
    }

}
