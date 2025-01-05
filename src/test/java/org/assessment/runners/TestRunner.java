package org.assessment.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.assessment.reporting.CucumberReportGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/resources/features"},
        //tags = "as",
        glue={"org.assessment.stepDefinitions"},
        plugin = {"pretty",
                "json:target/cucumber-report.json",
                "junit:target/cucumber.xml"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        System.out.println("Started tests");
    }

    @AfterClass
    public static void teardown() {
        CucumberReportGenerator.generateReport();
    }
}
