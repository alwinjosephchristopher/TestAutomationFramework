package org.assessment.framewokFunctions.utility;

import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateUtil extends WebDriverUtil{

    String oldWindowHandle;
    String lastWinHandle;

    /** Method to navigate back & forward
     * @param direction : String : Navigate to forward or backward
     */
    public void navigate(String direction) {
        if (direction.equals("back"))
            driver.navigate().back();
        else
            driver.navigate().forward();
    }


    /** Method to resize browser
     * @param width : int : Width for browser resize
     * @param height : int : Height for browser resize
     */
    public void resizeBrowser(int width, int height) {
        driver.manage().window().setSize(new Dimension(width,height));
    }


    /** Method to hover on element
     */
    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).perform();
    }

    /** Method to scroll page to particular element
     */
    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /** Method to scroll page to top or end
     * @param to : String : Scroll page to Top or End
     */
    public void scrollPage(String to) throws UserException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        if (to.equals("end"))
            executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        else if (to.equals("top"))
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
        else
            throw new UserException("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
    }

    /**Method to switch to new window */
    public void switchToNewWindow()
    {
        oldWindowHandle = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
            lastWinHandle = winHandle;
        driver.switchTo().window(lastWinHandle);
    }

    /** Method to switch to old window */
    public void switchToOldWindow()
    {
        driver.switchTo().window(oldWindowHandle);
    }

    /** Method to switch to window by title
     * @param windowTitle : String : Name of window title to switch
     */
    public void switchToWindowByTitle(String windowTitle) throws UserException {
        oldWindowHandle = driver.getWindowHandle();
        boolean winFound = false;
        for(String winHandle : driver.getWindowHandles())
        {
            String str = driver.switchTo().window(winHandle).getTitle();
            if (str.equals(windowTitle))
            {
                winFound = true;
                break;
            }
        }
        if (!winFound)
            throw new UserException("Window having title "+windowTitle+" not found");
    }

    /** Method to switch frame using web element frame
     * */
    public void switchFrame(WebElement frame, String locator) {
        if(null != locator)
            driver.switchTo().frame(locator);
        else
        {
            wait.until(ExpectedConditions.visibilityOf(frame));
            driver.switchTo().frame(frame);
        }
    }

    /** method to switch to default content*/
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
