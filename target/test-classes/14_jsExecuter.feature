Feature: js executor
  Scenario: TC01 js executor
    Given I navigate to "https://amazon.com"
    And I wait for 2 seconds
    And I scroll down to footer section by js
    And I wait for 2 seconds
    And I capture the screenshot of the page
    And I click on "Amazon Music" by js on amazon table
    Then I hold the browser open