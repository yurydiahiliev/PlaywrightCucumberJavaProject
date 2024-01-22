@smoke
Feature: Search in Google Playwright Library and check image commandline

    Scenario: Search Playwright in google 5
        Given I open google page
        When Trying to search
        And Click on the first link
        Then We are checking banner text
        And Click on 'Get Started' button
        And Click on 'How to run the example test' button
        Then Check img commandline
