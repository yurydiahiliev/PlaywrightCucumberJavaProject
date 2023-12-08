@smoke
Feature: Search in Google

    Scenario: Search Playwright in google
        Given I open google page
        When Trying to search
        And Click on the first link
        Then We are checking banner text
