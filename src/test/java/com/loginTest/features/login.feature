Feature: Login Functionality

  Scenario: Login with valid credentials and verify successful login
    Given User on the login page
    When User enter valid credentials
    Then User should be redirected to the dashboard

  Scenario: Login with invalid password and verify error message
    Given User on the login page
    When User enter an invalid password
    Then User should see an error message "Wrong username/password"

  Scenario: Login with invalid email and verify error message
    Given User on the login page
    When User enter an invalid email
    Then User should see an error message "User not found"