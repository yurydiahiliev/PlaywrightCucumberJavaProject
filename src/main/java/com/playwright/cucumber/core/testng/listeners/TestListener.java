package com.playwright.cucumber.core.testng.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started! --> " + result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test success! --> " + result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failed! --> " + result.getTestName());
    }
}