package org.assessment.framewokFunctions;

import io.cucumber.java.sl.In;
import org.assessment.framewokFunctions.utility.InputUtil;
import org.assessment.framewokFunctions.utility.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BaseTest {
   InputUtil inputUtil = new InputUtil();
   ScreenshotUtil screenShotUtil = new ScreenshotUtil();
}
