@Login
Feature: Login to LMS

  Scenario: Login to LMSTEST with valid credentials
    Given User need to load the LMSTEST environment
    When user enter the valid username and password
    And click on the login button
    Then user should see the mainpage of the LMSTEST environment


 