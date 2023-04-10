@assertions
Feature: assertions
  Scenario: TC01_verify_title
    Given I navigate to "https://techproeducation.com"
    And I get the title of tje current page and verify if it contain "Techpro Education"
