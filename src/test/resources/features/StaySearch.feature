Feature: Stay Search

  Scenario: Verify user can search properties
    Given user open application
    Then verify user is on home screen
    When user click on Stays menu
    And user enters stay location "stay.location"
    And user click on date field
    And select date check-in date "check-in.date"
    And check-out date "check-out.date"
    And click on done button
    And click on search button
    Then verify list of properties are displayed on the screen