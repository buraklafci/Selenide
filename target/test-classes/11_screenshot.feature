Feature: screenshots
  @screenshot_page
  Scenario: entire page
    Given I navigate to "https://techproeducation.com"
    And I capture the screenshot of the page

    @screenshot_element
    Scenario: element screenshot
      Given I navigate to "https://techproeducation.com"
      And I capture the screenshot of the programs pop up