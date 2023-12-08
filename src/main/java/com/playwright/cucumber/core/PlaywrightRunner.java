package com.playwright.cucumber.core;

import com.microsoft.playwright.*;
import io.cucumber.java.Scenario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@AllArgsConstructor
public class PlaywrightRunner {

    private static final ConcurrentHashMap<Long, PlaywrightRunner> playwrightHolder = new ConcurrentHashMap<>();

    @Getter
    private Playwright playwright;

    @Getter
    private Browser browser;

    @Getter
    @Setter
    private BrowserContext browserContext;

    @Getter
    @Setter
    private Page page;

    private Scenario scenario;

    private PlaywrightRunner(Playwright playwright, Browser browser, BrowserContext browserContext) {
        this.playwright = playwright;
        this.browser = browser;
        this.browserContext = browserContext;
        this.page = browserContext.newPage();
    }

    private static Playwright createPlaywright() {
        return Playwright.create();
    }

    private static Browser createBrowser(Playwright playwright) {
        String browserType = System.getProperty("browser", "chromium");

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
            .setHeadless(Configuration.headless)
            .setTimeout(Configuration.browserToStartTimeout)
            .setDevtools(Configuration.devTools)
            .setTracesDir(Paths.get(Configuration.tracesPath));

        return switch (browserType.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(options);
            case "webkit" -> playwright.webkit().launch(options);
            default -> playwright.chromium().launch(options);
        };
    }

    static PlaywrightRunner get() {
        return playwrightHolder.computeIfAbsent(Thread.currentThread().getId(), k -> {
            var playwright = createPlaywright();
            var browser = createBrowser(playwright);
            var browserContext = initBrowserContext(browser);

            return new PlaywrightRunner(playwright, browser, browserContext);
        });
    }

    private static BrowserContext initBrowserContext(Browser browser) {
        if (Configuration.baseUrl != null) {
            return browser.newContext(new Browser.NewContextOptions().setBaseURL(Configuration.baseUrl));
        }
        return browser.newContext();
    }

    public static void clearSessions() {
        playwrightHolder.forEach((key, runner) -> {
            if (runner != null) {
                if (runner.getPage() != null) {
                    runner.getPage().close();
                    runner.getBrowserContext().close();
                }
                runner.getBrowser().close();
                runner.getPlaywright().close();
            }
        });
    }
}