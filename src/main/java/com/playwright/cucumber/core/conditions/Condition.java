package com.playwright.cucumber.core.conditions;

import com.microsoft.playwright.Locator;

public interface Condition {

    Condition visible = new VisibleCondition();
    Condition hidden = new IsHiddenCondition();
    Condition checked = new CheckedCondition();
    Condition disabled = new DisabledCondition();

    static Condition visibleUntil(Integer maxTimeout) {
        return new VisibleUntil(maxTimeout);
    }

    static Condition text(String expectedText) {
        return new TextCondition(expectedText);
    }

    static Condition texts(String... expectedTexts) {
        return new TextsCondition(expectedTexts);
    }

    static Condition value(String expectedValue) {
        return new ValueCondition(expectedValue);
    }

    static Condition count(int expectedCount) {
        return new HasCountCondition(expectedCount);
    }

    static Condition attribute(String attributeName, String expectedValue) {
        return new AttributeCondition(attributeName, expectedValue);
    }

    static Condition className(String expectedClassName) {
        return new ClassCondition(expectedClassName);
    }

    void verify(Locator locator);
}