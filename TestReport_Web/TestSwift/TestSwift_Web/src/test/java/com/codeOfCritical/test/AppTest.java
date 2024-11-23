package com.codeOfCritical.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "../TestSwift_Web/src/main/java/com/codeOfCritical/featureFile", glue = {
        "com.codeOfCritical"}, // the path of the step definition files
        plugin = {"pretty", "html:test-outout/x.html", "json:json_output/cucumber.json",
                "junit:junit_xml/cucumber.xml",
                "com.codeOfCritical.CucumberExtentReport.adapter.ExtentCucumberAdapter:"}, monochrome = true, // display

        strict = true, // it will check if any step is not defined in step definition file
        dryRun = false, // to check the mapping is proper between feature file and step def file

        tags = "@t1")
public class AppTest {

}
