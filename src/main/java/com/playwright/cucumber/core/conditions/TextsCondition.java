package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextsCondition implements Condition {
    private final String[] expectedTexts;

    public TextsCondition(String[] expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public void verify(Locator locator) {
        assertThat(locator).containsText(expectedTexts);
    }
}