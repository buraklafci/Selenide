@assertions2
Feature:assertions2
  Scenario: TC02_search for tesla
    Given I navigate to "https://google.com"
    When I search for "Tesla"
    Then verify page source contains "Tesla"
    Then verify the result should contain "bulundu" keyword
    Then the first result in the page sections should contain "Tesla"
    #Created test case in feature folder
    #Create page objects in the page class
    #Create step definitions in stepdefinitions folder