package org.assessment.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.assessment.framewokFunctions.utility.FileUtility;
import org.assessment.framewokFunctions.utility.WebDriverUtil;

public class Hooks {
    public final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/target/screenshots/";
    private LocalDateTime startTime;

    @Before
    public void before(Scenario scenario) {
        this.startTime = LocalDateTime.now();
        System.out.println("Scenario Started: "+scenario.getName());
    }

    @After
    public void after(Scenario scenario) throws UserException {
        WebDriverUtil.closeDriver();
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.  between(startTime, endTime);
        System.out.println("##########Total Execution Time: " + duration.toHours() + ":"+
                duration.toMinutes() + ":" + duration.getSeconds());

        FileUtility fileUtility = new FileUtility();
        List<String> screenshots = fileUtility.getAllFiles(SCREENSHOT_DIR, ".png");

        for(String screenshot : screenshots) {
            File file = new File(screenshot);
            try {
                scenario.attach(Files.readAllBytes(file.toPath()), "image/png", "Screenshot");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            file.delete();
        }
    }

}