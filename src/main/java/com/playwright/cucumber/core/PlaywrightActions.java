package com.playwright.cucumber.core;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;

public class PlaywrightActions {

    public static void open(String url) {
        getCurrentPage().navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));
    }

    public static Response goBack() {
        return getCurrentPage().goBack();
    }

    public static LocatorActions find(String selector) {
        return new LocatorActions(getCurrentPage().locator(selector).first());
    }

    public static LocatorActions find(String selector, String withText) {
        return new LocatorActions(getCurrentPage().locator(selector).filter(new Locator.FilterOptions().setHasText(withText)).first());
    }

    public static LocatorActions findByAltText(String altText) {
        return new LocatorActions(getCurrentPage().getByAltText(altText));
    }

    public static LocatorActions $(String selector) {
        return find(selector);
    }

    public static LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public static LocatorActions role(AriaRole role) {
        return new LocatorActions(getCurrentPage().getByRole(role));
    }

    public static LocatorActions role(AriaRole role, String withAccessibilityName) {
        return new LocatorActions(getCurrentPage().getByRole(role, new Page.GetByRoleOptions().setName(withAccessibilityName)));
    }

    public static LocatorActions testId(String testIdValue) {
        return new LocatorActions(getCurrentPage().getByTestId(testIdValue));
    }

    public static LocatorActions byText(String textInElement) {
        return new LocatorActions(getCurrentPage().getByText(textInElement));
    }

    public static LocatorActions text(String text, boolean caseSensitive) {
        return new LocatorActions(getCurrentPage().getByText(text, new Page.GetByTextOptions().setExact(caseSensitive)));
    }

    public static LocatorActions label(String labelValue) {
        return new LocatorActions(getCurrentPage().getByLabel(labelValue));
    }

    public static LocatorActions placeholder(String placeholderValue) {
        return new LocatorActions(getCurrentPage().getByPlaceholder(placeholderValue));
    }

    public static LocatorActions findAll(String selector) {
        return new LocatorActions(getCurrentPage().locator(selector));
    }

    public static LocatorActions $$(String selector) {
        return findAll(selector);
    }

    public static void waitForUrl(String expectedUrl) {
        try {
            getCurrentPage().waitForURL(expectedUrl);
        } catch (PlaywrightException e) {
            throw new PlaywrightException("Expected page to have: '" + expectedUrl + "' but was:\n" + getCurrentPage().url());
        }
    }

    public static void clearCookies() {
        getCurrentBrowserContext().clearCookies();
    }

    public PlaywrightActions newTab() {
        getCurrentBrowserContext().newPage();
        return this;
    }

    private static Page getCurrentPage() {
        return PlaywrightRunner.pw().getPage();
    }

    private static BrowserContext getCurrentBrowserContext() {
        return PlaywrightRunner.pw().getBrowserContext();
    }

    public static byte[] getScreenshot() {
        return getCurrentPage().screenshot();
    }

    public static byte[] getScreenshot(Page.ScreenshotOptions options) {
        return getCurrentPage().screenshot(options);
    }

    public static List<Page> getActiveTabs() {
        return getCurrentBrowserContext().pages();
    }

    public static void switchToTab(int index) {
        PlaywrightRunner.pw().setPage(getCurrentBrowserContext().pages().get(index));
    }

    public static void closeActiveTab() {
        getCurrentPage().close();
        switchToTab(getActiveTabs().size() - 1);
    }
}