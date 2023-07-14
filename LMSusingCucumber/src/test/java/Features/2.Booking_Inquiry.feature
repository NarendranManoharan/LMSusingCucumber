@BookingInquiry
Feature: Retrieve the Booking

  Scenario: Navigate to Booking Inquiry page and retrieve the booking
    Given Select the office code 
    When click on the Booking & Documentation under service management
    And click the Booking Inquiry tab
    Then user should see the Booking Inquiry page
    And enter the booking number in BKG NO field and click retrieve
    And user should see the booking information
