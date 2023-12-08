package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.playwright.cucumber.core.Configuration;
import lombok.AllArgsConstructor;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class ClassCondition implements Condition {

    private final String expectedClassName;

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasClass(
            expectedClassName,
            new LocatorAssertions.HasClassOptions().setTimeout(Configuration.defaultTimeout));
    }
}