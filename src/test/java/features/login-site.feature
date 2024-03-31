Feature: Accessing the website and capturing the json

  @AccessingWebPage
  Scenario: Accessing the website and capturing the json
    Given The user access the website
    And Click on photos menu
    And Capture json
    Then The id 6 should be displayed