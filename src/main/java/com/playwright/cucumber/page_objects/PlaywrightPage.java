package com.playwright.cucumber.page_objects;

import com.playwright.cucumber.core.LocatorActions;
import com.playwright.cucumber.core.conditions.Condition;
import io.qameta.allure.Step;

import static com.playwright.cucumber.core.PlaywrightActions.$;
import static com.playwright.cucumber.core.PlaywrightActions.findByAltText;

public class PlaywrightPage {

    private LocatorActions getStartedButton = $("text=Get Started");

    @Step
    public PlaywrightPage checkPlaywrightPageGetStartedButton() {
        getStartedButton.shouldHas(Condition.attribute("href", "/docs/intro"));
        return this;
    }

    @Step
    public PlaywrightPage clickOnGetStartedButton() {
        getStartedButton.click();
        return this;
    }

    @Step
    public PlaywrightPage clickOnHowToRunTheExampleTest() {
        $("text=How to run the example test").click();
        return this;
    }

    @Step
    public PlaywrightPage checkImageForTestsRunningInCommandLine() {
        findByAltText("tests running in command line").shouldBe(Condition.visible);
        return this;
    }
}