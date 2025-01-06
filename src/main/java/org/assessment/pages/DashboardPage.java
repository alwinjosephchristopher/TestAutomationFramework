package org.assessment.pages;

import org.assessment.framewokFunctions.BaseTest;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage implements BaseTest {

    WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardLabel;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement userProfileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;



    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyRedirectedToDashboard() {
        Assert.assertTrue(dashboardLabel.isDisplayed());
    }

    public void verifyWidgetsOfDashboardPage(String widgets) throws UserException {
        String[] widgetHeaders = widgets.split(",");

        for (String widget : widgetHeaders) {
            String xpath = "//div[contains(@class,'orangehrm-dashboard-grid')]//p[normalize-space()='" + widget.trim() + "']";

            WebElement widgetElement = driver.findElement(By.xpath(xpath));
            Assert.assertTrue(widgetElement.isDisplayed());
        }
        screenShotUtil.captureScreenshot("DashboardPage");
    }

    public void logout() throws UserException {
        inputUtil.click(userProfileDropdown);
        screenShotUtil.captureScreenshot("BEFORE_LOGOUT");
        inputUtil.click(logout);
    }

}
