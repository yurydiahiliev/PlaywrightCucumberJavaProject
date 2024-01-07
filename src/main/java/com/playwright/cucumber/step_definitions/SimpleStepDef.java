package com.playwright.cucumber.step_definitions;

import com.playwright.cucumber.page_objects.GoogleSearchPage;
import com.playwright.cucumber.page_objects.PlaywrightPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleStepDef {

    private GoogleSearchPage googleSearchPage;

    private PlaywrightPage playwrightPage;

    public SimpleStepDef(GoogleSearchPage googleSearchPage, PlaywrightPage playwrightPage) {
        this.googleSearchPage = googleSearchPage;
        this.playwrightPage = playwrightPage;
    }

    @Given("I open google page")
    public void i_open_google_page() {
        googleSearchPage.openGoogleSearchPage();
    }

    @When("Trying to search")
    public void trying_to_search() {
        googleSearchPage.search("Playwright Demo");
    }

    @And("Click on the first link")
    public void click_on_the_first_link() {
        googleSearchPage.clickOnFirstSearchResult();
    }

    @Then("We are checking banner text")
    public void we_are_checking_banner_text() {
        playwrightPage.checkPlaywrightPageGetStartedButton();
    }

    @And("Click on 'Get Started' button")
    public void click_on_get_started_button() {
        playwrightPage.clickOnGetStartedButton();
    }

    @And("Click on 'How to run the example test' button")
    public void click_on_how_to_run_the_example_test_button() {
        playwrightPage.clickOnHowToRunTheExampleTest();
    }

    @Then("Check img commandline")
    public void check_img_commandline() {
        playwrightPage.checkImageForTestsRunningInCommandLine();
    }
}