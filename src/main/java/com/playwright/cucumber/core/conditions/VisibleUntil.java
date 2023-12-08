package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VisibleUntil implements Condition {
    private final Integer maxTimeout;

    public VisibleUntil(Integer maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    @Override
    public void verify(Locator locator) {
        assertThat(locator).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(maxTimeout));
    }
}