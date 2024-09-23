Feature: Advanced Patient Search

  Background:
    Given User is on the Pharmacist portal
    And User logs in with username "hardstop-pharmacist6@mailinator.com" and password "Password1#"
    And User clicked on the Patient Field in the Navigation Bar

  Scenario: Verify that Advanced Search popup opens successfully
    When User opens the Advanced Search popup
    Then Verify that the Advanced Search popup is displayed

  Scenario: Enter First Name and verify results
    When User opens the Advanced Search popup
    And User enters "Hardstop" as First Name
    And User performs a search
    Then Verify that the search results table is displayed
    And Verify that search results contain "Hardstop"

  Scenario: Enter Last Name and verify results
    When User opens the Advanced Search popup
    And User enters "Select health test patient 1" as Last Name
    And User performs a search
    Then Verify that the search results table is displayed
    And Verify that search results contain "Select health test patient 1"

  Scenario: Enter City and verify Error Popup
    When User opens the Advanced Search popup
    And User enters "Test City" as City
    And User performs a search
    Then Verify that error message "You must provide first or last name." is displayed

  Scenario: Select State and verify Error Popup
    When User opens the Advanced Search popup
    And User selects "California" as State
    And User performs a search
    Then Verify that error message "You must provide first or last name." is displayed

  Scenario: Enter Zip Code and verify Error Popup
    When User opens the Advanced Search popup
    And User enters "99999" as Zip Code
    And User performs a search
    Then Verify that error message "You must provide first or last name." is displayed

  Scenario: Enter Phone and verify results
    When User opens the Advanced Search popup
    And User enters "111-111-1111" as Phone
    And User performs a search
    Then Verify that the search results table is displayed
    And Verify that search results contain "111-111-1111"

  Scenario: Enter Birth Date and verify results
    When User opens the Advanced Search popup
    And User enters "01/01/1965" as Birth Date
    And User performs a search
    Then Verify that the search results table is displayed
    And Verify that search results contain "01/01/1965"

  Scenario: Enter HPID and verify results
    When User opens the Advanced Search popup
    And User enters "XD723643612345" as HPID
    And User performs a search
    Then Verify that the search results table is displayed
    And Verify that search results contain "XD723643612345"