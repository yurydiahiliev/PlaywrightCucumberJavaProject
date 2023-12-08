package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ValueCondition implements Condition {
    private final String expectedValue;

    public ValueCondition(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasValue(expectedValue);
    }
}