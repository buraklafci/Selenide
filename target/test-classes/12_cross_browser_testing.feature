Feature: cross browser
  Scenario: TC01 Running of headless
#    For cross browser testing, we should assign the browser type before opening the browser
#    otherwise selenide will open the browser on chrome
    Given I open the "headless" browser
    And I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page

    Scenario: TC02 Running of firefox
      Given I open the "firefox" browser
      And I navigate to "https://www.techproeducation.com"
      And I capture the screenshot of the page

  Scenario: TC03 Running of edge
    Given I open the "edge" browser
    And I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page

  Scenario: TC04 Running of edge
    Given I open the "chrome" browser
    And I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page
