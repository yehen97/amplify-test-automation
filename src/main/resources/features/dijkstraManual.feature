Feature: Test the Manual Mode

  @Test @SuccessFlow
  Scenario Outline: Verify that the Calculate button correctly computes the optimal path when nodes are manually selected.
    Given I want to open dijkstra page
    And I want to select from node as "<From Node>"
    And I want to select To node as "<To Node>"
    And I want to click on Calculate button
    Then I want verify results are showing as "<Results>"


    Examples:
      | From Node | To Node | Results |
      | A         | B       | 4       |
      | C         | D       | 8       |
      | D         | E       | 4       |



  @Test @SuccessFlow
  Scenario Outline: Verify that the "Clear" button resets the selected nodes and input fields to their default state.
    Given I want to open dijkstra page
    And I want to select from node as "<From Node>"
    And I want to select To node as "<To Node>"
    And I want to click on Clear button
    Then I want verify nodes are cleared


    Examples:
      | From Node | To Node |  |
      | A         | B       |  |



  @Test @ErrorFlow
  Scenario Outline: Verify that an error message is displayed if the user attempts to calculate the path without selecting both nodes.
    Given I want to open dijkstra page
    And I want to click on Calculate button
    Then I want verify error message as "<Message>"


    Examples:
      |  |  | Message                                |
      |  |  | Please select valid FROM and TO nodes. |

  @Test @ErrorFlow
  Scenario Outline: Verify that an error message is displayed if the user attempts to calculate the path without selecting to nodes.
    Given I want to open dijkstra page
    And I want to select from node as "<From Node>"
    And I want to click on Calculate button
    Then I want verify error message as "<Message>"


    Examples:
      | From Node |  | Message                                |
      | A         |  | Please select valid FROM and TO nodes. |

  @Test @ErrorFlow
  Scenario Outline: Verify that an error message is displayed if the user attempts to calculate the path without selecting from nodes.
    Given I want to open dijkstra page
    And I want to select To node as "<To Node>"
    And I want to click on Calculate button
    Then I want verify error message as "<Message>"


    Examples:
      | To Node |  | Message                                |
      | A      |  | Please select valid FROM and TO nodes. |



