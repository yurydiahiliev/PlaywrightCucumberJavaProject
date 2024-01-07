package com.playwright.cucumber.page_objects;

import io.qameta.allure.Step;

import static com.playwright.cucumber.core.PlaywrightActions.$;
import static com.playwright.cucumber.core.PlaywrightActions.open;

public class GoogleSearchPage {

    @Step
    public GoogleSearchPage openGoogleSearchPage() {
        open("http://google.com");
        return this;
    }

    @Step
    public GoogleSearchPage search(String text) {
        $("[name=q]").fill(text).pressEnter();
        return this;
    }

    @Step
    public PlaywrightPage clickOnFirstSearchResult() {
        $("a h3").click();
        return new PlaywrightPage();
    }
}