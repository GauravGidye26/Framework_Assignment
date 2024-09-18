Feature: Login Functionality

  Scenario: Login with valid credentials and verify successful login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard

  Scenario: Login with invalid password and verify error message
    Given I am on the login page
    When I enter an invalid password
    Then I should see an error message "Wrong username/password"

  Scenario: Login with invalid email and verify error message
    Given I am on the login page
    When I enter an invalid email
    Then I should see an error message "User not found"
