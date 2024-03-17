package com.playwright.cucumber.core.conditions.network;

import com.microsoft.playwright.Page;
import com.playwright.cucumber.core.PlaywrightRunner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseFinished implements NetworkCondition {

    private final String waitForUrl;
    private final Integer timeoutToWait;

    @Override
    public void wait(Runnable locatorActionToWrapWithNetworkWaiter) {
        var responseOptions = new Page.WaitForResponseOptions();
        PlaywrightRunner.pw().getPage()
                .waitForResponse(response -> response.url().contains(waitForUrl),
                        responseOptions.setTimeout(timeoutToWait),
                        locatorActionToWrapWithNetworkWaiter
                );
    }

}