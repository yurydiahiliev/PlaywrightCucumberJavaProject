package com.playwright.tests;

import com.playwright.cucumber.core.testng.listeners.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:target/failed_scenarios.txt"},
    monochrome = true,
    glue = {"com.playwright.cucumber.step_definitions"},
    tags = "@smoke"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    // to enable parallel tests, change @DataProvider(parallel=true)
    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}