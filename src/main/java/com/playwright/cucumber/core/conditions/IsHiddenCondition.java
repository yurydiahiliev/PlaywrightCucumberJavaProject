package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.playwright.cucumber.core.Configuration;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(Locator locatorActions) {
        assertThat(locatorActions).isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(Configuration.defaultTimeout));
    }
}