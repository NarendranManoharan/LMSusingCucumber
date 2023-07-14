@BLPreview
Feature: BL preview and save pdf

  Scenario: Click the BL preview and save the BL print as PDF
    Given Click on the BL preview
    When user should see the BL print preview page
    And  click on the charge type as all
    Then click on the print button
    And system should take the screenshot
    And cancel the print page