Feature: Flight search

  Scenario: Verify user can search flight
    Given user open application
    Then verify user is on home screen
    When user click on Flights menu
    Then verify user is on flight search screen
    When user enters flight source to "source.location"
    And flight destination to "destination.location"
    And select date from "travel.date" to "return.date"
    And click on done button
    And click on search button
    Then verify flight listing page is displayed

  Scenario: Verify error message when user select same source and destination location
    Given user open application
    Then verify user is on home screen
    When user click on Flights menu
    Then verify user is on flight search screen
    When user enters flight source to "source.location"
    And flight destination to "source.location"
    And select date from "travel.date" to "return.date"
    And click on done button
    And click on search button
    Then verify invalid search error is displayed with text
      | Please make sure your departure and arrival cities are in different places. |
    And click on done button on invalid search error popup