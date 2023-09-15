Feature: PIM Orange HRM App

  Background: User should be able to search employees
    Given I am in Orange HRM web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button


  @searchEmployees
  Scenario Outline: Search employees
    Given I click on the Admin link
    And I fill the employee User Role field with "<user role>"
    And I fill the employee Status field with "<status>"
    And I click on the Search button
    Then the User Role should be "<user role>"
    And the Status should be "<status>"
    Then I click on the User Dropdown
    And I click on the Logout Link
    Examples:
      | user role | status   |
      | Admin     | Enabled  |
      | Admin     | Disabled |
      | ESS       | Enabled  |
      | ESS       | Disabled |