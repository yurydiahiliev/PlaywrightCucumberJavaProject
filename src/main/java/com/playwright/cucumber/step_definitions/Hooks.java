package com.playwright.cucumber.step_definitions;

import com.microsoft.playwright.Page;
import com.playwright.cucumber.core.PlaywrightActions;
import com.playwright.cucumber.core.PlaywrightRunner;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static io.qameta.allure.Allure.addAttachment;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            attachScreenshotToAllureReport(scenario);
        }
    }

    @AfterAll
    public static void tearDown() {
        PlaywrightRunner.clearSessions();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private void attachScreenshotToAllureReport(Scenario scenario) {
        String resultName = scenario.getName() + "_" + UUID.randomUUID();
        Path screenshotPath = Paths.get("./target/screenshots/" + resultName + ".png");
        addAttachment(resultName, new ByteArrayInputStream(PlaywrightActions.getScreenshot(new Page.ScreenshotOptions().setPath(screenshotPath))));
    }
}
