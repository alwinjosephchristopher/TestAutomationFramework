package org.assessment.framewokFunctions;

import org.assessment.framewokFunctions.utility.InputUtil;
import org.assessment.framewokFunctions.utility.ScreenshotUtil;

/**
 * BaseTest interface which holds all reusable utils in ready state that could be used in POMs
 */
public interface BaseTest {
   InputUtil inputUtil = new InputUtil();
   ScreenshotUtil screenShotUtil = new ScreenshotUtil();
}
