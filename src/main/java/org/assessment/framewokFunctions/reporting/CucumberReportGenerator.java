package org.assessment.framewokFunctions.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.assessment.framewokFunctions.utility.FileUtility;
import org.assessment.framewokFunctions.utility.PropertiesFileHandler;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class CucumberReportGenerator {
    public final String INPUT_DIR = System.getProperty("user.dir") + "/target/cucumber-reports/";
    public String outputDir = System.getProperty("user.dir") + "/report";
    public String projectName = "Test Automation Framework";

    /**
     * Function generates cucumber pretty report from json report of TestNg
     */
    public void generateReport() throws UserException {
        // get list of json files
        FileUtility fileUtility = new FileUtility();
        List<String> jsonFiles = fileUtility.getAllFiles(INPUT_DIR, ".json");
        // make report output directories
        File output = new File(outputDir);
        output.mkdirs();
        PropertiesFileHandler prop = new PropertiesFileHandler("config.properties");

        // set configuration for reports.
        Configuration config = new Configuration(output, projectName);
        // set classification information for report from config files
        config.addClassifications("APP URI", prop.getValue("APP_URI"));
        config.addClassifications("OS", prop.getValue("OS"));
        config.addClassifications("BUILD", prop.getValue("BUILD"));

        // generate report
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        Reportable re = reportBuilder.generateReports();

        // rename output report folder with timestamp
        File outputFolder = new File(outputDir+"/cucumber-html-reports");
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Timestamp(new Date().getTime()));

        File newFolder = new File(outputDir+"/cucumber-html-reports"+timeStamp);
        outputFolder.renameTo(newFolder);

        System.out.println("--------Cucumber Test Scenario Stats--------");
        System.out.println("*** Passed Scenarios : "+re.getPassedScenarios());
        System.out.println("*** Failed Scenarios : "+re.getFailedScenarios());
        System.out.println("*** Total Scenarios : "+(re.getFailedScenarios()+re.getPassedScenarios()));
        System.out.println("--------------------------------------------");



    }
}
