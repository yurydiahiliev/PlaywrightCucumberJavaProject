package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.playwright.cucumber.core.Configuration;
import lombok.AllArgsConstructor;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class TextCondition implements Condition {

    private final String expectedText;

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasText(
            expectedText,
            new LocatorAssertions.HasTextOptions().setTimeout(Configuration.defaultTimeout).setIgnoreCase(false));
    }
}