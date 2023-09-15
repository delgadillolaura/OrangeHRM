Feature: PIM Orange HRM App

  Background: User should be able to add and delete an employee
    Given I am in Orange HRM web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @addEmployee
  Scenario: Add an employee
    Given I click on the PIM link
    And I click on the Add button
    And I fill the employee information with
      | Anthony | Edward | Stark |
    And I click on the Save button
    And I click on the Employee List Link
    Then I fill the employee name with "Anthony Edward"
    And I click on the Search button from PIM
    And I verify that the employee "Anthony Edward" is displayed
    Then I click on the User Dropdown
    And I click on the Logout Link

  @deleteEmployee
  Scenario: Delete an employee
    Given I click on the PIM link
    Then I fill the employee name with "Anthony Edward"
    And I click on the Search button from PIM
    And I delete the employee
    Then I verify the Records Message "No Records Found" is displayed
    Then I click on the User Dropdown
    And I click on the Logout Link