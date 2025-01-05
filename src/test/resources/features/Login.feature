@loginFunctionality
Feature: Login functionality
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    Then I should be redirected to the dashboard

  Scenario: Login failure with invalid credentials
    Given I am on the login page
    When I enter invalid username or password
    Then I should see an error message