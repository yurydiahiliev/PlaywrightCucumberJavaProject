package com.playwright.cucumber.core.conditions.network;

import com.microsoft.playwright.Page;
import com.playwright.cucumber.core.PlaywrightActions;
import com.playwright.cucumber.core.PlaywrightRunner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestFinished implements NetworkCondition {

    private final String waitForUrlRegex;
    private final Integer timeoutToWait;

    @Override
    public void wait(Runnable locatorActionToWrap) {
        var options = new Page.WaitForRequestFinishedOptions();
        PlaywrightRunner.pw().getPage()
                .waitForRequestFinished(
                        options
                                .setTimeout(timeoutToWait)
                                .setPredicate(request -> request.url().contains(waitForUrlRegex)),
                        locatorActionToWrap
                );
    }
}