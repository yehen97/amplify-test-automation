Feature:Test the Random Mode


  @Test @SuccessFlow
  Scenario Outline: Verify that enabling Random Mode automatically selects different nodes for each session
    Given I want to open dijkstra page
    And I want click on enable random mode
    And I want verify page change to random mode
    And I want to click on Calculate Random button
    Then I want to verify results dislpayed


    Examples:
      |  |  |  |
      |  |  |  |

  @Test @SuccessFlow
  Scenario Outline: Verify that Refresh in Random Mode automatically selects different nodes for each session
    Given I want to open dijkstra page
    And I want click on enable random mode
    And I want verify page change to random mode
    And I want to click on Refresh button
    And I want to click on Calculate Random button
    Then I want to verify results dislpayed


    Examples:
      |  |  |  |
      |  |  |  |