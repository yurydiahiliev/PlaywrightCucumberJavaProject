package com.playwright.cucumber.core;

import com.microsoft.playwright.*;
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