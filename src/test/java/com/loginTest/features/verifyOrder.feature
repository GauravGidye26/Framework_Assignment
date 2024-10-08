@verifyOrder
Feature: Verifying column order

    Background:
      Given User opens the Pharmacist portal
      And User login with username "hardstop-pharmacist6@mailinator.com" and password "Password1#"
      And User clicks on the Patient Field in the Navigation Bar

      Scenario: Verifying default column order
        When User clicks on Task Field in the Navigation Bar
        Then The columns should be in default order

      Scenario: Verifying column order after re-arranging by drag and drop
        Given User clicks on Task Field in the Navigation Bar
        When User drag the "Name" column to the "Due Date" column position
        Then Verify the column order

      Scenario: Verifying column order after clicking on reset
        Given User clicks on Task Field in the Navigation Bar
        And Clicks on Three Dots button to view hidden column list
        When User drag the "Due Date" column to the "Phone" column position in List
        When User clicks on Reset Button
        Then The columns should be in default order


