package com.playwright.cucumber.core;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;

public class PlaywrightActions {

    public static void open(String url) {
        getCurrentPage().navigate(url);
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

    public static LocatorActions $(String selector) {
        return find(selector);
    }

    public static LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public static void waitForUrl(String expectedUrl) {
        getCurrentPage().waitForURL(expectedUrl);
    }

    public static void clearCookies() {
        getCurrentBrowserContext().clearCookies();
    }

    public PlaywrightActions newTab() {
        getCurrentBrowserContext().newPage();
        return this;
    }

    private static Page getCurrentPage() {
        return PlaywrightRunner.get().getPage();
    }

    private static BrowserContext getCurrentBrowserContext() {
        return PlaywrightRunner.get().getBrowserContext();
    }

    public byte[] getScreenshot() {
        return getCurrentPage().screenshot();
    }

    public byte[] getScreenshot(Page.ScreenshotOptions options) {
        return getCurrentPage().screenshot(options);
    }
}