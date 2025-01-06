@Dashboard
Feature: Dashboard Page functionality
  Scenario: Successful login with valid credentials and all widgets should be visible in dashboard
    Given I am on the login page
    When I enter valid "Admin" and "admin123"
    Then I should be redirected to the dashboard
    And I should see following widgets in dashboard
  """
  Time at Work,My Actions,Quick Launch,Buzz Latest Posts,Employees on Leave Today,Employee Distribution by Sub Unit,
  Employee Distribution by Location
  """

  Scenario: Access dashboard without login
    Given I navigate to the dashboard page without logging in
    Then I should be redirected to the login page