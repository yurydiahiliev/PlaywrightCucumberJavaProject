package com.playwright.cucumber.step_definitions;

import com.playwright.cucumber.core.PlaywrightRunner;
import io.cucumber.java.AfterAll;

public class Hooks {

    @AfterAll
    public static void tearDown() {
        PlaywrightRunner.clearSessions();
    }
}
