package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.playwright.cucumber.core.Configuration;
import lombok.AllArgsConstructor;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class HasCountCondition implements Condition {

    private final int expectedCount;

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasCount(expectedCount, new LocatorAssertions.HasCountOptions().setTimeout(Configuration.defaultTimeout));
    }
}