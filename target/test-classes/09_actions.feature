Feature:  actions
  Scenario: TC01 actions
    Given I navigate to "https://jqueryui.com/droppable/"
    And I switch to the frame 1
    When I drag the source in the target
    And I hold the browser open

