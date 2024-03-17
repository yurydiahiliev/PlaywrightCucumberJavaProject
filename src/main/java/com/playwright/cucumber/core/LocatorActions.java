package com.playwright.cucumber.core;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.playwright.cucumber.core.conditions.Condition;
import com.playwright.cucumber.core.conditions.network.NetworkCondition;

import java.util.List;

public record LocatorActions(Locator locator) {

    public LocatorActions find(String locator) {
        return PlaywrightActions.find(locator);
    }

    public LocatorActions find(String locator, String filterWithText) {
        return PlaywrightActions.find(locator, filterWithText);
    }

    public LocatorActions $(String selector) {
        return find(selector);
    }

    public LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public LocatorActions f(String selector) {
        return find(selector);
    }


    public LocatorActions role(AriaRole role) {
        return PlaywrightActions.role(role);
    }

    public LocatorActions role(AriaRole role, String filterWithText) {
        return PlaywrightActions.role(role, filterWithText);
    }

    public LocatorActions clear() {
        locator.clear();
        return this;
    }

    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    public LocatorActions fill(String text, NetworkCondition fillConditions) {
        fillConditions.wait(() -> locator.fill(text));
        return this;
    }

    public LocatorActions parent() {
        locator.locator("..");
        return this;
    }

    public LocatorActions closest(String ancestor) {
        locator.locator("//ancestor::" + ancestor);
        return this;
    }

    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    public LocatorActions pressEnter() {
        locator.press("Enter");
        return this;
    }

    public LocatorActions click() {
        locator.click();
        return this;
    }

    public LocatorActions click(NetworkCondition clickConditions) {
        clickConditions.wait(locator::click);
        return this;
    }

    public LocatorActions clickWithNewPage() {
        var newPage = PlaywrightRunner.pw().getBrowserContext().waitForPage(locator::click);
        PlaywrightRunner.pw().setPage(newPage);
        return this;
    }

    public String textContent() {
        return locator.textContent();
    }

    public String innerText() {
        return locator.innerText();
    }

    public String innerHTML() {
        return locator.innerHTML();
    }

    public String getAttribute(String attributeName) {
        return locator.getAttribute(attributeName);
    }

    public LocatorActions shouldBe(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions should(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions shouldHave(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions shouldHas(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions first() {
        locator.first();
        return this;
    }

    public LocatorActions last() {
        locator.last();
        return this;
    }

    public LocatorActions nth(int index) {
        locator.nth(index);
        return this;
    }

    public List<Locator> all() {
        return locator.all();
    }

    public int size() {
        return all().size();
    }
}