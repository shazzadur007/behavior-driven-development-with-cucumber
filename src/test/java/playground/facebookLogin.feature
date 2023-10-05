Feature: Google Search Facebook
  @google
  Scenario: Type facebook and search
    Given User is on google home page
    When User search for facebook
    And click on the link containing facebook.com
    Then User should be redirected to facebook.com

  @facebook
  Scenario: Fill up username and password
    Given User is on facebook