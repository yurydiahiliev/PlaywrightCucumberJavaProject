package com.playwright.cucumber.step_definitions;

import com.playwright.cucumber.core.conditions.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.playwright.cucumber.core.PlaywrightActions.$;
import static com.playwright.cucumber.core.PlaywrightActions.open;

public class SimpleStepDef {

    @Given("I open google page")
    public void i_open_google_page() {
        open("http://google.com");
    }

    @When("Trying to search")
    public void trying_to_search() {
        $("[name=q]").fill("Playwright Demo").pressEnter();
    }

    @And("Click on the first link")
    public void click_on_the_first_link() {
        $("a h3").first().click();
    }

    @Then("We are checking banner text")
    public void we_are_checking_banner_text() {
        $("text=Get Started").shouldHas(Condition.attribute("href", "/docs/intro"));
    }
}