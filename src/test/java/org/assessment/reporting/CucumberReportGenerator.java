package org.assessment.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReportGenerator {

    public static void generateReport() {
        File reportOutputDirectory = new File("target/pretty-cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report.json"); // Path to the JSON report

        String projectName = "My Test Project";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "main");
        configuration.addClassifications("Environment", "QA");


        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
