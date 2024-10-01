package com.loginTest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/loginTest/features/verifyPatientData.feature",
        glue = "com.loginTest.stepdefinitions",
        plugin = {"pretty", "html:Cucumber_Reports/cucumber-reports.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
