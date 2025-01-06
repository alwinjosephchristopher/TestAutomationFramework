package org.assessment.framewokFunctions.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * This class provides different kinds of input actions user can do in Web UI using selenium web driver.
 * these methods are reusable for any webpages
 */
public class InputUtil extends WebDriverUtil{

    /** Method to enter text into text field
     * @param text : String : Text value to enter in field
     */
    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /** Method to clear text of text field
     */
    public void clearText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public void click(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public void javaScriptClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
    }

    public void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }

    /** Method to select element from Dropdown by type
     * @param selectList : Select : Select variable
     * @param byType : String : Name of by type
     * @param option : String : Option to select
     */
    public void selectElementFromDropdownByType (Select selectList, String byType, String option) {
        if (byType.equals("selectByIndex")) {
            int index = Integer.parseInt(option);
            selectList.selectByIndex(index - 1);
        } else if (byType.equals("value"))
            selectList.selectByValue(option);
        else if (byType.equals("text"))
            selectList.selectByVisibleText(option);
    }

    public void deselectOptionFromDropdown(WebElement dropdown, String optionBy, String option) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select selectList = new Select(dropdown);

        if(optionBy.equals("selectByIndex"))
            selectList.deselectByIndex(Integer.parseInt(option)-1);
        else if (optionBy.equals("value"))
            selectList.deselectByValue(option);
        else if (optionBy.equals("text"))
            selectList.deselectByVisibleText(option);
    }

    public void checkCheckbox(WebElement checkbox)  {
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public void uncheckCheckbox(WebElement checkbox) {
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        if (checkbox.isSelected())
            checkbox.click();
    }

    public void toggleCheckbox(WebElement checkbox) {
        wait.until(ExpectedConditions.visibilityOf(checkbox)).click();
    }

    public void selectRadioButton(WebElement radioButton) {
        wait.until(ExpectedConditions.visibilityOf(radioButton));
        if(!radioButton.isSelected())
            radioButton.click();
    }

    public void selectOptionFromRadioButtonGroup(By locator, String selectBy, String option)  {
        List<WebElement> radioButtonGroup = driver.findElements(locator);
        for(WebElement rb : radioButtonGroup)
        {
            if(selectBy.equals("value"))
            {
                if(rb.getAttribute("value").equals(option) && !rb.isSelected())
                    rb.click();
            }
            else if(selectBy.equals("text"))
            {
                if(rb.getText().equals(option) && !rb.isSelected())
                    rb.click();
            }
        }
    }

    public void handleAlert(String decision)  {
        if(decision.equals("accept"))
            driver.switchTo().alert().accept();
        else
            driver.switchTo().alert().dismiss();
    }
}
