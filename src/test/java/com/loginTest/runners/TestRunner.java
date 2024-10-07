package com.loginTest.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/loginTest/features"},
        glue = {"com.loginTest.stepdefinitions", "com.loginTest.AppHooks"},

        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:Cucumber_Reports/cucumber-reports.html"
        }


)

public class TestRunner {

}
