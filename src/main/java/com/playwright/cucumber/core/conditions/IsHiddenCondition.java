package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.playwright.cucumber.core.Configuration;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(Locator locatorActions) {
        PlaywrightAssertions.assertThat(locatorActions)
                            .isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(Configuration.defaultTimeout));
    }
}