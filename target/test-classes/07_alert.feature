Feature: alerts
  Scenario: TC01_alert_automation
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=javascript-alerts"
    And I click on alert prompt
    And I enter "I am here" and click OK
    And I wait for 5 seconds
    Then I verify the result contains "I am here"
    And I wait for 5 seconds
