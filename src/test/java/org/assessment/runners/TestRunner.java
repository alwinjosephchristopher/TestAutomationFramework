package org.assessment.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/resources/features"},
        //tags = "@test",
        glue={"org.assessment.stepDefinitions","org.assessment.hooks"},
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        System.out.println("Started tests");
    }

    @AfterClass
    public static void teardown() throws UserException {
        //CucumberReportGenerator reportGenerator = new CucumberReportGenerator();
        //reportGenerator.generateReport();
    }
}
