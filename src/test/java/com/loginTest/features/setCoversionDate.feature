Feature: Set Conversion Date

  Background:
    Given User opens the Pharmacist portal
    And User login with username "hardstop-pharmacist6@mailinator.com" and password "Password1#"
    And User clicks on the Patient Field in the Navigation Bar

  Scenario: Select Date before the specified no. days
    When User enters "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9" in ID Field
    And Clicks on Report option
    Then User selects Date "300" days before current Date
    And User clicks on Conversation Date Button