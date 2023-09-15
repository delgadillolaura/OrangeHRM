Feature: Login Orange HRM App

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

  @loginWithValidCredentials
  Scenario: Login into Orange HRM page with valid credentials
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then The Dashboard page should be displayed
    Then I click on the User Dropdown
    And I click on the Logout Link

  @loginWithInvalidCredentials
  Scenario: Login into Orange HRM page with invalid credentials
    Given I set the user name field with "wrong_user"
    And I set the password field with "wrong_password"
    When I click on the login button
    Then An error message that says "Invalid credentials" should be displayed