@loginFunctionality
Feature: Login functionality
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid "Admin" and "admin123"
    Then I should be redirected to the dashboard
    And close the browser

  Scenario Outline: Login failure with invalid credentials like
    1. wrong user name and correct password
    2. correct username with wrong password
    Given I am on the login page
    When I enter invalid "<username>" and "<password>"
    Then I should see an error message "Invalid credentials"
    And close the browser
    Examples:
      | username | password |
      |wronguser | admin123 |
      |Admin     | wrongPass|

  Scenario: Mandatory field errors in login page for empty credentials
    Given I am on the login page
    When I enter invalid "" and ""
    Then I should see error message for all mandatory fields

  Scenario: Forget password link navigation
    Given I am on the login page
    When I click on the "Forgot your password?" link
    Then I should be redirected to password reset page
    When I click "cancel" button on password reset page
    Then I should be redirected to the login page
    And close the browser