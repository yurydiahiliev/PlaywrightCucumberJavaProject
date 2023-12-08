package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AttributeCondition implements Condition {
    private final String attributeName;
    private final String expectedValue;

    public AttributeCondition(String attributeName, String expectedValue) {
        this.attributeName = attributeName;
        this.expectedValue = expectedValue;
    }

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasAttribute(attributeName, expectedValue);
    }
}