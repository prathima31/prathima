@SearchBox
Feature: Search feature
  This feature validates the search box availability

  Background: Launch application
    Given I launch the application
    Then I should see the home page

  @Search_TC002
  Scenario: Verify if search box is displayed
    Then I should see the search box

  @Search_TC003
  Scenario: Verify the text inside the search box
    And I should see the search box
    Then I validate the text inside the search box

  @Search_TC015
  Scenario Outline: Verify the search results
    And I should see the search box
    Then I enter the "<search_query>" in the search box
    And I verify the "<search_query>" in the search results
    Then I click on the search product
    And I verify the product details as per "<search_query>"


  Examples:
    |search_query|
    |Mower      |
    |Light       |