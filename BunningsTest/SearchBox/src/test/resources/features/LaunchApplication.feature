Feature: Launch Application
  This feature launches the application and validates if home page is displayed successfully

  Scenario: Launch Bunnings application

    Given I launch the application
    Then I should see the home page
