package com.playwright.cucumber.core.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true,
    glue = {"com.playwright.cucumber.step_definitions"},
    tags = "@smoke"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    // to enable parallel tests, change @DataProvider(parallel=true)
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}