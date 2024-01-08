package com.playwright.tests;


import com.playwright.cucumber.core.testng.listeners.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
@CucumberOptions(
        features = {"@target/failed_scenarios.txt"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        glue = {"com.playwright.cucumber.step_definitions"}
)
public class ReRunRunner extends AbstractTestNGCucumberTests {
}
