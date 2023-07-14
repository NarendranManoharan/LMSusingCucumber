@emailsend
Feature: send the email 

  Scenario: send the email to the given mail id
    Given Click on the email button
    When enter the valid email id
    And  click on the send button
    Then accept the email sent alert