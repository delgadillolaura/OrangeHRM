Feature: PIM Orange HRM App

  Background: User should be able to publish a post
    Given I am in Orange HRM web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @publishPost
  Scenario: Add an employee
    Given I click on the Buzz link
    And I fill the post text area with "Esto es una prueba"
    And I click on the Post button
    Then I verify that the post "Esto es una prueba" has been published
    Then I click on the User Dropdown
    And I click on the Logout Link