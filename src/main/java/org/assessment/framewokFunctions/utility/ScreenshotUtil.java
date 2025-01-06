package org.assessment.framewokFunctions.utility;

import org.apache.commons.io.FileUtils;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotUtil extends WebDriverUtil{
    public final String OUTPUT_DIR = System.getProperty("user.dir") + "/target/screenshots/";

    /** Method to take screen shot and save in ./Screenshots folder*/
    public void captureScreenshot(String page) throws UserException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();

        File destination = new File(OUTPUT_DIR + page+dateFormat.format(cal.getTime())+".png");

        try {
            FileUtils.copyFile(scrFile, destination);
        } catch (IOException e) {
            throw new UserException("IO Exception during screenshot " + e.getMessage());
        }
    }
}
